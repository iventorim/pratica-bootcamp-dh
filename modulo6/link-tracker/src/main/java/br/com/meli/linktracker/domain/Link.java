package br.com.meli.linktracker.domain;

public class Link {

    private String url;

    private int contadorDeAcessos;

    private String senha;

    private boolean enabled;

    public Link(String url) {
        this.url = url;
        this.contadorDeAcessos = 0;
        this.enabled = true;
        this.senha = "";
    }

    public Link(String url, String senha) {
        this.url = url;
        this.contadorDeAcessos = 0;
        this.senha = senha;
        this.enabled = true;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getContadorDeAcessos() {
        return contadorDeAcessos;
    }

    public String getSenha() {
        return senha;
    }

    public void atualizarAcessos() {
        this.contadorDeAcessos++;
    }
}
