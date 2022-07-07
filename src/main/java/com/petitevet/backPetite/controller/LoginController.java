package com.petitevet.backPetite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petitevet.backPetite.models.UserModel;
import com.petitevet.backPetite.service.UserServices;

@RestController
@RequestMapping (path="/api/login/")
public class LoginController {

private final UserServices userServices;
@Autowired
public LoginController(UserServices userServices) {
	this.userServices = userServices;
}// constructor

//	@PostMapping
//	public UserModel addUser(@RequestBody UserModel userModel, 
//			@RequestParam(required = false) String email,
//			@RequestParam(required = false) String password) {
//		return userServices.addUser(name, password);
//	}//addProduct

@PostMapping
public boolean authUser( 
		@RequestParam(required = true) String email,
		@RequestParam(required = true) String password) {
	return userServices.authUser(email, password);
}//addProduct

}
