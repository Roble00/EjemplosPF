package com.logRegMySQL.proyectoLogRegMySQL.servicio;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.logRegMySQL.proyectoLogRegMySQL.modelo.Usuario;
import com.logRegMySQL.proyectoLogRegMySQL.web.dto.UsuarioRegistroDto;



public interface UsuarioServicio extends UserDetailsService{
	Usuario guardar(UsuarioRegistroDto registrationDto);
}
