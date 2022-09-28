package com.vits56.restauranteapi.controllers;

import com.vits56.restauranteapi.entities.Restaurante;
import com.vits56.restauranteapi.services.dto.RestauranteDto;
import com.vits56.restauranteapi.services.impl.RestauranteServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurantes")
@RequiredArgsConstructor
public class RestauranteController {
    private final RestauranteServiceImpl restauranteService;

    @PostMapping
    public Restaurante incluir(@RequestBody RestauranteDto form) {
        return restauranteService.incluir(form);
    }

    @GetMapping
    public List<Restaurante> buscarTodos() {
        return restauranteService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Restaurante buscarPorId(@PathVariable("id") Long id) {
        return restauranteService.buscarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public Restaurante atualizar(@PathVariable("id") Long id, @RequestBody RestauranteDto formAtualizar) {
        return restauranteService.atualizar(id, formAtualizar);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletar(@PathVariable("id") Long id) {
        restauranteService.deletar(id);
    }
}
