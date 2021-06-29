package br.com.meli.aula4.ex4;

public class Analista implements Funcionario {

    private final int CH_SEMANAL = 40;

    private double salarioBase = 4000;

    private double bonus = 0.08;

    private final int H_DESCANSO = 4;

    @Override
    public double pagarSalario() {
        return salarioBase + salarioBase*bonus;
    }
}
