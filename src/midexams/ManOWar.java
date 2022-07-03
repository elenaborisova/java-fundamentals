package midexams;

import java.util.Arrays;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pirateShip = getIntArray(scanner);
        int[] warShip = getIntArray(scanner);

        int maxHealth = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Retire")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Fire":
                    int index = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);

                    if (isIndexValid(index, warShip.length)) {
                        break;
                    }

                    warShip[index] -= damage;
                    if (warShip[index] <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    damage = Integer.parseInt(tokens[3]);

                    if ((isIndexValid(startIndex, pirateShip.length)) ||
                            (isIndexValid(endIndex, pirateShip.length))) {
                        break;
                    }

                    for (int i = startIndex; i <= endIndex; i++) {
                        pirateShip[i] -= damage;
                        if (pirateShip[i] <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Repair":
                    index = Integer.parseInt(tokens[1]);
                    int health = Integer.parseInt(tokens[2]);

                    if (isIndexValid(index, pirateShip.length)) {
                        break;
                    }

                    pirateShip[index] += health;
                    if (pirateShip[index] > maxHealth) {
                        pirateShip[index] = maxHealth;
                    }
                    break;
                case "Status":
                    double threshold = maxHealth * 0.2;
                    int needRepairCount = 0;

                    for (int section : pirateShip) {
                        if (section < threshold) {
                            needRepairCount++;
                        }
                    }

                    System.out.printf("%d sections need repair.\n", needRepairCount);
                    break;
            }
            input = scanner.nextLine();
        }

        int pirateShipStatus = getSum(pirateShip), warShipStatus = getSum(warShip);
        System.out.println("Pirate ship status: " + pirateShipStatus);
        System.out.println("Warship status: " + warShipStatus);

    }

    public static int[] getIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static boolean isIndexValid(int index, int size) {
        return 0 > index || index >= size;
    }

    public static int getSum(int[] ship) {
        int result = 0;

        for (int section : ship) {
            result += section;
        }

        return result;
    }
}
