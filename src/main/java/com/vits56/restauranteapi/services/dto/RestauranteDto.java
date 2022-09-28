package com.vits56.restauranteapi.services.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class RestauranteDto {
    private String nomeFantasia;
    private String cnpj;
    private String cep;
    private String complemento;
}
