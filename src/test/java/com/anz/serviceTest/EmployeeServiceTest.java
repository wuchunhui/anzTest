package com.anz.serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.anz.exception.ParammeterException;
import com.anz.mybatis.generator.model.Employee;
import com.anz.service.EmployeeService;

/**
 * employee business test
 * 
 * @author jesse
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@Test
	@Transactional
	@Rollback(true)
	public void testAddDepartment() {
		Employee employee = new Employee();
		employee.setFirstName("firstNameTest");
		employee.setLastName("lastNameTest");
		employee.setIdapUserName("idapUserNameTest");
		employee.setTitle("titleTest");
		employee.setGender("genderTest");
		try {
			employeeService.addEmployee(employee);
		} catch (ParammeterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateDepartment() {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setFirstName("firstNameTest");
		employee.setLastName("lastNameTest");
		employee.setIdapUserName("idapUserNameTest");
		employee.setTitle("titleTest");
		employee.setGender("genderTest");
		try {
			employeeService.updateEmployee(employee);
		} catch (ParammeterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testRemoveDepartment() {
		try {
			employeeService.removeEmployee(1L);
		} catch (ParammeterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSearchDepartment() {
		Employee employee = new Employee();
		employee.setId(1L);
		employeeService.searchEmployee(employee);
	}

}
