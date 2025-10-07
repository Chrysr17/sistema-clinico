package com.clinica.service;

import java.util.Optional;

import com.clinica.entity.Usuario;

public interface UsuarioService {

    Usuario buscarPorNombreUsuario(String nombreUsuario);

    Usuario buscarPorDni(String dni);
    Usuario guardarUsuario(Usuario usuario);  // útil si registras pacientes

    Usuario buscarPorNombreUsuarioONumeroDocumento(String username);

}
