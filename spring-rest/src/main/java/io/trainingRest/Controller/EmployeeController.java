package io.trainingRest.Controller;

import io.trainingRest.Entity.Employee;
import io.trainingRest.Service.EmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "employees")
public class EmployeeController {

    final static Logger logger = Logger.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> findAll(){
        logger.info("Entering the findAll method");

        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Employee findOne(@PathVariable("id") String empid) {
        logger.info("Entering the Search by ID method");

        return service.findOne(empid);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee){
        logger.info("Entering the Create method");

        return service.create(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Employee update(@PathVariable("id") String empid, @RequestBody Employee employee){

        logger.info("Entering the Update method");
        return service.update(empid, employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable("id") String empid){

        logger.info("Entering the delete method");
        service.delete(empid);

    }
}
