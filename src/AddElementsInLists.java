import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class AddElementsInLists {
    private static volatile boolean runner = true;

    private static void addingForList(BlockingQueue<String> queue, List<String> list, String name) {
        while (!queue.isEmpty() | runner) {
            try {
                String value = queue.poll(100, TimeUnit.MILLISECONDS);
                if (value == null || value.equals("STOP")) continue;
                list.add(value);
                System.out.println("[" + name + "] Added: " + value); // подумай, нужно  ли тебе это выводить?
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
