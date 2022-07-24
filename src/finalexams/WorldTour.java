package finalexams;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        String command = scanner.nextLine();
        int length = stops.length();

        while (!command.equals("Travel")) {
            String[] tokens = command.split(":");
            String action = tokens[0];

            switch (action) {
                case "Add Stop" -> {
                    int index = Integer.parseInt(tokens[1]);
                    String substring = tokens[2];
                    if (isIndexValid(index, length)) {
                        stops = stops.substring(0, index) + substring + stops.substring(index);
                    }
                }
                case "Remove Stop" -> {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (isIndexValid(startIndex, length) && isIndexValid(endIndex, length)) {
                        stops = stops.substring(0, startIndex) + stops.substring(endIndex + 1);
                    }
                }
                case "Switch" -> {
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    if (stops.contains(oldString)) {
                        stops = stops.replace(oldString, newString);
                    }
                }
            }

            System.out.println(stops);
            command = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", stops);
    }

    public static boolean isIndexValid(int index, int size) {
        return 0 <= index && index < size;
    }
}
