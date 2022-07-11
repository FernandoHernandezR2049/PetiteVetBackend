package com.petitevet.backPetite.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.petitevet.backPetite.models.ProductHasCategoryModel;
import com.petitevet.backPetite.repository.ProductHasCategoryRepository;

@Service
public class ProductHasCategoryServices {
private final ProductHasCategoryRepository pruducthascategoryRepository;
	
	@Autowired
	public ProductHasCategoryServices(ProductHasCategoryRepository pruducthascategoryRepository) {
		super();
		this.pruducthascategoryRepository = pruducthascategoryRepository;
	}// constructor
	
	public List<ProductHasCategoryModel> getPrudctHasCategorys() {
		return pruducthascategoryRepository.findAll();
	}//getPrudctHasCategorys
	
	public ProductHasCategoryModel getPrudctHasCategory(Long id) {
		return pruducthascategoryRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El PrudctHasCategoryo con el id" + id + "no existe."));
	}//getPrudctHasCategory
	
	public ProductHasCategoryModel deletePrudctHasCategory(Long id) {
		ProductHasCategoryModel tmpProd = null;
		if(pruducthascategoryRepository.existsById(id)) {
			tmpProd = pruducthascategoryRepository.findById(id).get();
			pruducthascategoryRepository.deleteById(id);
		}//if exist
		return tmpProd;
	}//deletePrudctHasCategoryModel
	
	public ProductHasCategoryModel addPrudctHasCategory(Long category_idcategory) {
		ProductHasCategoryModel tmpProd = null;
		//Optional<ProductHasCategoryModel> prodByCategory = pruducthascategoryRepository.findByCat(prudcthascategoryModel.getCategory_idcategory());
		if(pruducthascategoryRepository.existsById(category_idcategory)) {
			tmpProd = pruducthascategoryRepository.findById(category_idcategory).get();
			pruducthascategoryRepository.save(tmpProd);
		}//if
		return tmpProd;
	}//addPrudctHasCategoryModel
	
//	public ProductHasCategoryModel addPrudctHasCategory(ProductHasCategoryModel prudcthascategoryModel) {
//		ProductHasCategoryModel tmpProd = null;
//		Optional<ProductHasCategoryModel> prodByCategory = pruducthascategoryRepository.findByCat(prudcthascategoryModel.getCategory_idcategory());
//		if(prodByCategory.isPresent()) {
//			throw new IllegalArgumentException("El id de categoría ["+
//		prudcthascategoryModel.getCategory_idcategory() + "] ya existe.");
//		} else {
//			pruducthascategoryRepository.save(prudcthascategoryModel);
//		}//if
//		return prudcthascategoryModel;
//	}//addPrudctHasCategoryModel
	
	public ProductHasCategoryModel updatePrudctHasCategory(Long id, Long category_idcategory) {
		ProductHasCategoryModel tmpProd = null;
		if(pruducthascategoryRepository.existsById(id)) {
			tmpProd = pruducthascategoryRepository.findById(id).get();
			if(category_idcategory!=null) tmpProd.setCategory_idcategory(category_idcategory);
			pruducthascategoryRepository.save(tmpProd);
		}else {
			System.out.println("El PrudctHasCategoryo con el id" + id + "no existe.");
		}//if
		return tmpProd;
	}//updatePrudctHasCategoryModel
}//Class
