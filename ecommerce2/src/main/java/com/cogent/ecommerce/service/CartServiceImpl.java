package com.cogent.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cogent.ecommerce.dto.Cart;
import com.cogent.ecommerce.repository.CartRepository;
import com.cogent.ecommerce.repository.CartRepositoryImpl;

@Repository
public class CartServiceImpl implements CartService {
	
//	private static CartService cartService;
//	private CartServiceImpl() {}
//	
//	public static CartService getInstance() {
//		if(cartService==null) {
//			cartService= new CartServiceImpl();
//			return cartService;
//		}
//		return cartService;
//	}
	@Autowired
	CartRepository cartRepository;
	@Override
	public String addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.addCart(cart);
	}

	@Override
	public Optional<String> deleteCartById(String id) {
		// TODO Auto-generated method stub
		return cartRepository.deleteCartById(id);
	}
	

	@Override
	public void deleteAllCarts() {
		// TODO Auto-generated method stub
		cartRepository.deleteAllCarts();
	}

	@Override
	public Optional<Cart> getCartByID(String id) {
		// TODO Auto-generated method stub
		return cartRepository.getCartByID(id);
	}

	@Override
	public Optional<List<Cart>> getCart() {
		// TODO Auto-generated method stub
		return cartRepository.getCart();
	}

	@Override
	public Optional<String> upddateCart(String id, Cart cart) {
		// TODO Auto-generated method stub
		return cartRepository.upddateCart(id, cart);
	}

	@Override
	public boolean isCartExist(String Id) {
		// TODO Auto-generated method stub
		return cartRepository.isCartExist(Id);
	}

}
