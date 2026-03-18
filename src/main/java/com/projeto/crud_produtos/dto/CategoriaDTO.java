package com.projeto.crud_produtos.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoriaDTO {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    //Getters and Setters
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
