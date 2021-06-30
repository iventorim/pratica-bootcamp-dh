package br.com.meli.aula4.ex5;

public class Celular implements Precedente<Celular>{

    private String holder;
    private String number;

    public Celular(String holder, String number) {
        this.holder = holder;
        this.number = number;
    }

    @Override
    public int precedeA(Celular celular) {
        return this.number.compareToIgnoreCase(celular.number);
    }

    @Override
    public Celular getTipo() {
        return this;
    }

    public String getHolder() {
        return holder;
    }

    public String getNumber() {
        return number;
    }
}
