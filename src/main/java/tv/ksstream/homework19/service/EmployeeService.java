package tv.ksstream.homework19.service;

import tv.ksstream.homework19.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int salary, int department);
    Employee remove(String firstName, String lastName, int salary, int department);
    Employee find(String firstName, String lastname, int salary, int department);
    Collection<Employee> findAll();
}
