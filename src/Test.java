import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static Scanner scanner1 = new Scanner(System.in);
    private static Scanner scanner2 = new Scanner(System.in);
    private static Scanner scanner3 = new Scanner(System.in);
    private static Scanner scanner4 = new Scanner(System.in);

    private static String firstValue;
    private static String firstSymbol;
    private static String secondValue;
    private static String secondSymbol;

    private static List<String> firstValues = new ArrayList<>();
    private static List<String> firstSymbols = new ArrayList<>();
    private static List<String> secondValues = new ArrayList<>();
    private static List<String> secondSymbols = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException, NullPointerException {
        if (firstValue != null | firstSymbol != null | secondValue != null | secondSymbol != null) {
            while (!firstValue.equals("=") | !secondValue.equals("=") | !secondSymbol.equals("=") | !firstSymbol.equals("=")) {
                // покумекай над условием выхода из бесконечнонр цикла

                Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AddElementsInLists.addingForFirstList(firstValue, scanner1, firstValues);
                    }
                });

                Thread thread2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AddElementsInLists.addingForSymbolsList1(firstSymbol, scanner2, firstSymbols);
                    }
                });
                Thread thread3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AddElementsInLists.addingForSecondList(secondValue, scanner3, secondValues);
                    }
                });

                Thread thread4 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AddElementsInLists.addingForSymbolsList2(secondSymbol, scanner4, secondSymbols);
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
        }
        //  }
        System.out.println(firstValues);
        System.out.println(firstSymbols);
        System.out.println(secondValues);
        System.out.println(secondSymbols);
    }
}
