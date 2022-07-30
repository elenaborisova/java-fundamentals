package advancedexams;

import java.util.*;
import java.util.stream.Collectors;

public class Chocolate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Double> milkValues = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Stack<Double> cacaoValues = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(Stack::new));



        Map<Integer, String> chocolateTable = new HashMap<>(Map.of(
           30, "Milk Chocolate",
           50, "Dark Chocolate",
           100, "Baking Chocolate"
        ));

        Map<String, Integer> chocolatesMade = new TreeMap<>();


        while (!cacaoValues.isEmpty() && !milkValues.isEmpty()) {
            double cacaoValue = cacaoValues.pop();
            double milkValue = milkValues.poll();
            int res = (int) ((cacaoValue / (milkValue + cacaoValue)) * 100);

            if (chocolateTable.containsKey(res)) {
                String chocName = chocolateTable.get(res);
                chocolatesMade.putIfAbsent(chocName, 0);
                chocolatesMade.put(chocName, chocolatesMade.get(chocName) + 1);
            } else {
                milkValues.add(milkValue + 10);
            }

        }


        System.out.println(chocolatesMade.size() >= 3
                ? "It’s a Chocolate Time. All chocolate types are prepared."
                : "Sorry, but you didn't succeed to prepare all types of chocolates.");

        chocolatesMade.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));

    }
}
