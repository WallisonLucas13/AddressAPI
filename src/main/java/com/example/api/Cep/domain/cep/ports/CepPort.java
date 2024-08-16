package com.example.api.Cep.domain.cep.ports;

import com.example.api.Cep.domain.cep.models.CepModel;

/**
 * Interface responsável por definir o contrato para a busca de endereço
 */
public interface CepPort {

    /**
     * Método para buscar o endereço pelo cep
     * @param cep valor a ser utilizado para encontrar o endereço
     * @return objeto com o endereço completo
     */
    CepModel findByCep(String cep);
}
