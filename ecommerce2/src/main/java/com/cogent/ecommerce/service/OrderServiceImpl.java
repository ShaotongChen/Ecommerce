package com.cogent.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.ecommerce.dto.Orders;
import com.cogent.ecommerce.repository.OrderRepository;
import com.cogent.ecommerce.repository.OrderRepositoryImpl;

@Service
public class OrderServiceImpl implements OrderService {

//	private static OrderService orderService;
//	private OrderServiceImpl() {}
//	
//	public static OrderService getInstance() {
//		if(orderService==null) {
//			orderService= new OrderServiceImpl();
//			return orderService;
//		}
//		return orderService;
//	}
	@Autowired
	OrderRepository orderRepository;
	@Override
	public String addOrder(Orders order) {
		// TODO Auto-generated method stub
		return orderRepository.addOrder(order);
	}

	@Override
	public Optional<String> deleteOrderById(String id) {
		// TODO Auto-generated method stub
		return orderRepository.deleteOrderById(id);
	}
	

	@Override
	public void deleteAllOrders() {
		// TODO Auto-generated method stub
		orderRepository.deleteAllOrders();
	}

	@Override
	public Optional<Orders> getOrderByID(String id) {
		// TODO Auto-generated method stub
		return orderRepository.getOrderByID(id);
	}

	@Override
	public Optional<List<Orders>> getOrder() {
		// TODO Auto-generated method stub
		return orderRepository.getOrder();
	}

	@Override
	public Optional<String> upddateOrder(String id, Orders order) {
		// TODO Auto-generated method stub
		return orderRepository.upddateOrder(id, order);
	}

	@Override
	public boolean isOrderExist(String Id) {
		// TODO Auto-generated method stub
		return orderRepository.isOrderExist(Id);
	}

}
