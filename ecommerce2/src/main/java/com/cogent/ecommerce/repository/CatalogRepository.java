package com.cogent.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import com.cogent.ecommerce.dto.Catalog;
;

public interface CatalogRepository {
	public String addCatalog(Catalog catalog);
	public Optional<String> deleteCatalogById(String id) ;
	public void deleteAllCatalogs();
	public Optional<Catalog> getCatalogByID(String id) ;
	public Optional<List<Catalog>> getCatalog();
	public Optional<String> upddateCatalog(String id, Catalog catalog) ;
	public boolean isCatalogExist(String Id);
}
