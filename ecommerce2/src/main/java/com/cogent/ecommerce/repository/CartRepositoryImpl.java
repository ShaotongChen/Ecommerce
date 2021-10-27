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

import com.cogent.ecommerce.dto.Cart;
import com.cogent.ecommerce.utils.DBUtils;

@Repository
public class CartRepositoryImpl implements CartRepository {

//	private static CartRepository cartRepository;
//	private CartRepositoryImpl() {}
//	
//	
//	public static CartRepository getInstance() {
//		
//		if(cartRepository==null) {
//			cartRepository= new CartRepositoryImpl();
//			return cartRepository;
//		}
//		return cartRepository;
//	}

@Autowired
	DBUtils dbutils;
	
	
	@Override
	public String addCart(Cart cart) {
		// TODO Auto-generated method stub
		Connection connection = dbutils.getConnection();
		String insertStatement = "insert into cart(cartId,userId,invId,productId,productQty,totalPrice) values(?,?,?,?,?,?)";
		PreparedStatement ps= null;
		
		try {
			ps=connection.prepareStatement(insertStatement);
			ps.setString(1, cart.getCartId());
			ps.setString(2, cart.getUserId());
			ps.setString(3, cart.getInvId());
			ps.setString(4, cart.getProductId());
			ps.setInt(5, cart.getProductQty());
			ps.setDouble(6, cart.getTotalPrice());
			
			
			boolean flag = ps.execute();
			
			if(flag== false) {
			return "insert cart inforamtion successful";
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
	public Optional<String> deleteCartById(String id) {
		Connection cn= null;
		PreparedStatement ps =null;
		String st=null;
		String query= "delete from cart where cartId = "+id;
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			int count =0;
			count = ps.executeUpdate();
			
			if(count!=0) {
				st= "delete cart successfully";
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
	public void deleteAllCarts() {
		Connection cn= null;
		PreparedStatement ps =null;
		String query= "delete from cart";
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			int count =0;
			count = ps.executeUpdate();
			if(count!=0) System.out.println("delete carts successfully");
			else System.out.println("didn't find the cart");
			
			
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
	public Optional<Cart> getCartByID(String id) {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		Cart cart= null;
		String query= "select * from cart where cartId = "+id;
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()!=false) {
				 cart= new Cart();
				
				cart.setCartId(rs.getString("cartId"));
				cart.setUserId(rs.getString("userId"));
				cart.setInvId(rs.getString("invId"));
				cart.setProductId(rs.getString("productId"));
				cart.setProductQty(rs.getInt("productQty"));
				cart.setTotalPrice(rs.getDouble("totalPrice"));
			}
			
			return Optional.ofNullable(cart);
			
			
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
	public Optional<List<Cart>> getCart() {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		List<Cart> list= new ArrayList<>();
		String query= "select * from cart";
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Cart cart= new Cart();
				cart.setCartId(rs.getString("cartId"));
				cart.setUserId(rs.getString("userId"));
				cart.setInvId(rs.getString("invId"));
				cart.setProductId(rs.getString("productId"));
				cart.setProductQty(rs.getInt("productQty"));
				cart.setTotalPrice(rs.getDouble("totalPrice"));
				list.add(cart);
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
	public Optional<String> upddateCart(String id, Cart cart) {
		Connection cn= dbutils.getConnection();
		PreparedStatement ps= null;
		int count=0;
		String query= "update cart set userId = ?, invId = ?, productId = ?, productQty =?, totalPrice = ? where cartId = ? ";
		try {
			ps=cn.prepareStatement(query);
			
			ps.setString(1, cart.getUserId());
			ps.setString(2, cart.getInvId());
			ps.setString(3, cart.getProductId());
			ps.setInt(4, cart.getProductQty());
			ps.setDouble(5, cart.getTotalPrice());
			ps.setString(6, cart.getCartId());
			
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
	public boolean isCartExist(String Id) {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		String query= "select * from cart where cartId = "+Id;
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


