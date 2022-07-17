package midexams;

import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int health = 100;
        int bitcoins = 0;
        String[] rooms = scanner.nextLine().split("\\|");
        int roomCount = 0;
        int healedValue;

        for (String room : rooms) {
            roomCount++;
            String[] tokens = room.split(" ");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            switch (command) {
                case "potion":
                    if (health + value > 100) {
                        healedValue = 100 - health;
                        health = 100;
                    } else {
                        healedValue = value;
                        health += value;
                    }
                    System.out.printf("You healed for %d hp.\n" +
                                    "Current health: %d hp.\n",
                            healedValue, health);
                    break;
                case "chest":
                    bitcoins += value;
                    System.out.printf("You found %d bitcoins.\n", value);
                    break;
                default:
                    health -= value;
                    if (health > 0) {
                        System.out.printf("You slayed %s.\n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.\n" +
                                        "Best room: %d",
                                command, roomCount);
                        return;
                    }
                    break;
            }
        }

        System.out.printf("You've made it!\n" +
                        "Bitcoins: %d\n" +
                        "Health: %d\n",
                bitcoins, health);
    }
}
