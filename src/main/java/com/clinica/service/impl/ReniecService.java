package com.clinica.service.impl;

import com.clinica.dto.ReniecResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ReniecService {
    private final String API_URL = "https://api.decolecta.com/v1/reniec/dni?numero=";
    private final String TOKEN = "sk_12073.bs9KLp0Qu02GD1Wey0txYzY5RibZQB9D";

    public ReniecResponse consultarDni(String dni) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + TOKEN);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<ReniecResponse> response =
                    restTemplate.exchange(API_URL + dni, HttpMethod.GET, entity, ReniecResponse.class);

            return response.getBody();
        } catch (Exception e) {
            System.out.println("ERROR RENIEC: " + e.getMessage());
            return null;
        }
    }
}