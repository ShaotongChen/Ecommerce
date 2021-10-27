package com.cogent.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.cogent.ecommerce.dto.Catagory;

public interface CatagoryService {
	public String addCatagory(Catagory catagory);
	public Optional<String> deleteCatagoryById(String id) ;
	public void deleteAllCatagorys();
	public Optional<Catagory> getCatagoryByID(String id) ;
	public Optional<List<Catagory>> getCatagory();
	public Optional<String> upddateCatagory(String id, Catagory catagory) ;
	public boolean isCatagoryExist(String Id);
}
