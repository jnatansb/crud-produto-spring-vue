package com.projeto.crud_produtos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok. *;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
    public class Categoria {
        @Id
        @GeneratedValue
        private Long id;

        @NotBlank(message = "Nome é obrigatório")
        @Column(unique = true, nullable = false)
        private String nome;
    }

