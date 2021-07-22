package br.com.meli.consultorioodontologico.service;

import br.com.meli.consultorioodontologico.domain.Dentist;
import br.com.meli.consultorioodontologico.domain.Patient;
import br.com.meli.consultorioodontologico.domain.Turn;
import br.com.meli.consultorioodontologico.repository.DentistRepository;
import br.com.meli.consultorioodontologico.repository.PatientRepository;
import br.com.meli.consultorioodontologico.repository.TurnRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ConsultorioService {

    private final DentistRepository dentistRepository;

    private final TurnRepository turnRepository;

    private final PatientRepository patientRepository;

    public ConsultorioService(DentistRepository dentistRepository, TurnRepository turnRepository, PatientRepository patientRepository) {
        this.dentistRepository = dentistRepository;
        this.turnRepository = turnRepository;
        this.patientRepository = patientRepository;
    }

    public List<Dentist> obterListaDentistaComMaisDeUmaConsultaNoDia(LocalDate date) {
        return dentistRepository.getDentistsThatHasMoreTwoTurnsOnDay(date);
    }

    public List<Patient> obterListaPacientesDia(LocalDate date) {
        return patientRepository.getPatientsDay(date);
    }

    public List<Turn> obterAgendaDentista(Long idDentista) {
        return turnRepository.getCalendarDentist(idDentista);
    }

    public List<Turn> obterRemarcaoes() {
        return turnRepository.getRemarks();
    }

    public List<Turn>  obterRemarcacoesDoDentista(Long idDentista) {
        return turnRepository.getRemarkByDentist(idDentista);
    }

    public List<Turn> obterConsultasFinalizadas() {
        return turnRepository.getTurnsFinished();
    }

    public List<Turn> obterConsultasPendentesDoDia(LocalDate date) {
        return turnRepository.getTurnsPendentByDay(date);
    }


}
