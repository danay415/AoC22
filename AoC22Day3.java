import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AoC22Day3 {
    public static void main(String []args) throws Exception
   {
      // intake the input of elf calories and assign the text file to the scanner
      File file = new File("Day3Input.txt");
      Scanner scanner = new Scanner(file);
    
      ArrayList<String> items = new ArrayList<>();
      char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
      for (char c : alphabet) {
        items.add(Character.toString(c));
      }

      String item = "";
      int weight = 0;
      while (scanner.hasNextLine()) {
        String rucksack = scanner.nextLine();
        String compartment1 = rucksack.substring(0, rucksack.length() / 2);
        String compartment2 = rucksack.substring(rucksack.length() / 2, rucksack.length());
        boolean found = false;

        for (int i = 0; i < rucksack.length() / 2; i++) {
            for (int j = 0; j < rucksack.length() / 2; j++) {
                if (compartment1.charAt(i) == compartment2.charAt(j) && !found) {
                    item += compartment1.charAt(i);
                    System.out.println(item);
                    weight += items.indexOf(item) + 1;
                    item = "";
                    found = true;
                }
            }
        }
      }

    scanner.close();
    System.out.println(weight);
   }
}
