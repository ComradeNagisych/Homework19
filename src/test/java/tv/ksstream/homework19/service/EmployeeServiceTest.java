package tv.ksstream.homework19.service;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tv.ksstream.homework19.exception.EmployeeAlreadyExistsException;
import tv.ksstream.homework19.exception.EmployeeNotFoundException;
import tv.ksstream.homework19.model.Employee;

import java.util.Collection;

public class EmployeeServiceTest {
    private EmployeeService service = new MapBasedEmployeeService();
    @Test
    public void toAddNewEmployee () {
        Employee employee = service.add("Mike", "Rotter", 60000, 1);
        Assertions.assertEquals("Mike", employee.getFirstName());
        Assertions.assertEquals("Rotter", employee.getLastName());
        Assertions.assertEquals(60000, employee.getSalary());
        Assertions.assertEquals(1, employee.getDepartment());
        Assertions.assertEquals(service.find("Mike", "Rotter", 60000, 1), employee);
    }
    @Test
    public void toThrowExceptionIfAddingExistingEmployee() {
        service.add("Mike", "Rotter", 60000, 1);
        Assertions.assertThrows(EmployeeAlreadyExistsException.class, () -> service.add("Mike", "Rotter", 60000, 1));
    }
    @Test
    public void toRemoveEmployee() {
        Employee employee = service.add("Mike", "Rotter", 60000, 1);
        Assertions.assertEquals("Mike", employee.getFirstName());
        Assertions.assertEquals("Rotter", employee.getLastName());
        Assertions.assertEquals(60000, employee.getSalary());
        Assertions.assertEquals(1, employee.getDepartment());
        service.remove("Mike", "Rotter", 60000, 1);
    }
    @Test
    public void toThrowExceptionIfDeletedEmployeeDoesNotExist() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> service.remove("Mike", "Rotter", 60000, 1));
    }
    @Test
    public void toFindEmployee() {
        service.add("Mike", "Rotter", 60000, 1);
        Employee employee = service.find("Mike", "Rotter", 60000, 1);
        Assertions.assertEquals("Mike", employee.getFirstName());
        Assertions.assertEquals("Rotter", employee.getLastName());
        Assertions.assertEquals(60000, employee.getSalary());
        Assertions.assertEquals(1, employee.getDepartment());
    }
    @Test
    public void toThrowExceptionIfEmployeeDoesNotExist () {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> service.find("Mike", "Rotter", 60000, 1));
    }
    @Test
    public void toReturnAllEmployees() {
        Employee rotter = service.add("Mike", "Rotter", 60000, 1);
        Employee nagisych = service.add("Comrade", "Nagisych", 70000, 2);
        Collection<Employee> employees = service.findAll();
        Assertions.assertEquals(2, employees.size());
        MatcherAssert.assertThat(employees, Matchers.containsInAnyOrder(rotter, nagisych));
    }
}
