package com.example.api.Address.domain.address.ports;

import com.example.api.Address.domain.address.models.AddressModel;

import java.net.URISyntaxException;

/**
 * Interface responsável por definir o contrato para a busca de endereço
 */
public interface AddressPort {

    /**
     * Método para buscar o endereço pelo address
     * @param cep valor a ser utilizado para encontrar o endereço
     * @return objeto com o endereço completo
     */
    AddressModel findAddressByCep(String cep) throws URISyntaxException;
}
