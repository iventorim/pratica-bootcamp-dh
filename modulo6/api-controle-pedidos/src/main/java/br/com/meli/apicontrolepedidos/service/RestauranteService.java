package br.com.meli.apicontrolepedidos.service;

import br.com.meli.apicontrolepedidos.domain.Mesa;
import br.com.meli.apicontrolepedidos.domain.Pedido;
import br.com.meli.apicontrolepedidos.domain.Prato;
import br.com.meli.apicontrolepedidos.dto.MesaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RestauranteService {

    private double caixa;
    private List<Mesa> mesas;

    public RestauranteService() {

        mesas = new ArrayList<>();
        int QTD_DE_MESAS = 20;
        for(int i = 1; i <= QTD_DE_MESAS; i++) {
            mesas.add(new Mesa(i));
        }
        caixa = 0.0;

        inicializaRestaurante();
    }

    public void inicializaRestaurante() {
        Prato prato1 = new Prato(1, 10.0, "Coxinha", 1);
        Prato prato2 = new Prato(2, 8.0, "Churrasco de boi", 1);
        Prato prato3 = new Prato(3, 7.0, "Churrasco de frango", 2);
        Prato prato4 = new Prato(4, 12.0, "Lasanha", 1);
        Prato prato5 = new Prato(5, 18.0, "Feijoada", 1);
        Prato prato6 = new Prato(6, 20.0, "Marmita", 2);

        Pedido pedido1 = new Pedido(1, mesas.get(0),List.of(prato1,prato2));
        Pedido pedido2 = new Pedido(2,mesas.get(1), List.of(prato3,prato4,prato5));
        Pedido pedido3 = new Pedido(3,mesas.get(2), List.of(prato3,prato4,prato5));
        Pedido pedido4 = new Pedido(4, mesas.get(0), List.of(prato5,prato6));

    }

    public MesaDTO obterInfoMesa(Long id) {
        Mesa mesa = mesas.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("Mesa não encontrada!"));
        return new MesaDTO(mesa);
    }

    public void fecharMesa(Long id) {
        Mesa mesa = mesas.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("Mesa não encontrada!"));

        caixa += mesa.getValorTotalConsumido();
        mesa.reinicializar();
    }

    public Double getValorCaixa(){
        return this.caixa;
    }
}
