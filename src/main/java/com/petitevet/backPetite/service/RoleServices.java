package com.petitevet.backPetite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petitevet.backPetite.models.ProductModel;
import com.petitevet.backPetite.models.RoleModel;
import com.petitevet.backPetite.repository.ProductRepository;
import com.petitevet.backPetite.repository.RoleRepository;

@Service
public class RoleServices {
private final RoleRepository roleRepository;
	
	@Autowired
	public RoleServices(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}// constructor
	
	public List<RoleModel> getRoles() {
		return roleRepository.findAll();
	}//getProducts
	
	public RoleModel getRole(Long id) {
		return roleRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El Producto con el id" + id + "no existe."));
	}//getProduct
	
	public RoleModel deleteRole(Long id) {
		RoleModel tmpProd = null;
		if(roleRepository.existsById(id)) {
			tmpProd = roleRepository.findById(id).get();
			roleRepository.deleteById(id);
		}//if exist
		return tmpProd;
	}//deleteProductModel
	
	public RoleModel addRole(RoleModel roleModel) {
		RoleModel tmpProd = null;
		Optional<RoleModel> prodByName = roleRepository.findByName(roleModel.getName());
		if(prodByName.isPresent()) {
			throw new IllegalArgumentException("El Producto con el nombre["+
		roleModel.getName() + "] ya existe.");
		} else {
			roleRepository.save(roleModel);
		}//if
		return roleModel;
	}//addProductModel
	
	public RoleModel updateRole(Long id, String name) {
		RoleModel tmpProd = null;
		if(roleRepository.existsById(id)) {
			tmpProd = roleRepository.findById(id).get();
			if(name!=null) tmpProd.setName(name);
			roleRepository.save(tmpProd);
		}else {
			System.out.println("El Producto con el id" + id + "no existe.");
		}//if
		return tmpProd;
	}//updateProductModel
	
}//Class RoleServices
