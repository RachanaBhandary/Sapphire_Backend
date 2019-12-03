package com.slk.rest;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.slk.dao.EmployeeDAOImpl;
import com.slk.model.Customer;
import com.slk.model.Employee;

@RestController
@Repository
@CrossOrigin(origins = "http://localhost:4200")
public class RestEmployee {
	@Autowired
	EmployeeDAOImpl employeeDaoimpl= new EmployeeDAOImpl();
	
	@GetMapping("/agent")
	public List getAgent()
	{
		return employeeDaoimpl.list();
	}
	@GetMapping("/customer")
	public List getCustomer() throws SQLException
	{
		return employeeDaoimpl.getAllCustomer();
	}
	@GetMapping("/transaction")
	public List getTransaction() throws SQLException
	{
		return employeeDaoimpl.getAllTransaction();
	}
	
	@DeleteMapping("/delete/agent/{id}")
	public ResponseEntity deleteCustomer(@PathVariable String id) {
	
		if (null == employeeDaoimpl.delete(id)) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}
	@PutMapping("/put/customer/{id}")
	public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer c) {
      System.out.println("ggasgcs");
		c =employeeDaoimpl.update(id, c);

		if (null == c) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(c, HttpStatus.OK);
	}
	@PutMapping("/put/agent/{id}")
	public ResponseEntity updateAgent1(@PathVariable Long id, @RequestBody Employee e) {
      System.out.println("ggasgcs");
		e =employeeDaoimpl.updateAgent(id, e);

		if (null == e) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(e, HttpStatus.OK);
	}

}
	


