package es.dgoj.rgiaj.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * Formulario de incidencia, usado cuando en peticiones desde la vista manageIssue, 
 * issueBox, showIssue y startNewIssue.
 * @author dbeltran
 * @version 1.0
 */
@Configurable
public final class IssueForm {

	/**
	 * Identificador de la incidencia.
	 */
	private Long issueId;

	/**
	 * Estado de la incidencia.
	 */
	private String state;

	/**
	 * Descripcion del estado de la incidencia.
	 */
	private String stateText;
	
	/**
	 * Importancia de la incidencia.
	 */
	@NotEmpty
	private String importance;

	/**
	 * Descripcion de la importancia de la incidencia.
	 */
	private String importanceText;
	
	/**
	 * Descripcion del ambito de la incidencia.
	 */
	@NotNull
	private Long scopeId;
	
	/**
	 * Identificador del tipo de la incidencia.
	 */
	@NotNull
	private Long issueTypeId;

	/**
	 * Resumen de la incidencia.
	 */
	@NotEmpty
	private String summary;

	/**
	 * Descripcion de la incidencia.
	 */
	private String description;

	/**
	 * Usuario que abrio la incidencia.
	 */
	private String requesterUsername;

	/**
	 * Nombre completo del usuario que abrio la incidencia.
	 */
	private String requesterFullName;
	
	/**
	 * Usuario que resolvio la incidencia.
	 */
	@NotEmpty
	private String solverUsername;

	/**
	 * Nombre completo del usuario que resolvio la incidencia.
	 */
	@NotEmpty
	private String solverFullName;
	
	/**
	 * Prioridad de la incidencia.
	 */
	@NotEmpty
	private String priority;

	/**
	 * Descripcion de la prioridad de la incidencia.
	 */
	private String priorityText;
	
	/**
	 * Accion de la incidencia.
	 */
	private String issueAction;
	
	/**
	 * Comentario de la incidencia.
	 */
	private String[] comment;
	
	/**
	 * Nueva prioridad definida para la incidencia.
	 */
	private String newPriority;

	/**
	 * Nuevo usuario que tiene que resolver la incidencia.
	 */
	private String newSolverUsername;
	
	/**
	 * Recupera el parametro issueId.
	 * @return identificador de incidencia.
	 */
	public Long getIssueId() {
		return this.issueId;
	}

	/**
	 * Almacena el paramentro issueId.
	 * @param issueId identificador de la incidencia
	 */
	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	/**
	 * Recupera el parametro state.
	 * @return codigo de estado de la incidencia
	 */
	public String getState() {
		return this.state;
	}

	/**
	 * Almacena el parametro state.
	 * @param state codigo de estado de la incidencia
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Recupera el paramentro stateText.
	 * @return descripcion del estado de la incidencia
	 */
	public String getStateText() {
		return this.stateText;
	}

	/**
	 * Almacena el parametro stateText.
	 * @param stateText descripcion del estado de la incidencia
	 */
	public void setStateText(String stateText) {
		this.stateText = stateText;
	}
	
	/**
	 * Recupera el parametro importance.
	 * @return importancia de la incidencia
	 */
	public String getImportance() {
		return this.importance;
	}

	/**
	 * Almacena el parametro importance.
	 * @param importance importancia de la incidencia
	 */
	public void setImportance(String importance) {
		this.importance = importance;
	}

	/**
	 * Recupera el parametro importanceText.
	 * @return descripcion de la importancia de la incidencia
	 */
	public String getImportanceText() {
		return this.importanceText;
	}

	/**
	 * Almacena el parametro importanceText.
	 * @param importanceText descripcion de la importancia de la incidencia
	 */
	public void setImportanceText(String importanceText) {
		this.importanceText = importanceText;
	}

	/**
	 * Recupera el parametro scopeId.
	 * @return identificador de ambito de la incidencia
	 */
	public Long getScopeId() {
		return this.scopeId;
	}

	/**
	 * Almacena el parametro scopeId.
	 * @param scopeId identificador de ambito de la incidencia
	 */
	public void setScopeId(Long scopeId) {
		this.scopeId = scopeId;
	}

	/**
	 * Recupera el parametro issueTypeId.
	 * @return identificador de tipo de incidencia
	 */
	public Long getIssueTypeId() {
		return this.issueTypeId;
	}

	/**
	 * Almacena el parametro issueTypeId.
	 * @param issueTypeId identificador de tipo de incidencia
	 */
	public void setIssueTypeId(Long issueTypeId) {
		this.issueTypeId = issueTypeId;
	}

	/**
	 * Recupera el parametro summary.
	 * @return columna Resumen de la incidencia
	 */
	public String getSummary() {
		return this.summary;
	}

	/**
	 * Almacena el parametro summary.
	 * @param summary columna Resumen de la incidencia
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * Recupera el parametro description.
	 * @return Descripcion de la incidencia
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Almacena el paramentro description.
	 * @param description Descripcion de la incidencia
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Recupera el parametro requesterUsername.
	 * @return nombre del Peticionario de la incidencia
	 */
	public String getRequesterUsername() {
		return this.requesterUsername;
	}

	/**
	 * Almacena el parametro requesterUsername.
	 * @param requesterUsername nombre del Peticionario de la incidencia
	 */
	public void setRequesterUsername(String requesterUsername) {
		this.requesterUsername = requesterUsername;
	}

	/**
	 * Recupera el parametro requesterFullName.
	 * @return nombre completo del Peticionario de la incidencia
	 */
	public String getRequesterFullName() {
		return this.requesterFullName;
	}

	/**
	 * Almacena el parametro requesterFullName.
	 * @param requesterFullName nombre completo del Peticionario de la incidencia
	 */
	public void setRequesterFullName(String requesterFullName) {
		this.requesterFullName = requesterFullName;
	}

	/**
	 * Recupera el parametro solverUsername.
	 * @return nombre del usuario Solucionador de la incidencia
	 */
	public String getSolverUsername() {
		return this.solverUsername;
	}

	/**
	 * Almacena el parametro solverUsername.
	 * @param solverUsername nombre del usuario Solucionador de la incidencia
	 */
	public void setSolverUsername(String solverUsername) {
		this.solverUsername = solverUsername;
	}

	/**
	 * Recuper el parametro solverFullName.
	 * @return nombre completo del usuario Solucionador de la incidencia
	 */
	public String getSolverFullName() {
		return this.solverFullName;
	}

	/**
	 * Almacena el parametro solverFullName.
	 * @param solverFullName nombre completo del usuario Solucionador de la incidencia
	 */
	public void setSolverFullName(String solverFullName) {
		this.solverFullName = solverFullName;
	}

	/**
	 * Recupera el parametro priority.
	 * @return prioridad de la incidencia
	 */
	public String getPriority() {
		return this.priority;
	}

	/**
	 * Almacena el parametro priority.
	 * @param priority prioridad de la incidencia
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * Recupera el paramentro priorityText.
	 * @return descripcion de la prioridad de la incidencia
	 */
	public String getPriorityText() {
		return this.priorityText;
	}

	/**
	 * Almacena el parametro priorityText.
	 * @param priorityText descripcion de la prioridad de la incidencia
	 */
	public void setPriorityText(String priorityText) {
		this.priorityText = priorityText;
	}

	/**
	 * Recupera el parametro issueAction.
	 * @return accion de la incidencia
	 */
	public String getIssueAction() {
		return this.issueAction;
	}

	/**
	 * Almacena el paramentro issueAction.
	 * @param issueAction accion de la incidencia
	 */
	public void setIssueAction(String issueAction) {
		this.issueAction = issueAction;
	}

	/**
	 * Recupera el parametro comment.
	 * @return comentarios asociados a la incidencia
	 */
	public String[] getComment() {
		return (comment == null ? null : this.comment.clone());
	}

	/**
	 * Almacena el paramentro comment.
	 * @param comment comentarios asociados a la incidencia
	 */
	public void setComment(String[] comment) {
		this.comment = comment.clone();
	}

	/**
	 * Recupera el parametro newPriority.
	 * @return Nueva prioridad definida para la incidencia
	 */
	public String getNewPriority() {
		return this.newPriority;
	}

	/**
	 * Almacena el parametro newPriority.
	 * @param newPriority Nueva prioridad definida para la incidencia
	 */
	public void setNewPriority(String newPriority) {
		this.newPriority = newPriority;
	}

	/**
	 * Recupera el paramentro newSolverUsername.
	 * @return Nuevo usuario que tiene que resolver la incidencia
	 */
	public String getNewSolverUsername() {
		return this.newSolverUsername;
	}

	/**
	 * Almacena el paramentro newSolverUsername.
	 * @param newSolverUsername Nuevo usuario que tiene que resolver la incidencia
	 */
	public void setNewSolverUsername(String newSolverUsername) {
		this.newSolverUsername = newSolverUsername;
	}
	
}
