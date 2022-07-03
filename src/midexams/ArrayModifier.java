package midexams;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArray = scanner.nextLine().split("\\s+");
        int[] nums = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);

                    if (areIndicesValid(firstIndex, secondIndex, nums.length)) {
                        int temp = nums[firstIndex];
                        nums[firstIndex] = nums[secondIndex];
                        nums[secondIndex] = temp;
                    }
                    break;
                case "multiply":
                    firstIndex = Integer.parseInt(tokens[1]);
                    secondIndex = Integer.parseInt(tokens[2]);

                    if (areIndicesValid(firstIndex, secondIndex, nums.length)) {
                        nums[firstIndex] = nums[firstIndex] * nums[secondIndex];
                    }
                    break;
                case "decrease":
                    nums = Arrays.stream(nums).map(e -> e - 1).toArray();
                    break;
            }
            input = scanner.nextLine();
        }

        printResult(nums);

    }

    public static boolean areIndicesValid(int firstIndex, int secondIndex, int length) {
        return 0 <= firstIndex && firstIndex < length && 0 <= secondIndex && secondIndex < length;
    }

    public static void printResult(int[] items) {
        System.out.println(IntStream.of(items)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

}
