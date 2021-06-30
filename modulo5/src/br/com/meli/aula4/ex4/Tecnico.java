package br.com.meli.aula4.ex4;

public class Tecnico implements Funcionario {

    private final int CH_SEMANAL = 40;

    private double salarioBase = 3200;

    private double bonus = 0.05;

    private final int H_DESCANSO = 0;

    @Override
    public double pagarSalario() {
        return salarioBase + salarioBase*bonus;
    }
}
