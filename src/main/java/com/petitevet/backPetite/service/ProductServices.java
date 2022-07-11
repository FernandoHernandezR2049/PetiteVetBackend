package com.petitevet.backPetite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.petitevet.backPetite.models.ProductModel;
import com.petitevet.backPetite.repository.ProductRepository;

@Service
public class ProductServices {
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductServices(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}// constructor
	
	public List<ProductModel> getProducts() {
		return productRepository.findAll();
	}//getProducts
	
	public ProductModel getProduct(Long id) {
		return productRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El Producto con el id" + id + "no existe."));
	}//getProduct
	
	public ProductModel deleteProduct(Long id) {
		ProductModel tmpProd = null;
		if(productRepository.existsById(id)) {
			tmpProd = productRepository.findById(id).get();
			productRepository.deleteById(id);
		}//if exist
		return tmpProd;
	}//deleteProductModel
	
	public ProductModel addProduct(ProductModel productModel) {
		ProductModel tmpProd = null;
		Optional<ProductModel> prodByName = productRepository.findByName(productModel.getName());
		if(prodByName.isPresent()) {
			throw new IllegalArgumentException("El Producto con el nombre["+
		productModel.getName() + "] ya existe.");
		} else {
			productRepository.save(productModel);
		}//if
		return productModel;
	}//addProductModel
	
	public ProductModel updateProduct(Long id, String name, String description,
			String img, Double precio, String SKU, String quantity ) {
		ProductModel tmpProd = null;
		if(productRepository.existsById(id)) {
			tmpProd = productRepository.findById(id).get();
			if(name!=null) tmpProd.setName(name);
			if(description!=null) tmpProd.setDescription(description);
			if(img!=null) tmpProd.setImg(img);
			if(precio!=null) tmpProd.setPrecio(precio.doubleValue());
			productRepository.save(tmpProd);
		}else {
			System.out.println("El Producto con el id" + id + "no existe.");
		}//if
		return tmpProd;
	}//updateProductModel
	
}//Class ProductServices
