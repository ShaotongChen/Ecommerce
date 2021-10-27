package com.cogent.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
private String invId;
private String userId;
private String productId;
private int productQty;
private double productPrice;
}
