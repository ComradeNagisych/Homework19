package tv.ksstream.homework19.service;

import org.springframework.stereotype.Service;
import tv.ksstream.homework19.exception.EmployeeNotFoundException;
import tv.ksstream.homework19.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
@Service

public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;
    public DepartmentServiceImpl (EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Employee employeeMaxSalary (int department) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
    @Override
    public Employee employeeMinSalary (int department) {
        return employeeService
                .findAll()
                .stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
    @Override
    public Map<Integer, List<Employee>> findEmployeeByDepartment() {
        return employeeService
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
                .collect(groupingBy(Employee::getDepartment));
    }
    @Override
    public Collection<Employee> findEmployeeDividedInDepartments(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
                .collect(Collectors.toList());
    }
}
