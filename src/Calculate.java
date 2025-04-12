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

    public static Double operation(List<Double> doubles1, List<Double> doubles2, List<String> symbols, Double result) {
        Double a = 0.0;
        Double b = 0.0;
        for (int i = 0; i < doubles1.size(); i++) {
            a = doubles1.get(i);
            for (int j = 0; j < doubles2.size(); j++) {
                b = doubles2.get(j);
                if (symbols.get(i).equals("+")) {
                    result = Calculate.addition(a, b);
                } else if (symbols.get(i).equals("-")) {
                    result = Calculate.subtraction(a, b);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Double result = 0.0;
        List<Double> doubles = new ArrayList<>();
        List<Double> doubles2 = new ArrayList<>();
        doubles.add(33.0);
        doubles2.add(17.0);
        doubles.add(50.0);
        doubles2.add(50.0);
        doubles.add(50.0);

        List<String> symbols = new ArrayList<>();
        symbols.add("+");
        symbols.add("+");
        symbols.add("-");
        symbols.add("-");
        System.out.println(operation(doubles, doubles2, symbols, result));
    }
}