package com.example.projetobaseweb2.model.dto;

import com.example.projetobaseweb2.model.entity.CategoriaEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;

@Data
public class CategoriaDTO {
    private Integer id;
    @Size(max=80, message = "Tamanho do nome acima do permitido (máximo de 80 caracteres)")
    @NotBlank(message = "Nome deve conter algum valor")
    private String nome;
    private String descricao;
}
