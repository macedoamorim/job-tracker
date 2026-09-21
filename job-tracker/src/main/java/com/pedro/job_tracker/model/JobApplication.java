package com.pedro.job_tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Audited;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Audited.Table(name = "tb_job_applications")

public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da empresa é obrigatório.")
    private String company;

    @NotBlank(message = "O cargo é obrigatório.")
    private String role;

    @NotBlank(message = "O status da candidatura é obrigatório.")
    private String status;
}