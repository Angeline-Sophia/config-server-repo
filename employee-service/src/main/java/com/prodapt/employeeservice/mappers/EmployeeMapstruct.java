package com.prodapt.employeeservice.mappers;

import com.prodapt.employeeservice.dto.ApiResponceDto;
import com.prodapt.employeeservice.dto.DepartmentDto;
import com.prodapt.employeeservice.dto.EmployeeDto;
import com.prodapt.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.DeleteMapping;

@Mapper
public interface EmployeeMapstruct {

    EmployeeMapstruct MAPPER = Mappers.getMapper(EmployeeMapstruct.class);

    Employee convertDtoToEntity(EmployeeDto employeeDto);
    EmployeeDto convertEntityToDto(Employee employee);

}
