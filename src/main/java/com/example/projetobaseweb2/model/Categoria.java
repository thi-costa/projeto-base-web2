package com.example.projetobaseweb2.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    private Integer id;
    private String nome;
    private String descricao;

    public Categoria update(Categoria categoria){
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
        return this;
    }
}
