package midexams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static boolean isIndexValid(int index, int size) {
        return index >= 0 && index < size;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] tokens = command.split(" ");
            String action = tokens[0];
            int index = Integer.parseInt(tokens[1]);
            int value = Integer.parseInt(tokens[2]);

            switch (action) {
                case "Shoot":
                    if (isIndexValid(index, targets.size())) {
                        targets.set(index, targets.get(index) - value);
                        if (targets.get(index) <= 0) {
                            targets.remove(index);
                        }
                    }
                    break;
                case "Add":
                    if (isIndexValid(index, targets.size())) {
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    if (isIndexValid(index, targets.size()) && isIndexValid(index - value,
                            targets.size()) && isIndexValid(index + value, targets.size())) {
                        for (int i = index + value; i >= index - value; i--) {
                            targets.remove(i);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                        break;
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join("|", targets.stream().map(String::valueOf)
                .collect(Collectors.joining("|"))));
    }
}
