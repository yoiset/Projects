package es.dgoj.rgiaj.form;

import org.springframework.beans.factory.annotation.Configurable;

/**
 * Formulario de busqueda de cartas.
 *
 * @author connectis
 */
@Configurable
public class SearchConsultaSVDIForm {

	/** Campo dni. */
	private String dni;

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	
 }
