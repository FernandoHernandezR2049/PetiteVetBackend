package com.petitevet.backPetite.controller;

import java.util.List;

import com.petitevet.backPetite.models.ProductModel;
import com.petitevet.backPetite.service.ProductServices;

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


@RestController
@RequestMapping (path="/api/products/")
//@CrossOrigin(origins = "*")
public class ModelController {

private final ProductServices productServices;
	
	@Autowired //La inyección de dependencias
	public ModelController(ProductServices productServices) {
		this.productServices = productServices;
	}//constructor
	
	@GetMapping
	public List<ProductModel> getAllProducts(){
		return productServices.getProducts();
	}//getAllProducts
	
	@GetMapping (path="{prodId}")
	public ProductModel getProduct(@PathVariable("prodId") Long id) {
		return productServices.getProduct(id);
	}//getMapping
	
	@DeleteMapping (path="{prodId}")
	public ProductModel deleteProduct(@PathVariable("prodId") Long id) {
		return productServices.deleteProduct(id);
	}//deleteProduct
	
	@PostMapping
	public ProductModel addProduct(@RequestBody ProductModel productoModel) {
		return productServices.addProduct(productoModel);
	}//addProduct
	
	@PutMapping (path="{prodId}")
	public ProductModel updateProduct(@PathVariable("prodId") Long id, 
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String description,
			@RequestParam(required = false) String img,
			@RequestParam(required = false) Double precio) {
		return productServices.updateProduct(id, name, description, img, precio);
	}//updateProduct
}
