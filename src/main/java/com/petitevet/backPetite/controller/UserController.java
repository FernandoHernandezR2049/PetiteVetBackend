package com.petitevet.backPetite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petitevet.backPetite.models.UserModel;
import com.petitevet.backPetite.service.UserServices;

@RestController
@RequestMapping (path="/api/users/")
public class UserController {

	private final UserServices userServices;
	
	
	@Autowired //La inyección de dependencias
	public UserController(UserServices userServices) {
		this.userServices = userServices;
	}//constructor
	
	
	@PostMapping
	public UserModel addUser(@RequestBody UserModel userModel) {
		return userServices.addUser(userModel);
	}//addProduct
	
}//Class UserController
