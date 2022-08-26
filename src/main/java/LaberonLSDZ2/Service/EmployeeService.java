package LaberonLSDZ2.Service;

import LaberonLSDZ2.Domain.Employee;
import LaberonLSDZ2.Exception.EmployeeAlreadyAddedException;
import LaberonLSDZ2.Exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private static final Map<String, Employee> employeeMap = new HashMap<>(5);

    public static Employee addPerson(String firstName, String lastName, String middleName) {
        Employee employee = new Employee(firstName, lastName,middleName);
        for (Employee employee1 : employeeMap.values()) {
        }
        return employeeMap.put(middleName, employee);
    }

    public static Employee findPerson(String firstName, String lastName,String middleName){
        Employee employee = new Employee(firstName, lastName,middleName);
        for (Employee employee1:employeeMap.values()) {
        }
        return employeeMap.get(middleName);
    }

    public static Employee removePerson(String middleName){
            return employeeMap.remove(middleName);
        }

    public static Collection<Employee> getAll() {
        return employeeMap.values();
    }
}


