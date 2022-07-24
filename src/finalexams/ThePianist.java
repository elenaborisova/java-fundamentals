package finalexams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, String>> pieces = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

            addNewPiece(pieces, piece, composer, key);
        }

        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] tokens = command.split("\\|");
            String action = tokens[0];
            String piece = tokens[1];

            switch (action) {
                case "Add" -> {
                    if (pieces.containsKey(piece)) {
                        System.out.printf("%s is already in the collection!%n", piece);
                        command = scanner.nextLine();
                        continue;
                    }
                    String composer = tokens[2];
                    String key = tokens[3];
                    addNewPiece(pieces, piece, composer, key);
                    System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                }
                case "Remove" -> {
                    if (!pieces.containsKey(piece)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                        command = scanner.nextLine();
                        continue;
                    }
                    pieces.remove(piece);
                    System.out.printf("Successfully removed %s!%n", piece);
                }
                case "ChangeKey" -> {
                    if (!pieces.containsKey(piece)) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                        command = scanner.nextLine();
                        continue;
                    }
                    String newKey = tokens[2];
                    pieces.get(piece).put("key", newKey);
                    System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                }
            }

            command = scanner.nextLine();
        }

        pieces.forEach((piece, info) -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                piece, info.get("composer"), info.get("key")));

    }

    public static void addNewPiece(Map<String, Map<String, String>> pieces,  String piece, String composer, String key) {
        pieces.putIfAbsent(piece, new HashMap<>());
        pieces.get(piece).put("composer", composer);
        pieces.get(piece).put("key", key);
    }
}
