package org.mahendra.studentmanagementapi.controller;

import jakarta.validation.Valid;
import org.mahendra.studentmanagementapi.entity.Student;
import org.mahendra.studentmanagementapi.service.StudentService;
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
    public Student createStudent(@Valid @RequestBody Student student){
        return studentService.createStudent(student);
    }
    @GetMapping
    public List<Student> getallStudents(){
        return studentService.getallStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentByID(@PathVariable Long id){
        return studentService.getStudentByID(id);
    }

    @PostMapping("/{id}")
    public Student updateStudentByID(@PathVariable Long id,@RequestBody Student student){
        return studentService.updateStudent(id, student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudentByID(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

}
