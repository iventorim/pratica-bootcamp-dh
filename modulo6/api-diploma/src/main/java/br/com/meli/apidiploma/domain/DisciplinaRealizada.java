package br.com.meli.apidiploma.domain;

public class DisciplinaRealizada {

    private String nome;

    private Double nota;

    public DisciplinaRealizada(String nome, Double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
