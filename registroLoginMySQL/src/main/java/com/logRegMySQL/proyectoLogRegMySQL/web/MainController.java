package com.logRegMySQL.proyectoLogRegMySQL.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.logRegMySQL.proyectoLogRegMySQL.modelo.Usuario;
import com.logRegMySQL.proyectoLogRegMySQL.servicio.ElementoServicio;


@Controller
public class MainController {
	
	@GetMapping("/app/login")
	public String login(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@GetMapping("/")
	public String welcome() {
		return "redirect:/app/login";// http://localhost:7000/app/login
	}

	//para login directo
//	@GetMapping("/app/login/NetView")
//	public String home() {
//		return "NetView";
//	}
	
	

	//Para sacar los videos
	@Autowired
	ElementoServicio elementoServicio;
	
	@ModelAttribute("VARCHAR")
	public List<String> productosNoVendidos(){
		return elementoServicio.allVideoPropietarioID();
	}

	@GetMapping("/app/login/NetView")
	public String index(Model model) {
			model.addAttribute("VARCHAR");
		return "NetView";
	}
}