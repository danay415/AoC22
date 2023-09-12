import java.io.File;
import java.util.ArrayList;
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

      // PART 1
      // String item = "";
      // int weight = 0;
      // boolean foundMatch = false;

      // while (scanner.hasNextLine()) {
      //   String rucksack = scanner.nextLine();
      //   String compartment1 = rucksack.substring(0, rucksack.length() / 2);
      //   String compartment2 = rucksack.substring(rucksack.length() / 2, rucksack.length());
      //   foundMatch = false;

      //   for (int i = 0; i < compartment1.length(); i++) {
      //       for (int j = 0; j < compartment2.length(); j++) {
      //           if (compartment1.charAt(i) == compartment2.charAt(j) && !foundMatch) {
      //               item += compartment1.charAt(i);
      //               weight += items.indexOf(item) + 1;
      //               item = "";
      //               foundMatch = true;
      //           }
      //       }
      //   }
      // }

      int weight = 0;
      ArrayList<String> possibleBadges = new ArrayList<>();

      while (scanner.hasNextLine()) {
        String elf1 = scanner.nextLine();
        String elf2 = scanner.nextLine();
        String elf3 = scanner.nextLine();

        for (int i = 0; i < elf1.length(); i++) {
          for (int j = 0; j < elf2.length(); j++) {
            if (elf1.charAt(i) == elf2.charAt(j) && !possibleBadges.contains("" + elf1.charAt(i))) {
              possibleBadges.add("" + elf1.charAt(i));
            }
          }
        }
        for (String item : possibleBadges) {
          if (elf3.contains(item)) {
            weight += items.indexOf(item) + 1;
          }
        }
        possibleBadges.clear();
      }

    scanner.close();
    System.out.println(weight);

   }
}
