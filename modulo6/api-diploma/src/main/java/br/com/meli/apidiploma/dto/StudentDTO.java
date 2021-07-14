package br.com.meli.apidiploma.dto;

import br.com.meli.apidiploma.domain.Aluno;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
public class StudentDTO {

    @Size(min = 8,max = 50, message = "Student name must be between 8 and 50")
    @Pattern(regexp = "^[A-Za-z ]+", message = "Must characters of A to Z")
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
