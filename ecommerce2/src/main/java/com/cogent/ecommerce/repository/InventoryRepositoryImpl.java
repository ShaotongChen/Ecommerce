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

import com.cogent.ecommerce.dto.Inventory;
import com.cogent.ecommerce.utils.DBUtils;

@Repository
public class InventoryRepositoryImpl implements InventoryRepository {

//	private static InventoryRepository inventoryRepository;
//	private InventoryRepositoryImpl() {}
//	
//	
//	public static InventoryRepository getInstance() {
//		
//		if(inventoryRepository==null) {
//			inventoryRepository= new InventoryRepositoryImpl();
//			return inventoryRepository;
//		}
//		return inventoryRepository;
//	}

	@Autowired
	DBUtils dbutils;
	
	
	@Override
	public String addInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		Connection connection = dbutils.getConnection();
		String insertStatement = "insert into inventory(invId,userId,productId,productQty,productPrice) values(?,?,?,?,?)";
		PreparedStatement ps= null;
		
		try {
			ps=connection.prepareStatement(insertStatement);
			ps.setString(1, inventory.getInvId());
			ps.setString(2, inventory.getUserId());
			ps.setString(3, inventory.getProductId());
			ps.setInt(4, inventory.getProductQty());
			ps.setDouble(5, inventory.getProductPrice());
			
			
			boolean flag = ps.execute();
			
			if(flag== false) {
			return "insert inventory inforamtion successful";
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
	public Optional<String> deleteInventoryById(String id) {
		Connection cn= null;
		PreparedStatement ps =null;
		String st=null;
		String query= "delete from inventory where invId = "+id;
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			int count =0;
			count = ps.executeUpdate();
			
			if(count!=0) {
				st= "delete inventory successfully";
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
	public void deleteAllInventorys() {
		Connection cn= null;
		PreparedStatement ps =null;
		String query= "delete from inventory";
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			int count =0;
			count = ps.executeUpdate();
			if(count!=0) System.out.println("delete inventorys successfully");
			else System.out.println("didn't find the inventory");
			
			
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
	public Optional<Inventory> getInventoryByID(String id) {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		Inventory inventory= null;
		String query= "select * from inventory where invId = "+id;
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()!=false) {
				 inventory= new Inventory();
				
				inventory.setInvId(rs.getString("invId"));
				inventory.setUserId(rs.getString("userId"));
				inventory.setProductId(rs.getString("productId"));
				inventory.setProductQty(rs.getInt("productQty"));
				inventory.setProductPrice(rs.getDouble("productPrice"));
			}
			
			return Optional.ofNullable(inventory);
			
			
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
	public Optional<List<Inventory>> getInventory() {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		List<Inventory> list= new ArrayList<>();
		String query= "select * from inventory";
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Inventory inventory= new Inventory();
				inventory.setInvId(rs.getString("invId"));
				inventory.setUserId(rs.getString("userId"));
				inventory.setProductId(rs.getString("productId"));
				inventory.setProductQty(rs.getInt("productQty"));
				inventory.setProductPrice(rs.getDouble("productPrice"));
				list.add(inventory);
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
	public Optional<String> upddateInventory(String id, Inventory inventory) {
		Connection cn= dbutils.getConnection();
		PreparedStatement ps= null;
		int count=0;
		String query= "update inventory set userId = ?,  productId = ?, productQty =?, productPrice = ? where invId = ? ";
		try {
			ps=cn.prepareStatement(query);
			
			ps.setString(1, inventory.getUserId());
			ps.setString(2, inventory.getProductId());
			ps.setInt(3, inventory.getProductQty());
			ps.setDouble(4, inventory.getProductPrice());
			ps.setString(5, inventory.getInvId());
			
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
	public boolean isInventoryExist(String Id) {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		String query= "select * from inventory where invId = "+Id;
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
