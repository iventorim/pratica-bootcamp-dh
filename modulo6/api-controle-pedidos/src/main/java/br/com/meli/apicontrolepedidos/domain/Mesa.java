package br.com.meli.apicontrolepedidos.domain;

import java.util.ArrayList;
import java.util.List;

public class Mesa {

    private Long id;
    private List<Pedido> pedidos;

    public Mesa(Integer id) {
        this.id = Long.valueOf(id);
        this.pedidos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Double getValorTotalConsumido() {
        if(this.pedidos.isEmpty()) {
            return 0.0;
        }else {
            return pedidos.stream().mapToDouble(Pedido::getValorTotal).sum();
        }
    }

    public void reinicializar() {
        pedidos.clear();
    }
}
