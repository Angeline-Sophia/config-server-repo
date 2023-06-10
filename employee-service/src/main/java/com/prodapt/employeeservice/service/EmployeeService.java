package com.prodapt.employeeservice.service;

import com.prodapt.employeeservice.dto.ApiResponceDto;
import com.prodapt.employeeservice.dto.EmployeeDto;
import com.prodapt.employeeservice.entity.Employee;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
//    EmployeeDto getEmployeeById(Long Id);
    ApiResponceDto getEmployeeById(Long Id);
}
