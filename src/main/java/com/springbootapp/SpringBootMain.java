package com.springbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.demo.Car;


@SpringBootApplication
@ComponentScan(basePackages  = {"com.springbootapp","com.demo"})

public class SpringBootMain {
	@Autowired
	Car car;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringBootMain.class, args);
	
		

	}

}
