package com.ipme.ortiecare;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipme.ortiecare.model.*;


@SpringBootApplication
public class OrtieCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrtieCareApplication.class, args);
		Avantages testAvantage = new Avantages(UUID.randomUUID(), "retiens bien leau");
		System.out.println(testAvantage.getDescription());
		testAvantage.setDescription("en fait non");
		System.out.println(testAvantage.getDescription());

		ArrayList<Avantages> listAvantages = new ArrayList<>();
		Avantages drainage = new Avantages(UUID.randomUUID(), "Draîne bien l'eau");
		Avantages rechaufffement = new Avantages(UUID.randomUUID(), "Se réchauffe rapidement");
		Avantages maniabilite = new Avantages(UUID.randomUUID(), "Se travaille facilement");
		Avantages fertilite = new Avantages(UUID.randomUUID(), "Est très fertile");
		Avantages etancheite = new Avantages(UUID.randomUUID(), "Retient bien l'eau");
		
		listAvantages.add(etancheite);
		listAvantages.add(fertilite);
		listAvantages.add(maniabilite);
		listAvantages.add(drainage);
		listAvantages.add(rechaufffement);
		
		ArrayList<Inconvenients> listInconvenients = new ArrayList<>();
		Inconvenients inconv0 = new Inconvenients(UUID.randomUUID(), "Peu fertile");
		Inconvenients inconv1 = new Inconvenients(UUID.randomUUID(), "Ne retient pas l'eau");
		Inconvenients inconv2 = new Inconvenients(UUID.randomUUID(), "Propice à l'érosion");
		Inconvenients inconv3 = new Inconvenients(UUID.randomUUID(), "Très fragile, s'érode facilement");
		Inconvenients inconv4 = new Inconvenients(UUID.randomUUID(), "Travaille mal");
		Inconvenients inconv5 = new Inconvenients(UUID.randomUUID(), "Réagit mal aux variations de température");
		Inconvenients inconv6 = new Inconvenients(UUID.randomUUID(), "Très acide, nuit au développement des végétaux");
		
		listInconvenients.add(inconv0);
		listInconvenients.add(inconv1);
		listInconvenients.add(inconv2);
		listInconvenients.add(inconv3);
		listInconvenients.add(inconv4);
		listInconvenients.add(inconv5);
		listInconvenients.add(inconv6);
		
	}

	
}
