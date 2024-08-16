package com.example.api.Cep.domain.cep.converters;

import com.example.api.Cep.domain.cep.inputs.CepInput;
import com.example.api.Cep.domain.cep.models.CepModel;

public final class CepConverter {

    public static CepModel inputToModel(CepInput cepInput){
        return CepModel.builder()
                .cep(cepInput.getCep())
                .localidade(cepInput.getLocalidade())
                .logradouro(cepInput.getLogradouro())
                .gia(cepInput.getGia())
                .uf(cepInput.getUf())
                .bairro(cepInput.getBairro())
                .ddd(cepInput.getDdd())
                .ibge(cepInput.getIbge())
                .siafi(cepInput.getSiafi())
                .complemento(cepInput.getComplemento())
                .unidade(cepInput.getUnidade())
                .build();
    }
}
