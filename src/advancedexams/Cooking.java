package advancedexams;

import java.util.*;
import java.util.stream.Collectors;


public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> liquids =
                Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(ArrayDeque::new));


        Stack<Integer> ingredients =
                Arrays.stream(scanner.nextLine().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(Stack::new));

        Map<Integer, String> foodValues = new HashMap<>(Map.of(
                25, "Bread",
                50, "Cake",
                75, "Pastry",
                100, "Fruit Pie"
        ));

        Map<String, Integer> foodsCollected = new TreeMap<>();
        foodValues.values().forEach(p -> foodsCollected.put(p, 0));

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int currentLiquid = liquids.poll();
            int currentIngredient = ingredients.pop();
            int mix = currentLiquid + currentIngredient;

            if (foodValues.containsKey(mix)) {
                String food = foodValues.get(mix);
                foodsCollected.put(food, foodsCollected.get(food) + 1);
            } else {
                ingredients.add(currentIngredient + 3);
            }
        }

        if (foodsCollected.values().stream().allMatch(v -> v >= 1)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        System.out.println("Liquids left: " + getElements(liquids));
        Collections.reverse(ingredients);
        System.out.println("Ingredients left: " + getElements(ingredients));

        foodsCollected.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));
    }

    private static String getElements(Collection<Integer> deque) {
        return !deque.isEmpty()
                ? deque.stream().map(String::valueOf).collect(Collectors.joining(", "))
                : "none";
    }
}
