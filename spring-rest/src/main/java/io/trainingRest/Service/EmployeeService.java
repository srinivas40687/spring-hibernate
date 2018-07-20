package io.trainingRest.Service;

import io.trainingRest.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findOne(String id);
    Employee create(Employee employee);
    Employee update(String id, Employee employee);
    Employee delete(String id);
}
