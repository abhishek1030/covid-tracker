package io.labs.anand.covidtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class CovidTrackerApplication {

	public String PORT = System.getenv("PORT");
	public static void main(String[] args) {
		SpringApplication.run(CovidTrackerApplication.class, args);
	}

}
