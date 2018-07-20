package io.trainingRest.Repository;

import io.trainingRest.Entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    List<Employee> findAll();
    Employee findOne(String id);
    Employee create(Employee employee);
    Employee update(Employee employee);
    Employee delete(Employee emp);
    Employee findByEmail(String email);

}
