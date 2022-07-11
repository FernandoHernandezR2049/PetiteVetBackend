package com.petitevet.backPetite.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order") //para mapear la tabla de productos en la base de datos
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idorder", unique=true, nullable=false)
	private Long id;
	@Column(name="date")
	private String dtime;
	//private java.sql.Timestamp dtime; //Falta realizar la instancia: https://es.stackoverflow.com/questions/10661/almacenar-un-valor-date-de-java-en-mysql
	@Column(name="user_iduser", unique=true, nullable=false)
	private Long user_iduser;
	@Column(name="user_role_idrole", unique=true, nullable=false)
	private Long user_role_idrole;
}//class OrderModel