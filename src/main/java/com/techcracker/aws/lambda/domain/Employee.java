package com.techcracker.aws.lambda.domain;

import lombok.Data;

@Data
public class Employee {
	private int id;
	private String name;
	private double salary;	
	
	public Employee(int empId,String empName,double empsalary){
		this.id = empId;
		this.name = empName;
		this.salary = empsalary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
