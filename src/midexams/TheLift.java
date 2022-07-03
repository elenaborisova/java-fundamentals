package midexams;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());

        String[] input = scanner.nextLine().split(" ");
        int[] wagon = new int[input.length];
        int fullWagon = 4 * input.length;
        for (int i = 0; i < input.length; i++) {
            wagon[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < wagon.length; i++) {
            int spotsLeft = 4 - wagon[i];
            while (peopleCount > 0 && spotsLeft > 0) {
                wagon[i]++;
                peopleCount--;
                spotsLeft--;
            }
        }

        int wagonState = Arrays.stream(wagon).sum();
        String wagonStr = IntStream.of(wagon)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        if (peopleCount == 0 && wagonState < fullWagon) {
            System.out.println("The lift has empty spots!\n" + wagonStr);
        }
        else if (peopleCount > 0 && wagonState == fullWagon) {
            System.out.printf("There isn't enough space! %d people in a queue!\n%s", peopleCount, wagonStr);
        }
        else {
            System.out.println(wagonStr);
        }
    }
}
