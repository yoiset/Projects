package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import es.dgoj.rgiaj.business.model.JugProhibicion;

public class ComunidadProviciaReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private int total;
	private List<ComunidadReport> listComunidad;
	
	
	
	
	
	
	public ComunidadProviciaReport() {
		super();
		this.listComunidad = new ArrayList<ComunidadReport>();
	}

	public int getTotal() {
		
		if(total==0) 
			if(listComunidad!=null){
				for (ComunidadReport com : listComunidad) 
					total+= com.getTotal();
			}
		
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<ComunidadReport> getListComunidad() {
		return listComunidad;
	}

	public void setListComunidad(List<ComunidadReport> listComunidad) {
		this.listComunidad = listComunidad;
	}
	
	
	/** Devuelve la lista de Comunidad con Provincias para el reporte
     * @return
     */
    public JRDataSource getComunidadesDS(){ 
	    return new JRBeanCollectionDataSource(this.getListComunidad());   
	}
    
    public void addComunidadReport(JugProhibicion prohibicon){
    	ComunidadReport comunidadReport= new ComunidadReport();
    	
    	if(prohibicon.getJugPersona()!=null & prohibicon.getJugPersona().getJugProvincia()!=null){
    		comunidadReport.setCodigo(prohibicon.getJugPersona().getJugProvincia().getJugComunidad().getCodigo());
        	comunidadReport.setDescripcion(prohibicon.getJugPersona().getJugProvincia().getJugComunidad().getDescripcion());	
    	} else comunidadReport.setCodigo("");
    	
    	if(!listComunidad.contains(comunidadReport)){
    		listComunidad.add(comunidadReport);
    		comunidadReport.addProvincia(prohibicon);
    	} else listComunidad.get(listComunidad.indexOf(comunidadReport)).addProvincia(prohibicon);
    	
    	
    	
    }
    
    public void setOrderComunidadAsc(){
    	 Collections.sort(listComunidad);
    	 for (ComunidadReport bean : listComunidad) {
			bean.setOrderProvinciaAsc();
		}
    	 
    }
    
	
	
}
