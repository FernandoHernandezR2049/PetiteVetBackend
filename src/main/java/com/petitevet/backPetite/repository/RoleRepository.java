package com.petitevet.backPetite.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.petitevet.backPetite.models.ProductModel;
import com.petitevet.backPetite.models.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
	Optional<RoleModel> findByName(String name);
}
