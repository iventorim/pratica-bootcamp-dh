package br.com.meli.aula4.dakar;

public abstract class Veiculo implements Comparable<Veiculo>{

    int velocidade;

    double aceleracao;

    double anguloDeGiro;

    String placa;

    double peso;

    int rodas;

    public Veiculo() {}

    public Veiculo(int velocidade, double aceleracao, double anguloDeGiro, String placa) {
        this.velocidade = velocidade;
        this.aceleracao = aceleracao;
        this.anguloDeGiro = anguloDeGiro;
        this.placa = placa;
    }

    @Override
    public int compareTo(Veiculo o) {
        return this.placa.compareToIgnoreCase(o.placa);
    }

    public double obterValorCorrida() {
        return (this.velocidade * this.aceleracao) / (this.anguloDeGiro *(this.peso - this.rodas * 100));
    }
}
