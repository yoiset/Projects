package es.dgoj.rgiaj.business.service;

import es.dgoj.rgiaj.business.bean.ComunidadQueryBean;
import es.dgoj.rgiaj.business.bean.ComunidadSearchResult;

public interface IComunidadUsuarioService {
	
	/**
	 * @param query
	 * @return
	 */
	public boolean existUsuario(ComunidadQueryBean query);
	
	
	
	/**
	 * @param query
	 * @return
	 */
	public void addUsuario(ComunidadQueryBean query);
	
	
	/**
	 * @param query
	 * @return
	 */
	public void editUsuario(ComunidadQueryBean query);
	
	
	/**
	 * @param query
	 * @return
	 */
	public void removeUsuario(ComunidadQueryBean query);
	
	/**
	 * @param query
	 * @return
	 */
	public ComunidadSearchResult getUsuarioComunidad(ComunidadQueryBean query);

}
