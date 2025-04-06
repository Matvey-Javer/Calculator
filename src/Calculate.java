import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
}