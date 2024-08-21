package com.example.api.Cep.domain.cep.usecases;

import com.example.api.Cep.domain.cep.models.AddressModel;
import com.example.api.Cep.domain.cep.ports.AddressPort;
import com.example.api.Cep.infrastructure.api.v1.exceptions.CepFormatInvalidException;
import com.example.api.Cep.infrastructure.api.v1.exceptions.AddressNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

@RequiredArgsConstructor
@Component
public class AddressIntegrationImpl implements AddressIntegration {

    private final AddressPort addressPort;

    @Override
    public AddressModel findAddressByCep(String cep) throws URISyntaxException, AddressNotFoundException, CepFormatInvalidException{

        String validCep = validateCepFormat(cep);

        if(validCep == null)
            throw new CepFormatInvalidException(
                    "The zip code is in an invalid format, please correct it and try again!\nFollow the example below:\n" +
                    "\n> 99999-999 or 99999999"
            );

        AddressModel model = addressPort.findAddressByCep(validateCepFormat(cep));

        if(model == null) throw new AddressNotFoundException("zip code not found, check the amount sent!");

        return addressPort.findAddressByCep(validateCepFormat(cep));
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
