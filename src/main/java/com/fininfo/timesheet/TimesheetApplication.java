package com.fininfo.timesheet;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TimesheetApplication {
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	} 
	public static void main(String[] args) {
		SpringApplication.run(TimesheetApplication.class, args);
	}

}
