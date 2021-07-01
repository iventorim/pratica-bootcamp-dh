package br.com.meli.apicontrolepedidos.domain;

import java.util.List;

public class Pedido {

    private Long id;
    private Mesa mesa;
    List<Prato> pratos;
    private Double valorTotal;

    public Pedido(Integer id, Mesa mesa, List<Prato> pratos) {
        this.id = Long.valueOf(id);
        this.mesa = mesa;
        this.pratos = pratos;
        mesa.adicionarPedido(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public Double getValorTotal() {
        return pratos.stream().mapToDouble(Prato::getPrecoTotal).sum();
    }

}
