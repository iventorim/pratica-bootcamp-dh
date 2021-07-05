package br.com.meli.linktracker.dto;

import br.com.meli.linktracker.domain.Link;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class LinkFullDTO {

    private Link link;

    public LinkFullDTO(Link link) {
        this.link = link;
    }

    public static LinkFullDTO convert(Link link){
        return new LinkFullDTO(link);
    }

    public static List<LinkFullDTO> convert(List<Link> links){
        return links.stream().map(LinkFullDTO::convert).collect(Collectors.toList());
    }

    public boolean isEnabled() {
        return link.isEnabled();
    }

    public int getContadorAcessos() {
        return link.getContadorDeAcessos();
    }

    public String getUrl() {
        return link.getUrl();
    }



}
