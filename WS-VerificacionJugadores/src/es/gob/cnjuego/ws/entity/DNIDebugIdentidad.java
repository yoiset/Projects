package es.gob.cnjuego.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="DNI_DEBUG_IDENTIDAD")
public class DNIDebugIdentidad {
	
	@Id
	@Column(name = "DNI" )
	private String dni;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	

	
	
}
