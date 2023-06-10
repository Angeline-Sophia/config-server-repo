package com.prodapt.employeeservice.impl;

//import com.google.gson.Gson;
import com.prodapt.employeeservice.dto.ApiResponceDto;
import com.prodapt.employeeservice.dto.DepartmentDto;
import com.prodapt.employeeservice.dto.EmployeeDto;
import com.prodapt.employeeservice.dto.OrganizationDto;
import com.prodapt.employeeservice.entity.Employee;
import com.prodapt.employeeservice.exception.CustomizedException;
import com.prodapt.employeeservice.service.APIClient;
import com.prodapt.employeeservice.mappers.EmployeeMapstruct;
import com.prodapt.employeeservice.repository.EmployeeRepository;
import com.prodapt.employeeservice.service.EmployeeService;
import com.prodapt.employeeservice.service.OrganizationAPIClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository repo;
//    private RestTemplate restTemplate;
//    private WebClient client;
    private APIClient apiClient;
    private OrganizationAPIClient organizationAPIClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee saveEmployee = repo.save(EmployeeMapstruct.MAPPER.convertDtoToEntity(employeeDto));
        return EmployeeMapstruct.MAPPER.convertEntityToDto(saveEmployee);
    }

//    @Override
//    public EmployeeDto getEmployeeById(Long Id) {
//        Optional<Employee> employeeFromDb = repo.findById(Id);
//        if(!employeeFromDb.isPresent())throw new CustomizedException("Employee cannot be found for the given Id!!!!");
//        return EmployeeMapstruct.MAPPER.convertEntityToDto(repo.findById(Id).get());
//    }

//    @CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Override
    public ApiResponceDto getEmployeeById(Long Id) {
        log.info("********inside getEmployeeById() method********");
       Optional<Employee> employeeFromDb = repo.findById(Id);
//        log.info("em->:{}",employeeFromDb.get());
        log.info("em w->:{}",employeeFromDb);
        log.info("code->:{}",employeeFromDb.get().getDepartmentCode());
//        ResponseEntity<DepartmentDto> departmentDtoResponseEntity =
//                restTemplate.getForEntity("http://localhost:9090/api/department/getDepartment/"+employeeFromDb.getDepartmentCode(), DepartmentDto.class);

//      DepartmentDto departmentDto=  client.get()
//                .uri("http://localhost:9090/api/department/getDepartment/"+employeeFromDb.get().getDepartmentCode())
//                .retrieve().bodyToMono(DepartmentDto.class).block();

        DepartmentDto departmentDto = apiClient.getDepartment(employeeFromDb.get().getDepartmentCode());
        OrganizationDto organizationDto = organizationAPIClient.getOrganizationByCode(employeeFromDb.get().getOrganizationCode());

        log.info("wwwwwwwwwwwwwwww->:{}",employeeFromDb.get().getOrganizationCode());
        log.info("dddddddddddd->:{}",employeeFromDb.get().getDepartmentCode());
        log.info("em from db->:{}",employeeFromDb);

//        if(employeeFromDb==null)throw new CustomizedException("Employee cannot be found for the given Id!!!!");

        EmployeeDto employeeDto = EmployeeMapstruct.MAPPER.convertEntityToDto(employeeFromDb.get());
        ApiResponceDto apiResponceDto = new ApiResponceDto();
        apiResponceDto.setEmployeeDto(employeeDto);
        apiResponceDto.setDepartmentDto(departmentDto);
        apiResponceDto.setOrganizationDto(organizationDto);
        return apiResponceDto;
    }

    public ApiResponceDto getDefaultDepartment(Long Id,Exception e) {
        log.info("********inside getDefaultDepartment() method********");
        Optional<Employee> employeeFromDb = repo.findById(Id);
//        log.info("em->:{}",employeeFromDb.get());
        log.info("em w->:{}",employeeFromDb);
        log.info("code->:{}",employeeFromDb.get().getDepartmentCode());
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("Electronics");
        departmentDto.setDepartmentCode("R&D department");
        departmentDto.setDepartmentDescription("ECE department");

        EmployeeDto employeeDto = EmployeeMapstruct.MAPPER.convertEntityToDto(employeeFromDb.get());
        ApiResponceDto apiResponceDto = new ApiResponceDto();
        apiResponceDto.setEmployeeDto(employeeDto);
        apiResponceDto.setDepartmentDto(departmentDto);
        return apiResponceDto;
    }
}
