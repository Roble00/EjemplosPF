package com.logRegMySQL.proyectoLogRegMySQL.modelo;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "elemento")
public class Elemento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String video;
	
	
	@ManyToOne
	@JoinColumn(name = "propietario_id", foreignKey = @ForeignKey(foreignKeyDefinition = "propietario_id"))
	private Usuario propietario;
	
	
	public Elemento() {
		
	}
	

	public Elemento(String video) {
		super();
		this.video = video;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	
	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

}