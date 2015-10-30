package es.gob.cnjuego.ws.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "TRADUCCION_CARACTERES")
@SequenceGenerator(name="sq_traduccion_caracteres",sequenceName="SEQ_TRADUCCION_CARACTERES", allocationSize=1,initialValue=1)
public class TraduccionCaracteres implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sq_traduccion_caracteres")
	@Column(name = "ID_TRADUCCION" )
	private Long idTraduccion;
	
	@Column(name = "ORIGINAL")
	private char original;

	@Column(name = "TRADUCCION")
	private char traduccion;

	public Long getIdTraduccion() {
		return idTraduccion;
	}

	public void setIdTraduccion(Long idTraduccion) {
		this.idTraduccion = idTraduccion;
	}

	public char getOriginal() {
		return original;
	}

	public void setOriginal(char original) {
		this.original = original;
	}

	public char getTraduccion() {
		return traduccion;
	}

	public void setTraduccion(char traduccion) {
		this.traduccion = traduccion;
	}

		
	
	
}
