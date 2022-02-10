package v.kiselev.controller;

import org.springframework.web.bind.annotation.*;
import v.kiselev.Dto.StudentDto;

import v.kiselev.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public List<StudentDto> allStudents() {
        return studentService.findAll();
    }


    @GetMapping("/{id}")
    public StudentDto student(@PathVariable("id") Long id) {
        return studentService.findById(id).get();
    }

    @PostMapping("/new")
    public StudentDto create(StudentDto studentDto) {
        return studentService.save(studentDto);
    }

    @DeleteMapping("/remove/{id}")
    public void removeStudent(@PathVariable("id") Long id) {
        studentService.delete(id);
    }


}
