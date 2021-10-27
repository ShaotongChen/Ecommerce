package com.cogent.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.ecommerce.dto.Inventory;
import com.cogent.ecommerce.repository.InventoryRepository;
import com.cogent.ecommerce.repository.InventoryRepositoryImpl;

@Service
public class InventoryServiceImpl implements InventoryService {

//	private static InventoryService inventoryService;
//	private InventoryServiceImpl() {}
//	
//	public static InventoryService getInstance() {
//		if(inventoryService==null) {
//			inventoryService= new InventoryServiceImpl();
//			return inventoryService;
//		}
//		return inventoryService;
//	}
	@Autowired
	InventoryRepository inventoryRepository;
	@Override
	public String addInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return inventoryRepository.addInventory(inventory);
	}

	@Override
	public Optional<String> deleteInventoryById(String id) {
		// TODO Auto-generated method stub
		return inventoryRepository.deleteInventoryById(id);
	}
	

	@Override
	public void deleteAllInventorys() {
		// TODO Auto-generated method stub
		inventoryRepository.deleteAllInventorys();
	}

	@Override
	public Optional<Inventory> getInventoryByID(String id) {
		// TODO Auto-generated method stub
		return inventoryRepository.getInventoryByID(id);
	}

	@Override
	public Optional<List<Inventory>> getInventory() {
		// TODO Auto-generated method stub
		return inventoryRepository.getInventory();
	}

	@Override
	public Optional<String> upddateInventory(String id, Inventory inventory) {
		// TODO Auto-generated method stub
		return inventoryRepository.upddateInventory(id, inventory);
	}

	@Override
	public boolean isInventoryExist(String Id) {
		// TODO Auto-generated method stub
		return inventoryRepository.isInventoryExist(Id);
	}

}
