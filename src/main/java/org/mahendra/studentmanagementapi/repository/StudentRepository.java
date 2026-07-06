package org.mahendra.studentmanagementapi.repository;

import org.mahendra.studentmanagementapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
