package com.dgmf.controller;

import com.dgmf.dto.StudentDto;
import com.dgmf.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String saveStudent(
            @Valid @ModelAttribute("student") StudentDto student,
            // Use Binding Result to Check Errors and Return the UI
            BindingResult result,
            Model model
    ) {
        // Check If there is Any Error while Submitting Form
        if(result.hasErrors()) {
            // Add StudentDto to the Model
            model.addAttribute("student", student);

            // Return the Same UI (Create Student Form)
            return "create_student";
        }

        // If there is no Any Error ==> Save Student
        studentService.createStudent(student);

        // Return the List Students Page
        return "redirect:/students";
    }

    // Handler Method for Edit Student Request
    @GetMapping("/students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId, Model model) {
        StudentDto student = studentService.getStudentById(studentId);
        model.addAttribute("student", student);

        return "edit_student";
    }

    // Handler Method for Edit Student Form Submit Request
    @PostMapping("/students/{studentId}")
    public String saveStudent(
            @PathVariable("studentId") Long studentId,
            @Valid @ModelAttribute("student") StudentDto studentDto,
            // Use Binding Result to Check Errors and Return the UI
            BindingResult result,
            Model model
    ) {
        // Check If there is Any Error while Submitting Form
        if(result.hasErrors()) {
            // Add StudentDto to the Model
            model.addAttribute("student", studentDto);

            // Return the Same UI (Create Student Form)
            return "edit_student";
        }

        // If there is no Any Error ==> Save Student
        studentDto.setId(studentId);
        studentService.updateStudent(studentDto);

        // Return the List Students Page
        return "redirect:/students";
    }
}
