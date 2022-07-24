package finalexams;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantsRarities = new LinkedHashMap<>();
        Map<String, List<Double>> plantsRatings = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] plantsInfo = scanner.nextLine().split("<->");
            String plant = plantsInfo[0];
            int rarity = Integer.parseInt(plantsInfo[1]);

            plantsRarities.put(plant, rarity);
            plantsRatings.putIfAbsent(plant, new ArrayList<>());
        }

        String command = scanner.nextLine();
        while (!command.equals("Exhibition")) {
            String[] tokens = command.split(": | - ");
            String action = tokens[0];
            String plant = tokens[1];

            if (!plantsRarities.containsKey(plant)) {
                System.out.println("error");
                command = scanner.nextLine();
                continue;
            }

            switch (action) {
                case "Rate" -> {
                    double rating = Double.parseDouble(tokens[2]);
                    plantsRatings.get(plant).add(rating);
                }
                case "Update" -> {
                    int newRarity = Integer.parseInt(tokens[2]);
                    plantsRarities.put(plant, newRarity);
                }
                case "Reset" -> plantsRatings.get(plant).clear();
            }

            command = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plantsRarities.forEach((plant, rarity) -> {
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", plant, rarity,
                    plantsRatings.get(plant).stream().mapToDouble(Double::doubleValue).average().orElse(0.0));
        });
    }
}
