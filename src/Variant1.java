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
        result = operation(symbols, doubles, result);
        System.out.println(result);
    }

    public static List<Double> converter(String[] strings) {
        List<Double> doubles = new ArrayList<>();
        for (String string : strings) {
            doubles.add(Double.parseDouble(string));
        }
        return doubles;
    }

    public static Double operation(String[] symbols, List<Double> doubles, Double result) {
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i].equals("+")) {
                result = result + doubles.get(i);
            } else if (symbols[i].equals("-")) {
                result = result + doubles.get(i);
            } else if (symbols[i].equals("*")) {
                result = result * doubles.get(i);
            } else if (symbols[i].equals("/")) {
                result = result / doubles.get(i);
            }
        }
        return result;
    }
}
