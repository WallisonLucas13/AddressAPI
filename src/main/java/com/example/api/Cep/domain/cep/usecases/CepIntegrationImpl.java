package com.example.api.Cep.domain.cep.usecases;

import com.example.api.Cep.domain.cep.models.CepModel;
import com.example.api.Cep.domain.cep.ports.CepPort;
import com.example.api.Cep.infrastructure.api.v1.exceptions.CepFormatInvalidException;
import com.example.api.Cep.infrastructure.api.v1.exceptions.CepNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

@RequiredArgsConstructor
@Component
public class CepIntegrationImpl implements CepIntegration{

    private final CepPort cepPort;

    @Override
    public CepModel findEnderecoByCep(String cep) throws URISyntaxException, CepNotFoundException, CepFormatInvalidException{

        String validCep = validateCepFormat(cep);

        if(validCep == null)
            throw new CepFormatInvalidException(
                    "The zip code is in an invalid format, please correct it and try again!\nFollow the example below:\n" +
                    "\n> 99999-999 or 99999999"
            );

        CepModel model = cepPort.findByCep(validateCepFormat(cep));

        if(model == null) throw new CepNotFoundException("zip code not found, check the amount sent!");

        return cepPort.findByCep(validateCepFormat(cep));
    }

    @Override
    public String validateCepFormat(String cep) {
        if((cep.length() < 8 || cep.length() > 9)
                || (cep.length() == 8 && cep.contains("-"))){
            return null;
        }

        return cep;
    }
}
