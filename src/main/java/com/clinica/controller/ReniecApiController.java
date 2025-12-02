package com.clinica.controller;

import com.clinica.dto.ReniecResponse;
import com.clinica.service.impl.ReniecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReniecApiController {
    @Autowired
    private ReniecService reniecService;

    @GetMapping("/reniec/{dni}")
    public ResponseEntity<?> consultarDni(@PathVariable String dni) {

        ReniecResponse datos = reniecService.consultarDni(dni);

        if (datos == null || datos.getDocument_number() == null) {
            return ResponseEntity.status(404).body("DNI no encontrado");
        }

        Map<String, String> resultado = new HashMap<>();
        resultado.put("nombres", datos.getFirst_name());
        resultado.put("apellidos",
                datos.getFirst_last_name() + " " + datos.getSecond_last_name());

        return ResponseEntity.ok(resultado);
    }
}
