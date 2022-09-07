package com.logRegMySQL.proyectoLogRegMySQL.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.logRegMySQL.proyectoLogRegMySQL.modelo.Role;
import com.logRegMySQL.proyectoLogRegMySQL.modelo.Usuario;
import com.logRegMySQL.proyectoLogRegMySQL.repositorio.UsuarioRepositorio;
import com.logRegMySQL.proyectoLogRegMySQL.web.dto.UsuarioRegistroDto;



@Service
public class UsuarioServicioImpl implements UsuarioServicio{

	private UsuarioRepositorio userRepository;
	
	@Lazy
	@Autowired
	private BCryptPasswordEncoder codificarContrasena;
	
	public Usuario registrar(Usuario u) {
		u.setContrasena(codificarContrasena.encode(u.getContrasena()));
		return userRepository.save(u);
	}
	
	public UsuarioServicioImpl(UsuarioRepositorio userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Usuario guardar(UsuarioRegistroDto registrationDto) {
		Usuario user = new Usuario(registrationDto.getNombre(), 
				registrationDto.getApellido(), registrationDto.getEmail(),
				codificarContrasena.encode(registrationDto.getContrasena()), Arrays.asList(new Role("ROLE_USER")));
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Usuario user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Nombre o contraseña incorrecta.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getContrasena(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}
	
}