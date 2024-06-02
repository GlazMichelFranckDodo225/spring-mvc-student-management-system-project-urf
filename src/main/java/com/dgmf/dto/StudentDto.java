package com.dgmf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Component
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
