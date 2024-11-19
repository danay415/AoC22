import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AoC22Day7 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("Test.txt"))) {
            String line;
            Map<String, Integer> sizes = new HashMap<>();
            List<String> stack = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                if (line.startsWith("$ ls") || line.startsWith("dir")) {
                    continue;
                }
                if (line.startsWith("$ cd")) {
                    String dest = line.split(" ")[2];
                    if (dest.equals("..")) {
                        if (!stack.isEmpty()) {
                            stack.remove(stack.size() - 1);
                        }
                    } else {
                        String path = stack.isEmpty() ? dest : stack.get(stack.size() - 1) + "_" + dest;
                        stack.add(path);
                    }
                } else {
                    String[] parts = line.split(" ");
                    int size = Integer.parseInt(parts[0]);
                    for (String path : stack) {
                        sizes.put(path, sizes.getOrDefault(path, 0) + size);
                    }
                }
            }

            int neededSize = 30000000 - (70000000 - sizes.getOrDefault("/", 0));
            int size = 0;
            List<Integer> sortedSizes = new ArrayList<>(sizes.values());
            Collections.sort(sortedSizes);
            for (int s : sortedSizes) {
                if (s > neededSize) {
                    size = s;
                    break;
                }
            }

            int task1Sum = sizes.values().stream().filter(n -> n <= 100000).mapToInt(Integer::intValue).sum();
            System.out.println(task1Sum); // task 1
            System.out.println(size); // task 2
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

