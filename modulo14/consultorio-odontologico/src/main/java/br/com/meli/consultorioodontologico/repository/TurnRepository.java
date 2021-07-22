package br.com.meli.consultorioodontologico.repository;

import br.com.meli.consultorioodontologico.domain.Dentist;
import br.com.meli.consultorioodontologico.domain.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TurnRepository extends JpaRepository<Turn, Long> {

    @Query("SELECT t FROM turns t, turn_status ts WHERE t.turnStatus.id = ts.id " +
            "AND ts.name = 'CONCLUIDO'")
    List<Turn> getTurnsFinished();

    @Query("SELECT t FROM turns t, turn_status ts WHERE t.turnStatus.id = ts.id" +
            "  AND ts.name = 'PENDENTE' AND t.day= :date")
    List<Turn> getTurnsPendentByDay(@Param("date") LocalDate date);

    @Query("SELECT t FROM dentists de, diarys di, turns t WHERE de.id = di.dentist.id AND t.diary.id = di.id" +
            "  AND t.turnoReprogramado IS NOT NULL AND de.id = :idDentist")
    List<Turn> getRemarkByDentist(@Param("idDentist") Long idDentist);

    @Query("SELECT t FROM turns t WHERE t.turnoReprogramado IS NOT NULL")
    List<Turn> getRemarks();

    @Query("SELECT t FROM dentists de, diarys di, turns t, patients p WHERE de.id = di.dentist.id AND " +
            "      di.id = t.diary.id AND " +
            "      p.id = t.patient.id AND" +
            "      de.id = :idDentist")
    List<Turn> getCalendarDentist(@Param("idDentist") Long idDentist);

}
