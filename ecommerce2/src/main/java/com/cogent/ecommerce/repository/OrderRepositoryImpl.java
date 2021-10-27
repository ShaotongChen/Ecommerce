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

import com.cogent.ecommerce.dto.Orders;
import com.cogent.ecommerce.utils.DBUtils;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
//
//	private static OrderRepository orderRepository;
//	private OrderRepositoryImpl() {}
//	
//	
//	public static OrderRepository getInstance() {
//		
//		if(orderRepository==null) {
//			orderRepository= new OrderRepositoryImpl();
//			return orderRepository;
//		}
//		return orderRepository;
//	}

	@Autowired
	DBUtils dbutils;
	
	
	@Override
	public String addOrder(Orders order) {
		// TODO Auto-generated method stub
		Connection connection = dbutils.getConnection();
		String insertStatement = "insert into orders (orderId,userId,invId,productId,productQty,totalPrice, grandTotalPrice) values(?,?,?,?,?,?,?)";
		PreparedStatement ps= null;
		
		try {
			ps=connection.prepareStatement(insertStatement);
			ps.setString(1, order.getOrderId());
			ps.setString(2, order.getUserId());
			ps.setString(3, order.getInvId());
			ps.setString(4, order.getProductId());
			ps.setInt(5, order.getProductQty());
			ps.setDouble(6, order.getTotalPrice());
			ps.setDouble(7, order.getGrandTotalPrice());
			
			
			boolean flag = ps.execute();
			
			if(flag== false) {
			return "insert orders inforamtion successful";
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
	public Optional<String> deleteOrderById(String id) {
		Connection cn= null;
		PreparedStatement ps =null;
		String st=null;
		String query= "delete from orders where orderId = "+id;
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			int count =0;
			count = ps.executeUpdate();
			
			if(count!=0) {
				st= "delete order successfully";
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
	public void deleteAllOrders() {
		Connection cn= null;
		PreparedStatement ps =null;
		String query= "delete from orders";
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			int count =0;
			count = ps.executeUpdate();
			if(count!=0) System.out.println("delete orders successfully");
			else System.out.println("didn't find the order");
			
			
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
	public Optional<Orders> getOrderByID(String id) {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		Orders order= null;
		String query= "select * from orders where orderId = "+id;
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()!=false) {
				 order= new Orders();
				
				order.setOrderId(rs.getString("orderId"));
				order.setUserId(rs.getString("userId"));
				order.setInvId(rs.getString("invId"));
				order.setProductId(rs.getString("productId"));
				order.setProductQty(rs.getInt("productQty"));
				order.setTotalPrice(rs.getDouble("totalPrice"));
				order.setGrandTotalPrice(rs.getDouble("grandTotalPrice"));
			}
			
			return Optional.ofNullable(order);
			
			
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
	public Optional<List<Orders>> getOrder() {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		List<Orders> list= new ArrayList<>();
		String query= "select * from orders";
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Orders order= new Orders();
				order.setOrderId(rs.getString("orderId"));
				order.setUserId(rs.getString("userId"));
				order.setInvId(rs.getString("invId"));
				order.setProductId(rs.getString("productId"));
				order.setProductQty(rs.getInt("productQty"));
				order.setTotalPrice(rs.getDouble("totalPrice"));
				order.setGrandTotalPrice(rs.getDouble("grandTotalPrice"));
				list.add(order);
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
	public Optional<String> upddateOrder(String id, Orders order) {
		Connection cn= dbutils.getConnection();
		PreparedStatement ps= null;
		int count=0;
		String query= "update orders set userId = ?, invId = ?, productId = ?, productQty =?, totalPrice = ?, grandTotalPrice = ? where orderId = ? ";
		try {
			ps=cn.prepareStatement(query);
			
			ps.setString(1, order.getUserId());
			ps.setString(2, order.getInvId());
			ps.setString(3, order.getProductId());
			ps.setInt(4, order.getProductQty());
			ps.setDouble(5, order.getTotalPrice());
			ps.setDouble(6, order.getGrandTotalPrice());
			ps.setString(7, order.getOrderId());
			
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
	public boolean isOrderExist(String Id) {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		String query= "select * from orders where orderId = "+Id;
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
