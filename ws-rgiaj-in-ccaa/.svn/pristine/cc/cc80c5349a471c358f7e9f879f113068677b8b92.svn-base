package es.dgoj.rgiaj.business.bean;

import java.util.Date;

import com.dgoj.core.common.entity.AbstractQueryEntity;

import es.dgoj.rgiaj.ComunidadQueryRequest;

public class ComunidadQueryBean extends AbstractQueryEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codeComunidad;
	private Long idComunidad;
	private String descripcion;
	private Integer activo;
	
	/**Start fields related with certify*/
	   private Date fechaDesde;
	   
	   private String certificado;
	   private String hashCertificado;
	   private Integer indActivo;
	   private Date fechaHasta;
	   private Date fechaCarga;
	   private String fingerSha1;
	  
	  	   	  
	/**End fields related with certify*/

	     
	   
	public String getCodeComunidad() {
		return codeComunidad;
	}

	public void setCodeComunidad(String codeComunidad) {
		this.codeComunidad = codeComunidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
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

	public Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
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

	

	public Long getIdComunidad() {
		return idComunidad;
	}

	public void setIdComunidad(Long idComunidad) {
		this.idComunidad = idComunidad;
	}
	
	
	public static ComunidadQueryBean toBean(ComunidadQueryRequest request){
		ComunidadQueryBean bean=new ComunidadQueryBean();
		if(request!=null){
			bean.setActivo(request.getActivo());
			bean.setCalculateNumResults(request.isCalculateNumResults());
			bean.setCertificado(request.getCertificado());
			bean.setCodeComunidad(request.getCodComunidad());
			bean.setDescripcion(request.getDescripcion());
			bean.setFechaCarga(request.getFechaCarga());
			bean.setFechaDesde(request.getFechaDesde());
			bean.setFechaHasta(request.getFechaHasta());
			bean.setFingerSha1(request.getFingerSha1());
			bean.setFirstResult(request.getFirstResult());
			bean.setFixDatetimes(request.isFixDatetimes());
			bean.setHashCertificado(request.getHashCertificado());
			bean.setIdComunidad(request.getIdComunidad());
			bean.setIndActivo(request.getIndActivo());
			bean.setMaxResults(request.getMaxResults());
			bean.setQueryTimeout(request.getQueryTimeout());
		}
		
		return bean;
	}
	
   
	

}
