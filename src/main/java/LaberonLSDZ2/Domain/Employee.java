package LaberonLSDZ2.Domain;

import java.util.*;

public class Employee {
    private final String firstName;
    private final String lastName;

    private Set<String> middleName;

    public String getFullName() {
        return firstName+" "+lastName;
    }

    public Set<String> getMiddleName() {
        return middleName;
    }

    public void setMiddleName(Set<String> middleName) {
        middleName = middleName;
    }

    public Employee(String firstName, String lastName) {//String middleName
        this.firstName = firstName;
        this.lastName = lastName;
//        this.middleName = new HashSet<>(List.of(middleNames));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(middleName, employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName=" + middleName +
                '}';
    }
}