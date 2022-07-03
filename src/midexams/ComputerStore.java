package midexams;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double totalPrice = 0;

        while (!command.equals("special") && !command.equals("regular")) {
            double price = Double.parseDouble(command);

            if (price < 0) {
                System.out.println("Invalid price!");
                command = scanner.nextLine();
                continue;
            }

            totalPrice += price;
            command = scanner.nextLine();
        }

        double totalTax = totalPrice * 0.2;
        double finalPrice = totalPrice + totalTax;
        if (command.equals("special")) {
            finalPrice -= finalPrice * 0.1;
        }

        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.printf("Congratulations you've just bought a new computer!\n" +
                            "Price without taxes: %.2f$\n" +
                            "Taxes: %.2f$\n" +
                            "-----------\n" +
                            "Total price: %.2f$",
                    totalPrice, totalTax, finalPrice);
        }


    }
}
