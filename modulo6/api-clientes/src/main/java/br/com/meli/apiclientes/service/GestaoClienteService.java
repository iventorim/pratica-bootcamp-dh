package br.com.meli.apiclientes.service;

import br.com.meli.apiclientes.domain.Cliente;
import br.com.meli.apiclientes.domain.Pedido;
import br.com.meli.apiclientes.domain.Produto;
import br.com.meli.apiclientes.repository.ClienteRepository;
import br.com.meli.apiclientes.repository.PedidoRepository;
import br.com.meli.apiclientes.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GestaoClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ProdutoRepository produtoRepository;


    public void inicializar() {
        Cliente c1 = new Cliente(1, "José Mané", "111.111.111.21","zemane@gmail.com","(27) 3333-3333");
        Cliente c2 = new Cliente(2, "José Roela", "111.111.333.21","zeroela@gmail.com","(27) 4444-5555");

        clienteRepository.criar(c1);
        clienteRepository.criar(c2);

        Produto p1 = new Produto(1,"Camisa","Branca",1,25.00);
        Produto p2 = new Produto(2,"Tenis","Preto",1,250.00);

        produtoRepository.criar(p1);
        produtoRepository.criar(p2);

    }

    public List<Pedido> getPedidosCliente(Integer idCliente) {

        Cliente cliente = clienteRepository.ler(idCliente);
        return cliente.getPedidos();
    }
}
