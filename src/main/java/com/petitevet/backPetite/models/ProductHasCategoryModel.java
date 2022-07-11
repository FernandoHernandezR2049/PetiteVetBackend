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
@Table(name="product_has_category") //para mapear la tabla de productos en la base de datos
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductHasCategoryModel {
	@Id
	@Column(name="product_idproduct", nullable=false)
	private Long id;
	@Column(nullable=false)
	private Long category_idcategory;
}//Class
