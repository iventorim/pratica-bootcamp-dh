package br.com.meli.apimorse.controller;

import br.com.meli.apimorse.Morse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrincipalController {

    @GetMapping("/translate-morse-to-text/{morseCode}")
    public String translateMorseToText(@PathVariable String morseCode) {

        return Morse.normal(morseCode);
    }

    @GetMapping("/translate-text-to-morse/{text}")
    public String translateTextToMorseCode(@PathVariable String text) {

        return Morse.morse(text);
    }
}