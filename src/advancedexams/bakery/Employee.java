package advancedexams.bakery;

public class Employee {
    private String name;
    private int age;
    private static int maxAge = 0;
    private String country;

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        maxAge = Math.max(this.age, maxAge);
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static int getMaxAge() {
        return maxAge;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, %d (%s)", name, age, country);
    }
}
