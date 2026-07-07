package org.mahendra.studentmanagementapi.service;

import org.mahendra.studentmanagementapi.entity.Student;
import org.mahendra.studentmanagementapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Student> getallStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByID(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Long id, Student updatedstudent) {
        Student existingStudent = studentRepository.findById(id).orElse(null);

        if(existingStudent == null){
            return null;
        }
        existingStudent.setFirstName(updatedstudent.getFirstName());
        existingStudent.setLastName(updatedstudent.getLastName());
        existingStudent.setAge(updatedstudent.getAge());
        existingStudent.setPhoneNumber(updatedstudent.getPhoneNumber());
        existingStudent.setPhoneNumber(updatedstudent.getPhoneNumber());
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
