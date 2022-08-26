package LaberonLSDZ2.Service;

import LaberonLSDZ2.Domain.Employee;
import LaberonLSDZ2.Exception.EmployeeAlreadyAddedException;
import LaberonLSDZ2.Exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private static final Map<String, Employee> employeeMap = new HashMap<>(5);

    public static Employee addPerson(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);//,middleName
        if(employeeMap.containsKey(employee.getFullName())){
        throw new EmployeeAlreadyAddedException("Message");}
//        for (Employee employee1 : employeeMap.values()) {
//        }
//        return employeeMap.put(middleName, employee);
        employeeMap.put(employee.getFullName(), employee);
        return employee;
    }

    public static Employee findPerson(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);//,middleName
        if (employeeMap.containsKey(employee.getFullName())) {
            return employeeMap.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("message");
//        for (Employee employee1:employeeMap.values()) {
//        }
//        return employeeMap.get(middleName);
    }

    public static Employee removePerson(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);//,middleName
        if (employeeMap.containsKey(employee.getFullName())) {
            return employeeMap.remove(employee.getFullName());
        }
//            return employeeMap.remove(middleName);
        throw new EmployeeNotFoundException("Message");
        }

    public static Collection<Employee> getAll() {
        return employeeMap.values();
    }
}


