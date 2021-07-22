package br.com.meli.consultorioodontologico.controller;

import br.com.meli.consultorioodontologico.domain.Dentist;
import br.com.meli.consultorioodontologico.domain.Patient;
import br.com.meli.consultorioodontologico.domain.Turn;
import br.com.meli.consultorioodontologico.service.ConsultorioService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ConsultorioController {

    private final ConsultorioService consultorioService;

    public ConsultorioController(ConsultorioService consultorioService) {
        this.consultorioService = consultorioService;
    }

    @GetMapping("dentistas-trabalhadores")
    @ResponseStatus(HttpStatus.OK)
    public List<Dentist> detistasComMaisDeUmConsulta(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return consultorioService.obterListaDentistaComMaisDeUmaConsultaNoDia(date);
    }

    @GetMapping("agenda-dentista")
    @ResponseStatus(HttpStatus.OK)
    public List<Turn> agendaDentista(@RequestParam("id") Long id) {
        return consultorioService.obterAgendaDentista(id);
    }

    @GetMapping("lista-paciente-dia")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> listaPacienteDia(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return consultorioService.obterListaPacientesDia(date);
    }

    @GetMapping("remarcacoes")
    @ResponseStatus(HttpStatus.OK)
    public List<Turn> listaRemarcacoes() {
        return consultorioService.obterRemarcaoes();
    }

    @GetMapping("remarcacoes/dentista")
    @ResponseStatus(HttpStatus.OK)
    public List<Turn> listaRemarcacoesDentista(@RequestParam("id") Long id) {
        return consultorioService.obterRemarcacoesDoDentista(id);
    }

    @GetMapping("consultas-finalizadas")
    @ResponseStatus(HttpStatus.OK)
    public List<Turn> listaConsultasFinalizadas() {
        return consultorioService.obterConsultasFinalizadas();
    }

    @GetMapping("consultas-pendentes")
    @ResponseStatus(HttpStatus.OK)
    public List<Turn> listaConsultasPendentesDoDia(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return consultorioService.obterConsultasPendentesDoDia(date);
    }

}
