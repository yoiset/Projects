package es.dgoj.rgiaj.taglib;

import java.io.Serializable;

/**
 * Clase genérica para representar un par de Strings.
 * Se utiliza en la carga de combo boxes.
 * @author fmg
 *
 */
public class SelectBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String value;

	private String text;
	
	
	public SelectBean() {
		
	}
	
	public SelectBean(String text, String value) {
		this.value = value;
		this.text = text;
	}
	

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SelectBean other = (SelectBean) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[value=" + value + ", text=" + text + "]";
	}

}
