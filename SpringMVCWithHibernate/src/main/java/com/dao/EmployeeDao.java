package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Employee;

@Repository
public class EmployeeDao {
/*
	@Autowired
	DataSource ds;
	
	public int storeEmployeeDao(Employee emp) {
		try {
			Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?)");
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setFloat(3, emp.getSalary());
			int res = pstmt.executeUpdate();
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return 0;
	}*/
	
	@Autowired
	SessionFactory sf;
	public int storeEmployeeDao(Employee emp) {
		Session session =sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
				Integer i= (Integer)session.save(emp);
		tran.commit();
		return i;
	}
	
	public List<Employee> getEmployeeDetails() {
		Session session = sf.openSession();
		Query qry = session.createQuery("from Employee");
		List<Employee> listOfRec = qry.list();
		return listOfRec;
	}
}
