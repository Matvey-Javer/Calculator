import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class AddElementsInLists {
    private Scanner scanner1 = new Scanner(System.in);
    private Scanner scanner2 = new Scanner(System.in);
    private Scanner scanner3 = new Scanner(System.in);
    private Scanner scanner4 = new Scanner(System.in);

    private List<String> firstValues =  new ArrayList<>();
    private List<String> firstSymbols = new ArrayList<>();
    private List<String> secondValues = new ArrayList<>();
    private List<String> secondSymbols =new ArrayList<>();

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private static final Object lock3 = new Object();
    private static final Object lock4 = new Object();


    public static void addingForFirstList(String firstValue, Scanner scanner1, List<String> firstValues) {
        //synchronized (lock1) {
            firstValue = scanner1.nextLine();
            firstValues.add(firstValue);
            //  }
   //     return firstValues;
    }

    public static void addingForSymbolsList1(String firstSymbol, Scanner scanner2, List<String> firstSymbols) {
        // synchronized (lock2) {
            firstSymbol = scanner2.nextLine();
            firstSymbols.add(firstSymbol);
        // }
     //   return firstSymbols;
    }

    public static void addingForSecondList(String secondValue, Scanner scanner3, List<String> secondValues) {
        // synchronized (lock3) {
            secondValue = scanner3.nextLine();
            secondValues.add(secondValue);
       // }
        // return secondValues;
    }

    public static void addingForSymbolsList2(String secondSymbol, Scanner scanner4, List<String> secondSymbols) {
         // synchronized (lock4) {
            secondSymbol = scanner4.nextLine();
            secondSymbols.add(secondSymbol);
       // }
   //       return secondSymbols;
    }
}
