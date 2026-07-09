package org.mahendra.studentmanagementapi.repository;

import org.mahendra.studentmanagementapi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
