import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class AddElementsInLists {
    private static volatile boolean runner = true;
    private static Double result = (double) 0;

    private static final BlockingQueue<String> q1 = new LinkedBlockingQueue<>();
    private static final BlockingQueue<String> q2 = new LinkedBlockingQueue<>();
    private static final BlockingQueue<String> q3 = new LinkedBlockingQueue<>();

    private static final List<String> firstValues = Collections.synchronizedList(new ArrayList<>());
    private static final List<String> symbols = Collections.synchronizedList(new ArrayList<>());
    private static final List<String> secondValues = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Thread reader = new Thread(() -> {
            while (runner) {
                String input = scanner.nextLine();
                if (input.equals("=")) {
                    runner = false;
                    q1.offer("STOP");
                    q2.offer("STOP");
                    q3.offer("STOP");
                    break;
                }

                if (input.startsWith("1:")) {
                    q1.offer(input.substring(2));
                } else if (input.startsWith("s:")) {
                    q2.offer(input.substring(2));
                } else if (input.startsWith("2:")) {
                    q3.offer(input.substring(2));
                } else {
                    System.out.println("Invalid input. Use 1:<val>, s:<val> or 2:<val>");
                }
            }
        });

        Thread thread1 = new Thread(() -> addingForList(q1, firstValues, "1st"));
        Thread thread2 = new Thread(() -> addingForList(q2, symbols, "Symbol"));
        Thread thread3 = new Thread(() -> addingForList(q3, secondValues, "2nd"));

        reader.start();
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            reader.join();
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // тут я заканчиваю, и получается что у меня есть 3 листа стрингов
        List<Double> doubles1 = Calculate.converter(firstValues);
        List<Double> doubles2 = Calculate.converter(secondValues); // здесь выкидываются 2 исключения минимум, намбэр формат и нул поинтер

        Calculate.operation(doubles1, symbols, doubles2, result);
        System.out.println(result);
//        System.out.println("First Values: " + doubles1);
//        System.out.println("Symbols      : " + symbols);
//        System.out.println("Second Values: " + doubles2);
    }


    private static void addingForList(BlockingQueue<String> queue, List<String> list, String name) {
        while (!queue.isEmpty() | runner) {
            try {
                String value = queue.poll(100, TimeUnit.MILLISECONDS);
                if (value == null || value.equals("STOP")) continue;
                list.add(value);
                System.out.println("[" + name + "] Added: " + value); // подумай, нужно  ли тебе это выводить?
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // ?
            }
        }
    }
}
