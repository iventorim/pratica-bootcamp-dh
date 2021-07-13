package br.com.meli.linktracker.controller;

import br.com.meli.linktracker.service.LinkService;
import br.com.meli.linktracker.domain.Link;
import br.com.meli.linktracker.dto.LinkDTO;
import br.com.meli.linktracker.dto.LinkEstatisticasDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LinkController {

    final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("link")
    @ResponseStatus(HttpStatus.CREATED)
    public LinkDTO cadastrar(@RequestParam String url, @RequestParam Optional<String> senha) {

        if(senha.isEmpty()) {
            return linkService.cadastrarLink(url);
        }else {
            return linkService.cadastrarLink(url, senha.get());
        }
    }

    @PostMapping("invalidate/{linkID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void invalidar(@PathVariable UUID linkID) {
        linkService.invalidarLink(linkID);
    }

    @GetMapping("metrics/{linkID}")
    @ResponseStatus(HttpStatus.OK)
    public LinkEstatisticasDTO obterEstatisticas(@PathVariable UUID linkID) {
        return linkService.obterEstatisticas(linkID);
    }

    @GetMapping("link/{linkID}")
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public void redirect(@PathVariable UUID linkID,@RequestParam Optional<String> senha, HttpServletResponse response) throws IOException {

        Link link = linkService.obterLinkRedirect(linkID, senha);
        link.atualizarAcessos();
        response.sendRedirect(link.getUrl());
    }

    @GetMapping("links")
    public List<Link> getLinks() {
        return linkService.getLinks();
    }

}
