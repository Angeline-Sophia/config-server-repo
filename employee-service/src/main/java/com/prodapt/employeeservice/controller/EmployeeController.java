package com.prodapt.employeeservice.controller;

import com.prodapt.employeeservice.dto.ApiResponceDto;
import com.prodapt.employeeservice.dto.EmployeeDto;
import com.prodapt.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService service;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(new HttpHeaders()).body(service.saveEmployee(employeeDto));

    }

    @GetMapping("/create/{id}")
    public ResponseEntity<ApiResponceDto> getEmployee(@PathVariable("id") Long Id){
        return ResponseEntity.status(HttpStatus.OK)
                .headers(new HttpHeaders()).body(service.getEmployeeById(Id));

    }
}
