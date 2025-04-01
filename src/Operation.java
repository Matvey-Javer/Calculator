import java.util.Scanner;

public class Operation {
    private static double result;

    public static double summer(Scanner scanner) {
        while (scanner.hasNextDouble()) {
            result += scanner.nextDouble();
        }
        return result;
    }

    public static double subtraction(Scanner scanner) {
        while (scanner.hasNextDouble()) {
            result = scanner.nextDouble() - scanner.nextDouble();
        }
        return result;
    }

    public static double multiplication(Scanner scanner) {
        while (scanner.hasNextDouble()) {
            result = scanner.nextDouble() * scanner.nextDouble();
        }
        return result;
    }

    public static double difference(Scanner scanner) {
        while (scanner.hasNextDouble()) {
            result = scanner.nextDouble() / scanner.nextDouble();
        }
        return result;
    }
}