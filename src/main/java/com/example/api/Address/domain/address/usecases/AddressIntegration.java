package com.example.api.Address.domain.address.usecases;

import com.example.api.Address.domain.address.models.AddressModel;
import com.example.api.Address.infrastructure.api.v1.exceptions.CepFormatInvalidException;
import com.example.api.Address.infrastructure.api.v1.exceptions.AddressNotFoundException;

import java.net.URISyntaxException;

/**
 * Contrato para a busca de um endereço pelo address
 */
public interface AddressIntegration {

    /**
     *
     * @param cep
     * @return
     */
    AddressModel findAddressByCep(String cep) throws URISyntaxException, CepFormatInvalidException, AddressNotFoundException;

    /**
     * Verifica se o address está no formato válido
     * @param cep
     * @return
     */
    String validateCepFormat(String cep);
}
