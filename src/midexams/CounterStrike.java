package midexams;

import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int winCount = 0;
        String command = scanner.nextLine();

        while (!command.equals("End of battle")) {
            int distance = Integer.parseInt(command);

            if (energy - distance >= 0) {
                energy -= distance;
                winCount++;
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", winCount, energy);
                return;
            }

            if (winCount % 3 == 0) {
                energy += winCount;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Won battles: %d. Energy left: %d", winCount, energy);

    }
}

