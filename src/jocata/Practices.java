package jocata;

import com.sun.deploy.util.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Practices {
    public static void main(String[] args) {
        String sample = "60347cmeHPzfUyV";
        String twoDecimalPoint = "-0.02640368359375345";
        String appId = "";
        String uniqueKey = "";
        /*for(char c : sample.toCharArray()){
            if(Character.isDigit(c)){
                appId = appId + c;
            } else {
                uniqueKey = uniqueKey + c;
            }
        }*/
        if (twoDecimalPoint == "" || twoDecimalPoint.equals("-")){
            uniqueKey = uniqueKey;
        } else {
            if (twoDecimalPoint != ""){
                char c1, c2, c3;
                Double d;
                c1 = new Character(twoDecimalPoint.charAt(0));
                c2 = new Character('-');
                if (c1 == c2){
                    uniqueKey= twoDecimalPoint.replace("-","");
                    d= Double.parseDouble(uniqueKey);
                    uniqueKey = "-"+ String.format("%.2f",d);
                    if (uniqueKey.equalsIgnoreCase("-0.00")) {
                        uniqueKey = "0.00";
                    } else {
                        uniqueKey = "-"+ String.format("%.2f",d);
                    }
                }else {
                    d= Double.valueOf(twoDecimalPoint);
                    uniqueKey = String.valueOf(String.format("%.2f",d));
                }
            }
        }
        BigDecimal bd = new BigDecimal(twoDecimalPoint);
       // System.out.println(uniqueKey);
        //System.out.println(String.valueOf(bd.setScale(2,BigDecimal.ROUND_HALF_DOWN)));
        double noPercentage = (250 - (1.05 * 200.5)) / 40.1;

        System.out.println(noPercentage * 100);

       /* String base64String = "";
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);
        String outPutPath = "D:\\PDF_test\\aoadocument.pdf";
        try (FileOutputStream fos = new FileOutputStream(outPutPath)) {
            fos.write(decodedBytes);
            System.out.println("File saved successfully to ");
        } catch (IOException e) {
            System.err.println("Error saving file: " + e.getMessage());
        }*/
        Map<String, Object> map = new HashMap<>();

        map.put("appId", 123);
        map.put("cinNumber", "Asdf");

        System.out.println(map);
        map.clear();
        map.put("application", 4444);
        map.put("txnId", "12345");
        System.out.println(map);
        map.remove("txnId", "12345");
        //System.out.println(map);
        map.put("ccId", "ok");
        System.out.println(map);
        /*ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable task = new Runnable() {

            @Override
            public void run() {
                System.out.println("Task executed at: " + System.currentTimeMillis());
            }
        };
        long initialDelay = 0; // Start immediately
        long period = 3; // Period in minutes

        if (true) {
            scheduler.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
        }*/

        Instant expDate = Instant.parse("2025-05-17T22:00:00Z");
        Instant currDt = Instant.now();

        long days = ChronoUnit.DAYS.between(currDt, expDate);

        System.out.println(days);


    }

}
