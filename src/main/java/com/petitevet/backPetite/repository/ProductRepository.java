package com.petitevet.backPetite.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.petitevet.backPetite.models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long>{
	//@Query("SELECT p FROM ProductModel p WHERE p.name=?1") //para realizar una consulta
	Optional<ProductModel> findByName(String name);
}//interface
