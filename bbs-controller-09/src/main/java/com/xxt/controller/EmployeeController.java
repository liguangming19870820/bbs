package com.xxt.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.page.Pagination;
import com.xxt.entity.Employee;
import com.xxt.entity.EmployeeQuery;
import com.xxt.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/employee/list")
	public String list(Integer pageNo, EmployeeQuery employeeQuery, Model model) {
		employeeQuery.setPageNo(Pagination.cpn(pageNo));

		StringBuilder sb = new StringBuilder();
		Pagination pagination = employeeService.getEmployeeListWithPage(employeeQuery);
		String params = sb.toString();
		if (StringUtils.isNotBlank(params) && params.startsWith("&")) {
			params = params.substring(1);
		}
		pagination.pageView("/employee/list", params);

		model.addAttribute("pagination", pagination);
		return "employee/list";
	}

	@RequestMapping("/employee/addinput")
	public String addinput() {
		return "employee/add";
	}

	@RequestMapping("/employee/save")
	public String save(Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employee/list.do";
	}

	@RequestMapping("/employee/edit")
	public String edit(String username, Model model) {
		Employee employee = employeeService.getEmployeeById(username);
		model.addAttribute("employee", employee);
		return "employee/edit";
	}

	@RequestMapping("/employee/update")
	public String update(Employee employee) {
		employeeService.updateEmployee(employee);
		return "redirect:/employee/list.do";
	}

	@RequestMapping("/employee/delete")
	public String delete(String username) {
		employeeService.deleteEmployeeById(username);
		return "redirect:/employee/list.do";
	}
}
