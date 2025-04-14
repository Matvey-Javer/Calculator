package CalculateWithMultithreading;

import java.util.List;

public class Calculate {

    public static void doWork(List<Double> doubles, List<String> symbols, Double result) {
        int size = Math.min(doubles.size(), symbols.size());
        for (int i = 1; i < size; i++) {
            Double value = doubles.get(i);
            String op = symbols.get(i - 1);
            result = doubles.get(0);

            switch (op) {
                case "+" -> result = Operation.addition(result, value);
                case "-" -> result = Operation.subtraction(result, value);
                case "*" -> result = Operation.multiplication(result, value);
                case "/" -> result = Operation.division(result, value);
                default -> {
                    System.out.println("Invalid operator: " + op);
                    continue;
                }
            }
        }
        System.out.println(result);
    }
}