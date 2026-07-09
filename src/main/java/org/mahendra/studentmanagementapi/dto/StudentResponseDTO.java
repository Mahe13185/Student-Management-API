package org.mahendra.studentmanagementapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentResponseDTO {
    private Long id;
    private String Firstname;
    private String LastName;
    private String email;
    private String phoneNumber;
    private Integer age;
    private String roleName;


}
