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
            String op = symbols[i];
            Double counter = 0.0;
            Double result;

            if (symbols[i].equals("+")) {
                result = doubles.get(i - 1) + doubles.get(i);
            } else if (symbols[i].equals("-")) {
                result = doubles.get(i - 1) - doubles.get(i);
            } else if (symbols[i].equals("*")) {
                result = doubles.get(i - 1) * doubles.get(i);
            } else if (symbols[i].equals("/")) {
                result = doubles.get(i - 1) / doubles.get(i);
            } else {
                System.out.println("Invalid operator: " + op);
                continue;
            }
            System.out.println("Result " + i + ": " + doubles.get(i-1) + " " + op + " " + doubles.get(i) + " = " + result);
        }
    }
}
