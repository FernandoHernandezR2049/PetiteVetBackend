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

import com.petitevet.backPetite.models.OrderModel;
import com.petitevet.backPetite.service.OrderServices;

@RestController
@RequestMapping(path="/api/order/")
public class OrderController {
private final OrderServices orderServices;
	
	@Autowired
	public OrderController(OrderServices orderServices) {
		this.orderServices = orderServices;
	}// constructor
	
	//CRUD
	@GetMapping
	public List<OrderModel> getAllOrders(){
		return orderServices.getOrders();
	}//getAllOrders
	
	@GetMapping (path="{prodId}")
	public OrderModel getOrder(@PathVariable("prodId") Long id) {
		return orderServices.getOrder(id);
	}//getMapping
	
	@DeleteMapping (path="{prodId}")
	public OrderModel deleteOrder(@PathVariable("prodId") Long id) {
		return orderServices.deleteOrder(id);
	}//deleteOrder
	
	@PostMapping
	public OrderModel addOrder(@RequestBody OrderModel orderModel) {
		return orderServices.addOrder(orderModel);
	}//addOrder
	
	@PutMapping (path="{prodId}")
	public OrderModel updateOrder(@PathVariable("prodId") Long id, 
			@RequestParam(required = false) String dtime,
			@RequestParam(required = false) Long id_roleuser,
			@RequestParam(required = false) Long user_role_idrole) {
		return orderServices.updateOrder(id, dtime, id_roleuser, user_role_idrole);
	}//updateOrder
}
