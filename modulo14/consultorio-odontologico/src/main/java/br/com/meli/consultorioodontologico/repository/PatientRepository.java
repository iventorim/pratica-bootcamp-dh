package br.com.meli.consultorioodontologico.repository;

import br.com.meli.consultorioodontologico.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("SELECT p FROM patients p, turns t WHERE p.id = t.patient.id AND t.day = :date")
    List<Patient> getPatientsDay(@Param("date") LocalDate date);
}
