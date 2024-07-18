package com.algaworks.algafood_api.controller;

import com.algaworks.algafood_api.domain.Restaurante;
import com.algaworks.algafood_api.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<Restaurante> adicionar(@RequestBody Restaurante restaurante){
        return ResponseEntity.ok(restauranteService.adicionar(restaurante));
    }

    @GetMapping
    public ResponseEntity<List<Restaurante>> listarTodos(){
        return ResponseEntity.ok(restauranteService.listarTodos());
    }

}
