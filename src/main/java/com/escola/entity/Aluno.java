package com.escola.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "alunos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    
    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email;
    
    @NotBlank(message = "Matrícula é obrigatória")
    @Column(unique = true)
    private String matricula;
    
    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate dataNascimento;
    
    private String telefone;
    
    private String endereco;
    
    private Boolean ativo = true;
    
    @Column(name = "data_criacao")
    private LocalDate dataCriacao = LocalDate.now();

}
