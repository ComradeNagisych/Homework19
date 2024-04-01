package tv.ksstream.homework19.service;

import tv.ksstream.homework19.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee employeeMaxSalary (int department);
    Employee employeeMinSalary (int department);
    Map<Integer, List<Employee>> findEmployeeByDepartment();
    Collection<Employee> findEmployeeDividedInDepartments (int department);
}
