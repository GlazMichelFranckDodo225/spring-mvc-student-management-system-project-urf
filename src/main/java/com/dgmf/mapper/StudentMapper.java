package com.dgmf.mapper;

import com.dgmf.dto.StudentDto;
import com.dgmf.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data @AllArgsConstructor @Builder
public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .build();
    }

    public static Student mapToStudent(StudentDto studentDto) {
        return Student.builder()
                .id(studentDto.getId())
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .email(studentDto.getEmail())
                .build();
    }
}
