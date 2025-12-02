package com.demo.beans;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	private int eid;
	private String ename;
	private double sal;
	private LocalDate hiredate;
	
	@ManyToMany
	Set<Project> pset ;
	public Employee() {
		super();
	}
	
	
	public Employee(int eid, String ename, double sal, LocalDate hiredate, Set<Project> pset) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
		this.hiredate = hiredate;
		this.pset = pset;
	}


	public Employee(int eid, String ename, double sal, LocalDate hiredate) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
		this.hiredate = hiredate;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public LocalDate getHiredate() {
		return hiredate;
	}
	public void setHiredate(LocalDate hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", sal=" + sal + ", hiredate=" + hiredate + "]";
	}
	
	
}
