package com.dgmf.service;

import com.dgmf.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();
    void createStudent(StudentDto student);
    StudentDto getStudentById(Long studentId);
}
