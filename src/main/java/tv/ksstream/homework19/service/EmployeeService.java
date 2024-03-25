package tv.ksstream.homework19.service;

import tv.ksstream.homework19.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    void remove(String firstName, String lastName);
    Employee find(String firstName, String lastname);
    Collection<Employee> findAll();
}
