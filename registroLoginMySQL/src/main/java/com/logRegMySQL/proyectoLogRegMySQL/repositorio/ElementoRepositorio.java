package com.logRegMySQL.proyectoLogRegMySQL.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.logRegMySQL.proyectoLogRegMySQL.modelo.Elemento;


public interface ElementoRepositorio extends JpaRepository<Elemento, Long> {

	//Buscar elementos con query
	@Query(value = "select elemento.video from elemento where elemento.propietario_id =7", nativeQuery = true)
	List<String> findByAllVideoPropietarioID();


}