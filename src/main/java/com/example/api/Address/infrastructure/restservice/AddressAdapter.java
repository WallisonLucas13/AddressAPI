package com.example.api.Address.infrastructure.restservice;

import com.example.api.Address.domain.address.converters.AddressConverter;
import com.example.api.Address.domain.address.inputs.AddressInput;
import com.example.api.Address.domain.address.models.AddressModel;
import com.example.api.Address.domain.address.ports.AddressPort;
import com.example.api.Address.infrastructure.api.v1.exceptions.AddressNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Component
public class AddressAdapter extends RestClientAdapter implements AddressPort {

    private final String VIACEP_URL;
    private static final String VIACEP_RESPONSE_PREFIX = "/json/";

    public AddressAdapter(@Value("${api.viacep.url}") final String VIACEP_URL,
                          final RestClient restClient){

        super(restClient);
        this.VIACEP_URL = VIACEP_URL;
    }

    @Override
    public AddressModel findAddressByCep(final String validCep) throws URISyntaxException {
        var uri = new URI(String.format("%s%s%s", VIACEP_URL, validCep, VIACEP_RESPONSE_PREFIX));
        AddressInput response = this.get(uri, AddressInput.class);

        if ((response == null) || (response.getCep() == null)){
            throw new AddressNotFoundException(HttpStatus.NOT_FOUND,
                    "Endereço não encontrado, verifique o Cep informado.");
        }
        return AddressConverter.inputToModel(response);
    }
}
