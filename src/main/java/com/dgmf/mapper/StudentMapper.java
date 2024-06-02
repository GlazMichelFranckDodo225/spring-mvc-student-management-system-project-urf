package com.dgmf.mapper;

import com.dgmf.dto.StudentDto;
import com.dgmf.entity.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentMapper {
    private final ModelMapper modelMapper;

    public StudentDto mapToStudentDto(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }

    public Student mapToStudent(StudentDto studentDto) {
        return modelMapper.map(studentDto, Student.class);
    }
}
