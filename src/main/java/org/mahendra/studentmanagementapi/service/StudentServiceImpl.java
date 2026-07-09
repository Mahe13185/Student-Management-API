package org.mahendra.studentmanagementapi.service;

import org.mahendra.studentmanagementapi.dto.StudentRequestDTO;
import org.mahendra.studentmanagementapi.dto.StudentResponseDTO;
import org.mahendra.studentmanagementapi.entity.Role;
import org.mahendra.studentmanagementapi.entity.Student;
import org.mahendra.studentmanagementapi.repository.RoleRepository;
import org.mahendra.studentmanagementapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private  final StudentRepository studentRepository;
    private final RoleRepository roleRepository;

    public StudentServiceImpl(StudentRepository studentRepository, RoleRepository roleRepository){
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO dto) {
        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow();
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setPhoneNumber(dto.getPhoneNumber());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());
        student.setRole(role);

        Student savedStudent = studentRepository.save(student);

        StudentResponseDTO response = new StudentResponseDTO();
        response.setId(savedStudent.getId());
        response.setFirstname(savedStudent.getFirstName());
        response.setLastName(savedStudent.getLastName());
        response.setEmail(savedStudent.getEmail());
        response.setPhoneNumber(savedStudent.getPhoneNumber());
        response.setAge(savedStudent.getAge());
        response.setRoleName(savedStudent.getRole().getName());

        return response;
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
