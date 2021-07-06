package br.com.meli.linktracker.dto;

import br.com.meli.linktracker.domain.Link;

public class LinkEstatisticasDTO {

    private Integer quantidadeRedirecionamento;
    private boolean ativo;

    public LinkEstatisticasDTO(Integer quantidadeRedirecionamento, boolean ativo) {
        this.quantidadeRedirecionamento = quantidadeRedirecionamento;
        this.ativo = ativo;
    }

    public static LinkEstatisticasDTO convert(Link link) {
        return new LinkEstatisticasDTO(link.getContadorDeAcessos(), link.isEnabled());
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getQuantidadeRedirecionamento() {
        return quantidadeRedirecionamento;
    }

    public void setQuantidadeRedirecionamento(Integer quantidadeRedirecionamento) {
        this.quantidadeRedirecionamento = quantidadeRedirecionamento;
    }
}
