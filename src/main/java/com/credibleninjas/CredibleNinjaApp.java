package com.credibleninjas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.credibleninjas.entities")
@SpringBootApplication(scanBasePackages={"com.credibleninjas"})
public class CredibleNinjaApp {

	public static void main(String[] args) {
		SpringApplication.run(CredibleNinjaApp.class, args);

	}

}
