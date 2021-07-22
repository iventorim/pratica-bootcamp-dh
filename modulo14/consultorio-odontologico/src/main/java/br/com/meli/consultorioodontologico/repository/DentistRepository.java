package br.com.meli.consultorioodontologico.repository;

import br.com.meli.consultorioodontologico.domain.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface DentistRepository extends JpaRepository<Dentist,Long> {

    @Query("SELECT de FROM dentists de, diarys di, turns t WHERE de.id = di.dentist.id AND t.diary.id = di.id " +
            "AND t.day = :date GROUP BY de.id HAVING count(de.id) >= 2")
    List<Dentist> getDentistsThatHasMoreTwoTurnsOnDay(@Param("date") LocalDate date);

}
