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

    public static Double operation(List<Double> doubles, List<String> symbols, Double result) {
        for (int i = 0; i < doubles.size(); i++) {
            if (symbols.get(i).equals("+")) {
                return result + doubles.get(i);
            } else if (symbols.get(i).equals("-")) {
                return result - doubles.get(i);
            } else if (symbols.get(i).equals("*")) {
                return result * doubles.get(i);
            } else if (symbols.get(i).equals("/")) {
                return result / doubles.get(i);
            }
        }return result;
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