package com.example.projetobaseweb2.controller;

import com.example.projetobaseweb2.model.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private List<Categoria> lista = new ArrayList<>();
    private Integer contador = 1;

    @GetMapping
    public List<Categoria> listar(){
        return lista;
    }
    @GetMapping("/{id}")
    public Categoria buscarCategoriaPorId(@PathVariable("id") Integer id){
        for(Categoria categoria: lista){
            if(categoria.getId().equals(id)) return categoria;
        }
        return null;
    }

    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria){
        categoria.setId(contador);
        lista.add(categoria);
        contador++;

        return categoria;
    }

    @PutMapping("/{id}")
    public Categoria editar(
            @RequestBody Categoria categoria,
            @PathVariable("id") Integer id){
        categoria.setId(id);
        for(Categoria item: lista){
            if(item.getId().equals(id)){
                item.setNome(categoria.getNome());
                item.setDescricao(categoria.getDescricao());

                return categoria;
            }
        }
        return null;

    }
    @DeleteMapping("/{id}")
    public String editar(
            @PathVariable("id") Integer id){
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
