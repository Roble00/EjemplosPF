package com.logRegMySQL.proyectoLogRegMySQL.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logRegMySQL.proyectoLogRegMySQL.modelo.Usuario;



@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);
	
}
