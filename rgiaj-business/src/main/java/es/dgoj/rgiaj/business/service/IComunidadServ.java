package es.dgoj.rgiaj.business.service;

import java.util.List;


import es.dgoj.rgiaj.business.beans.ComunidadBean;
import es.dgoj.rgiaj.business.beans.ComunidadCertificadoBean;
import es.dgoj.rgiaj.business.beans.ComunidadQueryBean;
import es.dgoj.rgiaj.business.beans.ComunidadSearchResult;
import es.dgoj.rgiaj.business.exceptions.JuegoExternoException;

/**
 * @author ylopezconnectis
 *
 */
/**
 * @author ylopezconnectis
 *
 */
public interface IComunidadServ {/**
	 * @param quey
	 * @return
	 */
	public ComunidadSearchResult getCertificadoComunidad( ComunidadQueryBean quey);
	
	
	
	/**Obtiene la lista de Comunidades
	 * @return
	 */
	public List<ComunidadBean> getComunidadList();
	
	
	/**
	 * @param query
	 */
	public void addCertificadoComunidad(ComunidadQueryBean query)throws JuegoExternoException;
	
	/** Calcula si existe otro certificado activo en la comunidad
	 * @param query
	 * @return
	 */
	public boolean existOtrotCertificadoActivoComunidad(ComunidadQueryBean query);
	
	/** Devuelve si la comunidad tiene un certificado activo aparte del que se le pasa
	 * @param query
	 * @return
	 */
	public ComunidadCertificadoBean getCertificadoActivoComunidad(ComunidadQueryBean query) ;
	
	
	/**
	 * @param query
	 */
	public void updateCertificadoComunidad(ComunidadQueryBean query);
	
	
	/** Calcula si el certificado esta activo
	 * @return
	 */
	public boolean isCertificadoActivo(ComunidadQueryBean query);
	
	
	/**
	 * @param query
	 */
	public void removeCertificadoComunidad(ComunidadQueryBean query);
	
	/** Calcula si ya existe el certificado en la comunida
	 * @param query
	 * @return
	 */
	public boolean existCertificadoComunidad(ComunidadQueryBean query);
	
	
	/** Calcula si existe el certificado activo en otra comunidad
	 * @param query
	 * @return
	 */
	public boolean existCertificadoActivoOtraComunidad(ComunidadQueryBean query);
	
	
	/**
	 * @param username
	 * @param comunidadBean
	 * @param reportType
	 * @param reportName
	 * @param reportTitle
	 * @return
	 */
	public byte[] exportComunidad(String username, ComunidadQueryBean query, String reportType, String reportName, String reportTitle);
	
	
	public List<ComunidadBean> getComunidadListWithOutNAC();
}
