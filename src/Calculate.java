import java.util.*;

public class Calculate {
    private static boolean stopper = true;
    private static double result;
    private static List<Double> firstValues = new ArrayList<>();
    private static List<Double> secondValues = new ArrayList<>();
    private static List<String> symbolList = new ArrayList<>();

    public static double workOperation(double value, String symbol) {
        switch (symbol) {
            case "+" -> result = result + value;
            case "-" -> result = result - value;
            case "*" -> result = result * value;
            case "/" -> result = result / value;
        }
        return result;
    }


    public static List<String> sortingValues(List<String> values, double value, String symbol) {
        List<String> symbols = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            if (i % 3 == 0) {
                value = Double.parseDouble(values.get(i)); // здесь может возникнуть рядь исколючений
            } else {
                symbol = values.get(i);
                symbols.add(symbol);
            }
        }return symbols;
    }
}
