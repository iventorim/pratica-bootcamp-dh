package br.com.meli.apiprodutos.domain;


public class Produto {

    private static Long count = Long.valueOf(0);

    private Long id;

    private String nome;

    private String descricao;

    private Integer qtd;

    private Double valor;

    public Produto(String nome, String descricao, Integer qtd, Double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.qtd = qtd;
        this.valor = valor;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public static Long incrementarProduto(){
        return ++count;
    }
}
