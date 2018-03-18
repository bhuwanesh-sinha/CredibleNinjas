package com.credibleninjas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@EntityScan("com.credibleninjas.entities")
@SpringBootApplication(scanBasePackages={"com.credibleninjas"})
public class CredibleNinjaApp extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CredibleNinjaApp.class, args);

	}

}
