package br.com.meli.apidiploma.domain;

public class Diploma {

    private Long id;
    private String nome;
    private Double nota;
    private String mensagem;

    public Diploma(Long id, String nome, Double media, String mensagem) {
        this.id = id;
        this.nome = nome;
        this.nota = media;
        this.mensagem = mensagem;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
