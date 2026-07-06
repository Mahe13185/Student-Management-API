package org.mahendra.studentmanagementapi.service;

import org.mahendra.studentmanagementapi.entity.Student;
import org.springframework.stereotype.Service;


public interface StudentService {
    Student createStudent(Student student);
}
