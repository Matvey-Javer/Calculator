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

    public static Double operation(List<Double> doubles, List<String> symbols) {
        Double result = 0.0;
        for (int j = 1; j < doubles.size(); j++) {
            switch (symbols.get(j - 1)) {
                case "+" -> result = addition(doubles.get(j - 1), doubles.get(j));
                case "-" -> result = subtraction(doubles.get(j - 1), doubles.get(j));
                case "*" -> result = multiplication(doubles.get(j - 1), doubles.get(j));
                case "/" -> result = division(doubles.get(j - 1), doubles.get(j));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Double result = 0.0;
        List<Double> doubles = new ArrayList<>();
        doubles.add(33.0);
        doubles.add(17.0);
        doubles.add(50.0);
        doubles.add(50.0);

        List<String> symbols = new ArrayList<>();
        symbols.add("+");
        symbols.add("+");
        symbols.add("-");
        System.out.println(operation(doubles, symbols, result));
    }
}