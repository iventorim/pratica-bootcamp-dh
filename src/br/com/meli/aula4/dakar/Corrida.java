package br.com.meli.aula4.dakar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Corrida {

    private double distancia;

    private double premioEmDolares;

    private String nome;

    private int quantidadeVeiculosPermitidos;

    private List<Veiculo> listaVeiculos;

    private SocorristaCarro socorristaCarro;

    private SocorristaMoto socorristaMoto;

    public Corrida(double distancia, double premioEmDolares, String nome, int quantidadeVeiculosPermitidos) {
        this.distancia = distancia;
        this.premioEmDolares = premioEmDolares;
        this.nome = nome;
        this.quantidadeVeiculosPermitidos = quantidadeVeiculosPermitidos;
        this.listaVeiculos = new ArrayList<>();
    }

    public double getDistancia() {
        return distancia;
    }

    public double getPremioEmDolares() {
        return premioEmDolares;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeVeiculosPermitidos() {
        return quantidadeVeiculosPermitidos;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public void registrarCarro(int velocidade, double aceleracao, double anguloDeGiro, String placa ) {
        if(listaVeiculos.size() < quantidadeVeiculosPermitidos) {
            Carro carro = new Carro(velocidade, aceleracao, anguloDeGiro, placa);
            this.listaVeiculos.add(carro);
        }
    }

    public void registrarMoto(int velocidade, double aceleracao, double anguloDeGiro, String placa) {
        if(listaVeiculos.size() < quantidadeVeiculosPermitidos) {
            Moto moto = new Moto(velocidade, aceleracao, anguloDeGiro, placa);
            this.listaVeiculos.add(moto);
        }
    }

    public void removerVeiculo(Veiculo veiculo) {
        listaVeiculos.remove(veiculo);
    }

    public void removerVeiculoPorPlaca(String placa) {
        Optional<Veiculo> veiculo = listaVeiculos.stream().filter(v -> v.placa.equals(placa)).findAny();
        veiculo.ifPresent(v -> listaVeiculos.remove(v));
    }

    public Veiculo obterVencendor() {

        Optional<Veiculo> vencedor = listaVeiculos.stream().max(Comparator.comparing(Veiculo::obterValorCorrida));
        if(vencedor.isPresent()) {
            return vencedor.get();
        }
        throw new RuntimeException("Nenhum vencendor foi encontrado!");
    }

    public void adicionarSocorrista(SocorristaCarro socorristaCarro) {
        this.socorristaCarro = socorristaCarro;
    }

    public void adicionarSocorrista(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public void socorrerCarro(String placa) {
        Optional<Veiculo> veiculo = listaVeiculos.stream().filter(v -> v.placa.equals(placa)).findFirst();
        veiculo.ifPresent(v -> {
            socorristaCarro.socorrer((Carro)v);
        });
    }

    public void socorrerMoto(String placa) {
        Optional<Veiculo> veiculo = listaVeiculos.stream().filter(v -> v.placa.equals(placa)).findFirst();
        veiculo.ifPresent(v -> {
            socorristaMoto.socorrer((Moto)v);
        });
    }
}
