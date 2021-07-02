package br.com.meli.apiclientes.repository;

import br.com.meli.apiclientes.domain.Cliente;
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
public class PedidoRepository {

    @Autowired
    ObjectMapper objectMapper;

    private final String PATH_DB = "src/main/resources/pedidos.json";


    public List<Pedido> lerPedidos() {
        List<Pedido> pedidos = null;
        Path filePath = Paths.get(PATH_DB);

        if(Files.exists(filePath)) {
            try{
                List<String> file = Files.lines(filePath).collect(Collectors.toList());
                String pedidosJSON = String.join("",file);
                TypeReference<List<Pedido>> typeReference = new TypeReference<List<Pedido>>() {};
                pedidos = objectMapper.readValue(pedidosJSON,typeReference);
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao ler produto no banco",ex.getCause());
            }
        }else {
            pedidos = new ArrayList<>();
        }

        return pedidos;
    }

    public void criar(Pedido pedido) {
        List<Pedido> pedidos = this.lerPedidos();
        pedidos.add(pedido);
        this.gravar(pedidos);
    }

    private void gravar(List<Pedido> pedidos) {
        Path filePath = Paths.get(PATH_DB);
        try{
            String pedidosJSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pedidos);
            Files.write(filePath,pedidosJSON.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao gravar produtos no banco",ex.getCause());
        }
    }

    public Pedido ler(Integer id) {
        List<Pedido> pedidos = this.lerPedidos();
        return pedidos.stream()
                .filter(pedido -> pedido.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Produto não encontrado"));
    }

    public void atualizar(Pedido pedido) {
        List<Pedido> pedidos = this.lerPedidos();
        Pedido pedidoSalvo = pedidos.stream()
                .filter(p -> p.getId().equals(pedido.getId()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Produto não encontrado"));
        pedidoSalvo.atualizarPedido(pedido);
        this.gravar(pedidos);
    }

    public void remover(Pedido pedido) {
        List<Pedido> pedidos = this.lerPedidos();
        pedidos.remove(pedido);
        this.gravar(pedidos);
    }

}
