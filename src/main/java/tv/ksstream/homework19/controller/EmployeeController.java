package tv.ksstream.homework19.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tv.ksstream.homework19.model.Employee;
import tv.ksstream.homework19.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int department) {
        return employeeService.add(firstName, lastName, salary, department);
    }
    @GetMapping("/remove")
    public void removeEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int department) {
        employeeService.remove(firstName, lastName, salary, department);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int department) {
        return employeeService.find(firstName, lastName, salary, department);
    }
    @GetMapping("/findAll")
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }
}
