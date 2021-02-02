package com.techcracker.aws.lambda.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.techcracker.aws.lambda.domain.Employee;

@Repository
public class EmployeeDao {

	public List<Employee> retrieveEmployees() {
		return Stream.of(new Employee(1, "EmpOne", 1000.00), new Employee(2, "EmpTwo", 20000.00),
				new Employee(3, "EmpThree", 30000.00)).collect(Collectors.toList());
	}

}