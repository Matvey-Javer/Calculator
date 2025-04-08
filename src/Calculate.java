import java.util.ArrayList;
import java.util.List;

public class Calculate {
    public static List<Double> converter(List<String> list) {
        List<Double> doubleList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            doubleList.add(Double.parseDouble(list.get(i)));
        }
        return doubleList; // Здесь потенциально можно переписать через лямбду
    }

    public static void addition() {              // +

    }

    public static void subtraction() {           // -

    }

    public static void multiplication() {        // *

    }

    public static void division() {              // /

    }

    public static Double operation(List<Double> doubles, List<String> symbols, Double result) {
        for (int i = 1; i < doubles.size(); i++) {
            for (int j = 0; j < symbols.size(); j++) {
                if (symbols.get(j).equals("+")) {
                    result = doubles.get(i-1)+ doubles.get(i);
                    break;
                } else if (symbols.get(j).equals("-")) {
                    result = doubles.get(i - 1) - doubles.get(i);
                    break;
                }
            }
        }
        return result;
    }

    public static Double operation2(List<Double> doubles, List<String> symbols, Double result){
        for (int i = 0; i < doubles.size(); i++) {
            Double a = doubles.get(i);
            for (int j = 0; j < symbols.size(); j++) {
                String s = symbols.get(j);
                if (s.equals("+")){
                    result = result + a;
                } else if (s.equals("-")) {
                    result = result - a;
                }
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
        System.out.println(operation2(doubles, symbols, result));
        // System.out.println(result);
    }

    // подумай, а что если использовать 2 листа а не 3, там действия совершать легче чем с 3????????
}