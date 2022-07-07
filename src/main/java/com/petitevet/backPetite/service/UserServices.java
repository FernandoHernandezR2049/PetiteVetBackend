package com.petitevet.backPetite.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import com.petitevet.backPetite.models.UserModel;

@Service
public class UserServices {
public final ArrayList<UserModel> lista = new ArrayList<>();
	
	public UserServices() {
		lista.add(new UserModel("Fernando Farías González","ffarias934@gmail.com","4776476274","Ferfar92"));

	}//contructor
	
//	public ArrayList<UserModel> getUsers(){
//		return lista;
//	}//ArrayList
	
	public UserModel addUser(UserModel userModel) {
		lista.add(userModel);
		return userModel;
	}//addUser

	public boolean authUser(String email, String password) {
		boolean result = false;
		for (UserModel userModel : lista) {
			if(userModel.getEmail().equals(email) && userModel.getPassword().equals(password)) {
				result=true;
				break;
			}
		}
		return result;
	}
	
}//Class UserServices
