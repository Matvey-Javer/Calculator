import java.util.*;
import java.util.concurrent.*;

public class Test2 {

    private static final List<String> firstValues = Collections.synchronizedList(new ArrayList<>());
    private static final List<String> symbols = Collections.synchronizedList(new ArrayList<>());
    private static final List<String> secondValues = Collections.synchronizedList(new ArrayList<>());

    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // Reader thread
        Thread reader = new Thread(() -> {
            while (running) {
                String input = scanner.nextLine();
                if ("=".equals(input)) {
                    running = false;
                    queue.offer("STOP");  // signal workers to stop
                    break;
                }
                queue.offer(input);
            }
        });

        // Worker threads
        Thread worker1 = new Thread(() -> process(queue, firstValues, "1st"));
        Thread worker2 = new Thread(() -> process(queue, symbols, "Symbol"));
        Thread worker3 = new Thread(() -> process(queue, secondValues, "2nd"));

        // Start all threads
        reader.start();
        worker1.start();
        worker2.start();
        worker3.start();

        // Wait for reader to finish
        reader.join();
        worker1.join();
        worker2.join();
        worker3.join();

        // Print final result
        System.out.println("First Values: " + firstValues);
        System.out.println("Symbols: " + symbols);
        System.out.println("Second Values: " + secondValues);
    }

    // Worker logic
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