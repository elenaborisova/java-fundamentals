package midexams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("!");
        List<String> items = new ArrayList<>(Arrays.asList(input));
        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {
            String[] tokens = command.split(" ");
            String action = tokens[0];
            String item = tokens[1];

            switch (action) {
                case "Urgent":
                    if (!items.contains(item)) {
                        items.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    items.remove(item);
                    break;
                case "Correct":
                    String newItem = tokens[2];
                    if (items.contains(item)) {
                        int itemIndex = items.indexOf(item);
                        items.set(itemIndex, newItem);
                    }
                    break;
                case "Rearrange":
                    if (items.contains(item)) {
                        int itemIndex = items.indexOf(item);
                        String itemToAdd = items.remove(itemIndex);
                        items.add(itemToAdd);
                    }
                    break;
            }
//            System.out.println(items);
            command = scanner.nextLine();
        }

        System.out.println(String.join(", ", items));
    }
}
