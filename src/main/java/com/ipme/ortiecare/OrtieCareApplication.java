package com.ipme.ortiecare;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipme.ortiecare.model.*;


@SpringBootApplication
public class OrtieCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrtieCareApplication.class, args);
		Avantages testAvantage = new Avantages(0, "retiens bien leau");
		System.out.println(testAvantage.getDescription());
		testAvantage.setDescription("en fait non");
		System.out.println(testAvantage.getDescription());

		ArrayList<Avantages> listAvantages = new ArrayList<>();
		Avantages drainage = new Avantages(0, "Draîne bien l'eau");
		Avantages rechaufffement = new Avantages(1, "Se réchauffe rapidement");
		Avantages maniabilite = new Avantages(2, "Se travaille facilement");
		Avantages fertilite = new Avantages(3, "Est très fertile");
		Avantages etancheite = new Avantages(4, "Retient bien l'eau");
		
		listAvantages.add(etancheite);
		listAvantages.add(fertilite);
		listAvantages.add(maniabilite);
		listAvantages.add(drainage);
		listAvantages.add(rechaufffement);
		
		ArrayList<Inconvenients> listInconvenients = new ArrayList<>();
		Inconvenients inconv0 = new Inconvenients(0, "Peu fertile");
		Inconvenients inconv1 = new Inconvenients(1, "Ne retient pas l'eau");
		Inconvenients inconv2 = new Inconvenients(2, "Propice à l'érosion");
		Inconvenients inconv3 = new Inconvenients(3, "Très fragile, s'érode facilement");
		Inconvenients inconv4 = new Inconvenients(4, "Travaille mal");
		Inconvenients inconv5 = new Inconvenients(5, "Réagit mal aux variations de température");
		Inconvenients inconv6 = new Inconvenients(6, "Très acide, nuit au développement des végétaux");
		
		listInconvenients.add(inconv0);
		listInconvenients.add(inconv1);
		listInconvenients.add(inconv2);
		listInconvenients.add(inconv3);
		listInconvenients.add(inconv4);
		listInconvenients.add(inconv5);
		listInconvenients.add(inconv6);
		
	}

	
}
