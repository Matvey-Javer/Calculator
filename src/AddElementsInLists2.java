import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddElementsInLists2 {

    public static List<String> addingForFirstList(String firstValue, Scanner scanner) {
        firstValue = scanner.nextLine();
        List<String> result = new ArrayList<>();
        result.add(firstValue);
        return result;
    }
}
