package br.com.meli.linktracker.dto;

import br.com.meli.linktracker.domain.Link;

public class LinkEstatisticasDTO {

    private Integer quantidadeRedirecionamento;

    public LinkEstatisticasDTO(Integer quantidadeRedirecionamento) {
        this.quantidadeRedirecionamento = quantidadeRedirecionamento;
    }

    public static LinkEstatisticasDTO convert(Link link) {
        return new LinkEstatisticasDTO(link.getContadorDeAcessos());
    }

    public Integer getQuantidadeRedirecionamento() {
        return quantidadeRedirecionamento;
    }

    public void setQuantidadeRedirecionamento(Integer quantidadeRedirecionamento) {
        this.quantidadeRedirecionamento = quantidadeRedirecionamento;
    }
}
