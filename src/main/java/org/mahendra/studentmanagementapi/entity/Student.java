package org.mahendra.studentmanagementapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 20,message = "The size should be between 2 to 20 length")
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @NotBlank
    @Size(min = 2,max = 50,message = "Length should be 2 to 50")
    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(nullable = false, unique = true, length = 100)
    @NotBlank(message = "Email should not empty")
    @Email(message = "Enter valid email address")
    private String email;

    @NotBlank(message = "Phone Number is required")
    @Column(length = 15)
    private String phoneNumber;

    @NotNull(message = "Age is required")
    @Min(value = 2,message = "Age should be Greater then 2")
    @Max(value = 60,message = "Age should be less then 60")
    private Integer age;
}