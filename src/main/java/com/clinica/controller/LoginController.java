package com.clinica.controller;

import com.clinica.entity.Usuario;
import com.clinica.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarFormularioLogin() {
        return "login";
    }

    @GetMapping("/post-login")
    public String redireccionarSegunRol(Authentication authentication, HttpSession session) {
        if (authentication != null && authentication.getAuthorities() != null) {
            String nombreUsuario = authentication.getName(); // nombreUsuario = username (DNI o nombre_usuario)

            Usuario usuario = usuarioService.buscarPorNombreUsuarioONumeroDocumento(nombreUsuario);
            if (usuario != null) {
                session.setAttribute("usuarioLogueado", usuario);
                session.setAttribute("idUsuario", usuario.getIdUsuario());

                String rol = usuario.getRol();

                if ("ADMIN".equalsIgnoreCase(rol)) {
                    return "redirect:/index";
                } else if ("PACIENTE".equalsIgnoreCase(rol)) {
                    return "redirect:/horarios-disponibles";
                }else if ("MEDICO".equalsIgnoreCase(rol)) {
                    return "redirect:/citas";
                }
            }
        }
        return "redirect:/login?error";
    }

}
