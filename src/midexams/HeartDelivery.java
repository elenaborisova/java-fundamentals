package midexams;

import java.util.Arrays;
import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] houses = Arrays.stream(scanner.nextLine().split("@"))
                .mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        int lastPosition = 0;

        while (!input.equals("Love!")) {
            String[] tokens = input.split(" ");
            int length = Integer.parseInt(tokens[1]);

            lastPosition += length;
            if (lastPosition >= houses.length) {
                lastPosition = 0;
            }

            if (houses[lastPosition] == 0) {
                System.out.printf("Place %d already had Valentine's day.\n", lastPosition);
                input = scanner.nextLine();
                continue;
            }

            houses[lastPosition] -= 2;
            if (houses[lastPosition] == 0) {
                System.out.printf("Place %d has Valentine's day.\n", lastPosition);
            }

//            System.out.println(Arrays.toString(houses));
            input = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.\n", lastPosition);

        int successHouses = 0;
        for (int house : houses) {
            if (house > 0) {
                successHouses++;
            }
        }

        if (successHouses == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", successHouses);
        }
    }
}
