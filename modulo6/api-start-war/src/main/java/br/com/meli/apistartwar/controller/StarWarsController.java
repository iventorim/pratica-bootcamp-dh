package br.com.meli.apistartwar.controller;

import br.com.meli.apistartwar.repository.StarWarsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {

    final StarWarsRepository repository;

    public StarWarsController(StarWarsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("search/{data}")
    public ResponseEntity<List<String>> obterDados(@PathVariable String data) {

        List<String> result = repository.getNomes(data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
