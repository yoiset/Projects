package es.dgoj.rgiaj.bean;

import java.io.Serializable;


/**
 * Criterios de busqueda de incidencias.
 * @author dbeltran
 * @version 1.0
 */
/**
 * @author dbeltran
 * @version 1.0
 */
public class MonitorBean implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Nombre del backend.
	 */
	private String name;
	
	/**
	 * Estado del backend.
	 */
	private String status;
	
	/**
	 * Tiempo de respuesta del backend.
	 */
	private String time;

	public MonitorBean() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
