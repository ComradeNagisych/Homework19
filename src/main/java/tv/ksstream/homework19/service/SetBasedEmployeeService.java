package tv.ksstream.homework19.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tv.ksstream.homework19.model.Employee;

import java.util.Collection;
@Service
@Primary
public class SetBasedEmployeeService implements EmployeeService {

    @Override
    public Employee add(String firstName, String lastName) {
        return new Employee("Ivan", "Ivanov");
    }

    @Override
    public void remove(String firstName, String lastName) {

    }

    @Override
    public Employee find(String firstName, String lastname) {
        return null;
    }

    @Override
    public Collection<Employee> findAll() {
        return null;
    }
}
