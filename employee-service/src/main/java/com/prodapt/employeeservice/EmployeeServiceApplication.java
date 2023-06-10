package com.prodapt.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients

public class EmployeeServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeServiceApplication.class, args);
		EmployeeServiceApplication em = new EmployeeServiceApplication();
		em.helloWorld();
	}
	public void helloWorld(){
		System.out.println("******Application has started******");
	}

	//by this annotation, Resttemplate get registered in IO cntainer
//	@Bean
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}

//	@Bean
//	public WebClient webClient(){
//		return WebClient.builder().build();
//	}

//	public

}
