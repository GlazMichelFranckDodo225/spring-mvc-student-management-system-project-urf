package com.dgmf.service.imp;

import com.dgmf.dto.StudentDto;
import com.dgmf.entity.Student;
import com.dgmf.mapper.StudentMapper;
import com.dgmf.repository.StudentRepository;
import com.dgmf.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream().map(StudentMapper::mapToStudentDto).toList();
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(
                        () -> new RuntimeException(
                        "Student Not Found with Given Id : " + studentId
                    )
                );

        return StudentMapper.mapToStudentDto(student);
    }
}
