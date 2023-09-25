import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AoC22Day7 {

    public static void main(String []args) throws Exception {
        File file = new File("Test.txt");
        Scanner scanner = new Scanner(file);
        Map<String, String> filesystem = new HashMap<>();

        while (scanner.hasNextLine()) {
            String[] currLine = {};
            currLine = scanner.nextLine().split(" ");
            System.out.println(currLine[0]);
            switch (currLine[0]) {
                case "$":
                    switch (currLine[1]) {
                        case "cd":
                            switch (currLine[2]) {
                                case "/":
                                    filesystem.put("/", "test");
                                    break;
                            }
                            break;
                        case "ls":
                            break;
                    }
                    break;
            }
        }

        scanner.close();
    }
}