package com.anz.serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.anz.exception.ParammeterException;
import com.anz.mybatis.generator.model.Department;
import com.anz.service.DepartmentService;

/**
 * department business test
 * 
 * @author jesse
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class DepartementServiceTest {

	@Autowired
	private DepartmentService DepartmentService;

	@Test
	@Transactional
	@Rollback(true)
	public void testAddDepartment() {
		Department department = new Department();
		department.setName("testName");
		department.setOpenPositions(1);
		try {
			DepartmentService.addDepartment(department);
		} catch (ParammeterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateDepartment() {
		Department department = new Department();
		department.setId(1L);
		department.setName("testNameNew");
		department.setOpenPositions(1);
		try {
			DepartmentService.updateDepartment(department);
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
			DepartmentService.removeDepartment(1L);
		} catch (ParammeterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSearchDepartment() {
		Department department = new Department();
		department.setId(1L);
		DepartmentService.searchDepartment(department);
	}

}
