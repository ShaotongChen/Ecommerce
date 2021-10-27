package com.cogent.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.cogent.ecommerce.dto.Inventory;

public interface InventoryService {
	public String addInventory(Inventory inventory);
	public Optional<String> deleteInventoryById(String id) ;
	public void deleteAllInventorys();
	public Optional<Inventory> getInventoryByID(String id) ;
	public Optional<List<Inventory>> getInventory();
	public Optional<String> upddateInventory(String id, Inventory inventory) ;
	public boolean isInventoryExist(String Id);
}
