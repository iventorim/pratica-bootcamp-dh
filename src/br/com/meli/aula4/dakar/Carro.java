package br.com.meli.aula4.dakar;

public class Carro extends Veiculo{

    public Carro(int velocidade, double aceleracao, double anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa);
        this.peso = 1000;
        this.rodas = 4;
    }
}
