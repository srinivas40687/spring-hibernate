package io.trainingRest.Repository;

import io.trainingRest.Entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.FindAllEmployees", Employee.class);

        return query.getResultList();
    }

    @Override
    public Employee findOne(String id) {

        return entityManager.find(Employee.class, id);

    }

    @Override
    public Employee findByEmail(String email) {

        TypedQuery<Employee> query = entityManager.createNamedQuery("Employee.FindByEmail", Employee.class);

        query.setParameter("paramEmail", email);
        List<Employee> resultList = query.getResultList();

        if(resultList != null && resultList.size() == 1){
            System.out.println("Entered here");
            return resultList.get(0);

        }else {
            System.out.println("Entered into else statement");
            return null;
        }
    }

    @Override
    public Employee create(Employee employee) {
        entityManager.persist(employee);

        return employee;
    }

    @Override
    public Employee update(Employee employee) {

        return entityManager.merge(employee);



    }

    @Override
    public Employee delete(Employee emp) {

        entityManager.remove(emp);

        return emp;

    }
}
