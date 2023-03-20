package com.example.projetobaseweb2.repository;

import com.example.projetobaseweb2.model.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDBMemory {
    private List<Categoria> lista = new ArrayList<>();
    private Integer contador = 1;
    public List<Categoria> buscarTodos(){
        return lista;
    }
    public Categoria pegarUm(Integer id){
        for(Categoria categoria: lista){
            if(categoria.getId().equals(id)) return categoria;
        }
        return null;
    }

    public Categoria criar(Categoria categoria){
        categoria.setId(contador);
        lista.add(categoria);
        contador++;

        return categoria;
    }
    public Categoria editar(Categoria categoria){
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getId().equals(categoria.getId())){
                lista.set(i, categoria);
            }
        }
        return categoria;
    }

    public String deletar(Integer id){
        int contador = 0;

        for(Categoria categoria: lista){
            if(categoria.getId().equals(id)){
                lista.remove(contador);
                return "Categoria com id " + id + " deletado com sucessp!";
            }
            contador++;
        }

        return "ID: " + id + " não encontrado!";
    }
}
