package midexams;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        int shotCount = 0;

        while (!command.equals("End")) {
            int index = Integer.parseInt(command);

            if (index < 0 || index >= targets.length || targets[index] == -1) {
                command = scanner.nextLine();
                continue;
            }

            int value = targets[index];
            targets[index] = -1;
            shotCount++;

            for (int i = 0; i < targets.length; i++) {
                if (targets[i] == -1) {
                } else if (targets[i] > value) {
                    targets[i] -= value;
                } else {
                    targets[i] += value;
                }
            }

            command = scanner.nextLine();
        }

        String targetsStr = Arrays
                .stream(targets)
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a.concat(" ").concat(b))
                .get();

        System.out.println("Shot targets: " + shotCount + " -> " + targetsStr);
    }
}
