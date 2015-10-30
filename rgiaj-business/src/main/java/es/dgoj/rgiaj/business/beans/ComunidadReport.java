package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import es.dgoj.rgiaj.business.model.JugProhibicion;

public class ComunidadReport  implements   Serializable, Comparable<ComunidadReport>{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigo;
	private String descripcion;
	private List<ProvinciaReport> listProvincia;
	private int total;

	
	
	public ComunidadReport() {
		super();
		listProvincia= new ArrayList<ProvinciaReport>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ProvinciaReport> getListProvincia() {
		return listProvincia;
	}

	public void setListProvincia(List<ProvinciaReport> listProvincia) {
		this.listProvincia = listProvincia;
	}

	public int getTotal() {
		
		if(total==0) 
			if(listProvincia!=null){
				for (ProvinciaReport p : listProvincia) 
					total+= p.getTotal();
			}
		
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public void addProvincia(JugProhibicion prohibicon){
		ProvinciaReport provincia= new ProvinciaReport();
		if(prohibicon.getJugPersona()!=null && prohibicon.getJugPersona().getJugProvincia()!=null){
			provincia.setCodigo(prohibicon.getJugPersona().getJugProvincia().getCodigo());
			provincia.setDescripcion(prohibicon.getJugPersona().getJugProvincia().getDescripcion());
		}else provincia.setCodigo("");
		
		
		if(!listProvincia.contains(provincia)){
			provincia.incTotal();
			listProvincia.add(provincia);
		}else listProvincia.get(listProvincia.indexOf(provincia)).incTotal();
		
	}
	
	
	
	/** Devuelve la lista de Provincias para el reporte 
     * @return
     */
    public JRDataSource getProvinciasDS(){ 
	    return new JRBeanCollectionDataSource(this.getListProvincia());   
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComunidadReport other = (ComunidadReport) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}



	@Override
	public int compareTo(ComunidadReport o) {
		// TODO Auto-generated method stub
		if(codigo==null || codigo.equalsIgnoreCase("")) return 1;
		
		if(o.getCodigo()==null || o.getCodigo().equalsIgnoreCase("")) return -1;
		
		return Integer.parseInt(codigo) - Integer.parseInt(o.getCodigo());
		
	}
	
	
	public void setOrderProvinciaAsc(){
		Collections.sort(listProvincia);
	}
}
