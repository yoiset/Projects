package es.dgoj.rgiaj.business.repository;

import com.jeveris.persistence.hibernate.repository.IHibernateBaseRepository;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.TipoFirmaQueryBean;
import es.dgoj.rgiaj.business.model.TipoFirma;



public interface TipoFirmaRepository<T, ID> extends IHibernateBaseRepository<TipoFirma, Long> {

	/**
	 * Encuentra los Tipos de Firma que cumplan las condiciones.
	 * @param tipoFirmaQueryBean 
	 * @return SearchResults<TipoFirma>
	 */
	SearchResults<TipoFirma> getTiposFirma(TipoFirmaQueryBean tipoFirmaQueryBean);

	/**
	 * Encuentra un Tipo de Firma por su ID.
	 * @param id
	 * @return TipoFirma
	 */
	TipoFirma getTipoFirmaById(Long id);
	
	/**
	 * Encuentra un Tipo de Firma por su Codigo.
	 * @param codigo
	 * @return TipoFirma
	 */
	TipoFirma getTipoFirmaByCodigo(String codigo);
	
	/**
	 * Devuelve un Tipo de Firma por su codigo que no tenga un Id.
	 * @param id
	 * @param codigo
	 * @return TipoFirma
	 */
	TipoFirma getTipoFirmaByCodigoNoID(Long id, String codigo);

	/**
	 * Edicion de un Tipo de Firma.
	 * @param tipoFirma
	 * @return true, en caso de exito
	 */
	boolean updateTipoFirma(TipoFirma tipoFirma);

	/**
	 * Alta de un Tipo de Firma.
	 * @param tipoFirma
	 * @return true, en caso de exito
	 */
	boolean addTipoFirma(TipoFirma tipoFirma);
	
	/**
	 * Baja de un Tipo de Firma.
	 * @param id
	 * @return true, en caso de exito
	 */
	boolean deleteTipoFirma(Long id);

}