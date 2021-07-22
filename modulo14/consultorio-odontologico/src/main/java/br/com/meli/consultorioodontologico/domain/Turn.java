package br.com.meli.consultorioodontologico.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "turns")
public class Turn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turn")
    private Long id;

    private LocalDate day;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Diary diary;

    @ManyToOne
    private TurnStatus turnStatus;

    @OneToOne
    private Turn turnoReprogramado;

    public Turn getTurnoReprogramado() {
        return turnoReprogramado;
    }

    public void setTurnoReprogramado(Turn turnoReprogramado) {
        this.turnoReprogramado = turnoReprogramado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Diary getDiary() {
        return diary;
    }

    public void setDiary(Diary diary) {
        this.diary = diary;
    }

    public TurnStatus getTurnStatus() {
        return turnStatus;
    }

    public void setTurnStatus(TurnStatus turnStatus) {
        this.turnStatus = turnStatus;
    }
}
