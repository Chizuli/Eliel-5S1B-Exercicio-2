package com.example.demo.controller;


import com.example.demo.models.ProdutoModel;
import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoModel> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> findById(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        produtoService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> criarLivro(@RequestBody ProdutoModel produtoModel){
        ProdutoModel requeste = produtoService.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(produtoModel.getId()).toUri();
        return  ResponseEntity.created(uri).body(requeste);
    }



}
