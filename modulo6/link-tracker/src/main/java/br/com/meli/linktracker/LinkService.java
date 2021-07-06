package br.com.meli.linktracker;

import br.com.meli.linktracker.domain.Link;
import br.com.meli.linktracker.dto.LinkDTO;
import br.com.meli.linktracker.dto.LinkEstatisticasDTO;
import br.com.meli.linktracker.exception.UnauthorizedException;
import br.com.meli.linktracker.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class LinkService {

    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public LinkDTO cadastrarLink(String url) {
       Link link = new Link(url);
       return LinkDTO.convert(linkRepository.adicionarLink(link)) ;
    }

    public LinkDTO cadastrarLink(String url, String senha) {
        Link link = new Link(url, senha);
        return LinkDTO.convert(linkRepository.adicionarLink(link)) ;
    }

    public void invalidarLink(UUID id) {
        linkRepository.invalidarLink(id);
    }

    public LinkEstatisticasDTO obterEstatisticas(UUID id) {
       return LinkEstatisticasDTO.convert(linkRepository.obterLink(id));
    }

    private Link obterLink(UUID linkID, Optional<String> senha) {

        Link link = linkRepository.obterLink(linkID);
        if(link.isPrivate() && !link.isValidPassword(senha)){
            throw new UnauthorizedException("A senha não foi informada ou é invalida.");
        }

        return link;
    }

    public Link obterLinkRedirect(UUID linkID, Optional<String> senha) {
        Link link = this.obterLink(linkID, senha);
        if(link.isEnabled()) {
            return link;
        }else{
            throw new NoSuchElementException("Este link não se encontra ativo");
        }
    }

    public List<Link> getLinks() {
        return linkRepository.getLinks();
    }
}
