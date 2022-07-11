package com.petitevet.backPetite.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.petitevet.backPetite.models.CategoryModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long>{
	Optional<CategoryModel> findByCategory(String category);
}
