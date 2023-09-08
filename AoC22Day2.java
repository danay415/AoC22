import java.io.File;
import java.util.Scanner;

public class AoC22Day2 {
    public static void main(String []args) throws Exception
    {
        File file = new File("Day2Input.txt");
        Scanner scanner = new Scanner(file);

        int points = 0;
        int win = 6;
        int draw = 3;
        int loss = 0;
        int rock = 1;
        int paper = 2;
        int scissors = 3;
        while (scanner.hasNext()) {
            // PART 1
            // A X rock         A X DRAW    A Y WIN     A Z LOSS
            // B Y paper        B X LOSS    B Y DRAW    B Z WIN
            // C Z scissors     C X WIN     C Y LOSS    C Z DRAW

            //PART 2
            // X LOSE
            // Y DRAW
            // Z WIN
            
            String opp = scanner.next();
            String player = scanner.next();
            
            switch (opp) {
                case "A":
                    switch (player) {
                        case "X":
                            points += scissors + loss;
                            break;
                        case "Y":
                            points += rock + draw;
                            break;
                        case "Z":
                            points += paper + win;
                            break;
                    }
                    break;
                case "B":
                    switch (player) {
                        case "X":
                            points += rock + loss;
                            break;
                        case "Y":
                            points += paper + draw;
                            break;
                        case "Z":
                            points += scissors + win;
                            break;
                    }
                    break;
                case "C":
                    switch (player) {
                        case "X":
                            points += paper + loss;
                            break;
                        case "Y":
                            points += scissors + draw;
                            break;
                        case "Z":
                            points += rock + win;
                            break;
                    }
                    break;
            }
        }
        scanner.close();
        System.out.println(points);
    }
}
