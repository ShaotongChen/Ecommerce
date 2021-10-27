package com.cogent.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.cogent.ecommerce.dto.Orders;

public interface OrderService {
	public String addOrder(Orders order);
	public Optional<String> deleteOrderById(String id) ;
	public void deleteAllOrders();
	public Optional<Orders> getOrderByID(String id) ;
	public Optional<List<Orders>> getOrder();
	public Optional<String> upddateOrder(String id, Orders order) ;
	public boolean isOrderExist(String Id);
}
