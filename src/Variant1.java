import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// первое это подумай про () и прочее в калькуляторе.
// второе это подумай про то, как игнорировать white-space символы, которые могут встречатся при вводе и прочее

public class Variant1 {
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
        result = operation(symbols, doubles);
        System.out.println(result);
    }

    public static List<Double> converter(String[] strings) {
        List<Double> doubles = new ArrayList<>();
        for (String string : strings) {
            doubles.add(Double.parseDouble(string));
        }
        return doubles;
    }

    public static Double operation(String[] symbols, List<Double> values) {
        Double result = 0.0;
        int size1 = symbols.length;
        int size2 = values.size();
        result = operation(symbols, values);
        if (size1 == 0 | size2 == 0) {
            return result;
        }
        for (int i = 1; i < symbols.length; i++) {
            switch (symbols[i]) {
                case "+" -> {
                    result = result + values.get(i - 1);
                    size1--;
                    size2--;
                }
                case "-" -> {
                    result = result - values.get(i - 1);
                    size1--;
                    size2--;
                }
                case "*" -> {
                    result = result * values.get(i - 1);
                    size1--;
                    size2--;
                }
                case "/" -> {
                    result = result / values.get(i - 1);
                    size1--;
                    size2--;
                }
                default -> {
                    System.out.println("Invalid operator: " + symbols[i]);
                    continue;
                    //System.out.println("Result " + ": " + i + " " + symbols[i] + " " + values.get(i) + " = " + result);
                }
            }
            size1--;
            size2--;
        }
        return result;
    }
}
