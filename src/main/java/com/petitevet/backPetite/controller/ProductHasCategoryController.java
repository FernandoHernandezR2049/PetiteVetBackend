package com.petitevet.backPetite.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.petitevet.backPetite.models.ProductHasCategoryModel;
import com.petitevet.backPetite.service.ProductHasCategoryServices;

@RestController
@RequestMapping (path="/api/produchascategory/")
@CrossOrigin(origins = "*")
public class ProductHasCategoryController {
private final ProductHasCategoryServices producthascategoryServices;
	
	@Autowired
	public ProductHasCategoryController(ProductHasCategoryServices producthascategoryServices) {
		this.producthascategoryServices = producthascategoryServices;
	}// constructor
	
	//CRUD
	@GetMapping
	public List<ProductHasCategoryModel> getAllProductHasCategorys(){
		return producthascategoryServices.getPrudctHasCategorys();
	}//getAllProductHasCategorys
	
	@GetMapping (path="{prodId}")
	public ProductHasCategoryModel getProductHasCategory(@PathVariable("prodId") Long id) {
		return producthascategoryServices.getPrudctHasCategory(id);
	}//getMapping
	
	@DeleteMapping (path="{prodId}")
	public ProductHasCategoryModel deleteProductHasCategory(@PathVariable("prodId") Long id) {
		return producthascategoryServices.deletePrudctHasCategory(id);
	}//deleteProductHasCategory
	
	@PostMapping
	public ProductHasCategoryModel addProductHasCategory(@RequestBody Long category_idcategory) {
		return producthascategoryServices.addPrudctHasCategory(category_idcategory);
	}//addProductHasCategory
	
//	@PostMapping
//	public ProductHasCategoryModel addProductHasCategory(@RequestBody ProductHasCategoryModel producthascategoryoModel) {
//		return producthascategoryServices.addPrudctHasCategory(producthascategoryoModel);
//	}//addProductHasCategory
	
	@PutMapping (path="{prodId}")
	public ProductHasCategoryModel updateProductHasCategory(@PathVariable("prodId") Long id, 
			@RequestParam(required = false) Long category_idcategory) {
		return producthascategoryServices.updatePrudctHasCategory(id, category_idcategory);
	}//updateProductHasCategory
}
