package com.example.projetobaseweb2.repository;

import com.example.projetobaseweb2.model.dto.CategoriaDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDBMemory {
    private List<CategoriaDTO> lista = new ArrayList<>();
    private Integer contador = 1;
    public List<CategoriaDTO> listar(){
        return lista;
    }
    public CategoriaDTO pegarPorId(Integer id){
        for(CategoriaDTO categoria : lista){
            if(categoria.getId().equals(id)) return categoria;
        }
        return null;
    }

    public CategoriaDTO criar(CategoriaDTO categoriaDTO){
        categoriaDTO.setId(contador);
        lista.add(categoriaDTO);
        contador++;

        return categoriaDTO;
    }
    public CategoriaDTO editar(CategoriaDTO categoria){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getId().equals(categoria.getId())){
                lista.set(i, categoria);
            }
        }
        return categoria;
    }

    public String deletar(Integer id){
        int contador = 0;

        for(CategoriaDTO categoriaDTO : lista){
            if(categoriaDTO.getId().equals(id)){
                lista.remove(contador);
                return "Categoria com id " + id + " deletado com sucessp!";
            }
            contador++;
        }

        return "ID: " + id + " não encontrado!";
    }
}
