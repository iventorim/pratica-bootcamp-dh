package br.com.meli.apidiploma.dto;


import br.com.meli.apidiploma.domain.DisciplinaRealizada;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectDTO {

    private final String subject;

    private final Double note;

    public SubjectDTO(String subject, Double note) {
        this.subject = subject;
        this.note = note;
    }

    public static DisciplinaRealizada convertSubjectToDisciplinaRealizada(SubjectDTO subjectDTO) {
        return new DisciplinaRealizada(subjectDTO.subject, subjectDTO.note);
    }

    public static List<DisciplinaRealizada> covertListSubjectToListDisciplinaRealizada(List<SubjectDTO> listSubjectDTO) {
        return listSubjectDTO.stream().map(SubjectDTO::convertSubjectToDisciplinaRealizada).collect(Collectors.toList());
    }

    public static SubjectDTO convertDisciplinaRealizadaToSubject(DisciplinaRealizada disciplinaRealizada) {
        return new SubjectDTO(disciplinaRealizada.getNome(), disciplinaRealizada.getNota());
    }

    public static List<SubjectDTO> convertListDisciplinaRealizadaToSubject(List<DisciplinaRealizada> disciplinaRealizadas) {
        return disciplinaRealizadas.stream().map(SubjectDTO::convertDisciplinaRealizadaToSubject).collect(Collectors.toList());
    }

    public String getSubject() {
        return subject;
    }

    public Double getNote() {
        return note;
    }
}
