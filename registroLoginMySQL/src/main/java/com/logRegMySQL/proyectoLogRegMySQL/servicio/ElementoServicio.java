package com.logRegMySQL.proyectoLogRegMySQL.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.logRegMySQL.proyectoLogRegMySQL.modelo.Elemento;
import com.logRegMySQL.proyectoLogRegMySQL.modelo.Usuario;
import com.logRegMySQL.proyectoLogRegMySQL.repositorio.ElementoRepositorio;


@Service
public class ElementoServicio {
	
	@Autowired
	ElementoRepositorio repositorio;
	
	
	
	//retornamos los datos
	public List<String> allVideoPropietarioID(){
	return repositorio.findByAllVideoPropietarioID();
	}
}