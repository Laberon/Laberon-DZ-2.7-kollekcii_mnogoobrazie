package LaberonLSDZ2.Controller;


import LaberonLSDZ2.Domain.Employee;
import LaberonLSDZ2.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam("name") String firstName,
                      @RequestParam("secondName") String secondName,
                      @RequestParam("middleName") String middleName) {
        employeeService.addPerson(firstName, secondName,middleName);
        return "Добавлен";
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("name") String firstname,
                         @RequestParam("secondName") String secondname,
                         @RequestParam("middleName") String middleName) {
        return employeeService.findPerson(firstname, secondname, middleName);
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("middleName") String middleName) {
        employeeService.removePerson(middleName);
        return "Сотрудник: "+middleName+" удален";
    }
    @GetMapping(path = "/findall")
    public Collection<Employee> find() {
        return employeeService.getAll();
    }
}
