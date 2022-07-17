package midexams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items = new ArrayList<>(Arrays.asList((scanner.nextLine().split(", "))));
        String command = scanner.nextLine();

        while (!command.equals("Craft!")) {
            String[] tokens = command.split(" - ");
            String action = tokens[0];
            String item = tokens[1];

            switch (action) {
                case "Collect":
                    if (!items.contains(item)) {
                        items.add(item);
                    }
                    break;
                case "Drop":
                    items.remove(item);
                    break;
                case "Combine Items":
                    String[] elements = item.split(":");
                    String oldItem = elements[0];
                    String newItem = elements[1];

                    if (items.contains(oldItem)) {
                        int itemIdx = items.indexOf(oldItem);
                        items.add(itemIdx + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (items.contains(item)) {
                        items.remove(item);
                        items.add(item);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", items));
    }
}
