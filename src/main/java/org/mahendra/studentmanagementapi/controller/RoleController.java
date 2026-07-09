package org.mahendra.studentmanagementapi.controller;

import org.mahendra.studentmanagementapi.entity.Role;
import org.mahendra.studentmanagementapi.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping("/allRoles")
    public List<Role> getallRoles(){
        return roleService.getAllRoles();
    }
    @PostMapping
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }
    @GetMapping("/{id}")
    public Role getRoleByID(@PathVariable Long id){
        return roleService.getRoleByID(id);
    }
    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Long id, @RequestBody Role role){
        return roleService.updateRole(id,role);
    }
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
    }
}
