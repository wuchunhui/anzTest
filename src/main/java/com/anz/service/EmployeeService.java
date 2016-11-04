package com.anz.service;

import java.util.List;

import com.anz.exception.ParammeterException;
import com.anz.mybatis.generator.model.Employee;

/**
 * this interface definition the business operation of employee
 * 
 * 
 * @author jesse
 * @since 1.0
 */
public interface EmployeeService {
	/**
	 * add the employee
	 * 
	 * @param employee
	 * @throws ParammeterException
	 * @return 1 success,0 fail
	 */
	public int addEmployee(Employee employee) throws ParammeterException ;

	/**
	 * update the employee
	 * 
	 * @param employee
	 * @throws ParammeterException
	 * @return 1 success,0 fail
	 */
	public int updateEmployee(Employee employee) throws ParammeterException ;

	/**
	 * remove the employee
	 * 
	 * @param employee
	 * @throws ParammeterException
	 * @return 1  success,0 fail
	 */
	public int removeEmployee(Long id) throws ParammeterException ;

	/**
	 * search the employee
	 * 
	 * @param employee
	 * @return all employees accord with the condition
	 */
	public List<Employee> searchEmployee(Employee employee);

}
