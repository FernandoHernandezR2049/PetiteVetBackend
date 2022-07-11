package com.petitevet.backPetite.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.petitevet.backPetite.models.CategoryModel;
import com.petitevet.backPetite.repository.CategoryRepository;

@Service
public class CategoryServices {
private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServices(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}// constructor
	
	public List<CategoryModel> getCategorys() {
		return categoryRepository.findAll();
	}//getCategorys
	
	public CategoryModel getCategory(Long id) {
		return categoryRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El Categoryo con el id" + id + "no existe."));
	}//getCategory
	
	public CategoryModel deleteCategory(Long id) {
		CategoryModel tmpProd = null;
		if(categoryRepository.existsById(id)) {
			tmpProd = categoryRepository.findById(id).get();
			categoryRepository.deleteById(id);
		}//if exist
		return tmpProd;
	}//deleteCategoryModel
	
	public CategoryModel addCategory(CategoryModel categoryModel) {
		CategoryModel tmpProd = null;
		Optional<CategoryModel> prodByCategory = categoryRepository.findByCategory(categoryModel.getCategory());
		if(prodByCategory.isPresent()) {
			throw new IllegalArgumentException("La categoría con el nombre["+
		categoryModel.getCategory() + "] ya existe.");
		} else {
			categoryRepository.save(categoryModel);
		}//if
		return categoryModel;
	}//addCategoryModel
	
	public CategoryModel updateCategory(Long id, String category) {
		CategoryModel tmpProd = null;
		if(categoryRepository.existsById(id)) {
			tmpProd = categoryRepository.findById(id).get();
			if(category!=null) tmpProd.setCategory(category);
			categoryRepository.save(tmpProd);
		}else {
			System.out.println("El Categoryo con el id" + id + "no existe.");
		}//if
		return tmpProd;
	}//updateCategoryModel
	
}
