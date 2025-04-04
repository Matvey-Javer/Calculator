import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public static void inputInFile(Scanner scanner) {
        Path filePath = Path.of("FileWithDate.txt");
        try (BufferedWriter bw = Files.newBufferedWriter(filePath)) {

            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("=")) {
                    break;
                } else {
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи данных файл");
        }
    }

    public static List<String> putInList() {
        /*
        данный метод записывает данные из файла в лист
        */
        List<String> values = new ArrayList<>();

        Path filePath = Path.of("FileWithDate.txt");
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = br.readLine()) != null) {
                values.add(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении данных из файла");
        }
        return values;
    }
}
