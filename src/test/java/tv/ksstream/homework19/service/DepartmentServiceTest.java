package tv.ksstream.homework19.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tv.ksstream.homework19.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    @Mock
    private EmployeeService employeeService;
    private List<Employee> employees = List.of(
            new Employee("Mike", "Rotter", 60000, 1),
            new Employee("Comrade", "Nagisych", 70000, 1),
            new Employee("Sglypa", "Kva", 50000, 2)
    );
    @BeforeEach
    public void init() {
        employeeService = Mockito.mock(EmployeeService.class);
        departmentService = new DepartmentServiceImpl(employeeService);
    }
    @Test
    public void toReturnEmployeeWithMaxSalary() {
        when(employeeService.findAll()).thenReturn(employees);
        Employee employee = departmentService.employeeMaxSalary(1);
        Assertions.assertEquals("Comrade", employee.getFirstName());
        Assertions.assertEquals("Nagisych", employee.getLastName());
    }
    @Test
    public void toReturnEmployeeWithMinSalary() {
        when(employeeService.findAll()).thenReturn(employees);
        Employee employee = departmentService.employeeMinSalary(1);
        Assertions.assertEquals("Mike", employee.getFirstName());
        Assertions.assertEquals("Rotter", employee.getLastName());
    }
    @Test
    public void toReturnEmployeeByDepartment() {
        when(employeeService.findAll()).thenReturn(employees);
        Map<Integer, List<Employee>> result = departmentService.findEmployeeByDepartment();
        Assertions.assertEquals(2, result.size());
        org.assertj.core.api.Assertions.assertThat(result.get(1))
                .hasSize(2)
                .contains(employees.get(0), employees.get(1));
        org.assertj.core.api.Assertions.assertThat(result.get(2))
                .hasSize(1)
                .contains(employees.get(2));
    }
    @Test
    public void toReturnEmployeeDividedInDepartment1() {
        when(employeeService.findAll()).thenReturn(employees);
        Collection<Employee> employeeCollection = departmentService.findEmployeeDividedInDepartments(1);
        Assertions.assertEquals(2, employeeCollection.size());
    }
    @Test
    public void toReturnEmployeeDividedInDepartment2() {
        when(employeeService.findAll()).thenReturn(employees);
        Collection<Employee> employeeCollection = departmentService.findEmployeeDividedInDepartments(2);
        Assertions.assertEquals(1, employeeCollection.size());
    }
}
