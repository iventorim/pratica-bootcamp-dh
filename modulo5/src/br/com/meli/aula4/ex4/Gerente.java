package br.com.meli.aula4.ex4;

public class Gerente implements Funcionario{

    private final int CH_SEMANAL = 36;

    private double salarioBase = 6000;

    private double bonus = 0.125;

    private final int H_DESCANSO = 4;

    @Override
    public double pagarSalario() {
        return salarioBase + salarioBase * bonus;
    }
}
