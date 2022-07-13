package com.petitevet.backPetite.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.petitevet.backPetite.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
	Optional<UserModel> findByName(String name);
	Optional<UserModel> findByEmailAndPassword(String email, String password);
	//Optional<UserModel> findByEmail(String email);
}//intarface
