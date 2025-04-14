import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// первое это подумай про () и прочее в калькуляторе.
// второе это подумай про то, как игнорировать white-space символы, которые могут встречатся при вводе и прочее

public class Variant1 {
    private static Double value = 0.0;

    public static void main(String[] args) {
        Double result = 0.0;
        List<Double> doubles = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] symbols = line.split("[0-9]+");
        String[] strings = line.split("(\\+|-|\\*|/|=)");
        System.out.println(Arrays.toString(symbols));
        System.out.println(Arrays.toString(strings));
        doubles = converter(strings);
        System.out.println(doubles);
        operation(symbols, doubles, result);
    }

    public static List<Double> converter(String[] strings) {
        List<Double> doubles = new ArrayList<>();
        for (String string : strings) {
            doubles.add(Double.parseDouble(string));
        }
        return doubles;
    }

    public static void operation(String[] symbols, List<Double> doubles, Double result) {
        int size = Math.min(symbols.length, doubles.size());
        for (int i = 1; i < size; i++) {
            //Double a = doubles.get(i - 1);
            result = doubles.getFirst();
            Double b = doubles.get(i);
            String op = symbols[i];
            switch (op) {
                case "+" -> result = addition(result, b);
                case "-" -> result = subtraction(result, b);
                case "*" -> result = multiplication(result, b);
                case "/" -> result = division(result, b);
                default -> {
                    System.out.println("Invalid operator: " + op);
                    continue;
                }
            }
        }
        System.out.println(result);
    }

    // подумай как тебе расставить приоритеты операция

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
}
