import java.util.ArrayList;
import java.util.List;

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
}