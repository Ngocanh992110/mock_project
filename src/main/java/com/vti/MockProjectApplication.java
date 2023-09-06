package com.vti;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MockProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MockProjectApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapper = new ModelMapper();
//		modelMapper.typeMap(AccountCreateForm.class, Account.class)
//				.addMappings(mapper -> mapper.skip(Account::setId));
		return modelMapper;
	}

	@Bean
	public ObjectWriter objectWriter(ObjectMapper objectMapper) {
		return objectMapper.writer();
	}

	// cho phép domain khác truy cập vào api để thao tác dữ lieu
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("GET", "POST", "PUT", "DELETE");
			}
		};
	}
}
