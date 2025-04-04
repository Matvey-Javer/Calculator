import java.util.List;
import java.util.Scanner;

public class AddElementsInLists {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private static final Object lock3 = new Object();


    public static void addingForFirstList(String double1, Scanner scanner1, List<String> firstValues) {
        synchronized (lock1) {
            double1 = scanner1.nextLine();
            firstValues.add(double1);
        }
    }

    public static void addingForSymbolsList1(String symbol, Scanner scanner2, List<String> symbols) {
         synchronized (lock2) {
            symbol = scanner2.nextLine();
            symbols.add(symbol);
         }
    }

    public static void addingForSecondList(String double2, Scanner scanner3, List<String> secondValues) {
         synchronized (lock3) {
            double2 = scanner3.nextLine();
            secondValues.add(double2);
        }
    }
}
// допустим все работает как нужно, и теперь эти методы заполняют листы, т.е на выходе у меня готовые листы.