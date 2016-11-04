package com.anz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.anz.exception.ParammeterException;
import com.anz.mybatis.generator.dao.DepartmentMapper;
import com.anz.mybatis.generator.model.Department;
import com.anz.mybatis.generator.model.DepartmentExample;
import com.anz.mybatis.generator.model.DepartmentExample.Criteria;

/**
 * implements department interface
 * @author jesse
 *
 */
@Transactional
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public int addDepartment(Department department) throws ParammeterException {
		if (!StringUtils.isEmpty(department.getId())) {
			throw new ParammeterException("id must be null in add method");
		}
		validateData(department);
		return departmentMapper.insert(department);
	}

	@Override
	public int updateDepartment(Department department)
			throws ParammeterException {
		if (StringUtils.isEmpty(department.getId())) {
			throw new ParammeterException(
					"id must be not null in update method");
		}
		validateData(department);
		return departmentMapper.updateByPrimaryKey(department);
	}

	@Override
	public int removeDepartment(Long id) throws ParammeterException {
		if (StringUtils.isEmpty(id)) {
			throw new ParammeterException(
					"id must be not null in remove method");
		}
		return departmentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Department> searchDepartment(Department department) {
		DepartmentExample example = new DepartmentExample();
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(department.getId())) {
			criteria.andIdEqualTo(department.getId());
		}
		if (!StringUtils.isEmpty(department.getManager())) {
			criteria.andManagerEqualTo(department.getManager());
		}
		if (!StringUtils.isEmpty(department.getParentDepartment())) {
			criteria.andParentDepartmentEqualTo(department
					.getParentDepartment());
		}
		return departmentMapper.selectByExample(example);
	}

	/**
	 * validate data
	 * 
	 * @param department
	 * @throws ParammeterException
	 */
	private void validateData(Department department) throws ParammeterException {

		if (StringUtils.isEmpty(department.getName())) {
			throw new ParammeterException("name must be not null ");
		}
		if (StringUtils.isEmpty(department.getOpenPositions())) {
			throw new ParammeterException("openPositions must be not null ");
		}
	}

}
