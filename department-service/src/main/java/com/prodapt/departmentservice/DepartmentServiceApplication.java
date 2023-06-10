package com.prodapt.departmentservice;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@Slf4j
public class DepartmentServiceApplication {


	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
		upApp();
	}


	static String upApp(){
		log.info("******Application has started******");
		return "Its up!!!!!1";
	}


}
