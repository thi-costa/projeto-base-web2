package com.example.projetobaseweb2.service;

import com.example.projetobaseweb2.model.Categoria;
import com.example.projetobaseweb2.repository.CategoriaDBMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private CategoriaDBMemory repository = new CategoriaDBMemory();
    public Categoria pegarUm(Integer id){
        return repository.pegarUm(id);
    }
    public List<Categoria> buscarTodos(){
        return repository.buscarTodos();
    }

    public Categoria criar(Categoria categoria){
        return repository.criar(categoria);
    }
    public Categoria editar(Categoria categoria, Integer id){
        Categoria categoriaFromDB = repository.pegarUm(id);
        if(categoriaFromDB == null) return null;

        Categoria categoriaAtualizada = categoriaFromDB.update(categoria);

        return repository.editar(categoriaAtualizada);
    }
    public void deletar(Integer id){
        repository.deletar(id);
    }
}
