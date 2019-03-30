package com.firstproject2.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.firstproject2.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String>{

}
