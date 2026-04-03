package Threads;

import java.util.concurrent.*;

public class CompletableFeature {
    public static void main(String[] args) throws Exception{
        java.util.concurrent.ExecutorService service = Executors.newFixedThreadPool(10);
        System.out.println("Placing order....");

        // 1. Fetch product info (returns String)
        CompletableFuture<String> productFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Product: Laptop";
        }, service);

        // 2. Check inventory (returns Boolean)
        CompletableFuture<Boolean> inventoryFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return true;
        }, service);

        // 3. Process payment (returns String)
        CompletableFuture<String> paymentFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Payment confirmed";
        }, service);


        // 4. Combine all with allOf
        CompletableFuture<Void> future = CompletableFuture.allOf(productFuture, inventoryFuture, paymentFuture);


        // 5. Final order confirmation
        future.thenRun(() -> {
            try {
                if (inventoryFuture.get()) {
                    System.out.println("\n Order summary:");
                    System.out.println(productFuture.get());
                    System.out.println(paymentFuture.get());

                    // Log confirmation (no return)
                    CompletableFuture.runAsync(() -> System.out.println("Order confirmed and logged."));
                } else {
                    System.out.println("Inventory not available. ");
                }
            } catch (Exception e) {
                System.out.println("Error during order processing: " + e.getMessage());
            }
        });

        // 6. Handle unexpected failure (like network issues)
        productFuture.exceptionally(ex -> {
            System.out.println("Failed to fetch product: " + ex.getMessage());
            return "Default product";
        });

        CompletableFuture<String> deliveryFuture = productFuture.thenCompose(product -> {
            return CompletableFuture.supplyAsync(() -> {
                sleep(500);
                return product + " will be delivered in 3 days";
            });
        });

        deliveryFuture.thenAccept(System.out::println);

        future.get();

        service.shutdown();
    }

    static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
