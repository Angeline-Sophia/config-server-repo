package com.prodapt.departmentservice.entity;

import jakarta.persistence.*;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
import lombok.*;

//import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")
@ToString
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
