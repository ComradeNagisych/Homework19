package tv.ksstream.homework19.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import tv.ksstream.homework19.model.Employee;

import java.util.Collection;
@Service
@Primary
public class SetBasedEmployeeService implements EmployeeService {

    @Override
    public Employee add(String firstName, String lastName, int salary, int departmant) {
        return new Employee("Ivan", "Ivanov", 70000, 1);
    }

    @Override
    public void remove(String firstName, String lastName, int salary, int department) {

    }

    @Override
    public Employee find(String firstName, String lastname, int salary, int department) {
        return null;
    }

    @Override
    public Collection<Employee> findAll() {
        return null;
    }
}
