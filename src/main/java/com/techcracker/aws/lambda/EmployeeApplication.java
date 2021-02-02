package com.techcracker.aws.lambda;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.techcracker.aws.lambda.domain.Employee;
import com.techcracker.aws.lambda.repository.EmployeeDao;

@SpringBootApplication
public class EmployeeApplication {

	@Autowired
	private EmployeeDao employeeDao;

	@Bean
	public Supplier<List<Employee>> employees() {
		return () -> employeeDao.retrieveEmployees();
	}

	@Bean
	public Function<APIGatewayProxyRequestEvent, List<Employee>> findEmployeeByName() {
		return (requestEvent) -> employeeDao.retrieveEmployees().stream()
				.filter(employee -> employee.getName().equals(requestEvent.getQueryStringParameters().get("name")))
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
