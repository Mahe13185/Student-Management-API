package org.mahendra.studentmanagementapi.service;

import org.mahendra.studentmanagementapi.entity.Student;
import org.mahendra.studentmanagementapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    private  final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}
