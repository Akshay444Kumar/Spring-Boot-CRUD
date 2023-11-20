package com.example.spring_crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "name can't be empty!")
    private String name;

    @Email(message = "Invalid Email")
    private String email;

    /*
    @NotNull
    @Pattern(regexp = "", message = "")
    @Min(18)
    @Max(60)
    @NotBlank => NotNull & NotEmpty
     */
}
