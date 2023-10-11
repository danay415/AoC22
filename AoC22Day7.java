import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC22Day7 {

    public static void main(String []args) throws Exception {
        File file = new File("Test.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<ArrayList<String[]>> filesystem = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] currLine = {};
            ArrayList<String[]> currDir = new ArrayList<>();
        }

        scanner.close();
    }
}