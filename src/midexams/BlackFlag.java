package midexams;

import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double gatheredPlunder = 0;

        for (int i = 1; i <= days; i++) {
            gatheredPlunder += dailyPlunder;
            if (i % 3 == 0) {
                gatheredPlunder += dailyPlunder * 0.5;
            }
            if (i % 5 == 0) {
                gatheredPlunder -= gatheredPlunder * 0.3;
            }
        }

        if (gatheredPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", gatheredPlunder);
        } else {
            double percentage = gatheredPlunder / expectedPlunder * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percentage);
        }

    }
}
