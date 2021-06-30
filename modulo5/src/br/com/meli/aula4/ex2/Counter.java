package br.com.meli.aula4.ex2;

public class Counter {

    private Integer valor;



    public Counter() {
    }

    public Counter(Counter counter) {
        this.valor = counter.getValor();
    }

    public Counter(Integer valor) {
        this.valor = valor;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public void incrementar() {
        this.valor++;
    }

    public void decrementar() {
        this.valor--;
    }
}
