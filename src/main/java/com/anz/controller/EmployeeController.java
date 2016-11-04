package com.anz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anz.bean.ReturnMsg;
import com.anz.mybatis.generator.model.Employee;
import com.anz.service.EmployeeService;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ReturnMsg addEmployee(@ModelAttribute Employee employee) {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			employeeService.addEmployee(employee);
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setCode(ReturnMsg.ERROR_CODE);
			returnMsg.setMessage(e.getMessage());
		}
		return returnMsg;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ReturnMsg getEmployeeByID(@PathVariable("id") Long id,
			@ModelAttribute Employee employee) {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			employee.setId(id);
			returnMsg.setData(employeeService.searchEmployee(employee));
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setCode(ReturnMsg.ERROR_CODE);
			returnMsg.setMessage(e.getMessage());
		}
		return returnMsg;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ReturnMsg updateEmployeeByID(@PathVariable("id") Long id,
			@ModelAttribute Employee employee) {
		ReturnMsg returnMsg = new ReturnMsg();
		try {
			employee.setId(id);
			employeeService.updateEmployee(employee);
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
			employeeService.removeEmployee(id);
		} catch (Exception e) {
			e.printStackTrace();
			returnMsg.setCode(ReturnMsg.ERROR_CODE);
			returnMsg.setMessage(e.getMessage());
		}
		return returnMsg;
	}

}
