package com.ipme.ortiecare;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipme.ortiecare.model.*;
import com.ipme.ortiecare.services.LegumeService;


@SpringBootApplication
public class OrtieCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrtieCareApplication.class, args);
		System.out.println("pouet");
		
	}

	
}
