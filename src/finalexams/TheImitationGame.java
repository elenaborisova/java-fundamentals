package finalexams;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String encrypted = scanner.nextLine();

        String command = scanner.nextLine();
        while (!command.equals("Decode")) {
            String[] tokens = command.split("\\|");
            String action = tokens[0];

            switch (action) {
                case "Move" -> {
                    int lettersCount = Integer.parseInt(tokens[1]);
                    encrypted = encrypted.substring(lettersCount) + encrypted.substring(0, lettersCount);
                }
                case "Insert" -> {
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    encrypted = encrypted.substring(0, index) + value + encrypted.substring(index);
                }
                case "ChangeAll" -> {
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    encrypted = encrypted.replace(substring, replacement);
                }
            }

            command = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s", encrypted);
    }

}
