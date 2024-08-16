package com.example.api.Cep.domain.cep.usecases;

import com.example.api.Cep.domain.cep.models.CepModel;
import com.example.api.Cep.domain.cep.ports.CepPort;
import lombok.RequiredArgsConstructor;

import java.net.URISyntaxException;

@RequiredArgsConstructor
public class CepIntegrationImpl implements CepIntegration{

    private final CepPort cepPort;

    @Override
    public CepModel findEnderecoByCep(String cep) throws URISyntaxException {
        return cepPort.findByCep(validateCepFormat(cep));
    }

    @Override
    public String validateCepFormat(String cep) {
        return cep;
    }
}
