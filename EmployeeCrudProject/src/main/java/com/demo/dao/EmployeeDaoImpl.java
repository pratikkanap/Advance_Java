package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	static SessionFactory sf;
	static {
		sf = HibernateUtil.getMySessionFactory();
	}

	public boolean save(Employee e) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(e);
		tr.commit();
		session.close();
		return true;

	}

	@Override
	public List<Employee> showEmployee() {
		List<Employee> eList = null;
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		String hql = "FROM Employee";
		eList = session.createQuery(hql, Employee.class).getResultList();
		tr.commit();
		session.close();

		return eList;
	}

	@Override
	public boolean removeById(int eid) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Employee employeeToDelete = session.get(Employee.class, eid);
		if (employeeToDelete != null) {
			session.delete(employeeToDelete);
			tr.commit();
			session.close();
			return true;
		} else {

			session.close();
			return false;
		}
	}

	@Override
	public boolean changeById(int eid, double nsal) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		String hql = "UPDATE Employee SET eid = :newEid WHERE sal = :oldSal";
		int rowsAffected = session.createQuery(hql).setParameter("newSal", nsal).setParameter("Eid", eid)
				.executeUpdate();

		tr.commit();
		session.close();

		return rowsAffected > 0;
	}
}
