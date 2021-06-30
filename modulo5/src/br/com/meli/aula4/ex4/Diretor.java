package br.com.meli.aula4.ex4;

public class Diretor implements Funcionario {

    private final int CH_SEMANAL = 0;

    private double salarioBase = 15000;

    private double bonus = 0.0;

    private final int H_DESCANSO = 0;

    @Override
    public double pagarSalario() {
        return salarioBase + salarioBase * bonus;
    }
}
