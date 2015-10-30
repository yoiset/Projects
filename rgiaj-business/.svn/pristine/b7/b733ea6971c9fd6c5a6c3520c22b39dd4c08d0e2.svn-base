package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;
import java.util.Date;

import es.dgoj.rgiaj.JugProhibicionBeanWS;

public class JugProhibicionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	  /** begin info historico*/
	  private Date fechaDescarga;
	  private Long ultimo;
	  /** end info historico*/
	  
	  
	  private Long idComunidad;
	  private String codComunidad;
	  private String descripcionComunidad;
	
	  
	  
	  
	
	  
	  
	public JugProhibicionBean(Date fechaDescarga, Long ultimo) {
		super();
		this.fechaDescarga = fechaDescarga;
		this.ultimo = ultimo;
	}
	
	public JugProhibicionBean() {
		super();	
	}
	
	
	public Date getFechaDescarga() {
		return fechaDescarga;
	}
	public void setFechaDescarga(Date fechaDescarga) {
		this.fechaDescarga = fechaDescarga;
	}
	public Long getUltimo() {
		return ultimo;
	}
	public void setUltimo(Long ultimo) {
		this.ultimo = ultimo;
	}
	public String getCodComunidad() {
		return codComunidad;
	}
	public void setCodComunidad(String codComunidad) {
		this.codComunidad = codComunidad;
	}
	public String getDescripcionComunidad() {
		return descripcionComunidad;
	}
	public void setDescripcionComunidad(String descripcionComunidad) {
		this.descripcionComunidad = descripcionComunidad;
	}
	
	public boolean isNac(){
		if(codComunidad!=null && codComunidad.equalsIgnoreCase("NAC"))
			return true;
		return false;
	}

	public Long getIdComunidad() {
		return idComunidad;
	}

	public void setIdComunidad(Long idComunidad) {
		this.idComunidad = idComunidad;
	}
	
	public static JugProhibicionBean toBean(JugProhibicionBeanWS response){
		JugProhibicionBean bean= new JugProhibicionBean();
		if(response!=null){
			bean.setCodComunidad(response.getCodigo());
			bean.setDescripcionComunidad(response.getDescripcion());
			bean.setFechaDescarga(response.getFechaDescarga());
			bean.setIdComunidad(response.getIdComunidad());
			bean.setUltimo(response.getUltimo());
		}
		
		return bean;
	}
	  
	  
	  
	
	

}
