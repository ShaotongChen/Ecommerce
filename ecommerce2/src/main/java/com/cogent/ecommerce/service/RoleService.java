package com.cogent.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.cogent.ecommerce.dto.Role;

public interface RoleService {
	public String addRole(Role role);
	public Optional<String> deleteRoleById(String id);
	public void deleteAllRole();
	public Optional<Role> getRoleByID(String id) ;
	public Optional<List<Role>> getRoles();
	public Optional<String> upddateRole(String id, Role role);
	public boolean isRoleExist(String Id);
}
