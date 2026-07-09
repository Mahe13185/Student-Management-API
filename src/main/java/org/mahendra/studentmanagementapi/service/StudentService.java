package org.mahendra.studentmanagementapi.service;

import org.mahendra.studentmanagementapi.dto.StudentRequestDTO;
import org.mahendra.studentmanagementapi.dto.StudentResponseDTO;
import org.mahendra.studentmanagementapi.entity.Student;

import java.util.List;


public interface StudentService {
    StudentResponseDTO createStudent(StudentRequestDTO dto);
    List<Student> getallStudents();
    Student getStudentByID(Long id);
    Student updateStudent(Long id,Student student);
    void deleteStudent(Long id);
}
