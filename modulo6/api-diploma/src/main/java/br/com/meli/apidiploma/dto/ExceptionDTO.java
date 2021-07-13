package br.com.meli.apidiploma.dto;

public class ExceptionDTO {

    private final String mensagem;

    public ExceptionDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
