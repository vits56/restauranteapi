package com.vits56.restauranteapi.services;

import com.vits56.restauranteapi.entities.Restaurante;
import com.vits56.restauranteapi.controllers.dto.RestauranteDto;

import java.util.List;

public interface RestauranteService {
    Restaurante incluir(RestauranteDto form);
    List<Restaurante> buscarTodos();
    Restaurante buscarPorId(Long id);
    Restaurante atualizar(Long id, RestauranteDto formAtualizar);
    void deletar(Long id);
}
