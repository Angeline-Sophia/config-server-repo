package com.prodapt.employeeservice.entity;

import jakarta.persistence.*;
import lombok.*;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Table;
//import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
@ToString
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String firstName;
    private String lastName;
    @Column(nullable = false,unique = true)
    private String email;
    private String departmentCode;
    private String organizationCode;
}
