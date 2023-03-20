package com.example.projetobaseweb2.model.dto;

import com.example.projetobaseweb2.model.entity.CategoriaEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private Integer id;
    private String nome;
    private String descricao;

    public CategoriaDTO update(CategoriaEntity categoria){
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
        return this;
    }
}
