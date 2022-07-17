package midexams;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int lecturesCount = Integer.parseInt(scanner.nextLine());
        int addBonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = 0;
        int maxAttendance = 0;

        for (int i = 0; i < studentsCount; i++) {
            int studentAttendance = Integer.parseInt(scanner.nextLine());
            double bonus = (studentAttendance * 1.0 / lecturesCount) * (5 + addBonus);

            if (bonus > maxBonus) {
                maxBonus = bonus;
                maxAttendance = studentAttendance;
            }
        }

        System.out.printf("Max Bonus: %d.\n" +
                        "The student has attended %d lectures.",
                (int) Math.ceil(maxBonus), maxAttendance);
    }
}
