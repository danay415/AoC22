import java.util.ArrayList;
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
            calorieCount = 0;
         }
      }
      scanner.close();
      System.out.println(maxCal);
   }
}