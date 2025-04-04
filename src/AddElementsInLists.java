import java.util.List;
import java.util.Scanner;

public class AddElementsInLists {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private static final Object lock3 = new Object();


    public static void addingForFirstList(Scanner scanner1, List<String> firstValues) {
        synchronized (lock1) {
            firstValues.add(scanner1.nextLine());
        }
    }

    public static void addingForSymbolsList1(Scanner scanner2, List<String> symbols) {
         synchronized (lock2) {
            symbols.add(scanner2.nextLine());
         }
    }

    public static void addingForSecondList(Scanner scanner3, List<String> secondValues) {
         synchronized (lock3) {
            secondValues.add(scanner3.nextLine());
        }
    }
}
// допустим все работает как нужно, и теперь эти методы заполняют листы, т.е на выходе у меня готовые листы.