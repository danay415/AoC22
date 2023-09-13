import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC22Day5 {
    public static void main(String []args) throws Exception {
        File file = new File("Test.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<String> test = new ArrayList<>();

        while (scanner.hasNextLine()) {
            test.add(scanner.nextLine());
        }

        scanner.close();
    }
}
