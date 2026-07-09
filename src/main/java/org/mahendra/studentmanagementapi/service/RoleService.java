package org.mahendra.studentmanagementapi.service;

import org.mahendra.studentmanagementapi.entity.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);
    List<Role> getAllRoles();
    Role getRoleByID(Long id);
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
}
