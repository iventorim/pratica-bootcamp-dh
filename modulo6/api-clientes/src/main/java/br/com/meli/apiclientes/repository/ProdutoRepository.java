package br.com.meli.apiclientes.repository;

import br.com.meli.apiclientes.domain.Pedido;
import br.com.meli.apiclientes.domain.Produto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepository {

    @Autowired
    ObjectMapper objectMapper;

    private final String PATH_DB = "src/main/resources/produtos.json";

    public List<Produto> lerProdutos() {
        List<Produto> produtos = null;
        Path filePath = Paths.get(PATH_DB);

        if(Files.exists(filePath)) {
            try{
                List<String> file = Files.lines(filePath).collect(Collectors.toList());
                String produtosJson = String.join("",file);
                TypeReference<List<Produto>> typeReference = new TypeReference<List<Produto>>() {};
                produtos = objectMapper.readValue(produtosJson,typeReference);
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao ler produto no banco",ex.getCause());
            }
        }else {
            produtos = new ArrayList<>();
        }

        return produtos;
    }

    public void criar(Produto produto) {
        List<Produto> produtos = this.lerProdutos();
        produtos.add(produto);
        this.gravar(produtos);
    }

    private void gravar(List<Produto> produtos) {
        Path filePath = Paths.get(PATH_DB);
        try{
            String produtosJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(produtos);
            Files.write(filePath,produtosJson.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao gravar produtos no banco",ex.getCause());
        }
    }

    public Produto ler(Integer id) {
        List<Produto> produtos = this.lerProdutos();
        return produtos.stream()
                .filter(produto -> produto.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Produto não encontrado"));
    }

    public void atualizar(Integer id, Produto produto) {
        //TODO IMPLEMENTAR

    }

    public void remover(Produto produto) {
        List<Produto> produtos = this.lerProdutos();
        produtos.remove(produto);
        this.gravar(produtos);
    }


}
