package com.swlc.ScrumPepperAdminCPU6001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ScrumPepperAdminCpu6001Application extends SpringBootServletInitializer {

	// app builder config
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ScrumPepperAdminCpu6001Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ScrumPepperAdminCpu6001Application.class, args);
	}

}
