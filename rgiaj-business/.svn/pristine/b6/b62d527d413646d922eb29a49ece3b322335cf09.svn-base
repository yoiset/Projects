package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;

public class ProvinciaReport implements Serializable, Comparable<ProvinciaReport>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String descripcion;
	private int total;
	
	
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public void incTotal(){
		total++;
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
		ProvinciaReport other = (ProvinciaReport) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	@Override
	public int compareTo(ProvinciaReport o) {
		// TODO Auto-generated method stub
      if(codigo==null || codigo.equalsIgnoreCase("")) return 1;
		
		if(o.getCodigo()==null || o.getCodigo().equalsIgnoreCase("")) return -1;
		
		return Integer.parseInt(codigo) - Integer.parseInt(o.getCodigo());
		
	}

}
