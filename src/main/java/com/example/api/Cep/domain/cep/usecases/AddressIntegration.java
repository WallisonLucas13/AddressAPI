package com.example.api.Cep.domain.cep.usecases;

import com.example.api.Cep.domain.cep.models.AddressModel;
import com.example.api.Cep.infrastructure.api.v1.exceptions.CepFormatInvalidException;
import com.example.api.Cep.infrastructure.api.v1.exceptions.AddressNotFoundException;

import java.net.URISyntaxException;

/**
 * Contrato para a busca de um endereço pelo cep
 */
public interface AddressIntegration {

    /**
     *
     * @param cep
     * @return
     */
    AddressModel findAddressByCep(String cep) throws URISyntaxException, CepFormatInvalidException, AddressNotFoundException;

    /**
     * Verifica se o cep está no formato válido
     * @param cep
     * @return
     */
    String validateCepFormat(String cep);
}
