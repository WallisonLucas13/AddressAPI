package com.example.api.Address.domain.address.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressModel {

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
