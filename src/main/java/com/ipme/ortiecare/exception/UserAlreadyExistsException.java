package com.ipme.ortiecare.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends Exception{
	// TODO : si on a le temps
//	private
//	
//	//throws UserAlreadyExistsException
//	public UserAlreadyExistsException(String firstname, String lastName)
//	{
//		
//	}
//	try {
//		user.create
//	}
//	catch(UserAlreadyExistsException e){
//		return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseCodeMessage(409,"l'utilisateur existe déjà"));
//	}
}
