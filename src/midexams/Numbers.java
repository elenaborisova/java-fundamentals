package midexams;

import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> result = new ArrayList<>();
        double average = 0;

        for (int num: nums) {
            average += num;
        }
        average /= nums.length;

        for (int num: nums) {
            if (num > average) {
                result.add(num);
            }
        }

        if (result.size() == 0) {
            System.out.println("No");
        } else {
            Collections.sort(result);
            Collections.reverse(result);
            for (int i = result.size() - 1; i >= 5; i--) {
                result.remove(result.get(i));
            }

            System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
