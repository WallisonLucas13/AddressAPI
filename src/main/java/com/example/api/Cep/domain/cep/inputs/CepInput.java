package com.example.api.Cep.domain.cep.inputs;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CepInput {

    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}
