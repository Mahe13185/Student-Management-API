package org.mahendra.studentmanagementapi.controller;

import jakarta.validation.Valid;
import org.mahendra.studentmanagementapi.dto.StudentRequestDTO;
import org.mahendra.studentmanagementapi.dto.StudentResponseDTO;
import org.mahendra.studentmanagementapi.entity.Student;
import org.mahendra.studentmanagementapi.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")

public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @PostMapping
    public StudentResponseDTO createStudent(
            @Valid @RequestBody StudentRequestDTO dto) {

        return studentService.createStudent(dto);

    }
    @GetMapping
    public ResponseEntity<List<Student>> getallStudents(){
        List<Student> student = studentService.getallStudents();
        return ResponseEntity.ok(student);
    }

    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable Long id){
        return studentService.getStudentByID(id);
    }

    @PutMapping("/{id}")
    public Student updateStudentByID(@PathVariable Long id,@RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudentByID(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
