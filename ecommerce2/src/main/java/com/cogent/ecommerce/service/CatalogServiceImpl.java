package com.cogent.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.ecommerce.dto.Catalog;
import com.cogent.ecommerce.repository.CatalogRepository;
import com.cogent.ecommerce.repository.CatalogRepositoryImpl;

@Service
public class CatalogServiceImpl implements CatalogService {
//	private static CatalogService catalogService;
//	private CatalogServiceImpl() {}
//	
//	public static CatalogService getInstance() {
//		if(catalogService==null) {
//			catalogService= new CatalogServiceImpl();
//			return catalogService;
//		}
//		return catalogService;
//	}
	@Autowired
	CatalogRepository catalogRepository;
	@Override
	public String addCatalog(Catalog catalog) {
		// TODO Auto-generated method stub
		return catalogRepository.addCatalog(catalog);
	}

	@Override
	public Optional<String> deleteCatalogById(String id) {
		// TODO Auto-generated method stub
		return catalogRepository.deleteCatalogById(id);
	}
	

	@Override
	public void deleteAllCatalogs() {
		// TODO Auto-generated method stub
		catalogRepository.deleteAllCatalogs();
	}

	@Override
	public Optional<Catalog> getCatalogByID(String id) {
		// TODO Auto-generated method stub
		return catalogRepository.getCatalogByID(id);
	}

	@Override
	public Optional<List<Catalog>> getCatalog() {
		// TODO Auto-generated method stub
		return catalogRepository.getCatalog();
	}

	@Override
	public Optional<String> upddateCatalog(String id, Catalog catalog) {
		// TODO Auto-generated method stub
		return catalogRepository.upddateCatalog(id, catalog);
	}

	@Override
	public boolean isCatalogExist(String Id) {
		// TODO Auto-generated method stub
		return catalogRepository.isCatalogExist(Id);
	}

}
