package br.com.meli.apiclientes.service;

import br.com.meli.apiclientes.domain.Cliente;
import br.com.meli.apiclientes.domain.Pedido;
import br.com.meli.apiclientes.domain.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GestaoClienteService {

    List<Cliente> clientes;

    public GestaoClienteService() {

        clientes = new ArrayList<>();
        inicializar();
    }

    public void inicializar() {
        Cliente c1 = new Cliente(1, "José Mané", "111.111.111.21","zemane@gmail.com","(27) 3333-3333");
        Cliente c2 = new Cliente(2, "José Roela", "111.111.333.21","zeroela@gmail.com","(27) 4444-5555");
        clientes.add(c1);
        clientes.add(c2);

        Produto p1 = new Produto(1,"Camisa","Branca",1,25.00);
        Produto p2 = new Produto(2,"Tenis","Preto",1,250.00);
    }

    public List<Pedido> getPedidosCliente(Integer idCliente) {

        Cliente clienteRegistrado = clientes.stream()
                .filter(cliente -> cliente.getId().equals(idCliente))
                .findFirst()
                .orElseThrow(()-> new NoSuchElementException("Cliente não encontrado"));

        return clienteRegistrado.getPedidos();
    }
}
