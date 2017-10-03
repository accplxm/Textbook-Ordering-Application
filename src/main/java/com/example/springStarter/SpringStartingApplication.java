package com.example.springStarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@EnableCaching
public class SpringStartingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStartingApplication.class, args);
	}
}
