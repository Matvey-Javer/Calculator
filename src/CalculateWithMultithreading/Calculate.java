package CalculateWithMultithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Calculate {

    public static List<Double> converter(List<String> list) {
        List<Double> doubleList = new ArrayList<>();
        for (String s : list) {
            doubleList.add(Double.parseDouble(s));
        }
        return doubleList;
    }

    public static Double addition(Double a, Double b) {
        return a + b;
    }

    public static Double subtraction(Double a, Double b) {
        return a - b;
    }

    public static Double multiplication(Double a, Double b) {
        return a * b;
    }

    public static Double division(Double a, Double b) {
        return a / b;
    }

    public static void operation(List<Double> list1, List<Double> list2, List<String> symbols) {
        int size = Math.min(list1.size(), Math.min(list2.size(), symbols.size()));
        for (int i = 0; i < size; i++) {
            Double a = list1.get(i);
            Double b = list2.get(i);
            String op = symbols.get(i);
            Double result;

            switch (op) {
              case "+" -> result = addition(a, b);
                case "-" -> result = subtraction(a, b);
                case "*" -> result = multiplication(a, b);
                case "/" -> result = division(a, b);
                default -> {
                    System.out.println("Invalid operator: " + op);
                    continue;
                }
            }
            System.out.println("Result " + i + ": " + a + " " + op + " " + b + " = " + result);
        }
    }

    public static class AddElementsInLists {
        private static volatile boolean runner = true;
        private static Double result = 0.0;

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
}