package com.factoriaf5.covid_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.factoriaf5.covid_dashboard.repository")
public class CovidDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidDashboardApplication.class, args);
	}

}
