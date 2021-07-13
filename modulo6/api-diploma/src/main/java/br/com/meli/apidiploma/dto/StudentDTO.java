package br.com.meli.apidiploma.dto;

import br.com.meli.apidiploma.domain.Aluno;

import java.util.List;

public class StudentDTO {

    private final String name;
    private final List<SubjectDTO> subjects;

    public StudentDTO(String name, List<SubjectDTO> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public static Aluno convertStudentToAluno(StudentDTO studentDTO) {
        return new Aluno(studentDTO.getName(), SubjectDTO.covertListSubjectToListDisciplinaRealizada(studentDTO.getSubjects()));
    }



    public String getName() {
        return name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

}
