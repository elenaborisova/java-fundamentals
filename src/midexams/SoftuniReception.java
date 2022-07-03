package midexams;

import java.util.Scanner;

public class SoftuniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employeeEfficiency = 0;
        for (int i = 0; i < 3; i++) {
            employeeEfficiency += Integer.parseInt(scanner.nextLine());
        }

        int studentsCount = Integer.parseInt(scanner.nextLine());
        int totalHours = 0;

        while (studentsCount > 0) {
            totalHours++;
            if (totalHours % 4 == 0) {
                totalHours++;
            }
            studentsCount -= employeeEfficiency;
        }

        System.out.println("Time needed: " + totalHours + "h.");
    }
}
