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
import com.petitevet.backPetite.models.RoleModel;
import com.petitevet.backPetite.service.RoleServices;

@RestController
@RequestMapping(path="/api/role/")
public class RoleController {
private final RoleServices roleServices;
	
	@Autowired
	public RoleController(RoleServices roleServices) {
		this.roleServices = roleServices;
	}// constructor
	
	//CRUD
	@GetMapping
	public List<RoleModel> getAllRoles(){
		return roleServices.getRoles();
	}//getAllRoles
	
	@GetMapping (path="{prodId}")
	public RoleModel getRole(@PathVariable("prodId") Long id) {
		return roleServices.getRole(id);
	}//getMapping
	
	@DeleteMapping (path="{prodId}")
	public RoleModel deleteRole(@PathVariable("prodId") Long id) {
		return roleServices.deleteRole(id);
	}//deleteRole
	
	@PostMapping
	public RoleModel addRole(@RequestBody RoleModel roleoModel) {
		return roleServices.addRole(roleoModel);
	}//addRole
	
	@PutMapping (path="{prodId}")
	public RoleModel updateRole(@PathVariable("prodId") Long id, 
			@RequestParam(required = false) String name) {
		return roleServices.updateRole(id, name);
	}//updateRole
	
}//RoleController
