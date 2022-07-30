package advancedexams;

import java.util.*;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        Map<String, int[]> moveCommands = new HashMap<>(Map.of(
                "up", new int[]{-1, 0},
                "down", new int[]{1, 0},
                "left", new int[]{0, -1},
                "right", new int[]{0, 1}
        )
        );

        int[] currentPosition = findPosition(matrix, 'S');
        int money = 0;

        while (true) {
            String command = scanner.nextLine();
            int newRow = currentPosition[0] + moveCommands.get(command)[0];
            int newCol = currentPosition[1] + moveCommands.get(command)[1];

            if (!isPositionValid(newRow, newCol, matrix)) {
                System.out.println("Bad news, you are out of the bakery.");
                matrix[currentPosition[0]][currentPosition[1]] = '-';
                break;
            }

            if (Character.isDigit(matrix[newRow][newCol])) {
                money += Integer.parseInt(String.valueOf(matrix[newRow][newCol]));
            } else if (matrix[newRow][newCol] == 'O') {
                matrix[newRow][newCol] = '-';
                int[] newPosition = findPosition(matrix, 'O');
                newRow = newPosition[0];
                newCol = newPosition[1];
            }

            matrix[currentPosition[0]][currentPosition[1]] = '-';
            matrix[newRow][newCol] = 'S';
            currentPosition[0] = newRow;
            currentPosition[1] = newCol;

            if (money >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
        }

        System.out.printf("Money: %d%n", money);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static boolean isPositionValid(int r, int c, char[][] matrix) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static int[] findPosition(char[][] matrix, char symbol) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == symbol) {
                    return new int[]{r, c};
                }
            }

        }
        return new int[0];
    }
}
