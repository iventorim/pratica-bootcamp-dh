package br.com.meli.apicontrolepedidos.controller;

import br.com.meli.apicontrolepedidos.dto.MesaDTO;
import br.com.meli.apicontrolepedidos.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("restaurante")
public class RestauranteController {

    @Autowired
    RestauranteService restauranteService;


    @GetMapping("{id}")
    public ResponseEntity<MesaDTO> infoMesa(@PathVariable Long id) {

        MesaDTO mesaDTO = restauranteService.obterInfoMesa(id);
        ResponseEntity<MesaDTO> response = new ResponseEntity<MesaDTO>(mesaDTO, HttpStatus.OK);
        return response;
    }

    @PostMapping("fechar-mesa")
    public ResponseEntity fecharMesa(@RequestParam Long id) {
        restauranteService.fecharMesa(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("valor-caixa")
    public ResponseEntity<Double> obterValorCaixa() {
        Double valorCaixa = restauranteService.getValorCaixa();
        ResponseEntity<Double> response = new ResponseEntity<>(valorCaixa,HttpStatus.OK);
        return response;
    }

}
