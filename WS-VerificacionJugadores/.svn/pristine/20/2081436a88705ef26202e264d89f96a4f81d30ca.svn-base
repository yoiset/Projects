package es.gob.cnjuego.ws.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="JUGADORES_TEST_RGIAJ") 
public class JugadoresTestCambioRGIAJEntity implements IJugadoresCambioRGIAJ {
		
	
	@EmbeddedId
	private JugadoresCambioRGIAJEntityPK id;
	
	@Column(name = "EVENTO" )
	private String evento;
	
	@Column(name = "FECHA_VALOR" )
	private Date fechaValor;
	

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public Date getFechaValor() {
		return fechaValor;
	}

	public void setFechaValor(Date fechaValor) {
		this.fechaValor = fechaValor;
	}

	public JugadoresCambioRGIAJEntityPK getId() {
		return id;
	}

	public void setId(JugadoresCambioRGIAJEntityPK id) {
		this.id = id;
	}


		
	}