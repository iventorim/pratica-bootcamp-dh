package br.com.meli.aula4.lachiqui;

import java.util.ArrayList;
import java.util.List;

public class PacoteDeFogosDeArtificio implements FogosDeArtificio{

    private List<FogosDeArtificio> items = new ArrayList<>();

    public void adicionarFogosDeArtificio(FogosDeArtificio f) {
        items.add(f);
    }

    @Override
    public void explodir() {
        items.forEach( f -> f.explodir());
    }
}
