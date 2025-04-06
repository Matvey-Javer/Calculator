/*
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static Scanner scanner1 = new Scanner(System.in);
    private static Scanner scanner2 = new Scanner(System.in);
    private static Scanner scanner3 = new Scanner(System.in);

    private static String double1;
    private static String symbol;
    private static String double2;

    private static List<String> firstValues = new ArrayList<>();
    private static List<String> symbols = new ArrayList<>();
    private static List<String> secondValues = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException, NullPointerException {
        while(true) {
            if (scanner1.nextLine().equals("=") | scanner2.nextLine().equals("=") | scanner3.nextLine().equals("=")){
                System.out.println(firstValues);
                System.out.println(symbols);
                System.out.println(secondValues);
                break;
            }else {


                Thread thread1 = new Thread(() -> AddElementsInLists.addingForFirstList(double1, scanner1, firstValues));

                Thread thread2 = new Thread(() -> AddElementsInLists.addingForSymbolsList1(symbol, scanner2, symbols));

                Thread thread3 = new Thread(() -> AddElementsInLists.addingForSecondList(double2, scanner3, secondValues));

                thread1.start();
                thread2.start();
                thread3.start();

                thread1.join();
                thread2.join();
                thread3.join();
            }
        }
    }
}
*/
