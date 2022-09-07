package com.logRegMySQL.proyectoLogRegMySQL.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.logRegMySQL.proyectoLogRegMySQL.modelo.Usuario;
import com.logRegMySQL.proyectoLogRegMySQL.servicio.UsuarioServicio;
import com.logRegMySQL.proyectoLogRegMySQL.web.dto.UsuarioRegistroDto;


@Controller
public class UsuarioRegistroControlador {

	private UsuarioServicio userService;

	public UsuarioRegistroControlador(UsuarioServicio userService) {
		super();
		this.userService = userService;
	}
	
	
    public UsuarioRegistroDto userRegistrationDto() {
        return new UsuarioRegistroDto();
    }

	
    @PostMapping("/app/register")
	public String registerUserAccount(@ModelAttribute UsuarioRegistroDto registrationDto) {
		userService.guardar(registrationDto);
		return "redirect:/app/login?reg_OK";
	}
	
}