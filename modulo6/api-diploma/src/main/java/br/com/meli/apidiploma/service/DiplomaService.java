package br.com.meli.apidiploma.service;

import br.com.meli.apidiploma.domain.Aluno;
import br.com.meli.apidiploma.domain.Diploma;
import br.com.meli.apidiploma.domain.DisciplinaRealizada;
import br.com.meli.apidiploma.repository.DiplomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiplomaService {


    private final DiplomaRepository diplomaRepository;

    public DiplomaService(DiplomaRepository diplomaRepository) {
        this.diplomaRepository = diplomaRepository;
    }

    public Diploma gerarDiploma(Aluno aluno) {

        Double media = calculateAverage(aluno.getDisciplinas());
        String mensagem = getMessageDiploma(media);
        Diploma diploma = new Diploma((long) (diplomaRepository.getAll().size() + 1), aluno.getNome(), media, mensagem);
        diplomaRepository.save(diploma);
        return diploma;
    }

    public Diploma buscarDiplomaById(Long id) {
        return diplomaRepository.getDiplomaById(id);
    }

    public Double calculateAverage(List<DisciplinaRealizada> disciplinas) {
        return disciplinas
                .stream()
                .mapToDouble(DisciplinaRealizada::getNota)
                .average()
                .orElseThrow(()-> new RuntimeException("Problema ao calcular a media das notas"));
    }

    public String getMessageDiploma(Double media) {
        if(withHonor(media)) {
            return "Parabéns! Sua média foi de "+media.toString();
        }

        return "Sua média foi de "+media.toString();
    }

    public boolean withHonor(Double media) {
        return media >= 9;
    }

}
