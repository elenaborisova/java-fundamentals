package midexams;

import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodQuantity = Double.parseDouble(scanner.nextLine()) * 1000;  // Quantity for 30 days
        double hayQuantity = Double.parseDouble(scanner.nextLine());
        double coverQuantity = Double.parseDouble(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());

        for (int i = 1; i < 31; i++) {
            foodQuantity -= 300;

            if (i % 2 == 0) {
                hayQuantity -= 5.0 / 100 * (foodQuantity / 1000);
            }
            if (i % 3 == 0) {
                coverQuantity -= 1.0 / 3 * weight;
            }
            if (foodQuantity <= 0 || hayQuantity <= 0 || coverQuantity <= 0) {
                System.out.println("Merry must go to the pet store!");
                return;
            }
        }

        System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                foodQuantity / 1000, hayQuantity, coverQuantity);
    }
}
