package br.com.meli.apidiploma.dto;

import br.com.meli.apidiploma.domain.Aluno;
import br.com.meli.apidiploma.domain.Diploma;

import java.util.List;

public class DiplomaDTO {

    private final String message;
    private final Double average;
    private final String name;
    private final List<SubjectDTO> subjects;

    public DiplomaDTO(String message, Double average, String name, List<SubjectDTO> subjects) {
        this.message = message;
        this.average = average;
        this.name = name;
        this.subjects = subjects;
    }

    public DiplomaDTO(Diploma diploma, Aluno aluno) {
        this.message = diploma.getMensagem();
        this.average = diploma.getNota();
        this.name = diploma.getNome();
        this.subjects = SubjectDTO.convertListDisciplinaRealizadaToSubject(aluno.getDisciplinas());
    }

    public String getMessage() {
        return message;
    }

    public Double getAverage() {
        return average;
    }

    public String getName() {
        return name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }
}
