package br.com.meli.apiclientes.domain;

public class Produto {

    private Integer id;
    private String descricao;
    private String cor;
    private Integer qtd;
    private Double preco;

    public Produto(Integer id, String descricao, String cor, Integer qtd, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.cor = cor;
        this.qtd = qtd;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getValor() {
        return this.qtd * this.preco;
    }
}
