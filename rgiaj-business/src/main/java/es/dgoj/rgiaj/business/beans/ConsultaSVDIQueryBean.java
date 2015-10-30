package es.dgoj.rgiaj.business.beans;

import com.dgoj.core.common.entity.AbstractQueryEntity;


/**
 * The query bean class for the JUG_PERSONA database table.
 * 
 */
public class ConsultaSVDIQueryBean  extends AbstractQueryEntity {

	private static final long serialVersionUID = 1L;

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