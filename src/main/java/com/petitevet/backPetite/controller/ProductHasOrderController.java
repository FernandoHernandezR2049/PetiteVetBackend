package com.petitevet.backPetite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.petitevet.backPetite.models.ProductHasOrderModel;
import com.petitevet.backPetite.service.ProductHasOrderServices;

@RestController
@RequestMapping(path="/api/producthasorder/")
public class ProductHasOrderController {
private final ProductHasOrderServices producthasorderServices;
	
	@Autowired
	public ProductHasOrderController(ProductHasOrderServices producthasorderServices) {
		this.producthasorderServices = producthasorderServices;
	}// constructor
	
	//CRUD
	@GetMapping
	public List<ProductHasOrderModel> getAllProductHasOrders(){
		return producthasorderServices.getProductHasOrders();
	}//getAllProductHasOrders
	
	@GetMapping (path="{prodId}")
	public ProductHasOrderModel getProductHasOrder(@PathVariable("prodId") Long id) {
		return producthasorderServices.getProductHasOrder(id);
	}//getMapping
	
	@DeleteMapping (path="{prodId}")
	public ProductHasOrderModel deleteProductHasOrder(@PathVariable("prodId") Long id) {
		return producthasorderServices.deleteProductHasOrder(id);
	}//deleteProductHasOrder
	
	@PostMapping
	public ProductHasOrderModel addProductHasOrder(@RequestBody Long o_ido) {
		return producthasorderServices.addPrudctHasCategory(o_ido);
	}//addProductHasCategory
	
//	@PostMapping
//	public ProductHasOrderModel addProductHasOrder(@RequestBody ProductHasOrderModel producthasorderoModel) {
//		return producthasorderServices.addProductHasOrder(producthasorderoModel);
//	}//addProductHasOrder
	
	@PutMapping (path="{prodId}")
	public ProductHasOrderModel updateProductHasOrder(@PathVariable("prodId") Long id, 
			@RequestParam(required = false) Long o_ido,
			@RequestParam(required = false) Long o_user_iduser,
			@RequestParam(required = false) Long o_user_role_idrole){
		return producthasorderServices.updateProductHasOrder(id, o_ido, o_user_iduser, o_user_role_idrole);
	}//updateProductHasOrder
}
