package br.com.meli.apiclientes.controller;

import br.com.meli.apiclientes.domain.Pedido;
import br.com.meli.apiclientes.service.GestaoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

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

    @GetMapping("pedido/{id}")
    public ResponseEntity<Pedido> obterPedido(@PathVariable Integer id) {
        Pedido pedido = gestaoClienteService.getPedido(id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @DeleteMapping("pedido/{id}")
    public ResponseEntity<Pedido> deletarPedido(@PathVariable Integer id) {
        gestaoClienteService.removerPedido(id);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("pedido")
    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody Pedido pedido,
                                                  UriComponentsBuilder uriComponentsBuilder) {
        gestaoClienteService.cadastrarPedido(pedido);
        URI uri = uriComponentsBuilder.path("/gestao-clientes/pedido/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("pedido")
    public ResponseEntity<Pedido> atualizarPedido(@RequestBody Pedido pedido,
                                                  UriComponentsBuilder uriComponentsBuilder) {

        Pedido pedidoFound = gestaoClienteService.getPedido(pedido.getId());

        if(Objects.nonNull(pedidoFound)) {
            gestaoClienteService.atualizarPedido(pedido);
            return ResponseEntity.ok().build();
        }else {
            gestaoClienteService.cadastrarPedido(pedido);
            URI uri = uriComponentsBuilder.path("/gestao-clientes/pedido/{id}").buildAndExpand(pedido.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
    }

    @GetMapping("pedido/data/{day}/{month}/{year}")
    public ResponseEntity<List<Pedido>> obterPedidosPorDia(@PathVariable int day,
                                                           @PathVariable int month,
                                                           @PathVariable int year) {
        List<Pedido> pedidos = gestaoClienteService.obterPedidosPorData(day, month, year);
        return ResponseEntity.ok(pedidos);
    }


}
