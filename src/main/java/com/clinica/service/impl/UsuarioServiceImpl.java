package com.clinica.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.clinica.entity.Usuario;
import com.clinica.repository.UsuarioRepository;
import com.clinica.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public Usuario buscarPorNombreUsuario(String nombreUsuario) {
		return usuarioRepository.findByNombreUsuario(nombreUsuario)
				.orElse(null);
	}

	@Override
	public Usuario buscarPorDni(String dni) {
		return usuarioRepository.findByDni(dni)
				.orElse(null);
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		String passwordEncriptada = passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(passwordEncriptada);
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario buscarPorNombreUsuarioONumeroDocumento(String username) {
		return usuarioRepository.findByNombreUsuarioOrDni(username, username);
	}


}
