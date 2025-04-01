
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test2 {
    private static String firstValue;
    private static String firstSymbol;
    private static String secondValue;
    private static String secondSymbol;

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();
    private static final Object lock3 = new Object();
    private static final Object lock4 = new Object();


    private static List<String> firstValues = new ArrayList<>();
    private static List<String> firstSymbols = new ArrayList<>();
    private static List<String> secondValues = new ArrayList<>();
    private static List<String> secondSymbols = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(1);
        es.submit(new Runnable() {
            @Override
            public void run() {
                while (!firstValue.equals("=")) {
                    firstValue = scanner.nextLine();
                    result.add(firstValue);
                }
            }
        });
        es.shutdown();
        es.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(firstValues);
    }
}
