package com.petitevet.backPetite.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.petitevet.backPetite.models.OrderModel;

public interface OrderRepository extends JpaRepository<OrderModel, Long>{
	Optional<OrderModel> findByDtime(String dtime);

}
