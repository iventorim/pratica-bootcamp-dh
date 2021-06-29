package br.com.meli.aula4.ex4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Analista());
        funcionarios.add(new Analista());
        funcionarios.add(new Analista());
        funcionarios.add(new Analista());
        funcionarios.add(new Tecnico());
        funcionarios.add(new Tecnico());
        funcionarios.add(new Tecnico());
        funcionarios.add(new Tecnico());
        funcionarios.add(new Gerente());
        funcionarios.add(new Gerente());
        funcionarios.add(new Diretor());

        funcionarios.forEach( f -> System.out.println(f.pagarSalario()));

    }

}
