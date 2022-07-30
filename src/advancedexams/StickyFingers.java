package advancedexams;

import java.util.*;
import java.util.stream.Collectors;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] matrix = new char[n][n];
        int currentRow = 0;
        int currentCol = 0;

        for (int r = 0; r < n; r++) {
            List<String> line = new ArrayList<>(Arrays.asList(scanner.nextLine().split("\\s+")));
            matrix[r] = String.join("", line)
                    .toCharArray();

            if (line.contains("D")) {
                currentRow = r;
                currentCol = line.indexOf("D");
            }
        }

        Map<String, int[]> directions = new HashMap<>(Map.of(
                "up", new int[]{-1, 0},
                "down", new int[]{1, 0},
                "left", new int[]{0, -1},
                "right", new int[]{0, 1}
        ));
        int money = 0;

        for (String command : commands) {
            int newRow = currentRow + directions.get(command)[0];
            int newCol = currentCol + directions.get(command)[1];

            if (isOutOfBounds(newRow, newCol, n)) {
                System.out.println("You cannot leave the town, there is police outside!");
                continue;
            }

            matrix[currentRow][currentCol] = '+';

            if (matrix[newRow][newCol] == '$') {
                int currentMoney = newRow * newCol;
                money += currentMoney;
                System.out.printf("You successfully stole %d$.%n", currentMoney);
            } else if (matrix[newRow][newCol] == 'P') {
                matrix[newRow][newCol] = '#';
                System.out.printf("You got caught with %d$, and you are going to jail.%n", money);
                printMatrix(matrix, n);
                return;
            }

            matrix[newRow][newCol] = 'D';
            currentRow = newRow;
            currentCol = newCol;
        }

        System.out.printf("Your last theft has finished successfully with %s$ in your pocket.%n", money);
        printMatrix(matrix, n);
    }

    private static void printMatrix(char[][] matrix, int n) {
        for (int r = 0; r < n; r++) {
            System.out.println(Arrays.toString(matrix[r]).replaceAll("[\\[\\],]", ""));
        }
    }

    private static boolean isOutOfBounds(int newRow, int newCol, int n) {
        return newRow < 0 || newRow >= n || newCol < 0 || newCol >= n;
    }

}
