package br.com.meli.apicontrolepedidos.domain;

public class Prato {

    private Long id;
    private Double preco;
    private String descricao;
    private int qtd;

    public Prato(Integer id, Double preco, String descricao, int qtd) {
        this.id = Long.valueOf(id);
        this.preco = preco;
        this.descricao = descricao;
        this.qtd = qtd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Double getPrecoTotal() {
        return this.getQtd() * this.getPreco();
    }
}
