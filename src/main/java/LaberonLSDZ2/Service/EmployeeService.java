package LaberonLSDZ2.Service;

import LaberonLSDZ2.Domain.Employee;
import LaberonLSDZ2.Exception.EmployeeAlreadyAddedException;
import LaberonLSDZ2.Exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private static final Map<String, Employee> employeeMap = new HashMap<>(5);

    public static Employee addPerson(String firstName, String lastName, String middleName) throws EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName,middleName);
        for (Employee employee1 : employeeMap.values()) {
//            throw new EmployeeAlreadyAddedException("Такой сотрудник есть в базе");
        }
        return employeeMap.put(middleName, employee);
    }

    public static Employee findPerson(String firstName, String lastName,String middleName)throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName,middleName);
        if (employee.getFirstName().equals(firstName) && Objects.equals(employee.getLastName(), lastName)) {
            return employeeMap.get(middleName);
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    public static Employee removePerson(String middleName)throws EmployeeNotFoundException {
        if (employeeMap.containsKey(middleName)) {
            return employeeMap.remove(middleName);
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    public static Collection<Employee> getAll() {
        return employeeMap.values();
    }
}


