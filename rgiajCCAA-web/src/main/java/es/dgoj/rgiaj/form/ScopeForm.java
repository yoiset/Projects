package es.dgoj.rgiaj.form;


/**
 * Formulario de ambito, usado cuando en peticiones desde la vista admin.jsp.
 * @author dbeltran
 * @version 1.0
 */
public final class ScopeForm {

	/**
	 * Identificador del ambito.
	 */
	private Integer id;
	
	/**
	 * Nombre del ambito.
	 */
	private String name;

	/**
	 * Recupera el parametro id.
	 * @return identificador de la incidencia
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Almacena el parametro id.
	 * @param id identificador de la incidencia
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Recupera el parametro name.
	 * @return nombre del ambito
	 */
	public String getName() {
		return name;
	}

	/**
	 * Almacena el parametro name.
	 * @param name nombre del ambito
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
