import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AoC22Day6 {

    public static void main(String []args) throws Exception {
        File file = new File("Day6Input.txt");
        Scanner scanner = new Scanner(file);

        String commString = "";
        while (scanner.hasNext()) {
            commString += scanner.next();
        }

        int commLength = 14;
        ArrayList<String> packets = new ArrayList<>();
        for (int i = 0; i < commString.length() - (commLength - 1); i++) {
            String currPacket = commString.substring(i, i + commLength);
            packets.add(currPacket);
        }

        int marker = commLength - 1;
        for (String packet : packets) {
            marker++;
            if (packet.chars().distinct().count() == commLength) {
                System.out.println(marker);
                break;
            }             
        }
        System.out.println();
        scanner.close();
    }
}