package br.com.meli.consultorioodontologico.domain;

import javax.persistence.*;
import java.time.LocalTime;

@Entity(name = "diarys")
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diary")
    private Long id;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "ending_time")
    private LocalTime endingTime;

    @ManyToOne
    private Dentist dentist;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalTime endingTime) {
        this.endingTime = endingTime;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }
}
