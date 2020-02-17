package com.mainacad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AppRunner {

	public static void main(String[] args) {
//		SpringApplication.run(AppRunner.class, args);

		SpringApplication context = new SpringApplication(AppRunner.class);
		context.setAdditionalProfiles("jsp");
		context.run(args);
	}

}
