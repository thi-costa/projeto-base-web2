package com.example.projetobaseweb2.controller;

import com.example.projetobaseweb2.model.dto.CategoriaDTO;
import com.example.projetobaseweb2.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDTO> listar(){
        return categoriaService.listar();
    }
    @GetMapping("/{id}")
    public CategoriaDTO pegarCategoriaDTOById(@PathVariable("id") Integer id){
        return categoriaService.pegarCategoriaDTOById(id);
    }

    @PostMapping
    public CategoriaDTO criar(@RequestBody CategoriaDTO categoriaDTO){
        return categoriaService.criar(categoriaDTO);
    }

    @PutMapping("/{id}")
    public CategoriaDTO editar(
            @RequestBody CategoriaDTO categoriaDTO,
            @PathVariable("id") Integer id){
        return categoriaService.editar(categoriaDTO, id);
    }
    @DeleteMapping("/{id}")
    public String deletar(
            @PathVariable("id") Integer id){
        categoriaService.deletar(id);
        return  "Categoria com id " + id + " removido com sucesso!";
    }

}
