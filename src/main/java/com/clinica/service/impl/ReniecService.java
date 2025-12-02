package com.clinica.service.impl;

import com.clinica.dto.ReniecResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReniecService {
    private final String API_URL = "https://api.apis.net.pe/v2/reniec/dni?numero=";


    public ReniecResponse consultarDni(String dni) {

        RestTemplate restTemplate = new RestTemplate();

        try {
            return restTemplate.getForObject(API_URL + dni, ReniecResponse.class);
        } catch (Exception e) {
            return null;
        }
    }
}
