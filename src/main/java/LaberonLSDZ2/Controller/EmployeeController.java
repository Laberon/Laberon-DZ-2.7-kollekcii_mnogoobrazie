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
                      @RequestParam("secondName") String secondName) {
        employeeService.addPerson(firstName, secondName);
        return "Добавлен";
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("name") String firstname,
                         @RequestParam("secondName") String secondName) {
        return employeeService.findPerson(firstname, secondName);
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("name") String firstname,
                         @RequestParam("secondName") String secondName) {
        employeeService.removePerson(firstname, secondName);
        return "Сотрудник: "+firstname+" удален";
    }
    @GetMapping(path = "/findall")
    public Collection<Employee> find() {
        return employeeService.getAll();
    }
}
