package com.petitevet.backPetite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.petitevet.backPetite.models.UserModel;
import com.petitevet.backPetite.service.UserServices;

@RestController
@RequestMapping (path="/api/users/")
@CrossOrigin(origins = "*")
public class UserController {
private final UserServices userServices;
	
	@Autowired
	public UserController(UserServices userServices) {
		this.userServices = userServices;
	}// constructor
	
	//CRUD
	@GetMapping
	public List<UserModel> getAllUsers(){
		return userServices.getUsers();
	}//getAllUsers
	
	@GetMapping (path="{prodId}")
	public UserModel getUser(@PathVariable("prodId") Long id) {
		return userServices.getUser(id);
	}//getMapping
	
	@DeleteMapping (path="{prodId}")
	public UserModel deleteUser(@PathVariable("prodId") Long id) {
		return userServices.deleteUser(id);
	}//deleteUser
	
	@PostMapping
	public UserModel addUser(@RequestBody UserModel useroModel) {
		return userServices.addUser(useroModel);
	}//addUser
	
	@PutMapping (path="{prodId}")
	public UserModel updateUser(@PathVariable("prodId") Long id, 
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String tel,
			@RequestParam(required = false) String password,
			@RequestParam(required = false) Long idrole) {
		return userServices.updateUser(id, name, email, tel, password, idrole);
	}//updateUser
	
}//Class UserController
