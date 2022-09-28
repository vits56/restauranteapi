package com.vits56.restauranteapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Embeddable
@Builder
public class Endereco {
    private String cep;
    private String complemento;
}
