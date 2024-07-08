package com.rh.PROJECT1.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rh.PROJECT1.Dao.MainDao;
import com.rh.PROJECT1.Entity.Country;
import com.rh.PROJECT1.Entity.Employee;

@Service
public class MainService {
	@Autowired
	MainDao dao;
	public String insertCountry(Country c) {
		String msg = dao.insertCountry(c);
		if (msg==null) {
			System.out.println("failed to insert country data !");
		}
		return msg;
	}
	public String updateCountry(int id, Country c) {
		String msg = dao.updateCountry(id, c);
		if (msg==null) {
			System.out.println("failed to update country data !");
		}
		return msg;
	}
	public String deleteCountry(int id) {
		String msg = dao.deleteCountry(id);
		if (msg==null) {
			System.out.println("failed to delete country data !");
		}
		return msg;
	}
	public Country fetchsingleCountry(int id) {
		Country cn = dao.fetchsingleCountry(id);
		if (cn==null) {
			System.out.println("failed to fetch country data !");
		}
		return cn;
	}
	public List<Country> fetchallCountry(){
		List<Country> list = dao.fetchallCountry();
		if (list==null) {
			System.out.println("failed to fetch country data !");
		}
		return list;
	}
	public String addEmployee(Employee e) {
		String msg = dao.addEmployee(e);
		if (msg==null) {
			System.out.println("failed to save employee data !");
		}
		return msg;
	}
	public String updateEmployee(int id, Employee e) {
		String msg = dao.updateEmployee(id, e);
		if (msg==null) {
			System.out.println("failed to update employee data !");
		}
		return msg;
	}
	public String deleteEmployee(int id) {
		String msg = dao.deleteEmployee(id);
		if (msg==null) {
			System.out.println("failed to delete employee data");
		}
		return msg;
	}
	public Employee getSingleEmployee(int id) {
		Employee emp = dao.getSingleEmployee(id);
		if (emp==null) {
			System.out.println("failed to fetch employee data");
		}
		return emp;
	}
	public List<Employee> getAllEmployee() {
		List<Employee> list = dao.getAllEmployee();
		if (list==null) {
			System.out.println("failed to fetch employee data");
		}
		return list;
	}
	public List<Employee> getEmployeebyStatus(String status) {
		List<Employee> list = dao.getEmployeebyStatus(status);
		if (list==null) {
			System.out.println("failed to fetch employee data");
		}
		return list;
	}
}
