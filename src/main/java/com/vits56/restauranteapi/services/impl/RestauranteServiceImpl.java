package com.vits56.restauranteapi.services.impl;

import com.vits56.restauranteapi.entities.Endereco;
import com.vits56.restauranteapi.entities.Restaurante;
import com.vits56.restauranteapi.repository.RestauranteRepository;
import com.vits56.restauranteapi.services.RestauranteService;
import com.vits56.restauranteapi.services.dto.RestauranteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RestauranteServiceImpl implements RestauranteService {
    private final RestauranteRepository restauranteRepository;

    @Override
    public Restaurante incluir(RestauranteDto form) {
        Restaurante novoRestaurante = Restaurante.builder()
                .nomeFantasia(form.getNomeFantasia())
                .cnpj(form.getCnpj())
                .cardapio(new ArrayList<>())
                .endereco(Endereco.builder()
                        .cep(form.getCep())
                        .complemento(form.getComplemento())
                        .build())
                .build();
        return restauranteRepository.save(novoRestaurante);
    }

    @Override
    public List<Restaurante> buscarTodos() {
        return restauranteRepository.findAll();
    }

    @Override
    public Restaurante buscarPorId(Long id) {
        return restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id %d não encontrado!".formatted(id)));
    }

    @Override
    public Restaurante atualizar(Long id, RestauranteDto formAtualizar) {
        Restaurante restauranteParaAtualizar = buscarPorId(id);
        restauranteParaAtualizar.setNomeFantasia(formAtualizar.getNomeFantasia());
        restauranteParaAtualizar.setCnpj(formAtualizar.getCnpj());
        restauranteParaAtualizar.setEndereco(
                Endereco.builder()
                        .cep(formAtualizar.getCep())
                        .complemento(formAtualizar.getComplemento())
                        .build()
        );
        return restauranteRepository.save(restauranteParaAtualizar);
    }

    @Override
    public void deletar(Long id) {
        Restaurante buscarPorId = buscarPorId(id);
        restauranteRepository.delete(buscarPorId);
    }
}
