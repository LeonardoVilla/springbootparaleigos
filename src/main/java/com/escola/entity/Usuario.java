package com.escola.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Usuário é obrigatório")
    @Column(unique = true)
    private String username;
    
    @NotBlank(message = "Senha é obrigatória")
    private String senha;
    
    @Email(message = "Email inválido")
    private String email;
    
    private Boolean ativo = true;

}
