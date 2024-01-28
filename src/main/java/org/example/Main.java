package org.example;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;


public class Main {

    private static final HashMap<Integer, BigInteger> results = new HashMap<>();

    public HashMap<Integer, BigInteger> getResults() {
        return results;
    }

    public static class Factorial implements Runnable {

        int number;

        public Factorial(int number) {
            this.number = number;
        }

        public void run() {
            BigInteger result = BigInteger.ONE;
            for (int i = 1; i <= number; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            results.put(number, result);
            System.out.printf("#%s: factorial of %d is %d%n", Thread.currentThread().getName(), number, result);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("file.txt");

        Stream<String> lines = Files.lines(path);
        List<Integer> data = lines.map(Integer::parseInt).toList();
        lines.close();
        data.forEach(number -> {
            Thread thread = new Thread(new Factorial(number));
            thread.start();
        });
        Thread.sleep(1000);
        System.out.println();
        System.out.println(results);
    }

}