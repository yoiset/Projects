package es.dgoj.rgiaj.form;

import org.springframework.beans.factory.annotation.Configurable;

import com.dgoj.core.common.util.WriteUtil;
import com.dgoj.sprmvc.form.AbstractForm;

/**
 * Formulario de comentarios.
 * @author dbeltran
 * @version 1.0
 */
@Configurable
public final  class CommentForm extends AbstractForm {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Listado de comentarios.
	 */
	private String comments;
	
	/**
	 * Recupera el parametro comments.
	 * @return listado de comentarios
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Almacena el parametro comments.
	 * @param comments listado de comentarios
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	/**
	 * Devuelve un string con lo elementos separados por ';'.
	 *  @return devuelve los comentarios separados por ';'
	 */
	public String toString() {
		return WriteUtil.formatValue(this.comments);
	}
}
