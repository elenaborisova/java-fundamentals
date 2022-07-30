package advancedexams.bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    private boolean hasCapacity() {
        return getCount() < capacity;
    }

    public void add(Employee employee) {
        if (hasCapacity()) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        int maxAge = Employee.getMaxAge();

        for (Employee e : employees) {
            if (e.getAge() == maxAge) {
                return e;
            }
        }
        return null;
    }

    public Employee getEmployee(String name) {
        for (Employee e : employees) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder(String.format("Employees working at Bakery %s:%n", name));

        employees.forEach(e -> sb.append(e.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }


}
