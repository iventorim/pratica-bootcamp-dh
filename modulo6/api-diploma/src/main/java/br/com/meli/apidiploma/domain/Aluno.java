package br.com.meli.apidiploma.domain;


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

    public Double getMedia() {
        return this.getDisciplinas()
                .stream()
                .mapToDouble(DisciplinaRealizada::getNota)
                .average()
                .orElseThrow(()-> new RuntimeException("Problema ao calcular a media das notas"));

    }
}
