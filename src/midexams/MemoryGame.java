package midexams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split(" ");
        List<String> sequence = new ArrayList<>(Arrays.asList(elements));
        int movesCount = 0;

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            movesCount++;
            String[] indexes = command.split(" ");
            int idx1 = Integer.parseInt(indexes[0]);
            int idx2 = Integer.parseInt(indexes[1]);

            if (idx1 == idx2 || idx1 < 0 || idx1 >= sequence.size() || idx2 < 0 || idx2 >= sequence.size()) {
                int midIdx = sequence.size() / 2;
                String element = "-" + movesCount + "a";
                sequence.add(midIdx, element);
                sequence.add(midIdx, element);
                System.out.println("Invalid input! Adding additional elements to the board");
                command = scanner.nextLine();
                continue;
            }

            if (sequence.get(idx1).equals(sequence.get(idx2))) {
                String element = sequence.get(idx1);
                if (idx1 < idx2) {
                    sequence.remove(idx2);
                    sequence.remove(idx1);
                } else {
                    sequence.remove(idx1);
                    sequence.remove(idx2);
                }
                System.out.printf("Congrats! You have found matching elements - %s!\n", element);
            } else {
                System.out.println("Try again!");
            }

            if (sequence.size() == 0) {
                System.out.printf("You have won in %d turns!", movesCount);
                break;
            }

            command = scanner.nextLine();
        }

        if (sequence.size() > 0) {
            System.out.println("Sorry you lose :(\n" + String.join(" ", sequence));
        }

    }
}
