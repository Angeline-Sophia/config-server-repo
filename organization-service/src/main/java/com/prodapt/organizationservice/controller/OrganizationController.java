package com.prodapt.organizationservice.controller;

import com.prodapt.organizationservice.dto.OrganizationDto;
import com.prodapt.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        "api/organization"
)
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;

    @PostMapping("/save")
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        return ResponseEntity.status(HttpStatus.CREATED).headers(new HttpHeaders())
                .body(organizationService.saveOrganizationDto(organizationDto));
    }

    @GetMapping("/get/{code}")
    public ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable("code") String organizationCode){
        return ResponseEntity.status(HttpStatus.OK).headers(new HttpHeaders())
                .body(organizationService.getOrganization(organizationCode));
    }
}
