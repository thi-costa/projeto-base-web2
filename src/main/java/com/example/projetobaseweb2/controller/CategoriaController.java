package com.example.projetobaseweb2.controller;

import com.example.projetobaseweb2.model.Categoria;
import com.example.projetobaseweb2.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar(){
        return categoriaService.buscarTodos();
    }
    @GetMapping("/{id}")
    public Categoria pegarUm(@PathVariable("id") Integer id){
        return categoriaService.pegarUm(id);
    }

    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria){
        return categoriaService.criar(categoria);
    }

    @PutMapping("/{id}")
    public Categoria editar(
            @RequestBody Categoria categoria,
            @PathVariable("id") Integer id){
        return categoriaService.editar(categoria, id);
    }
    @DeleteMapping("/{id}")
    public String deletar(
            @PathVariable("id") Integer id){
        categoriaService.deletar(id);
        return  "Categoria com id " + id + " removido com sucesso!";
    }

}
