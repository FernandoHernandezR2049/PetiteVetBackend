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
import com.petitevet.backPetite.models.CategoryModel;
import com.petitevet.backPetite.service.CategoryServices;

@RestController
@RequestMapping (path="/api/category/")
//@CrossOrigin(origins = "*")
public class CategoryController {
	private final CategoryServices categoryServices;

	@Autowired //La inyección de dependencias
	public CategoryController(CategoryServices categoryServices) {
		this.categoryServices = categoryServices;
	}//constructor
	
	@GetMapping
	public List<CategoryModel> getAllCategorys(){
		return categoryServices.getCategorys();
	}//getAllCategorys
	
	@GetMapping (path="{prodId}")
	public CategoryModel getCategory(@PathVariable("prodId") Long id) {
		return categoryServices.getCategory(id);
	}//getMapping 
	
	@DeleteMapping (path="{prodId}")
	public CategoryModel deleteCategory(@PathVariable("prodId") Long id) {
		return categoryServices.deleteCategory(id);
	}//deleteCategory
	
	@PostMapping
	public CategoryModel addCategory(@RequestBody CategoryModel categoryoModel) {
		return categoryServices.addCategory(categoryoModel);
	}//addCategory
	
	@PutMapping (path="{prodId}")
	public CategoryModel updateCategory(@PathVariable("prodId") Long id, 
			@RequestParam(required = false) String category) {
		return categoryServices.updateCategory(id, category);
	}//updateCategory
	
}//Class
