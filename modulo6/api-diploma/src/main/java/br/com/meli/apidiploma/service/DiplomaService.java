package br.com.meli.apidiploma.service;

import br.com.meli.apidiploma.domain.Aluno;
import br.com.meli.apidiploma.domain.Diploma;
import br.com.meli.apidiploma.domain.DisciplinaRealizada;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiplomaService {

    List<Diploma> diplomas;

    public DiplomaService() {
        this.diplomas = new ArrayList<>();
    }

    public Diploma gerarDiploma(Aluno aluno) {
        Diploma diploma = new Diploma(Long.valueOf(diplomas.size()+1), aluno);
        diplomas.add(diploma);
        return diploma;
    }

    public Diploma buscarDiplomaById(Long id) {
        return diplomas.stream()
                .filter( diploma -> diploma.getId() == id)
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Diploma não encontrado"));
    }
}
