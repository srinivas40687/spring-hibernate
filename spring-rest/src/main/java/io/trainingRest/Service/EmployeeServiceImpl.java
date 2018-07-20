package io.trainingRest.Service;

import io.trainingRest.Entity.Employee;
import io.trainingRest.Exception.BadRequestException;
import io.trainingRest.Exception.EmployeeNotFoundException;
import io.trainingRest.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository repo;

    @Transactional(readOnly = true)
    public List<Employee> findAll() {

        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Employee findOne(String id) {

        Employee emp = repo.findOne(id);
        if(emp == null){
            throw new EmployeeNotFoundException("Employee with id " +id + " Not Found");
        } else {
            return emp;
        }
    }

   @Transactional
    public Employee create(Employee employee) {
       System.out.println("Entered into Service layer");
        Employee emp = repo.findByEmail(employee.getEmail());
        if(emp != null){
            throw new BadRequestException("Employee with email " +employee.getEmail() + " Not Found");
        }
        return repo.create(employee);
    }

    @Transactional
    public Employee update(String id, Employee employee) {
        Employee emp = repo.findOne(id);
        if(emp == null){
            throw new EmployeeNotFoundException(" Employee with id" +id + " Not Found");
        }
        return repo.update(employee);
    }

    @Transactional
    public Employee delete(String id) {
        Employee emp = repo.findOne(id);
        if(emp == null){
            throw new EmployeeNotFoundException(" Employee with id" +id + " Not Found");
        }
        return repo.delete(emp);

    }
}
