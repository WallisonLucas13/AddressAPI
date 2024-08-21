package com.example.api.Cep.domain.cep.converters;

import com.example.api.Cep.domain.cep.inputs.AddressInput;
import com.example.api.Cep.domain.cep.models.AddressModel;

public final class AddressConverter {

    public static AddressModel inputToModel(AddressInput addressInput){
        return AddressModel.builder()
                .cep(addressInput.getCep())
                .localidade(addressInput.getLocalidade())
                .logradouro(addressInput.getLogradouro())
                .gia(addressInput.getGia())
                .uf(addressInput.getUf())
                .bairro(addressInput.getBairro())
                .ddd(addressInput.getDdd())
                .ibge(addressInput.getIbge())
                .siafi(addressInput.getSiafi())
                .complemento(addressInput.getComplemento())
                .unidade(addressInput.getUnidade())
                .build();
    }
}
