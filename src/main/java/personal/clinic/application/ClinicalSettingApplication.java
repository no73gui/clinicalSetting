package personal.clinic.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "personal.clinic")

public class ClinicalSettingApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ClinicalSettingApplication.class , args);

	}

}
