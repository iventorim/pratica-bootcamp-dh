package br.com.meli.aula4.lachiqui;

import java.util.ArrayList;
import java.util.List;

public class EventoLaChiqui {

    private List<Convidado> listaDeConvidados = new ArrayList<>();
    private List<FogosDeArtificio> listaDeFogosDeArtificio = new ArrayList<>();

    public void apagarVelasDoBolo() {
        listaDeFogosDeArtificio.forEach(f -> f.explodir());
        listaDeConvidados.forEach( c -> c.gritar());
    }

    public void adicionarConvidado(Convidado convidado) {
        listaDeConvidados.add(convidado);
    }

    public void adicionarFogosDeArtificio(FogosDeArtificio fogosDeArtificio) {
        listaDeFogosDeArtificio.add(fogosDeArtificio);
    }

    public static void main(String[] args) {
        EventoLaChiqui evento = new EventoLaChiqui();
        evento.adicionarConvidado(new ConvidadoMeli());
        evento.adicionarConvidado(new ConvidadoStandard());
        evento.adicionarConvidado(new ConvidadoStandard());
        evento.adicionarConvidado(new ConvidadoStandard());
        evento.adicionarConvidado(new ConvidadoMeli());
        evento.adicionarConvidado(new ConvidadoMeli());
        evento.adicionarConvidado(new ConvidadoStandard());
        evento.adicionarConvidado(new ConvidadoStandard());

        PacoteDeFogosDeArtificio pack = new PacoteDeFogosDeArtificio();
        pack.adicionarFogosDeArtificio(new FogosDeArtificioIndividual());
        pack.adicionarFogosDeArtificio(new PacoteDeFogosDeArtificio());

        evento.adicionarFogosDeArtificio(new FogosDeArtificioIndividual());
        evento.adicionarFogosDeArtificio(new FogosDeArtificioIndividual());
        evento.adicionarFogosDeArtificio(new FogosDeArtificioIndividual());
        evento.adicionarFogosDeArtificio(new FogosDeArtificioIndividual());
        evento.adicionarFogosDeArtificio(pack);

        evento.apagarVelasDoBolo();

    }

}
