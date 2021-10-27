package com.cogent.ecommerce.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {

	private String productId;
	private String productName;
	private String catID;
	private String ProductDescription;
	private String productImage;
	
}
