package es.gob.cnjuego.ws.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.gob.cnjuego.ws.entity.DNIDebugIdentidad;

public class DNIDebugIdentidadDAO  {

	@PersistenceContext
	EntityManager manager;
	
	List<String> listaCacheDebugIdentidades;
	
	/**
	 * Lee los valores de la tabla de identidades de debug y los almacena en una cach�
	 * en memoria. La aplicaci�n puede invocar este m�todo para recargar la cach�.
	 */
	@SuppressWarnings("unchecked")
	public void reloadListaCacheDebugIdentidades(){
		List<String> listaNif = null;
		Query query = manager.createQuery("SELECT d FROM DNIDebugIdentidad d ORDER BY d.dni");
		List<DNIDebugIdentidad> lista = query.getResultList();

		if (lista != null && !lista.isEmpty()){
			listaNif = new ArrayList<String>();
			for(DNIDebugIdentidad it : lista) {
				listaNif.add(it.getDni());
			}
		}
		this.setListaCacheDebugIdentidades(listaNif);
	}

	/**
	 * Retorna la lista de  de la aplicaci�n.
	 * Los par�metros se guardan en la base de datos, pero se gestionan en
	 * una cach� para acelerar el acceso. 
	 */
	public List<String> getListaDebugIdentidades() {
		if (this.getListaCacheDebugIdentidades() == null) {
			this.reloadListaCacheDebugIdentidades();
		}
		return this.getListaCacheDebugIdentidades();
	}
	
	
	
	public List<String> getListaCacheDebugIdentidades() {
		return listaCacheDebugIdentidades;
	}

	public void setListaCacheDebugIdentidades(List<String> listaCacheDebugIdentidades) {
		this.listaCacheDebugIdentidades = listaCacheDebugIdentidades;
	}
	
}
