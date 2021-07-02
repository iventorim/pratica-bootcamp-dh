package br.com.meli.apiclientes.domain;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

    private Integer id;
    private List<Produto> produtos;
    private Cliente cliente;
    private LocalDate data;

    public Pedido(Integer id, List<Produto> produtos, Cliente cliente) {
        this.id = id;
        this.produtos = produtos;
        this.cliente = cliente;
        this.data = LocalDate.now();
        this.cliente.adicionarPedido(this);
    }

    public void atualizarPedido(Pedido pedido) {
        this.produtos = pedido.produtos;
        this.cliente = pedido.cliente;
        this.data = pedido.data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValorTotal() {
        return produtos.stream().mapToDouble(Produto::getValor).sum();
    }
}
