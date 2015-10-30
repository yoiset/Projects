package es.dgoj.rgiaj.form;

import org.springframework.beans.factory.annotation.Configurable;


@Configurable
public class ComunidadForm {
	
	private String comunidadCode;

	public String getComunidadCode() {
		return comunidadCode;
	}

	public void setComunidadCode(String comunidadCode) {
		this.comunidadCode = comunidadCode;
	}

}
