package Threads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureAllMethod {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        java.util.concurrent.ExecutorService service = Executors.newFixedThreadPool(3);

        CompletableFuture<List<Integer>> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
            return integers.stream().filter(f -> f % 2 == 0).collect(Collectors.toList());
        }, service);

        CompletableFuture<List<Integer>> future2 = future1.thenApplyAsync((list) -> {
            System.out.println("Thread " + Thread.currentThread().getName());
            return list.stream().filter(f -> f > 4).collect(Collectors.toList());
        }, service);

        future2.thenAcceptAsync((lists) -> {
            System.out.println("Thread " + Thread.currentThread().getName());
            lists.forEach(System.out::println);
        }, service).join();

        //2 dependent future use thenCompose
        CompletableFuture<List<Integer>> future3 = future1.thenCompose(future -> CompletableFuture.supplyAsync(() -> {
            return future.stream().filter(f -> f > 4).collect(Collectors.toList());
        }));
        System.out.println(future3.get());

        //2 indipendent future use thenCombine
        CompletableFuture<List<Integer>> listCompletableFuture = future1.thenCombine(future2, (f1, f2) -> Stream.concat(f1.stream(), f2.stream()).collect(Collectors.toList()));

        System.out.println(listCompletableFuture.get());

        service.shutdown();
    }
}
