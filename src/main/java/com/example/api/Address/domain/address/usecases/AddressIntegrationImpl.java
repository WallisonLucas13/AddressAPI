package com.example.api.Address.domain.address.usecases;

import com.example.api.Address.domain.address.models.AddressModel;
import com.example.api.Address.domain.address.ports.AddressPort;
import com.example.api.Address.infrastructure.api.v1.exceptions.CepFormatInvalidException;
import com.example.api.Address.infrastructure.api.v1.exceptions.AddressNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

@RequiredArgsConstructor
@Component
public class AddressIntegrationImpl implements AddressIntegration {

    private final AddressPort addressPort;

    @Override
    public AddressModel findAddressByCep(final String cep) throws URISyntaxException {
        validateCepFormat(cep);
        return addressPort.findAddressByCep(cep);
    }

    private void validateCepFormat(final String cep) {
        if((cep.length() < 8 || cep.length() > 9)
                || (cep.length() == 8 && cep.contains("-"))){

            throw new CepFormatInvalidException(HttpStatus.BAD_REQUEST,
                    "O Cep informado está no formato incorreto."
            );
        }
    }
}
