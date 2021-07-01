package br.com.meli.apidiploma.controller;

import br.com.meli.apidiploma.domain.Aluno;
import br.com.meli.apidiploma.domain.Diploma;
import br.com.meli.apidiploma.service.DiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/diploma")
public class DiplomaController {

    @Autowired
    DiplomaService diplomaService;

    @PostMapping
    public ResponseEntity<Aluno> gerarDiploma(@RequestBody Aluno aluno, UriComponentsBuilder uriComponentsBuilder) {

        //TODO Validar dados aluno
        Long idDiploma = diplomaService.gerarDiploma(aluno);
        URI uri = uriComponentsBuilder.path("/diploma/{id}").buildAndExpand(idDiploma).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Diploma> obterDiploma(@PathVariable Long id) {

        Diploma diploma = diplomaService.buscarDiplomaById(id);
        return new ResponseEntity<Diploma>(diploma, HttpStatus.OK);
    }

}
