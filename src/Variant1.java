import java.util.*;

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
        operation(symbols, doubles);
    }

    public static List<Double> converter(String[] strings) {
        List<Double> doubles = new ArrayList<>();
        for (String string : strings) {
            doubles.add(Double.parseDouble(string));
        }
        return doubles;
    }

    public static void operation(String[] symbols, List<Double> doubles) {
        int size = Math.min(symbols.length, doubles.size());
        for (int i = 1; i < size; i++) {
            Double a = doubles.get(i - 1);
            String op = symbols[i];
            Double result = 0.0;
            if (symbols[i].equals("=")) {
                break;
            } else {
                switch (op) {
                    case "+" -> result = addition(result, a);
                    case "-" -> result = subtraction(result, a);
                    case "*" -> result = multiplication(result, a);
                    case "/" -> result = division(result, a);
                    default -> {
                        System.out.println("Invalid operator: " + op);
                        continue;
                    }
                }
               // result = operation(symbols, doubles);
            }
            System.out.println("Result " + i + ": " + result + " " + op + " " + a + " = " + result);
        }
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
}
