package com.prodapt.organizationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

//import javax.persistence.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String organizationName;

    @Column(nullable = false,unique = true)
    private String organizationCode;

    private String organizationDescription;

    @CreationTimestamp
    private LocalDateTime createdDate;//spring will Automatically create date in db


}
