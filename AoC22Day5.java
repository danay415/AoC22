import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC22Day5 {
    public static void main(String []args) throws Exception {
        File file = new File("Test.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<String> crates = new ArrayList<>();

        // scan up to the crate stacks
        String instructions;
        while (scanner.hasNextLine()) {
            instructions = scanner.nextLine();
            if (instructions.equals("")) {
                break;
            }
            crates.add(instructions);
        }

        // initialize the stacks starting with the stack number
        int numStacks = crates.get(0).length() / 3;
        ArrayList<ArrayList<String>> stacks = new ArrayList<>();
        for (int i = 0; i < numStacks; i++) {
            ArrayList<String> currStack = new ArrayList<>();
            currStack.add(Integer.toString(i + 1));
            stacks.add(currStack);
        }

        // add the crates to the appropriate stacks
        int whitespaceCount = 0;
        for (int i = 0; i < crates.size() - 1; i++) {
            for (int j = 0; j < crates.get(i).length(); j++) {
                switch (crates.get(i).substring(j, j + 1)) {
                    case " ":
                        whitespaceCount += 1;
                        if (whitespaceCount == 4) {
                            stacks.get(i).add(" ");
                            whitespaceCount = 0;
                        }
                        break;
                    case "[":
                        stacks.get(i).add(crates.get(i).substring(j, j + 3));
                        break;
                }
            }
        }
        scanner.close();
        System.out.println(stacks);
    }
}
