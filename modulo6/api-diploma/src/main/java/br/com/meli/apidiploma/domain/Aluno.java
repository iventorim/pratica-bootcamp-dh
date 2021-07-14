package br.com.meli.apidiploma.domain;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class Aluno {

    private String nome;

    private List<DisciplinaRealizada> disciplinasRealizadas;

    public Aluno(String nome, List<DisciplinaRealizada> disciplinasRealizadas) {
        this.nome = nome;
        this.disciplinasRealizadas = disciplinasRealizadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<DisciplinaRealizada> getDisciplinas() {
        return disciplinasRealizadas;
    }

    public void setDisciplinas(List<DisciplinaRealizada> disciplinaRealizadas) {
        this.disciplinasRealizadas = disciplinaRealizadas;
    }

}
