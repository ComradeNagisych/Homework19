package tv.ksstream.homework19.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tv.ksstream.homework19.model.Employee;
import tv.ksstream.homework19.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    public DepartmentController (DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping ("/max-salary")
    public Employee employeeMaxSalary (@RequestParam int department) {
        return departmentService.employeeMaxSalary(department);
    }
    @GetMapping ("/min-salary")
    public Employee employeeMinSalary (@RequestParam int department) {
        return departmentService.employeeMinSalary(department);
    }
    @GetMapping ("/all")
    public Map<Integer, List<Employee>> findEmployees() {
        return departmentService.findEmployeeByDepartment();
    }
    @GetMapping (path = "/all", params = {"department"})
    public Collection<Employee> findEmployees (@RequestParam int department) {
        return departmentService.findEmployeeDividedInDepartments(department);
    }
}
