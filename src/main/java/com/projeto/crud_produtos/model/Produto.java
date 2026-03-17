package com.projeto.crud_produtos.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok. *;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Positive(message = "Preço deve ser maior que zero")
    private Double preco;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Categoria categoria;
}
