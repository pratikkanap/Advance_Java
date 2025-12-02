package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeService {


	boolean addNewEmployee();

	List<Employee> displayEmployee();

	boolean deleteEmpId(int eid);

	boolean updateById(int eid, double nsal);



}
