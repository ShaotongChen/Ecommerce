package com.cogent.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cogent.ecommerce.dto.Catalog;
import com.cogent.ecommerce.utils.DBUtils;

@Repository
public class CatalogRepositoryImpl implements CatalogRepository {

//	private static CatalogRepository catalogRepository;
//	private CatalogRepositoryImpl() {}
//	
//	
//	public static CatalogRepository getInstance() {
//		
//		if(catalogRepository==null) {
//			catalogRepository= new CatalogRepositoryImpl();
//			return catalogRepository;
//		}
//		return catalogRepository;
//	}

	@Autowired
	DBUtils dbutils;
	
	
	@Override
	public String addCatalog(Catalog catalog) {
		// TODO Auto-generated method stub
		Connection connection = dbutils.getConnection();
		String insertStatement = "insert into catalog(productId, productName,catId,productDescription,productImage) values(?,?,?,?,?)";
		PreparedStatement ps= null;
		
		try {
			ps=connection.prepareStatement(insertStatement);
			ps.setString(1, catalog.getProductId());
			ps.setString(2, catalog.getProductName());
			ps.setString(3, catalog.getCatID());
			ps.setString(4, catalog.getProductDescription());
			ps.setString(5, catalog.getProductImage());
		
			
			
			boolean flag = ps.execute();
			
			if(flag== false) {
			return "insert catalog inforamtion successful";
			}return "something wrong!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(ps!= null) {
					ps.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}try {
				if(connection!=null) connection.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return "something wrong!";
	
	}

	@Override
	public Optional<String> deleteCatalogById(String id) {
		Connection cn= null;
		PreparedStatement ps =null;
		String st=null;
		String query= "delete from catalog where productId  = "+id;
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			int count =0;
			count = ps.executeUpdate();
			
			if(count!=0) {
				st= "delete catalog successfully";
			}
			return Optional.ofNullable(st);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(ps!= null) {
					ps.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}try {
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void deleteAllCatalogs() {
		Connection cn= null;
		PreparedStatement ps =null;
		String query= "delete from catalog";
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			int count =0;
			count = ps.executeUpdate();
			if(count!=0) System.out.println("delete catalogs successfully");
			else System.out.println("didn't find the catalog");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(ps!= null) {
					ps.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}try {
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

	}

	@Override
	public Optional<Catalog> getCatalogByID(String id) {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		Catalog catalog= null;
		String query= "select * from catalog where productId = "+id;
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()!=false) {
				 catalog= new Catalog();
				
				catalog.setProductId(rs.getString("productId"));
				catalog.setProductName(rs.getString("productName"));
				catalog.setCatID(rs.getString("catId"));
				catalog.setProductDescription(rs.getString("productDescription"));
				catalog.setProductImage(rs.getString("productImage"));
			}
			
			return Optional.ofNullable(catalog);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			try {
				if(ps!= null) {
					ps.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}try {
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<Catalog>> getCatalog() {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		List<Catalog> list= new ArrayList<>();
		String query= "select * from catalog";
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Catalog catalog= new Catalog();
				catalog.setProductId(rs.getString("productId"));
				catalog.setProductName(rs.getString("productName"));
				catalog.setCatID(rs.getString("catId"));
				catalog.setProductDescription(rs.getString("productDescription"));
				catalog.setProductImage(rs.getString("productImage"));
				
				list.add(catalog);
			}
			return Optional.ofNullable(list); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			try {
				if(ps!= null) {
					ps.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}try {
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return Optional.empty();
	}

	@Override
	public Optional<String> upddateCatalog(String id, Catalog catalog) {
		Connection cn= dbutils.getConnection();
		PreparedStatement ps= null;
		int count=0;
		String query= "update catalog set productName = ?, catId = ?, productDescription = ?,productImage = ? where productId = ? ";
		try {
			ps=cn.prepareStatement(query);
			
			ps.setString(1, catalog.getProductName());
			ps.setString(2, catalog.getCatID());
			ps.setString(3, catalog.getProductDescription());
			ps.setString(4, catalog.getProductImage());
			ps.setString(5, catalog.getProductId());
			
			count = ps.executeUpdate();
			
			if(count!=0) {
				String st = "Update successfully!";
				return Optional.ofNullable(st);
			}

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(ps!= null) {
					ps.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}try {
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return Optional.empty();
	}

	@Override
	public boolean isCatalogExist(String Id) {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		String query= "select * from catalog where productId = "+Id;
		boolean result= false;
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()!=false) {System.out.println("the employee exists");
			result = true;
			return result;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			try {
				if(ps!= null) {
					ps.close();
				}
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}try {
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return result;
	}

}
