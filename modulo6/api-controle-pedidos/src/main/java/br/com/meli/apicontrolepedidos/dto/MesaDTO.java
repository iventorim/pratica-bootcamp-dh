package br.com.meli.apicontrolepedidos.dto;

import br.com.meli.apicontrolepedidos.domain.Mesa;
import br.com.meli.apicontrolepedidos.domain.Pedido;

import java.util.List;

public class MesaDTO {

    private Mesa mesa;

    public MesaDTO(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Pedido> getPedidos() {
        return mesa.getPedidos();
    }

    public Double getValorTotalConsumido() {
        return mesa.getValorTotalConsumido();
    }
}
