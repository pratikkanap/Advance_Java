package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;



import com.demo.beans.Employee;
import com.demo.beans.Project;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;
import com.demo.dao.ProjectDao;




public class EmployeeServiceImpl implements EmployeeService{
	  private EmployeeDao edao;
	   private ProjectDao pdao;

	public EmployeeServiceImpl() {
		super();
		this.edao = new EmployeeDaoImpl();
	}
	
	public boolean addNewEmployee() {
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Enter new ID:");
	    int eid = sc.nextInt();
	    sc.nextLine(); 

	    System.out.println("Enter employee name:");
	    String ename = sc.nextLine(); 

	    System.out.println("Enter hiredate (dd/MM/yyyy):");
	    String dt = sc.next();
	    
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate ldt;
	    try {
	        ldt = LocalDate.parse(dt, formatter);
	    } catch (Exception e) {
	        System.out.println("Invalid date format. Returning false.");
	        return false; 
	    }

	    System.out.println("Enter salary:");
	    double s = sc.nextDouble();
	    sc.nextLine(); 

	    System.out.println("Enter project Id:");
	    String pid = sc.nextLine();
	    String[] parr = pid.split(",");
	    
	    Set<Project> pset = pdao.findByPid(parr);
	    
	    Employee e = new Employee(eid, ename, s, ldt, pset);
	    
	    return edao.save(e);
	}
	
	

	@Override
	public List<Employee> displayEmployee() {
		return edao.showEmployee();
	}

	@Override
	public boolean deleteEmpId(int eid) {
		return edao.removeById(eid);
	}

	
	@Override
	public boolean updateById(int eid, double nsal) {
		// TODO Auto-generated method stub
		return edao.changeById(eid,nsal);
	}
	
	
}
