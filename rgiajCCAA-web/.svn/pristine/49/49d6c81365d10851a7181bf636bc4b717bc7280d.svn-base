package es.dgoj.rgiaj.form;

import java.util.Date;

import javax.validation.constraints.Digits;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * Formulario de busqueda de incidencias, usado para enviar y recibir informacion para la busqueda.
 * @author dbeltran
 * @version 1.0
 */
@Configurable
public final class SearchIssueForm {
	
	/**
	 * Formato Fecha.
	 */
	private static final String FECHA = "dd/MM/yyyy";

	/**
	 * Identificador de la incidencia.
	 */
	@Digits(integer=16, fraction=0)
	private Long issueId;

	/**
	 * Ambito de la incidencia.
	 */
	private Long scope;

	/**
	 * Tipo de incidencia.
	 */
	private Long type;
	
	/**
	 * Resumen de la incidencia.
	 */
	private String summary;
	
	/**
	 * Usuario que abrio la incidencia.
	 */
	private String requesterUsername;
	
	/**
	 * Importancia de la incidencia.
	 */
	private String importance;

	/**
	 * Usuario que tiene que resolver la incidencia.
	 */
	private String solverUsername;
	
	/**
	 * Prioridad de la incidencia.
	 */
	private String priority;

	
	/**
	 * Fecha minima de creacion de la incidencia.
	 */
	@DateTimeFormat(pattern=FECHA)
	private Date creationDateMin;
	
	/**
	 * Fecha maxima de creacion de la incidencia.
	 */
	@DateTimeFormat(pattern=FECHA)
	private Date creationDateMax;
	
	/**
	 * Fecha minima de cambio de estado de la incidencia.
	 */
	@DateTimeFormat(pattern=FECHA)
	private Date lastStateDateMin;
	
	/**
	 * Fecha maxima de cambio de estado de la incidencia.
	 */
	@DateTimeFormat(pattern=FECHA)
	private Date lastStateDateMax;
	
	/**
	 * Nombre completo del peticionario.
	 */
	private String requesterFullName;
	
	/**
	 * Nombre completo del solucionador.
	 */
	private String solverFullName; 
	
	
	/**
	 * Comprobación de campos del formulario
	 * que no se puede realizar con anotaciones.
	 * @param result contiene el listado de errores
	 */
	public void validate(BindingResult result) {
		if ((this.creationDateMax != null) && (this.creationDateMin != null) && (this.creationDateMax.before(this.creationDateMin))) {
				result.addError(new FieldError("SearchIssueForm", "creationDateMin", null, true, new String[]{"TimeBefore.searchIssueForm.creationDateMin"}, null, null));
		}
		if ((this.lastStateDateMax != null) && (this.lastStateDateMin != null) && (this.lastStateDateMax.before(this.lastStateDateMin))) {
				result.addError(new FieldError("SearchIssueForm", "lastStateDateMin", null, true, new String[]{"TimeBefore.searchIssueForm.lastStateDateMin"}, null, null));
		}
	}
	
	/**
	 * Recupera el parametro issueId.
	 * @return identificador de incidencia
	 */
	public Long getIssueId() {
		return this.issueId;
	}

	/**
	 * Almacena el parametros issueId.
	 * @param issueId identificador de incidencia
	 */
	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	/**
	 * Recupera el parametro scope.
	 * @return identificador de ambito
	 */
	public Long getScope() {
		return this.scope;
	}

	/**
	 * Almacena el parametro scope.
	 * @param scope identificador de ambito
	 */
	public void setScope(Long scope) {
		this.scope = scope;
	}

	/**
	 * Recupera el parametro type.
	 * @return el identificador de tipo
	 */
	public Long getType() {
		return this.type;
	}

	/**
	 * Almacena el parametro type.
	 * @param type identificador de tipo
	 */
	public void setType(Long type) {
		this.type = type;
	}

	/**
	 * Recupera el parametro summary.
	 * @return columna Resumen de la incidencia
	 */
	public String getSummary() {
		return this.summary;
	}

	/**
	 * Almacena el paramentro summary.
	 * @param summary columna Resumen de la incidencia
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * Recupera el paramentro requesterUsername.
	 * @return nombre de usuario peticionario de la incidencia
	 */
	public String getRequesterUsername() {
		return this.requesterUsername;
	}

	/**
	 * Almacena el parametro requesterUsername.
	 * @param requesterUsername nombre de usuario peticionario de la incidencia
	 */
	public void setRequesterUsername(String requesterUsername) {
		this.requesterUsername = requesterUsername;
	}

	/**
	 * Recupera el parametro importance.
	 * @return identificador de importancia de la incidencia
	 */
	public String getImportance() {
		return this.importance;
	}

	/**
	 * Almacena el parametro importance.
	 * @param importance identificador de importancia de la incidencia
	 */
	public void setImportance(String importance) {
		this.importance = importance;
	}

	/**
	 * Recupera el parametro solverUsername.
	 * @return el nombre del usuario solucionador de la incidencia
	 */
	public String getSolverUsername() {
		return this.solverUsername;
	}

	/**
	 * Almacena el parametro solverUsername.
	 * @param solverUsername nombre del usuario solucionador de la incidencia
	 */
	public void setSolverUsername(String solverUsername) {
		this.solverUsername = solverUsername;
	}

	/**
	 * Recupera el parametro priority.
	 * @return identificador de prioridad
	 */
	public String getPriority() {
		return this.priority;
	}

	/**
	 * Almacena el parametro priority.
	 * @param priority identificador de prioridad
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * Recupera el parametro creationDateMin.
	 * @return fecha de creacion minima
	 */
	public Date getCreationDateMin() {
		return (this.creationDateMin == null ? null : (Date)this.creationDateMin.clone());
	}

	/**
	 * Almacena el paramentro creationDateMin .
	 * @param creationDateMin fecha de creacion minima
	 */
	public void setCreationDateMin(Date creationDateMin) {
		this.creationDateMin = (creationDateMin == null ? null : (Date)creationDateMin.clone());
	}

	/**
	 * Recupera el parametro creationDateMax.
	 * @return fecha de creacion maxima
	 */
	public Date getCreationDateMax() {
		return (this.creationDateMax == null ? null : (Date)this.creationDateMax.clone());
	}

	/**
	 * Almacena el parametro creationDateMax. 
	 * @param creationDateMax fecha de creacion maxima
	 */
	public void setCreationDateMax(Date creationDateMax) {
		this.creationDateMax = (creationDateMax == null ? null : (Date)creationDateMax.clone());
	}

	/**
	 * Recupera el parametro lastStateDateMin.
	 * @return la ultima fecha de cambio de estado minima
	 */
	public Date getLastStateDateMin() {
		return (this.lastStateDateMin == null ? null : (Date)this.lastStateDateMin.clone());
	}

	/**
	 * Almacena el parametro lastStateDateMin.
	 * @param lastStateDateMin la ultima fecha de cambio de estado minima
	 */
	public void setLastStateDateMin(Date lastStateDateMin) {
		this.lastStateDateMin = (lastStateDateMin == null ? null : (Date)lastStateDateMin.clone());
	}

	/**
	 * Recupera el parametro lastStateDateMax.
	 * @return la ultima fecha de cambio de estado maxima
	 */
	public Date getLastStateDateMax() {
		return (this.lastStateDateMax == null ? null : (Date)this.lastStateDateMax.clone());
	}

	/**
	 * Almacena el parametro lastStateDateMax.
	 * @param lastStateDateMax la ultima fecha de cambio de estado maxima
	 */
	public void setLastStateDateMax(Date lastStateDateMax) {
		this.lastStateDateMax = (lastStateDateMax == null ? null : (Date)lastStateDateMax.clone());
	}

	/**
	 * Recupera el parametro requesterFullName.
	 * @return nombre completo del usuario peticionario de la incidencia
	 */
	public String getRequesterFullName() {
		return requesterFullName;
	}

	/**
	 * Almacena el parametro requesterFullName.
	 * @param requesterFullName nombre completo del usuario peticionario de la incidencia
	 */
	public void setRequesterFullName(String requesterFullName) {
		this.requesterFullName = requesterFullName;
	}

	/**
	 * Recupera el parametro solverFullName.
	 * @return nombre completo del usuario solucionador de la incidencia
	 */
	public String getSolverFullName() {
		return solverFullName;
	}

	/**
	 * Almacena el parametro solverFullName.
	 * @param solverFullName nombre completo del usuario solucionador de la incidencia
	 */
	public void setSolverFullName(String solverFullName) {
		this.solverFullName = solverFullName;
	}

}
