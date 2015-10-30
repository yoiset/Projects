package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;
import java.util.Date;

import es.dgoj.rgiaj.JugHistoricoBeanWS;

/**
 * @author ylopezconnectis
 *
 */
public class JugHistoricoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Long idHistoricoDescarga;
	
	private Date fechaDescarga;
	
	private String tipo;
	
	private ComunidadBean comunidad;
	
	private String confirmada;
	
	private Long ultimo;
	
	private String procedencia;

	
	
	public Long getIdHistoricoDescarga() {
		return idHistoricoDescarga;
	}

	public void setIdHistoricoDescarga(Long idHistoricoDescarga) {
		this.idHistoricoDescarga = idHistoricoDescarga;
	}

	public Date getFechaDescarga() {
		return fechaDescarga;
	}

	public void setFechaDescarga(Date fechaDescarga) {
		this.fechaDescarga = fechaDescarga;
	}

	public String getTipo() {
		if(tipo==null) return "-";
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getConfirmada() {
		if(confirmada==null) return "-";
		return confirmada;
	}

	public void setConfirmada(String confirmada) {
		this.confirmada = confirmada;
	}

	public ComunidadBean getComunidad() {
		return comunidad;
	}

	public void setComunidad(ComunidadBean comunidad) {
		this.comunidad = comunidad;
	}

	public Long getUltimo() {
		return ultimo;
	}

	public void setUltimo(Long ultimo) {
		this.ultimo = ultimo;
	}
	
	public String getComunidadDes(){
		if(comunidad!=null)
		  return comunidad.getDescripcion();
		else return "";
	}

	public JugHistoricoBeanWS toResponse() {
		JugHistoricoBeanWS result= new JugHistoricoBeanWS();
		if(this.ultimo!=null)
		  result.setUltimo(this.ultimo);
		
		result.setTipo(this.tipo);
		
		if(this.idHistoricoDescarga!=null)
		 result.setIdHistoricoDescarga(this.idHistoricoDescarga);
		
		result.setFechaDescarga(this.getFechaDescarga());
		
		if(this.comunidad!=null)
		  result.setComunidad(this.comunidad.toResponse());
		
		result.setConfirmada(this.getConfirmada());
		return result;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

}
