package es.dgoj.rgiaj.business.bean;

import java.io.Serializable;
import java.util.Date;


import es.dgoj.rgiaj.ComunidadCertificadoBeanWS;
import es.dgoj.rgiaj.business.model.JugComunidadCertificado;

public class ComunidadCertificadoBean extends ComunidadBean implements Serializable  {
	
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	   
	   
	   private Date fechaDesde;	   
	   private String certificado;
	   private String hashCertificado;
	   private Integer indActivo;
	   private Date fechaHasta;
	   private Date fechaCarga;
	   private String fingerSha1;
	
	
	public ComunidadCertificadoBean(Long idComunidad, String codigo, String descripcion) {
			super(idComunidad, codigo, descripcion);
			// TODO Auto-generated constructor stub
	}  
	   
	   
	
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	public String getHashCertificado() {
		return hashCertificado;
	}
	public void setHashCertificado(String hashCertificado) {
		this.hashCertificado = hashCertificado;
	}
	public Integer getIndActivo() {
		return indActivo;
	}
	public void setIndActivo(Integer indActivo) {
		this.indActivo = indActivo;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public Date getFechaCarga() {
		return fechaCarga;
	}
	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}
	public String getFingerSha1() {
		return fingerSha1;
	}
	public void setFingerSha1(String fingerSha1) {
		this.fingerSha1 = fingerSha1;
	}
	
	public static ComunidadCertificadoBean getBean(JugComunidadCertificado entity){
		ComunidadCertificadoBean bean=new ComunidadCertificadoBean(entity.getJugComunidad().getId(), entity.getJugComunidad().getCodigo(), entity.getJugComunidad().getDescripcion());
		
		bean.setFechaDesde(entity.getId().getFechaDesde());
		
		bean.setCertificado(entity.getCertificado());
		bean.setFechaCarga(entity.getFechaCarga());		
		bean.setFechaHasta(entity.getFechaHasta());
		bean.setFingerSha1(entity.getFingerSha1());
		bean.setHashCertificado(entity.getHashCertificado());
		
//		if(entity.getIndActivo()!=null)
		 bean.setIndActivo((entity.getIndActivo()));
          		
		return bean;
	}
	
	
	
	public static ComunidadCertificadoBeanWS toResponseBean(ComunidadCertificadoBean bean){
		ComunidadCertificadoBeanWS result= new ComunidadCertificadoBeanWS();
		if(bean!=null){
			result.setCertificado(bean.getCertificado());
			result.setCodigo(bean.getCodigo());
			result.setDescripcion(bean.getDescripcion());
			result.setFechaCarga(bean.getFechaCarga());
			result.setFechaDesde(bean.getFechaDesde());
			result.setFechaHasta(bean.getFechaHasta());
			result.setFingerSha1(bean.getFingerSha1());
			result.setHashCertificado(bean.getHashCertificado());
			
			if(bean.getIdComunidad()!=null)
			  result.setIdComunidad(bean.getIdComunidad());
			
			if(bean.getIndActivo()!=null)
			 result.setIndActivo(bean.getIndActivo());
		}
		
		return result;
	}
	

}
