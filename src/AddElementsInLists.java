import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddElementsInLists {
    private List<String> firstValues = new ArrayList<>();
    private List<String> firstSymbols = new ArrayList<>();
    private List<String> secondValues = new ArrayList<>();
    private List<String> secondSymbols = new ArrayList<>();

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private static final Object lock3 = new Object();
    private static final Object lock4 = new Object();

// подумай что ты возвращаешь в методах, и для чего ты это возвращаешь
    // не проще ли сделать 1 метод для этого всего? нет, т.к race condition будет по определению monitor


    public static void addingForFirstList(String firstValue, Scanner scanner, List<String> firstValues) {
     //   synchronized (lock1) {
            firstValue = scanner.nextLine();
            firstValues.add(firstValue);
       // }
   //     return firstValues;
    }

    public static void addingForSymbolsList1(String firstSymbol, Scanner scanner, List<String> firstSymbols) {
      //  synchronized (lock2) {
            firstSymbol = scanner.nextLine();
            firstSymbols.add(firstSymbol);
        //}
     //   return firstSymbols;
    }

    public static void addingForSecondList(String secondValue, Scanner scanner, List<String> secondValues) {
        //synchronized (lock3) {
            secondValue = scanner.nextLine();
            secondValues.add(secondValue);
        //}
        // return secondValues;
    }

    public static void addingForSymbolsList2(String secondSymbol, Scanner scanner, List<String> secondSymbols) {
        // synchronized (lock4) {
            secondSymbol = scanner.nextLine();
            secondSymbols.add(secondSymbol);
        //}
   //       return secondSymbols;
    }
}
