import java.util.*;
import java.util.concurrent.*;

public class Test2 {

    private static final List<String> firstValues = Collections.synchronizedList(new ArrayList<>());
    private static final List<String> symbols = Collections.synchronizedList(new ArrayList<>());
    private static final List<String> secondValues = Collections.synchronizedList(new ArrayList<>());

    private static final BlockingQueue<String> q1 = new LinkedBlockingQueue<>();
    private static final BlockingQueue<String> qs = new LinkedBlockingQueue<>();
    private static final BlockingQueue<String> q2 = new LinkedBlockingQueue<>();

    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // Reader thread: routes inputs to correct queues
        Thread reader = new Thread(() -> {
            while (running) {
                String input = scanner.nextLine();
                if (input.equals("=")) {
                    running = false;
                    q1.offer("STOP");
                    qs.offer("STOP");
                    q2.offer("STOP");
                    break;
                }

                if (input.startsWith("1:")) {
                    q1.offer(input.substring(2));
                } else if (input.startsWith("s:")) {
                    qs.offer(input.substring(2));
                } else if (input.startsWith("2:")) {
                    q2.offer(input.substring(2));
                } else {
                    System.out.println("Invalid input. Use 1:<val>, s:<val>, or 2:<val>");
                }
            }
        });

        // Each worker reads only from its own queue
        Thread worker1 = new Thread(() -> process(q1, firstValues, "1st"));
        Thread workerS = new Thread(() -> process(qs, symbols, "Symbol"));
        Thread worker2 = new Thread(() -> process(q2, secondValues, "2nd"));

        reader.start();
        worker1.start();
        workerS.start();
        worker2.start();

        reader.join();
        worker1.join();
        workerS.join();
        worker2.join();

        System.out.println("First Values: " + firstValues);
        System.out.println("Symbols     : " + symbols);
        System.out.println("Second Values: " + secondValues);
    }

    private static void process(BlockingQueue<String> queue, List<String> list, String name) {
        while (running || !queue.isEmpty()) {
            try {
                String value = queue.poll(100, TimeUnit.MILLISECONDS);
                if (value == null || value.equals("STOP")) continue;
                list.add(value);
                System.out.println("[" + name + "] Added: " + value);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}