import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;

public class AoC22Day1
{

   /* This is my first java program.
    * This will print 'Hello World' as the output
    */

   public static void main(String []args) throws Exception
   {

      // intake the input of elf calories and assign the text file to the scanner
      File file = new File("Day1Input.txt");
      Scanner scanner = new Scanner(file);

      int calorieCount = 0;
      int maxCal = 0;
      ArrayList<Integer> calories = new ArrayList<>();
      while (scanner.hasNextLine())
      {
         String cal;
         if ((cal = scanner.nextLine()) != "")
         {
            calorieCount += Integer.parseInt(cal);
         } else
         {
            if (calorieCount > maxCal)
            {
               maxCal = calorieCount;
            }
            calories.add(calorieCount);
            calorieCount = 0;
         }
      }
      Collections.sort(calories, Collections.reverseOrder());
      int topThree = calories.get(0) + calories.get(1) + calories.get(2);
      scanner.close();
      System.out.println(topThree);
   }
}