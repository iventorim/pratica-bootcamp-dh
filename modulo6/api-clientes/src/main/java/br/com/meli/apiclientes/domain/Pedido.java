package br.com.meli.apiclientes.domain;

import java.util.List;

public class Pedido {

    private Integer id;
    private List<Produto> produtos;
    private Cliente cliente;

    public Pedido(Integer id, List<Produto> produtos, Cliente cliente) {
        this.id = id;
        this.produtos = produtos;
        this.cliente = cliente;

        this.cliente.adicionarPedido(this);
    }

    public Double getValorTotal() {
        return produtos.stream().mapToDouble(Produto::getValor).sum();
    }
}
