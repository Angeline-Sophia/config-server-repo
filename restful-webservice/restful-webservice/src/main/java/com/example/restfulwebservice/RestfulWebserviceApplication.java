package com.example.restfulwebservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring Boot REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Angeline Sophia",
						email = "sophia.a@prodapt.com",
						url = "https://www.javaguides.net"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.javaguides.net/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot User Management Documentation",
				url = "https://www.javaguides.net/user_management.html"
		)
)
public class RestfulWebserviceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebserviceApplication.class, args);
	}
	//this @Bean annotation will configure modelmapper class as Spring bean and will register in application context
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

//	@RequestMapping("/validateUser")
//	public Principal user(Principal user) {
//		return user;
//	}
//
//	@Configuration
//	protected static class AuthenticationManagerConfiguration extends GlobalAuthenticationConfigurerAdapter {
//
//
//		@Override
//		public void init(AuthenticationManagerBuilder auth) throws Exception {
//			auth.inMemoryAuthentication().withUser("admin").password("admin123").roles("USER")
//					.and().withUser("angeline").password("angeline123").roles("ADMIN");
//		}



//	}
}
