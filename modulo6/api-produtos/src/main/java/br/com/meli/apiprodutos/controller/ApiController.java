package br.com.meli.apiprodutos.controller;

import br.com.meli.apiprodutos.domain.Produto;
import br.com.meli.apiprodutos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("produto")
public class ApiController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("{id}")
    public ResponseEntity<Produto> obterProduto(@PathVariable Long id) {
        Produto produto = produtoService.obterProdutoById(id);
        return new ResponseEntity<Produto>(produto, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<Produto>> listarProdutos() {

        List<Produto> produtos = produtoService.obterProdutos();
        return new ResponseEntity<List<Produto>>(produtos,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto, UriComponentsBuilder uriComponentsBuilder) {
        Produto p = produtoService.cadastrarProduto(produto);
        URI uri = uriComponentsBuilder.path("/produto/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto) {
        Produto p = produtoService.atualizarOuCriarProduto(produto);
        return new ResponseEntity<Produto>(p, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Produto> excluirProduto(@PathVariable Long id) {
        produtoService.removerProduto(id);
        return ResponseEntity.ok().build();
    }



}
