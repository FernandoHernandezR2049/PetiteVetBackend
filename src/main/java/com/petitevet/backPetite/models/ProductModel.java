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
@Table(name="product") //para mapear la tabla de productos en la base de datos
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idproduct", unique=true, nullable=false)
	private Long id;
	@Column(name="name")
	public String name;
	@Column(name="description")
	private String description;
	@Column(name="image")
	private String img;
	@Column(name="price")
	private double precio;
	@Column(name="sku", unique=true, nullable=false)
	private String SKU;
	@Column(name="quantity", nullable=false)
	private String quantity;
}//ProductModel
