package com.rh.PROJECT1.controller;

//import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rh.PROJECT1.Entity.Country;
import com.rh.PROJECT1.Entity.Employee;
import com.rh.PROJECT1.service.MainService;

@RestController
@RequestMapping("Api")
public class MainController {
	@Autowired
	MainService service;
	//Insert country data API
	@PostMapping("/insertcountry")
	public String insertCountry(@RequestBody Country c) {
		String msg = service.insertCountry(c);
		return msg;
	}
	//Update country data API
	@PutMapping("/updatecountry/{id}")
	public String updateCountry(@PathVariable int id,@RequestBody Country c) {
		String msg = service.updateCountry(id, c);
		return msg;
	}
	//Delete country data API
	@DeleteMapping("/deletecountry/{id}")
	public String deleteCountry(@PathVariable int id) {
		String msg = service.deleteCountry(id);
		return msg;
	}
	//Fetch single country data API
	@GetMapping("/fetchsinglecountry/{id}")
	public Country fetchsingleCountry(@PathVariable int id) {
		Country cn = service.fetchsingleCountry(id);
		return cn;
	}
	//Fetch all country data API
	@GetMapping("/fetchallcountry")
	public List<Country> fetchallCountry() {
		List<Country> list = service.fetchallCountry();
		return list;
	}
	//Insert employee data API
	@PostMapping("/insertemployee")
	public String addEmployee(@RequestBody Employee e) {
		String msg = service.addEmployee(e);
		return msg;
	}
	//Update employee data API
	@PutMapping("/updateemployee/{id}")
	public String updateEmployee(@PathVariable int id,@RequestBody Employee e) {
		String msg = service.updateEmployee(id, e);
		return msg;
	}
	//Delete employee data API
	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		String msg = service.deleteEmployee(id);
		return msg;
	}
	//Fetch single employee data API
	@GetMapping("/fetchsingleemployee/{id}")
	public Employee getSingleEmployee(@PathVariable int id) {
		Employee emp = service.getSingleEmployee(id);
		return emp;
	}
	//Fetch all employee data API
	@GetMapping("/fetchallemployee")
	public List<Employee> getAllEmployee() {
		List<Employee> list = service.getAllEmployee();
		return list;
	}
	//Fetch employee by status API
	@GetMapping("/fetchemployeebystatus/{status}")
	public List<Employee> getEmployeebyStatus(@PathVariable String status){
		List<Employee> list = service.getEmployeebyStatus(status);
		return list;
	}
}
