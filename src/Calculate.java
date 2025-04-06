public class Calculate{
    public static void addition(){              // +

    }

    public static void subtraction(){           // -

    }

    public static void multiplication(){        // *

    }

    public static void division(){              // /

    }

    public static Double operation(List<Double> doubles1, List<String> symbols, List<Double> doubles2, Double result){
        for (int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i).equals("+")){
                result = doubles1.get(i) + doubles2.get(i);
            }else {
                result = doubles1.get(i) - doubles2.get(i);
            }
        }
        return result;
    }

    // подумай, а что если использовать 2 листа а не 3, там действия совершать легче чем с 3????????
}