package br.com.meli.apiclientes.repository;

import br.com.meli.apiclientes.domain.Cliente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Repository
public class ClienteRepository {

    @Autowired
    ObjectMapper objectMapper;

    private final String PATH_DB = "src/main/resources/clientes.json";

    public List<Cliente> lerClientes() {
        List<Cliente> clientes = null;
        Path filePath = Paths.get(PATH_DB);

        if(Files.exists(filePath)) {
            try{
                List<String> file = Files.lines(filePath).collect(Collectors.toList());
                String clientesJSON = String.join("",file);
                TypeReference<List<Cliente>> typeReference = new TypeReference<List<Cliente>>() {};
                clientes = objectMapper.readValue(clientesJSON,typeReference);
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao ler produto no banco",ex.getCause());
            }
        }else {
            clientes = new ArrayList<>();
        }

        return clientes;
    }

    public void criar(Cliente cliente) {
        List<Cliente> clientes = this.lerClientes();
        clientes.add(cliente);
        this.gravar(clientes);
    }

    private void gravar(List<Cliente> clientes) {
        Path filePath = Paths.get(PATH_DB);
        try{
            String clientesJSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clientes);
            Files.write(filePath,clientesJSON.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao gravar clientes no banco",ex.getCause());
        }
    }

    public Cliente ler(Integer id) {
        List<Cliente> cliente = this.lerClientes();
        return cliente.stream()
                .filter(pedido -> pedido.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
    }

    public void atualizar(Cliente cliente) {
        List<Cliente> clientes = this.lerClientes();
        Cliente clienteSalvo = clientes.stream()
                .filter(p -> p.getId().equals(cliente.getId()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
        clienteSalvo.atualizarPedido(cliente);
        this.gravar(clientes);
    }

    public void remover(Cliente cliente) {
        List<Cliente> clientes = this.lerClientes();
        clientes.remove(cliente);
        this.gravar(clientes);
    }

}
