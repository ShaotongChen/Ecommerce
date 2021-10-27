package com.cogent.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.cogent.ecommerce.dto.Cart;

public interface CartService {
	public String addCart(Cart cart);
	public Optional<String> deleteCartById(String id) ;
	public void deleteAllCarts();
	public Optional<Cart> getCartByID(String id) ;
	public Optional<List<Cart>> getCart();
	public Optional<String> upddateCart(String id, Cart cart) ;
	public boolean isCartExist(String Id);
}
