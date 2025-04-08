import java.util.ArrayList;
import java.util.List;

public class Calculate{
    public static List<Double> converter(List<String> list){
         List<Double> doubleList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            doubleList.add(Double.parseDouble(list.get(i)));
        }
        return doubleList; // Здесь потенциально можно переписать через лямбду
    }
    public static void addition(){              // +

    }

    public static void subtraction(){           // -

    }

    public static void multiplication(){        // *

    }

    public static void division(){              // /

    }

    public static Double operation(List<Double> doubles, List<String> symbols, Double result){
        for (int i = 1; i < symbols.size(); i++) {
            if (symbols.get(i).equals("+")){
                result = doubles.get(i - 1) + doubles.get(i);
            }else {
                result = result - doubles.get(i);
            }
        }
        return result;
    }

    // подумай, а что если использовать 2 листа а не 3, там действия совершать легче чем с 3????????
}