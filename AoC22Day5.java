import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC22Day5 {
    public static void main(String []args) throws Exception {
        File file = new File("Day5Input.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<String> crates = new ArrayList<>();

        // scan up to the crate stacks
        String cargo;
        while (scanner.hasNextLine()) {
            cargo = scanner.nextLine();
            if (cargo.equals("")) {
                break;
            }
            crates.add(cargo);
        }

        // convert the scanner info to rows
        int numStacks = Integer.parseInt(crates.get(crates.size() - 1)
        .substring(crates.get(crates.size() - 1).length() - 2, crates.get(crates.size() - 1).length() - 1));
        ArrayList<ArrayList<String>> stacks = new ArrayList<>();
        ArrayList<ArrayList<String>> rows = new ArrayList<>();

        for (int i = 0; i < numStacks; i++) {
            ArrayList<String> currStack = new ArrayList<>();
            rows.add(currStack);
        }

        // add the crates to the appropriate stacks
        int whitespaceCount = 0;
        for (int i = 0; i < crates.size() - 1; i++) {
            for (int j = 0; j < crates.get(i).length(); j++) {
                switch (crates.get(i).substring(j, j + 1)) {
                    case " ":
                        whitespaceCount += 1;
                        if (whitespaceCount == 4) {
                            rows.get(i).add(" ");
                            whitespaceCount = 0;
                        }
                        break;
                    case "[":
                        whitespaceCount = 0;
                        rows.get(i).add(crates.get(i).substring(j + 1, j + 2));
                        break;
                }
            }
        }

        // initialize the stacks starting with the stack number
        for (int i = 0; i < numStacks; i++) {
            ArrayList<String> currStack = new ArrayList<>();
            stacks.add(currStack);
        }

        // convert rows to columns
        for (int i = 0; i < rows.size(); i++) {
            for (int j = 0; j < rows.get(i).size(); j++) {
                if (!rows.get(i).get(j).equals(" ")) {
                    stacks.get(j)
                    .add(rows.get(i).get(j));
                }
            }
        }
        // get the instructions in an array
        ArrayList<String> fullInstructions = new ArrayList<>();
        while (scanner.hasNextLine()) {
            fullInstructions.add(scanner.nextLine());
        }
        scanner.close();

        // parse instructions: [amount, fromStack, toStack]
        ArrayList<ArrayList<Integer>> instructions = new ArrayList<>();
        for (String string : fullInstructions) {
            String[] currSet = string.split(" ");
            String amount = currSet[1];
            String fromStack = currSet[3];
            String toStack = currSet[5];
            ArrayList<Integer> set = new ArrayList<>();
            set.add(Integer.parseInt(amount));
            set.add(Integer.parseInt(fromStack));
            set.add(Integer.parseInt(toStack));
            instructions.add(set);
        }

        // execute instructions
        for (ArrayList<Integer> set : instructions) {
            for (int i = set.get(0); i > 0; i--) {
                ArrayList<String> takeFrom = stacks.get(set.get(1) - 1);
                ArrayList<String> addTo = stacks.get(set.get(2) - 1);
                if (takeFrom.size() > 0) {
                    addTo.add(0, takeFrom.get(i - 1));
                    takeFrom.remove(i - 1);
                }
            }
        }

        // get the top crate from each stack
        String topCrates = "";
        for (ArrayList<String> crate : stacks) {
            topCrates += crate.get(0);
        }

        System.out.println(topCrates);
    }
}
