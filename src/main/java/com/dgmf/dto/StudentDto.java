package com.dgmf.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Component
public class StudentDto {
    private Long id;
    @NotEmpty(message = "First Name Should Not Be Empty")
    private String firstName;
    @NotEmpty(message = "Last Name Should Not Be Empty")
    private String lastName;
    @NotEmpty(message = "Email Should Not Be Empty")
    @Email
    private String email;
}
