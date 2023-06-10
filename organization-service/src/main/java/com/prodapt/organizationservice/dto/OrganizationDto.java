package com.prodapt.organizationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    private Long id;
    private String organizationName;
    private String organizationCode;
    private String organizationDescription;
    private LocalDateTime createdDate;
}
