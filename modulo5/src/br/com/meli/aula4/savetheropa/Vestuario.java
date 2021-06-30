package br.com.meli.aula4.savetheropa;

public class Vestuario {

    private String marca;

    private String modelo;

    public Vestuario(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "marca: " + marca +", modelo: " + modelo;
    }
}
