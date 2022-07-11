package com.petitevet.backPetite.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.petitevet.backPetite.models.ProductHasCategoryModel;

public interface ProductHasCategoryRepository extends JpaRepository<ProductHasCategoryModel, Long>{
	//Optional<ProductHasCategoryModel> findByCat(Long category_idcategory);

}
