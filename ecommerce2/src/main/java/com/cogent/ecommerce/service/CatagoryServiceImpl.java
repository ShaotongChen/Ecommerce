package com.cogent.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.ecommerce.dto.Catagory;
import com.cogent.ecommerce.repository.CatagoryRepository;
import com.cogent.ecommerce.repository.CatagoryRepositoryImpl;

@Service
public class CatagoryServiceImpl implements CatagoryService {
//
//	private static CatagoryService catagoryService;
//	private CatagoryServiceImpl() {}
//	
//	public static CatagoryService getInstance() {
//		if(catagoryService==null) {
//			catagoryService= new CatagoryServiceImpl();
//			return catagoryService;
//		}
//		return catagoryService;
//	}
	@Autowired
	CatagoryRepository catagoryRepository;
	@Override
	public String addCatagory(Catagory catagory) {
		// TODO Auto-generated method stub
		return catagoryRepository.addCatagory(catagory);
	}

	@Override
	public Optional<String> deleteCatagoryById(String id) {
		// TODO Auto-generated method stub
		return catagoryRepository.deleteCatagoryById(id);
	}
	

	@Override
	public void deleteAllCatagorys() {
		// TODO Auto-generated method stub
		catagoryRepository.deleteAllCatagorys();
	}

	@Override
	public Optional<Catagory> getCatagoryByID(String id) {
		// TODO Auto-generated method stub
		return catagoryRepository.getCatagoryByID(id);
	}

	@Override
	public Optional<List<Catagory>> getCatagory() {
		// TODO Auto-generated method stub
		return catagoryRepository.getCatagory();
	}

	@Override
	public Optional<String> upddateCatagory(String id, Catagory catagory) {
		// TODO Auto-generated method stub
		return catagoryRepository.upddateCatagory(id, catagory);
	}

	@Override
	public boolean isCatagoryExist(String Id) {
		// TODO Auto-generated method stub
		return catagoryRepository.isCatagoryExist(Id);
	}


}
