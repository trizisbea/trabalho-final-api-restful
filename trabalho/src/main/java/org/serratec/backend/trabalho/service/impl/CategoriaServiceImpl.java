package org.serratec.backend.trabalho.service.impl;

import java.util.List;

import java.util.Optional;

import org.serratec.backend.trabalho.domain.Categoria;
import org.serratec.backend.trabalho.repository.CategoriaRepository;
import org.serratec.backend.trabalho.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> pesquisarTodos() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> pesquisarUm(Long idCategoria) {
        return categoriaRepository.findById(idCategoria);
    }

    @Override
    public Categoria inserir(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public boolean idExiste(Long idCategoria) {
        return categoriaRepository.existsById(idCategoria);
    }

    @Override
    public void remover(Long idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }

    @Override
    public Categoria editar(Categoria categoria) {
        return categoriaRepository.save(categoria);
   }
 
}
