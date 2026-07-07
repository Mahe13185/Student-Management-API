package org.mahendra.studentmanagementapi.service;

import org.mahendra.studentmanagementapi.entity.Student;

import java.util.List;


public interface StudentService {
    Student createStudent(Student student);
    List<Student> getallStudents();
    Student getStudentByID(Long id);
    Student updateStudent(Long id,Student student);
    void deleteStudent(Long id);
}
