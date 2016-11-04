package com.anz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.anz.exception.ParammeterException;
import com.anz.mybatis.generator.dao.EmployeeMapper;
import com.anz.mybatis.generator.model.Employee;
import com.anz.mybatis.generator.model.EmployeeExample;
import com.anz.mybatis.generator.model.EmployeeExample.Criteria;

/**
 * implements employee interface
 * @author jesse
 *
 */
@Transactional
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public int addEmployee(Employee employee) throws ParammeterException {
		if (!StringUtils.isEmpty(employee.getId())) {
			throw new ParammeterException("id must be null in add method");
		}
		validateData(employee);
		return employeeMapper.insert(employee);
	}

	@Override
	public int updateEmployee(Employee employee) throws ParammeterException {
		if (StringUtils.isEmpty(employee.getId())) {
			throw new ParammeterException(
					"id must be not null in update method");
		}
		validateData(employee);
		return employeeMapper.updateByPrimaryKey(employee);
	}

	@Override
	public int removeEmployee(Long id) throws ParammeterException {
		if (StringUtils.isEmpty(id)) {
			throw new ParammeterException(
					"id must be not null in remove method");
		}
		return employeeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Employee> searchEmployee(Employee employee) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(employee.getId())) {
			criteria.andIdEqualTo(employee.getId());
		}
		if (!StringUtils.isEmpty(employee.getFirstName())) {
			criteria.andFirstNameEqualTo(employee.getFirstName());
		}
		if (!StringUtils.isEmpty(employee.getLastName())) {
			criteria.andFirstNameEqualTo(employee.getLastName());
		}
		if (!StringUtils.isEmpty(employee.getIdapUserName())) {
			criteria.andFirstNameEqualTo(employee.getIdapUserName());
		}
		if (!StringUtils.isEmpty(employee.getGender())) {
			criteria.andFirstNameEqualTo(employee.getGender());
		}
		return employeeMapper.selectByExample(example);
	}

	/**
	 * validate data
	 * 
	 * @param employee
	 * @throws ParammeterException
	 */
	private void validateData(Employee employee) throws ParammeterException {

		if (StringUtils.isEmpty(employee.getFirstName())) {
			throw new ParammeterException("fistName must be not null ");
		}
		if (StringUtils.isEmpty(employee.getLastName())) {
			throw new ParammeterException("lastName must be not null ");
		}
		if (StringUtils.isEmpty(employee.getIdapUserName())) {
			throw new ParammeterException("idapUserName must be not null ");
		}
		if (StringUtils.isEmpty(employee.getTitle())) {
			throw new ParammeterException("title must be not null ");
		}
		if (StringUtils.isEmpty(employee.getGrade())) {
			throw new ParammeterException("grade must be not null ");
		}
	}

}
