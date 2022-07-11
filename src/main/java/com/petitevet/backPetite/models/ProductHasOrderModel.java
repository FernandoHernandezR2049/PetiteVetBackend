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
@Table(name="product_has_order") //para mapear la tabla de productos en la base de datos
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductHasOrderModel {
	@Id
	@Column(name="product_idproduct", unique=true, nullable=false)
	private Long id;
	@Column(name="order_idorder", unique=true, nullable=false)
	private Long o_ido;
	@Column(name="order_user_iduser", unique=true, nullable=false)
	private Long o_user_iduser;
	@Column(name="order_user_role_idrole", unique=true, nullable=false)
	private Long o_user_role_idrole;
}//Class
