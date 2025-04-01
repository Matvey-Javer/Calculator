import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Variant1 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String a = "";
        String b = "";
        String c = "";

        /*while (true){
            a = scanner.nextLine();
            if (a.equals("=")){
                break;
            }
            aList.add(a);
        }*/
        addingAList(scanner, a, b, c,  list1, list2, list3);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);

    }

    public static void addingAList(Scanner scanner, String a, String b, String c, List<String> list1,
                                   List<String> list2, List<String> list3) {
        while (true) {
            a = scanner.nextLine();
            b = scanner.nextLine();
            c = scanner.nextLine();

            if (!a.equals("=") | !b.equals("=") | !c.equals("=") ) {
                break;
            }
            list1.add(a);
            list2.add(b);
            list3.add(c);
        }
    }
}
