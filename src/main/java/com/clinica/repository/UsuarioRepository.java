package com.clinica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
    // Buscar por nombre de usuario (ADMIN)
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    // Buscar por DNI (PACIENTE)
    Optional<Usuario> findByDni(String dni);

    Optional<Usuario> findById(Integer idUsuario);
    Usuario findByNombreUsuarioOrDni(String nombreUsuario, String dni);
}
