package br.com.meli.apiprodutos.controller;

import br.com.meli.apiprodutos.domain.Produto;
import br.com.meli.apiprodutos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ApiController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("{id}")
    public Produto obterProduto(@PathVariable Long id) {
        return produtoService.obterProdutoById(id);
    }

    @GetMapping("all")
    public List<Produto> listarProdutos() {
        return produtoService.obterProdutos();
    }

    @PostMapping
    public Produto cadastrarProduto(@RequestBody Produto produto) {
        return produtoService.cadastrarProduto(produto);
    }

    @PutMapping
    public Produto atualizarProduto(@RequestBody Produto produto) {
        return produtoService.atualizarOuCriarProduto(produto);
    }

    @DeleteMapping("{id}")
    public void excluirProduto(@PathVariable Long id) {
        produtoService.removerProduto(id);
    }



}
