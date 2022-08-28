package com.user;

import com.emp.EmployeeDTO;

public class Login {
	private EmployeeDTO loginEmployee = null;
	
	public EmployeeDTO loginEmployee() {
		return loginEmployee;
	}
	
	public void login(EmployeeDTO loginEmployee) {
		this.loginEmployee = loginEmployee;
	}
	
	public void logout() {
		loginEmployee = null;
	}
}
