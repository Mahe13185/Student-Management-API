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
    public ResponseEntity<StudentResponseDTO> createStudent(
            @Valid @RequestBody StudentRequestDTO dto) {

        StudentResponseDTO responseDTO =  studentService.createStudent(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseDTO);
    }
    @GetMapping
    public ResponseEntity<List<Student>> getallStudents(){
        List<Student> students = studentService.getallStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentByID(@PathVariable Long id){
        Student student =  studentService.getStudentByID(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentByID(@PathVariable Long id,@RequestBody Student student){
        Student updateStudent =  studentService.updateStudent(id, student);
        return ResponseEntity.ok(updateStudent);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentByID(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.notFound().build();
    }

}
