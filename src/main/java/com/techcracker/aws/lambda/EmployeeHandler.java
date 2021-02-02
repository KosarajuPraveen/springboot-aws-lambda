package com.techcracker.aws.lambda;

import java.util.List;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.techcracker.aws.lambda.domain.Employee;

public class EmployeeHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent, List<Employee>>{

}
