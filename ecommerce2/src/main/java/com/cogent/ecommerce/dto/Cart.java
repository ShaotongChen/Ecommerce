package com.cogent.ecommerce.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
private String cartId;
private String userId;
private String invId;
private String productId;
private int productQty;
private double totalPrice;
}
