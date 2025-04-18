package CalculateWithMultithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    private static volatile boolean runner = true;
    private static Double result;

    private static final BlockingQueue<String> q1 = new LinkedBlockingQueue<>();
    private static final BlockingQueue<String> q2 = new LinkedBlockingQueue<>();

    private static final List<String> values = Collections.synchronizedList(new ArrayList<>());
    private static final List<String> symbols = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        Thread reader = new Thread(() -> {
            while (runner) {
                String input = scanner.nextLine();
                if (input.equals("=")) {
                    runner = false;
                    q1.offer("STOP");
                    q2.offer("STOP");
                    break;
                }

                if (input.startsWith("v:")) {
                    q1.offer(input.substring(2));
                } else if (input.startsWith("s:")) {
                    q2.offer(input.substring(2));
                } else {
                    System.out.println("Invalid input. Use v:<val> or s:<val>");
                }
            }
        });

        Thread thread1 = new Thread(() -> addingForList(q1, values, "Values"));
        Thread thread2 = new Thread(() -> addingForList(q2, symbols, "Symbol"));


        reader.start();
        thread1.start();
        thread2.start();

        reader.join();
        thread1.join();
        thread2.join();

        List<Double> doubles = Operation.converter(values);
        Calculate.doWork(doubles, symbols, result);
    }


    private static void addingForList(BlockingQueue<String> queue, List<String> list, String name) {
        while (!queue.isEmpty() | runner) {
            try {
                String value = queue.poll(100, TimeUnit.MILLISECONDS);
                if (value == null || value.equals("STOP")) continue;
                list.add(value);
                System.out.println("[" + name + "] Added: " + value);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}