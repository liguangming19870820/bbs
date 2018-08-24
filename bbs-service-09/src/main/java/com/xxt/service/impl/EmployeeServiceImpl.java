package com.xxt.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.common.page.Pagination;
import com.xxt.dao.EmployeeMapper;
import com.xxt.entity.Employee;
import com.xxt.entity.EmployeeQuery;
import com.xxt.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;

	@Override
	public Pagination getEmployeeListWithPage(EmployeeQuery employeeQuery) {
		return new Pagination(employeeQuery.getPageNo(), employeeQuery.getPageSize(), employeeMapper.getEmployeeCount(employeeQuery), employeeMapper.getEmployeeListWithPage(employeeQuery));
	}

	@Override
	public Employee getEmployeeById(String username) {
		return employeeMapper.getEmployeeById(username);
	}

	@Override
	public List<Employee> getEmployeeList() {
		return employeeMapper.getEmployeeList();
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeMapper.updateEmployee(employee);
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeMapper.saveEmployee(employee);
	}

	@Override
	public void deleteEmployeeById(String username) {
		employeeMapper.deleteEmployeeById(username);
	}
}
