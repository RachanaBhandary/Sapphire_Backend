package com.slk.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.slk.model.Customer;
import com.slk.model.Employee;
import com.slk.model.Transaction;
@Repository
public interface EmployeeDAO {
	public List list();
	public String delete(String id);
	public Customer  update(Long id, Customer c);
	public List<Customer> getAllCustomer() throws SQLException;
	public List<Transaction> getAllTransaction() throws SQLException;
	public Employee updateAgent(Long id, Employee e);
}
