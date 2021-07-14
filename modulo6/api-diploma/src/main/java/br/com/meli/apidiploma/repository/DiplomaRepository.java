package br.com.meli.apidiploma.repository;

import br.com.meli.apidiploma.domain.Diploma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DiplomaRepository {

    private final List<Diploma> diplomas;

    public DiplomaRepository() {
        this.diplomas = new ArrayList<>();
    }

    public void save(Diploma diploma) {
        diplomas.add(diploma);
    }

    public List<Diploma> getAll() {
        return diplomas;
    }

    public Diploma getDiplomaById(Long id) {
        return diplomas.stream()
                .filter(diploma -> diploma.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new RuntimeException("Diploma não encontrado"));
    }
}
