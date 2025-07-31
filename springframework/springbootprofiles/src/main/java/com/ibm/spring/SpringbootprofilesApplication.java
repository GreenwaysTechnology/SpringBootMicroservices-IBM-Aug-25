package com.ibm.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootprofilesApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootprofilesApplication.class, args);
		ProfileService profileService = context.getBean(ProfileService.class);
		System.out.println(profileService.getInfo());
	}

}
