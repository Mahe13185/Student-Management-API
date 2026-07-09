package org.mahendra.studentmanagementapi.service;

import jakarta.annotation.Resource;
import org.mahendra.studentmanagementapi.entity.Role;
import org.mahendra.studentmanagementapi.exception.ResourceNotFoundException;
import org.mahendra.studentmanagementapi.repository.RoleRepository;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    public RoleServiceImpl(RoleRepository roleRespository){
        this.roleRepository = roleRespository;
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleByID(Long id) {
        return roleRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Role not found with ID : " + id));
    }

    @Override
    public Role updateRole(Long id, Role updatedRole) {
        Role existingRole = roleRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Role not found"));
        existingRole.setName(updatedRole.getName());
        return roleRepository.save(existingRole);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

}
