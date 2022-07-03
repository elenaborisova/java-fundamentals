package midexams;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasure = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
//        List<String> treasure = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\|")));
        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")) {
            String[] tokens = input.split("\\s+", 2);
            String command = tokens[0];

            switch (command) {
                case "Loot":
                    String[] items = tokens[1].split("\\s+");
                    for (String item : items) {
                        if (!treasure.contains(item)) {
                            treasure.add(0, item);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (0 <= index && index < treasure.size()) {
                        String element = treasure.remove(index);
                        treasure.add(element);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);

                    if (count >= treasure.size()) {
                        System.out.println(String.join(", ", treasure));
                        treasure.clear();
                        break;
                    }

                    List<String> stolenItems = new ArrayList<>();

                    for (int i = 0; i < count; i++) {
                        String item = treasure.remove(treasure.size() - 1);
                        stolenItems.add(item);
                    }

                    Collections.reverse(stolenItems);
                    System.out.println(String.join(", ", stolenItems));
                    break;
            }
            input = scanner.nextLine();
        }

        if (treasure.size() > 0) {
            double averageGain = 0;
            for (String item : treasure) {
                averageGain += item.length();
            }
            averageGain /= treasure.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
