package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;
import com.demo.service.ProjectService;
import com.demo.service.ProjectServiceImpl;

public class TestEmployeeProject {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ProjectService pservice=new ProjectServiceImpl();
		EmployeeService eservice=new EmployeeServiceImpl();
		
		int choice=0;
		do {
			System.out.println("1. Add project");
			System.out.println("2. Add Employees");
		    System.out.println("3. show all employees");
		    System.out.println("4. delete employee");
			System.out.println("5. update Employees salary");
		    System.out.println("6. exit\nchoice:");
		    choice=sc.nextInt();
		    switch(choice) {
		    case 1 :
		    	pservice.addNewProject();
		    	break;
		    
		    case 2: 
		    	boolean status=eservice.addNewEmployee();
		    	if(status) {
		    		System.out.println("employee added successfully");
		    	}else {
		    		System.out.println("Not added");
		    	}break;
		    case 3:
		    	List<Employee> elist = eservice.displayEmployee();
		    	elist.forEach(System.out::print);
		    	break;
		    
		    case 4:
		    	System.out.println("Enter employee id to delete:");
		    	int eid = sc.nextInt();
		    	boolean status1 = eservice.deleteEmpId(eid);
		    	if(status1) {
		    		System.out.println("Deleted Successfully");
		    	}
		    	else {
		    		System.out.println("not found");
		    	}
		    	break;
		    	
		    case 5:
		    	System.out.println("Enter Employee salary to update:");
		    	int eid1= sc.nextInt();
		    	System.out.println("Enter new salary:");
		    	double nsal = sc.nextDouble();
		    	boolean st = eservice.updateById(eid1,nsal);
		    	if(st) {
		    		System.out.println("Updated successfully");
		    	}
		    	else {
		    		System.out.println("not found");
		    	}
		    	break;
		    	
		    	
		    case 6 :
		    	System.out.println("Thank you for visiting");
		    	sc.close();
		    	break;
		    }
		    
		}while(choice!=6);

	}

}
