package es.dgoj.rgiaj.business.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ComunidadBeanReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
   private Long id;
	
   private String descripcion;
   
   private boolean indActivo;
   
   private List<CertificadoReport> listCertificado;
   
   private List<UsuarioReport> listUsuario;
   
   private List<JugHistoricoBean> listHistorico;
   

	public ComunidadBeanReport() {
	     super();
	     this.listCertificado=new ArrayList<CertificadoReport>();
	     this.listUsuario=new ArrayList<UsuarioReport>();
	     this.listHistorico= new ArrayList<JugHistoricoBean>();
	// TODO Auto-generated constructor stub
    }

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public boolean isIndActivo() {
		return indActivo;
	}
	
	public void setIndActivo(boolean indActivo) {
		this.indActivo = indActivo;
	}
	
	public List<CertificadoReport> getListCertificado() {
		return listCertificado;
	}
	
	public void setListCertificado(List<CertificadoReport> listCertificado) {
		this.listCertificado = listCertificado;
	}
	
	public List<UsuarioReport> getListUsuario() {
		return listUsuario;
	}
	
	public void setListUsuario(List<UsuarioReport> listUsuario) {
		this.listUsuario = listUsuario;
	}
	
    /** Devuelve la lista de Certificado para el Reporte
     * @return
     */
    public JRDataSource getCertificadosDS(){ 
	    return new JRBeanCollectionDataSource(this.getListCertificado());   
	}
    
    
    /** Devuelve la lista de Usuarios para el Reporte
     * @return
     */
    public JRDataSource getUsersDS(){       
		
	    return new JRBeanCollectionDataSource(this.getListUsuario());   
	}

	public List<JugHistoricoBean> getListHistorico() {
		return listHistorico;
	}

	public void setListHistorico(List<JugHistoricoBean> listHistorico) {
		this.listHistorico = listHistorico;
	}
	
	
	public JRDataSource getHistoricosDS(){       
			
		    return new JRBeanCollectionDataSource(this.getListHistorico());   
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ComunidadBeanReport other = (ComunidadBeanReport) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
		
		

}
