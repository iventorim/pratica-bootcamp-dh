package br.com.meli.apidiploma.unit;

import br.com.meli.apidiploma.domain.Aluno;
import br.com.meli.apidiploma.domain.Diploma;
import br.com.meli.apidiploma.domain.DisciplinaRealizada;
import br.com.meli.apidiploma.repository.DiplomaRepository;
import br.com.meli.apidiploma.service.DiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CertificateServiceImplTest {

    @Mock
    private DiplomaRepository diplomaRepository;

    DiplomaService diplomaService;

    @BeforeEach
    void setUp() {
        diplomaService = new DiplomaService(diplomaRepository);
    }

    @Test
    public void mediaComputadaCorretamenteTest() {

        List<DisciplinaRealizada> disciplinaRealizadas = List.of(
          new DisciplinaRealizada("Cálculo 1", 7.0),
          new DisciplinaRealizada("Prog 1", 10.0),
          new DisciplinaRealizada("IA", 10.0)
        );

        Double nota = diplomaService.calculateAverage(disciplinaRealizadas);

        Assertions.assertEquals(9.0,nota);
    }

    @Test
    public void mediaComputadaErradaTest() {

        List<DisciplinaRealizada> disciplinaRealizadas = List.of(
                new DisciplinaRealizada("Cálculo 1", 7.0),
                new DisciplinaRealizada("Prog 1", 10.0),
                new DisciplinaRealizada("IA", 10.0)
        );


        Double nota = diplomaService.calculateAverage(disciplinaRealizadas);

        Assertions.assertNotEquals(9.5,nota);
    }

    @Test
    public void alunoHonradoMensagemTest() {

        Double media = 10.00;

        String result = diplomaService.getMessageDiploma(media);

        Assertions.assertEquals("Parabéns! Sua média foi de "+media, result);
    }

    @Test
    public void alunoNaoHonradoMensagemTest() {

        Double media = 5.0;

        String result = diplomaService.getMessageDiploma(media);

        Assertions.assertNotEquals("Parabéns! Sua média foi de "+media, result);
    }

    @Test
    public void geracaoDeDiplomaTest() {

        List<DisciplinaRealizada> disciplinasRealizadas = List.of(
                new DisciplinaRealizada("Cálculo 1", 7.0),
                new DisciplinaRealizada("Prog 1", 10.0),
                new DisciplinaRealizada("IA", 10.0)
        );
        Aluno aluno = new Aluno("Jose Mane", disciplinasRealizadas);
        when(diplomaRepository.getAll()).thenReturn(new ArrayList<>());
        Diploma diploma = diplomaService.gerarDiploma(aluno);


        Assertions.assertEquals("Parabéns! Sua média foi de 9.0", diploma.getMensagem());
        Assertions.assertEquals("Jose Mane", diploma.getNome());
        Assertions.assertEquals(9.0, diploma.getNota());
    }

    @Test
    public void geracaoDeDiplomaInvalidoTest() {

        List<DisciplinaRealizada> disciplinasRealizadas = List.of(
                new DisciplinaRealizada("Cálculo 1", 7.0),
                new DisciplinaRealizada("Prog 1", 10.0),
                new DisciplinaRealizada("IA", 10.0)
        );
        Aluno aluno = new Aluno("Jose Mane", disciplinasRealizadas);
        when(diplomaRepository.getAll()).thenReturn(new ArrayList<>());
        Diploma diploma = diplomaService.gerarDiploma(aluno);


        Assertions.assertNotEquals("Sua média foi de 9.0", diploma.getMensagem());
        Assertions.assertNotEquals("Jose", diploma.getNome());
        Assertions.assertNotEquals(9.5, diploma.getNota());

    }
}
