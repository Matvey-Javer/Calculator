
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test2 {
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


    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(4);
        es.submit(new Runnable() {
            @Override
            public void run() {
                while (!firstSymbol.equals("=")) {
                    AddElementsInLists.addingForFirstList(firstValue, scanner1, firstValues);
                    AddElementsInLists.addingForSymbolsList1(firstSymbol, scanner2, firstSymbols);
                    AddElementsInLists.addingForSecondList(secondValue, scanner3, secondValues);
                    AddElementsInLists.addingForSymbolsList2(secondSymbol, scanner4, secondSymbols);
                }
            }
        });
        es.shutdown();
        es.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(firstValues);
        System.out.println(firstSymbols);
        System.out.println(secondValues);
        System.out.println(secondSymbols);
    }
}
