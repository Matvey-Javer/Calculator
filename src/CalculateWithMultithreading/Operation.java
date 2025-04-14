package CalculateWithMultithreading;

import java.util.ArrayList;
import java.util.List;

public class Operation {
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
}
