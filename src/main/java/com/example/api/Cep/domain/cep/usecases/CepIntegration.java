package com.example.api.Cep.domain.cep.usecases;

import com.example.api.Cep.domain.cep.models.CepModel;
import com.example.api.Cep.infrastructure.api.v1.exceptions.CepFormatInvalidException;
import com.example.api.Cep.infrastructure.api.v1.exceptions.CepNotFoundException;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

/**
 * Contrato para a busca de um endereço pelo cep
 */
public interface CepIntegration {

    /**
     *
     * @param cep
     * @return
     */
    CepModel findEnderecoByCep(String cep) throws URISyntaxException, CepFormatInvalidException, CepNotFoundException;

    /**
     * Verifica se o cep está no formato válido
     * @param cep
     * @return
     */
    String validateCepFormat(String cep);
}
