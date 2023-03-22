package com.example.projetobaseweb2.model.entity;

import com.example.projetobaseweb2.model.dto.CategoriaDTO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome", nullable = false, unique = true)
    private String nome;
    @Column(name = "descricao")
    private String descricao;
}
