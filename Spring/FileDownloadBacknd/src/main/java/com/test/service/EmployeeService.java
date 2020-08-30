package com.test.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.test.Repo.EmployeeRepository;
import com.test.model.Employee;
import com.test.model.EmployeeVo;

@Service
@Scope("prototype")
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	

	public List<EmployeeVo> getEmployeeList() {
		List<Employee> list = employeeRepository.findAll();
		return list.stream().map(emp -> {
			EmployeeVo vo = new EmployeeVo();
			vo.setId(emp.getId());
			vo.setName(emp.getName());
			vo.setEmail(emp.getEmail());
			return vo;
		}).collect(Collectors.toList());
	}
}
