package com.petitevet.backPetite.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.petitevet.backPetite.models.ProductHasOrderModel;

public interface ProductHasOrderRepository extends JpaRepository<ProductHasOrderModel, Long>{
	//Optional<ProductHasOrderModel> findById(Long o_ido);

}//Interface
