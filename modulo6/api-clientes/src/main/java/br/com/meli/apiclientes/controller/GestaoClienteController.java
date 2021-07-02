package br.com.meli.apiclientes.controller;

import br.com.meli.apiclientes.domain.Pedido;
import br.com.meli.apiclientes.service.GestaoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("gestao-clientes")
public class GestaoClienteController {

    @Autowired
    GestaoClienteService gestaoClienteService;

    @GetMapping("pedidos/cliente/{id}")
    public ResponseEntity<List<Pedido>> obterPedidosCliente(@PathVariable Integer id) {
        List<Pedido> pedidosCliente = gestaoClienteService.getPedidosCliente(id);
        return new ResponseEntity<>(pedidosCliente, HttpStatus.OK);
    }

    @GetMapping("start")
    public void iniciar() {
        gestaoClienteService.inicializar();
    }

}
