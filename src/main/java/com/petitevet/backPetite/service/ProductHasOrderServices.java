package com.petitevet.backPetite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petitevet.backPetite.models.ProductHasCategoryModel;
import com.petitevet.backPetite.models.ProductHasOrderModel;
import com.petitevet.backPetite.repository.ProductHasOrderRepository;

@Service
public class ProductHasOrderServices {
private final ProductHasOrderRepository producthasorderRepository;
	
	@Autowired
	public ProductHasOrderServices(ProductHasOrderRepository producthasorderRepository) {
		super();
		this.producthasorderRepository = producthasorderRepository;
	}// constructor

	public List<ProductHasOrderModel> getProductHasOrders() {
		return producthasorderRepository.findAll();
	}//getProductHasOrders

	public ProductHasOrderModel getProductHasOrder(Long id) {
		return producthasorderRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El ProductHasOrdero con el id" + id + "no existe."));
	}//getProductHasOrders

	public ProductHasOrderModel deleteProductHasOrder(Long id) {
		ProductHasOrderModel tmpProd = null;
		if(producthasorderRepository.existsById(id)) {
			tmpProd = producthasorderRepository.findById(id).get();
			producthasorderRepository.deleteById(id);
		}//if exist
		return tmpProd;
	}//deleteProductHasOrderModel

	public ProductHasOrderModel addPrudctHasCategory(Long o_ido) {
		ProductHasOrderModel tmpProd = null;
		//Optional<ProductHasCategoryModel> prodByCategory = pruducthascategoryRepository.findByCat(prudcthascategoryModel.getCategory_idcategory());
		if(producthasorderRepository.existsById(o_ido)) {
			tmpProd = producthasorderRepository.findById(o_ido).get();
			producthasorderRepository.save(tmpProd);
		}//if
		return tmpProd;
	}//addPrudctHasCategoryModel
	
//	public ProductHasOrderModel addProductHasOrder(ProductHasOrderModel producthasorderModel) {
//		ProductHasOrderModel tmpProd = null;
//		Optional<ProductHasOrderModel> prodById = producthasorderRepository.findById(producthasorderModel.getO_ido());
//		if(prodById.isPresent()) {
//			throw new IllegalArgumentException("La orden del producto con el ID: ["+
//		producthasorderModel.getO_ido() + "] ya existe.");
//		} else {
//			producthasorderRepository.save(producthasorderModel);
//		}//if
//		return producthasorderModel;
//	}//addProductHasOrderModel
	
	public ProductHasOrderModel updateProductHasOrder(Long id, Long o_ido, Long o_user_iduser, Long o_user_role_idrole) {
		ProductHasOrderModel tmpProd = null;
		if(producthasorderRepository.existsById(id)) {
			tmpProd = producthasorderRepository.findById(id).get();
			if(o_ido!=null) tmpProd.setO_ido(o_ido);
			if(o_user_iduser!=null) tmpProd.setO_user_iduser(o_user_iduser);
			if(o_user_role_idrole!=null) tmpProd.setO_user_role_idrole(o_user_role_idrole);
			producthasorderRepository.save(tmpProd);
		}else {
			System.out.println("El ProductHasOrdero con el id" + id + "no existe.");
		}//if
		return tmpProd;
	}//updateProductHasOrderModel
	
}
