package com.petitevet.backPetite.models;

import lombok.Data;

@Data
public class UserModel {
	private String name;
	private String email;
	private String tel;
	private String password;
	private int id;
	private static int total=0;
	
	public UserModel() {
		total ++;
		this.id=total;
	}//Constructor por default

	public UserModel(String name, String email, String tel, String password) {
		super();
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.password = password;
		total ++;
		this.id = total;
	}//Constructor UserModel

//	public UserModel(String email, String password) {
//		super();
//		this.email = email;
//		this.password = password;
//	}//Constructor LoginModel
	
	
}//Class UserModel
