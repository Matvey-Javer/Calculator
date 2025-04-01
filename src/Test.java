import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static String firstValue;
    private static String firstSymbol;
    private static String secondValue;
    private static String secondSymbol;


    private static List<String> firstValues = new ArrayList<>();
    private static List<String> firstSymbols = new ArrayList<>();
    private static List<String> secondValues = new ArrayList<>();
    private static List<String> secondSymbols = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while (!scanner.nextLine().equals("=")) {

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    AddElementsInLists.addingForFirstList(firstValue, scanner, firstValues);
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    AddElementsInLists.addingForFirstList(firstSymbol, scanner, firstSymbols);
                }
            });
            Thread thread3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    AddElementsInLists.addingForFirstList(secondValue, scanner, secondValues);
                }
            });

            Thread thread4 = new Thread(new Runnable() {
                @Override
                public void run() {
                    AddElementsInLists.addingForFirstList(secondSymbol, scanner, secondSymbols);
                }
            });

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();

            thread1.join();
            thread4.join();
            thread2.join();
            thread3.join();
        }
        System.out.println(firstValues);
        System.out.println(firstSymbols);
        System.out.println(secondValues);
        System.out.println(secondSymbols);
    }
}
