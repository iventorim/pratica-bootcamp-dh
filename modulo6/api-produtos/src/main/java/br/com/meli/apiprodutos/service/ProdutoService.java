package br.com.meli.apiprodutos.service;

import br.com.meli.apiprodutos.domain.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    List<Produto> produtos;

    ProdutoService() {
        this.produtos = new ArrayList<>();
    }

    public Produto obterProdutoById(Long id) {
        Optional<Produto> optionalProduto = produtos.stream().filter(produto -> produto.getId() == id).findFirst();
        if (optionalProduto.isPresent()) {
            return optionalProduto.get();
        } else {
            throw new RuntimeException("Produto não encontrado!");
        }
    }

    public Produto cadastrarProduto(Produto p) {
        p.setId(Produto.incrementarProduto());
        produtos.add(p);
        return p;
    }

    public Produto atualizarOuCriarProduto(Produto p) {
        try {
            Produto produtoCadastrado = this.obterProdutoById(p.getId());
            produtoCadastrado.setDescricao(p.getDescricao());
            produtoCadastrado.setNome(p.getNome());
            produtoCadastrado.setQtd(p.getQtd());
            produtoCadastrado.setValor(p.getValor());
            return produtoCadastrado;
        }catch (RuntimeException ex) {
            this.cadastrarProduto(p);
        }
        return p;
    }

    public void removerProduto(Long id) {
        Produto produtoCadastrado = this.obterProdutoById(id);
        produtos.remove(produtoCadastrado);
    }

    public List<Produto> obterProdutos() {
        return produtos;
    }
}
