package com.anz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anz.bean.ReturnMsg;
import com.anz.mybatis.generator.model.Department;
import com.anz.service.DepartmentService;

@RestController
@RequestMapping("/v1/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ReturnMsg addDepartment(@ModelAttribute Department department) {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			departmentService.addDepartment(department);
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setCode(ReturnMsg.ERROR_CODE);
			returnMsg.setMessage(e.getMessage());
		}
		return returnMsg;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ReturnMsg getEmployeeByID(@PathVariable("id") Long id,
			@ModelAttribute Department department) {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			department.setId(id);
			returnMsg.setData(departmentService.searchDepartment(department));
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setCode(ReturnMsg.ERROR_CODE);
			returnMsg.setMessage(e.getMessage());
		}
		return returnMsg;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ReturnMsg updateEmployeeByID(@PathVariable("id") Long id,
			@ModelAttribute Department department) {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			department.setId(id);
			departmentService.updateDepartment(department);
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setCode(ReturnMsg.ERROR_CODE);
			returnMsg.setMessage(e.getMessage());
		}
		return returnMsg;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ReturnMsg delEmployeeByID(@PathVariable("id") Long id) {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			departmentService.removeDepartment(id);
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setCode(ReturnMsg.ERROR_CODE);
			returnMsg.setMessage(e.getMessage());
		}
		return returnMsg;
	}

}
