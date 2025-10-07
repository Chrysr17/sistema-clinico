package com.clinica.config;

import com.clinica.entity.Usuario;
import com.clinica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetalisService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String usernameOrDni) throws UsernameNotFoundException {
		Usuario usuario;

		if (usernameOrDni.matches("\\d{8}")) {
			// Es un DNI (PACIENTE)
			usuario = usuarioRepository.findByDni(usernameOrDni)
					.orElseThrow(() -> new UsernameNotFoundException("Paciente no encontrado con DNI: " + usernameOrDni));
		} else {
			// Es nombre de usuario (ADMIN)
			usuario = usuarioRepository.findByNombreUsuario(usernameOrDni)
					.orElseThrow(() -> new UsernameNotFoundException("Admin no encontrado con usuario: " + usernameOrDni));
		}

		return User.builder()
				.username(usernameOrDni)
				.password(usuario.getPassword())
				.roles(usuario.getRol()) // Spring automáticamente agrega "ROLE_" como prefijo
				.build();
	}
}
