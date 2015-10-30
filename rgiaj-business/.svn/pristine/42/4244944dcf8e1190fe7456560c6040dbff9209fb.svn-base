package es.dgoj.rgiaj.business.beans;

import java.util.Date;

import com.dgoj.core.common.entity.AbstractQueryEntity;

import es.dgoj.rgiaj.JugProhibicionQueryRequest;
import es.dgoj.rgiaj.business.beans.type.FormatoDescargaProhibidos;
import es.dgoj.rgiaj.business.beans.type.TipoDescargaProhibidos;

/**
 * @author ylopezconnectis
 *
 */
public class JugProhibicionQueryBean  extends AbstractQueryEntity {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codComunidad;	
    private FormatoDescargaProhibidos formatoDescargaProhibidos;	
	private TipoDescargaProhibidos  tipoDescargaProhibidos;
	private Date desde;
	
	
	/**
	 *  Valor numerico de ultima descarga
	 */
	private Long last;
	
	
	
	
	public JugProhibicionQueryBean(String codComunidad,
			FormatoDescargaProhibidos formatoDescargaProhibidos,
			TipoDescargaProhibidos tipoDescargaProhibidos, Date desde, Long last) {
		super();
		this.codComunidad = codComunidad;
		this.formatoDescargaProhibidos = formatoDescargaProhibidos;
		this.tipoDescargaProhibidos = tipoDescargaProhibidos;
		this.desde=desde;
		this.last=last;
		setMaxResults(10);
		setFirstResult(0);
	}
	
	
	
	
	public JugProhibicionQueryBean(String codComunidad) {
		super();
		this.codComunidad = codComunidad;
		setMaxResults(10);
		setFirstResult(0);
	}




	public JugProhibicionQueryBean() {
		super();
		setMaxResults(10);
		setFirstResult(0);
	}

	public String getCodComunidad() {
		return codComunidad;
	}

	public void setCodComunidad(String codComunidad) {
		this.codComunidad = codComunidad;
	}

	public FormatoDescargaProhibidos getFormatoDescargaProhibidos() {
		return formatoDescargaProhibidos;
	}

	public void setFormatoDescargaProhibidos(
			FormatoDescargaProhibidos formatoDescargaProhibidos) {
		this.formatoDescargaProhibidos = formatoDescargaProhibidos;
	}

	public TipoDescargaProhibidos getTipoDescargaProhibidos() {
		return tipoDescargaProhibidos;
	}

	public void setTipoDescargaProhibidos(
			TipoDescargaProhibidos tipoDescargaProhibidos) {
		this.tipoDescargaProhibidos = tipoDescargaProhibidos;
	}

	public Long getLast() {
		return last;
	}

	public void setLast(Long last) {
		this.last = last;
	}




	public Date getDesde() {
		return desde;
	}




	public void setDesde(Date desde) {
		this.desde = desde;
	}

	
	public  es.dgoj.rgiaj.JugProhibicionQueryRequest toRequest(){
		 es.dgoj.rgiaj.JugProhibicionQueryRequest result= new JugProhibicionQueryRequest();
		 
		 result.setCalculateNumResults(this.isCalculateNumResults());
		 result.setCodComunidad(this.getCodComunidad());
		 result.setDesde(this.getDesde());
		 result.setFirstResult(this.getFirstResult());
		 result.setFixDatetimes(this.isFixDatetimes());
		 
		 if(this.getFormatoDescargaProhibidos()!=null)
		  result.setFormatoDescarga(this.getFormatoDescargaProhibidos().toString());
		 
		 if(this.getTipoDescargaProhibidos()!=null) 
		  result.setTipoDescarga(this.getTipoDescargaProhibidos().toString());
		 
		 if(this.getMaxResults()!=null)
		   result.setMaxResults(this.getMaxResults());
		
		 if(this.getQueryTimeout()!=null)
		   result.setQueryTimeout(this.getQueryTimeout());
		 
		 if(this.last!=null)
		   result.setLast(this.last);
		 
		 return result;
		 
	}
	
	

}
