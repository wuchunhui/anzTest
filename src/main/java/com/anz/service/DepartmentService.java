package com.anz.service;

import java.util.List;

import com.anz.exception.ParammeterException;
import com.anz.mybatis.generator.model.Department;

/**
 * this interface definition business operation of department
 * 
 * @author jesse
 *
 */
public interface DepartmentService {

	/**
	 * add department
	 * 
	 * @param department
	 * @return 1 success,0 fail
	 */
	public int addDepartment(Department department) throws ParammeterException ;

	/**
	 * update department
	 * 
	 * @param department
	 * @return 1 success,0 fail
	 */
	public int updateDepartment(Department department) throws ParammeterException ;

	/**
	 * remove department
	 * 
	 * @param department
	 * @return 1 success,0 fail
	 */
	public int removeDepartment(Long id) throws ParammeterException ;

	/**
	 * search department
	 * 
	 * @param department
	 * @return all employees accord with the condition
	 */
	public List<Department> searchDepartment(Department department);
}
