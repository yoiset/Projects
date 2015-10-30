package es.dgoj.rgiaj.form;

import com.dgoj.sprmvc.form.AbstractForm;


/**
 * Bean que contiene toda la informacion de un fichero adjunto.
 * @author dbeltran
 * @version 1.0
 */
public final class FileForm extends AbstractForm {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Contenido del fichero. 
	 */
	private byte[] file;
	
	/**
	 * Nombre del fichero.
	 */
	private String name;
	
	/**
	 * Content type del fichero.
	 */
	private String type;
	
	/**
	 * Tamano del fichero. 
	 */
	private Long size;
	
	/**
	 * Descripcion del fichero.
	 */
	private String location;

	/**
	 * Recupera el parametro file.
	 * @return Contenido del fichero 
	 */
	public byte[] getFile() {
		return (file == null ? null : this.file.clone());
	}

	/**
	 * Almacena el parametro file.
	 * @param file  Contenido del fichero
	 */
	public void setFile(byte[] file) {
		this.file = file.clone();
	}

	/**
	 * Recupera el parametro name.
	 * @return Nombre del fichero
	 */
	public String getName() {
		return name;
	}

	/**
	 * Almacena el parametro name.
	 * @param name Nombre del fichero
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Recupera el parametro type.
	 * @return Content type del fichero
	 */
	public String getType() {
		return type;
	}

	/**
	 * Almacena el parametro type.
	 * @param type Content type del fichero
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Recupera el parametro size.
	 * @return Tamano del fichero
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * Almacena el paramtro size.
	 * @param size Tamano del fichero
	 */
	public void setSize(Long size) {
		this.size = size;
	}

	/**
	 * Recupera el parametro location.
	 * @return  Descripcion del fichero.
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Almacena el parametro  Descripcion del fichero.
	 * @param location Descripcion del fichero.
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Devuelve un string con lo elementos separados por ";". 
	 * @return String con lo elementos separados por ";"
	 */
	public String toString() {
		return new StringBuffer(this.getName()).append(";").append(this.getType()).append(";").append(this.getSize()).append(";").toString();
	}
	
}
