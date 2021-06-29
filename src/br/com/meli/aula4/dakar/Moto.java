package br.com.meli.aula4.dakar;

public class Moto extends Veiculo{

    public Moto(int velocidade, double aceleracao, double anguloDeGiro, String placa) {
        super(velocidade,aceleracao,anguloDeGiro,placa);
        this.peso = 300;
        this.rodas = 2;
    }
}
