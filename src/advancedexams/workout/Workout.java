package advancedexams.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return exercises.removeIf(e -> e == getExercise(name, muscle));

//        Exercise exercise = getExercise(name, muscle);
//        if (exercise != null) {
//            exercises.remove(exercise);
//            return true;
//        }
//        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public Exercise getMostBurnedCaloriesExercise() {
        Exercise exercise = null;
        for (Exercise e : exercises) {
            if (exercise == null || exercise.getBurnedCalories() < e.getBurnedCalories()) {
                exercise = e;
            }
        }
        return exercise;
    }

    public int getExerciseCount() {
        return exercises.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("Workout type: %s", type));
        exercises.forEach(e -> sb.append(System.lineSeparator()).append(e));
        return sb.toString();
    }
}
