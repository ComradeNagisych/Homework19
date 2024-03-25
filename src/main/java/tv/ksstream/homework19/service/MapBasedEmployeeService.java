package tv.ksstream.homework19.service;

import org.springframework.stereotype.Service;
import tv.ksstream.homework19.exception.EmployeeAlreadyExistsException;
import tv.ksstream.homework19.exception.EmployeeNotFoundException;
import tv.ksstream.homework19.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class MapBasedEmployeeService implements EmployeeService {
    private final Map<String, Employee> storage = new HashMap<>();

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (storage.containsKey(firstName + lastName)) {
            throw new EmployeeAlreadyExistsException("Employee already exists, addition impossible");
        }
        storage.put(firstName + lastName, employee);
        return employee;
    }
    @Override
    public void remove(String firstName, String lastName) {
        if (!storage.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException("Employee not found, removal impossible");
        }
        storage.remove(firstName + lastName);
    }
    @Override
    public Employee find(String firstName, String lastName) {
        if (!storage.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException("Employee not found, search stopped");
        }
        return storage.get(firstName + lastName);
    }
    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(storage.values());
    }
}
