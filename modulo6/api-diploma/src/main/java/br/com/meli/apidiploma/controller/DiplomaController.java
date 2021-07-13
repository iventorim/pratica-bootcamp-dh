package br.com.meli.apidiploma.controller;

import br.com.meli.apidiploma.domain.Aluno;
import br.com.meli.apidiploma.domain.Diploma;
import br.com.meli.apidiploma.dto.DiplomaDTO;
import br.com.meli.apidiploma.dto.StudentDTO;
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
        Diploma diploma = diplomaService.gerarDiploma(aluno);
        URI uri = uriComponentsBuilder.path("/diploma/{id}").buildAndExpand(diploma.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Diploma> obterDiploma(@PathVariable Long id) {

        Diploma diploma = diplomaService.buscarDiplomaById(id);
        return new ResponseEntity<>(diploma, HttpStatus.OK);
    }

    @PostMapping("/analyzeNotes")
    public ResponseEntity<DiplomaDTO> cadastrarAluno(@RequestBody StudentDTO studentDTO) {
        Aluno aluno =StudentDTO.convertStudentToAluno(studentDTO);
        Diploma diploma = diplomaService.gerarDiploma(aluno);

        DiplomaDTO diplomaDTO = new DiplomaDTO(diploma, aluno);
        return new ResponseEntity<>(diplomaDTO,HttpStatus.CREATED);
    }

}
