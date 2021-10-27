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

import com.cogent.ecommerce.dto.Role;
import com.cogent.ecommerce.utils.DBUtils;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

//	private static RoleRepository roleRepository;
//	private RoleRepositoryImpl() {}
//	
//	
//	public static RoleRepository getInstance() {
//		
//		if(roleRepository==null) {
//			roleRepository= new RoleRepositoryImpl();
//			return roleRepository;
//		}
//		return roleRepository;
//	}
	@Autowired
	DBUtils dbutils;
	
	
	@Override
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		Connection connection = dbutils.getConnection();
		String insertStatement = "insert into role(roleId,roleName) values(?,?)";
		PreparedStatement ps= null;
		
		try {
			ps=connection.prepareStatement(insertStatement);
			ps.setString(1, role.getRoleId());
			ps.setString(2, role.getRoleName());
		
			
			
			boolean flag = ps.execute();
			
			if(flag== false) {
			return "insert role inforamtion successful";
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
	public Optional<String> deleteRoleById(String id) {
		Connection cn= null;
		PreparedStatement ps =null;
		String st=null;
		String query= "delete from role where roleId = "+id;
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			int count =0;
			count = ps.executeUpdate();
			
			if(count!=0) {
				st= "delete role successfully";
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
	public void deleteAllRole() {
		Connection cn= null;
		PreparedStatement ps =null;
		String query= "delete from role";
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			int count =0;
			count = ps.executeUpdate();
			if(count!=0) System.out.println("delete roles successfully");
			else System.out.println("didn't find the role");
			
			
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
	public Optional<Role> getRoleByID(String id) {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		Role role= null;
		String query= "select * from role where roleId = "+id;
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()!=false) {
				 role= new Role();
				
				role.setRoleId(rs.getString("roleId"));
				role.setRoleName(rs.getString("roleName"));
				
			}
			
			return Optional.ofNullable(role);
			
			
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
	public Optional<List<Role>> getRoles() {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		List<Role> list= new ArrayList<>();
		String query= "select * from role";
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Role role= new Role();
				role.setRoleId(rs.getString("roleId"));
				role.setRoleName(rs.getString("roleName"));
				list.add(role);
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
	public Optional<String> upddateRole(String id, Role role) {
		Connection cn= dbutils.getConnection();
		PreparedStatement ps= null;
		int count=0;
		String query= "update role set roleName = ? where roleId = ? ";
		try {
			ps=cn.prepareStatement(query);
			
			ps.setString(1, role.getRoleName());
			ps.setString(2, role.getRoleId());
		
			
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
	public boolean isRoleExist(String Id) {
		Connection cn= null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		String query= "select * from role where roleId = "+Id;
		boolean result= false;
		try {
			cn= dbutils.getConnection();
			if(cn!=null) ps=cn.prepareStatement(query);
			rs = ps.executeQuery();
			
			if(rs.next()!=false) {System.out.println("the role exists");
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


