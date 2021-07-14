package br.com.meli.apidiploma.dto;


import br.com.meli.apidiploma.domain.DisciplinaRealizada;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

public class SubjectDTO {

    @Size(min = 8,max = 50, message = "Subject name must be between 8 and 50")
    @Pattern(regexp = "^[A-Za-z ]+", message = "Must characters of A to Z")
    private final String subject;

    private final @Size(max = 2) @Digits(fraction = 0, integer = 2) Double note;

    public SubjectDTO(String subject, @Size(max = 2) @Digits(fraction = 0, integer = 2) Double note) {
        this.subject = subject;
        this.note = note;
    }

    public static DisciplinaRealizada convertSubjectToDisciplinaRealizada(SubjectDTO subjectDTO) {
        return new DisciplinaRealizada(subjectDTO.subject, subjectDTO.getNote());
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

    public @Size(max = 2) @Digits(fraction = 0, integer = 2) Double getNote() {
        return note;
    }
}
