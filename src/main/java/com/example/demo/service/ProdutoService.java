package com.example.demo.service;


import com.example.demo.models.ProdutoModel;
import com.example.demo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;

    public Optional<ProdutoModel> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public List<ProdutoModel> findAll() {
        return produtoRepository.findAll();
    }

    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoModel criarProduto(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }
}
