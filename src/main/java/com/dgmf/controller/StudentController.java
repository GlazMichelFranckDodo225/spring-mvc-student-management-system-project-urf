package com.dgmf.controller;

import com.dgmf.dto.StudentDto;
import com.dgmf.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    // Handler Method for List Students Request
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());

        return "students";
    }

    // Handler Method for Create New Student Request
    @GetMapping("/students/new")
    public String newStudent(Model model) {
        // Student Model Object to Store Student Form Data
        StudentDto studentDto = new StudentDto();

        model.addAttribute("student", studentDto);

        return "create_student";
    }

    // Handler Method for Save Student Form Submit Request
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") StudentDto student) {
        studentService.createStudent(student);

        return "redirect:/students";
    }

}
