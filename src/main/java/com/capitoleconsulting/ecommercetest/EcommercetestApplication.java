package com.capitoleconsulting.ecommercetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.capitoleconsulting.ecommercetest")
public class EcommercetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommercetestApplication.class, args);
	}

}
