package com.petitevet.backPetite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petitevet.backPetite.models.UserModel;
import com.petitevet.backPetite.repository.UserRepository;

@Service
public class UserServices {
private final UserRepository userRepository;
	
	@Autowired
	public UserServices(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}// constructor

	public List<UserModel> getUsers() {
		return userRepository.findAll();
	}//getProducts

	public UserModel getUser(Long id) {
		return userRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El Producto con el id" + id + "no existe."));
	}//getProduct

	public UserModel deleteUser(Long id) {
		UserModel tmpProd = null;
		if(userRepository.existsById(id)) {
			tmpProd = userRepository.findById(id).get();
			userRepository.deleteById(id);
		}//if exist
		return tmpProd;
	}//deleteProductModel

	public UserModel addUser(UserModel userModel) {
		UserModel tmpProd = null;
		Optional<UserModel> prodByName = userRepository.findByName(userModel.getName());
		if(prodByName.isPresent()) {
			throw new IllegalArgumentException("El Producto con el nombre["+
		userModel.getName() + "] ya existe.");
		} else {
			userRepository.save(userModel);
		}//if
		return userModel;
	}//addProductModel

	public UserModel updateUser(Long id, String name, String email, String tel, String password, Long idrole) { //String newPassword) {
		UserModel tmpProd = null;
		if(userRepository.existsById(id)) {
			tmpProd = userRepository.findById(id).get();
			if(tmpProd.getPassword().equals(password)) {
				if(name!=null) tmpProd.setName(name);
				if(email!=null) tmpProd.setEmail(email);
				if(tel!=null) tmpProd.setTel(tel);
				if(password!=null) tmpProd.setPassword(password);
				if(idrole!=null) tmpProd.setIdrole(idrole);
//					if(newPassword != null) {
//						tmpProd.setPassword(newPassword);
//					} else {
//						System.out.println("Error al comparar las contraseñas");
//					}//if newpassword
				userRepository.save(tmpProd);
			}
		}else {
			System.out.println("El usuario no existe o credenciales inválidas.");
		}//if
		return tmpProd;
	}//updateProductModel

	//Login
	public boolean authUser(String email,String password) {
		boolean respt = false;
		Optional<UserModel> prodByLogin = userRepository.findByEmailAndPassword(email, password);
		if(prodByLogin.isPresent()) {
			System.out.println("Ingreso exitoso");
			respt = true;
		}else {
			System.out.println("Credenciales inválidas");
		}//if
		return respt;
	}//updateProductModel

}//Class UserServices
