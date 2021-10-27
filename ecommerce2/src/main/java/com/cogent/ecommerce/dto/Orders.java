package com.cogent.ecommerce.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
private String orderId;
private String userId;
private String invId;
private String productId;
private int productQty;
private double totalPrice;
private double grandTotalPrice;
}
