package com.cogent.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.ecommerce.dto.Role;
import com.cogent.ecommerce.repository.RoleRepository;
import com.cogent.ecommerce.repository.RoleRepositoryImpl;

@Service
public class RoleServiceImpl implements RoleService {

//	private static RoleService roleService;
//	private RoleServiceImpl() {}
//	
//	public static RoleService getInstance() {
//		if(roleService==null) {
//			roleService= new RoleServiceImpl();
//			return roleService;
//		}
//		return roleService;
//	}
	@Autowired
	RoleRepository roleRepository;
	@Override
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.addRole(role);
	}

	@Override
	public Optional<String> deleteRoleById(String id) {
		// TODO Auto-generated method stub
		return roleRepository.deleteRoleById(id);
	}
	

	@Override
	public void deleteAllRole() {
		// TODO Auto-generated method stub
		roleRepository.deleteAllRole();
	}

	@Override
	public Optional<Role> getRoleByID(String id) {
		// TODO Auto-generated method stub
		return roleRepository.getRoleByID(id);
	}

	@Override
	public Optional<List<Role>> getRoles() {
		// TODO Auto-generated method stub
		return roleRepository.getRoles();
	}

	@Override
	public Optional<String> upddateRole(String id, Role role) {
		// TODO Auto-generated method stub
		return roleRepository.upddateRole(id, role);
	}

	@Override
	public boolean isRoleExist(String Id) {
		// TODO Auto-generated method stub
		return roleRepository.isRoleExist(Id);
	}

}
