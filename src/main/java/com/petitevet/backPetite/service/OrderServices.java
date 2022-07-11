package com.petitevet.backPetite.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.petitevet.backPetite.models.OrderModel;
import com.petitevet.backPetite.repository.OrderRepository;

@Service
public class OrderServices {
private final OrderRepository orderRepository;
	
	@Autowired
	public OrderServices(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}// constructor
	
	public List<OrderModel> getOrders() {
		return orderRepository.findAll();
	}//getOrders
	
	public OrderModel getOrder(Long id) {
		return orderRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El Ordero con el id" + id + "no existe."));
	}//getOrder
	
	public OrderModel deleteOrder(Long id) {
		OrderModel tmpProd = null;
		if(orderRepository.existsById(id)) {
			tmpProd = orderRepository.findById(id).get();
			orderRepository.deleteById(id);
		}//if exist
		return tmpProd;
	}//deleteOrderModel
	
	public OrderModel addOrder(OrderModel orderModel) {
		OrderModel tmpProd = null;
		Optional<OrderModel> prodByDtime = orderRepository.findByDtime(orderModel.getDtime());
		if(prodByDtime.isPresent()) {
			throw new IllegalArgumentException("La orden con la fecha [" + 
		orderModel.getDtime() + "] ya existe.");
		} else {
			orderRepository.save(orderModel);
		}//if
		return orderModel;
	}//addOrderModel
	
	public OrderModel updateOrder(Long id, String dtime, Long user_iduser, Long user_role_idrole ) {
		OrderModel tmpProd = null;
		if(orderRepository.existsById(id)) {
			tmpProd = orderRepository.findById(id).get();
			if(dtime!=null) tmpProd.setDtime(dtime);
			if(user_iduser!=null) tmpProd.setUser_iduser(user_iduser);
			if(user_role_idrole!=null) tmpProd.setUser_role_idrole(user_role_idrole);
			orderRepository.save(tmpProd);
		}else {
			System.out.println("La Ordern con el id" + id + "no existe.");
		}//if
		return tmpProd;
	}//updateOrderModel
	
}//class OrderServices
