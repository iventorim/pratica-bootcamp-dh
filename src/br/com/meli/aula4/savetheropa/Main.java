package br.com.meli.aula4.savetheropa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        GuardaRoupa guardaRoupa = new GuardaRoupa();

        List<Vestuario> vestuarios = new ArrayList<>();
        vestuarios.add(new Vestuario("Adidas","Camisa regata"));
        vestuarios.add(new Vestuario("Adidas","Bermuda jogo preta"));
        vestuarios.add(new Vestuario("Nike","Tênis running"));
        vestuarios.add(new Vestuario("Invicta","Relógio Golden Era"));

        Integer id = guardaRoupa.guardarVestuarios(vestuarios);
        System.out.println(guardaRoupa.devolverVestuarios(id));


    }

}
