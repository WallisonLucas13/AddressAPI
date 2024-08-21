package com.example.api.Cep.domain.cep.ports;

import com.example.api.Cep.domain.cep.models.AddressModel;

import java.net.URISyntaxException;

/**
 * Interface responsável por definir o contrato para a busca de endereço
 */
public interface AddressPort {

    /**
     * Método para buscar o endereço pelo cep
     * @param cep valor a ser utilizado para encontrar o endereço
     * @return objeto com o endereço completo
     */
    AddressModel findAddressByCep(String cep) throws URISyntaxException;
}
