package br.com.meli.linktracker.repository;

import br.com.meli.linktracker.domain.Link;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class LinkRepository {

    public final Map<UUID, Link> map;

    public LinkRepository() {
        this.map = new HashMap<>();
    }

    public UUID adicionarLink(Link link) {
        UUID id = UUID.randomUUID();
        map.put(id, link);
        return id;
    }

    public Link obterLink(UUID uuid) {

        if(map.containsKey(uuid))  {
            Link link = map.get(uuid);
            if(link.isEnabled()) {
                return link;
            }else{
                throw new NoSuchElementException("Este link não se encontra válido");
            }
        }else {
            throw new NoSuchElementException("Link não encontrado");
        }
    }

    public void invalidarLink(UUID uuid) {
        Link link = this.obterLink(uuid);
        link.setEnabled(false);
    }

    public List<Link> getLinks() {
        return new ArrayList<>(map.values());
    }
}
