import java.io.File;
import java.util.Scanner;

public class AoC22Day4 {

    public static void main(String []args) throws Exception {
        File file = new File("Day4Input.txt");
        Scanner scanner = new Scanner(file);

        String[] elf1;
        String[] elf2;
        String[] elfPair;
        int elf1Start;
        int elf1End;
        int elf2Start;
        int elf2End;

        int contains = 0;
        int overlaps = 0;

        while (scanner.hasNextLine()) {
            elfPair = scanner.next().split(",");
            elf1 = elfPair[0].split("-");
            elf2 = elfPair[1].split("-");

            elf1Start = Integer.parseInt(elf1[0]);
            elf1End = Integer.parseInt(elf1[1]);

            elf2Start = Integer.parseInt(elf2[0]);
            elf2End = Integer.parseInt(elf2[1]);

            if (elf1Start >= elf2Start && elf1End <= elf2End) {
                contains += 1;
                overlaps += 1;
                continue;
            }
            if (elf2Start >= elf1Start && elf2End <= elf1End) {
                contains += 1;
                overlaps += 1;
                continue;
            }
            if (elf1Start <= elf2End && elf2Start <= elf1End) {
                overlaps += 1;
                continue;
            }

        }

        System.out.println(overlaps);
        scanner.close();
    }
}
