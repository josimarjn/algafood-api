package com.algaworks.algafood_api.service;

import com.algaworks.algafood_api.domain.Restaurante;
import com.algaworks.algafood_api.repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante adicionar(Restaurante restaurante){
        return restauranteRepository.save(restaurante);
    }

    public List<Restaurante> listarTodos(){
        return restauranteRepository.findAll();
    }
}
