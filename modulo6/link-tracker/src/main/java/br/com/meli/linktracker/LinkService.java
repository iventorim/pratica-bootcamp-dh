package br.com.meli.linktracker;

import br.com.meli.linktracker.domain.Link;
import br.com.meli.linktracker.dto.LinkDTO;
import br.com.meli.linktracker.dto.LinkEstatisticasDTO;
import br.com.meli.linktracker.exception.UnauthorizedException;
import br.com.meli.linktracker.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Link obterLink(UUID id) {
        Link link = linkRepository.obterLink(id);
        if(link.getSenha().equals("")) {
            return link;
        }else {
            throw new UnauthorizedException("É necessário senha para acessar esse redirecionamento");
        }
    }

    public Link obterLink(UUID linkID, String senha) {

        Link link = linkRepository.obterLink(linkID);
        if(link.getSenha().equals(senha)) {
            return link;
        }else {
            throw new UnauthorizedException("Senha inválida");
        }
    }

    public List<Link> getLinks() {
        return linkRepository.getLinks();
    }
}
