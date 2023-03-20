package com.example.projetobaseweb2.service;

import com.example.projetobaseweb2.model.dto.CategoriaDTO;
import com.example.projetobaseweb2.model.entity.CategoriaEntity;
import com.example.projetobaseweb2.repository.CategoriaDBMemory;
import com.example.projetobaseweb2.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;
    public CategoriaDTO pegarCategoriaDTOById(Integer id){
        Optional<CategoriaEntity> categoriaEntityOp = repository.findById(id);

        if(categoriaEntityOp.isPresent()){
            CategoriaEntity categoriaEntity = categoriaEntityOp.get();
            return new CategoriaDTO().update(categoriaEntity);

        }

        throw new EntityNotFoundException();
    }
    public List<CategoriaDTO> listar(){
        List<CategoriaEntity> listaEntities = repository.findAll();
        return listaEntities.stream()
                .map(categoriaEntity -> new CategoriaDTO().update(categoriaEntity))
                .toList();
    }

    public CategoriaDTO criar(CategoriaDTO categoriaDTO){
        CategoriaEntity categoria = new CategoriaEntity().update(categoriaDTO);
        categoria = repository.save(categoria);

        return new CategoriaDTO().update(categoria);
    }
    public CategoriaDTO editar(CategoriaDTO categoria, Integer id){
        Optional<CategoriaEntity> categoriaEntityOp = repository.findById(id);

        if(categoriaEntityOp.isPresent()){
            CategoriaEntity categoriaEntity = categoriaEntityOp.get();
            return new CategoriaDTO().update(categoriaEntity);

        }

        throw new EntityNotFoundException();
    }
    public void deletar(Integer id){
        Optional<CategoriaEntity> categoriaEntityOp = repository.findById(id);

        categoriaEntityOp.ifPresent(categoriaEntity -> repository.delete(categoriaEntity));

        throw new EntityNotFoundException();
    }
}
