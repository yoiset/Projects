package es.dgoj.rgiaj.business.bean;

import java.util.Date;

import com.dgoj.core.common.entity.AbstractQueryEntity;

import es.dgoj.rgiaj.JugProhibicionQueryRequest;
import es.dgoj.rgiaj.business.bean.type.FormatoDescargaProhibidos;
import es.dgoj.rgiaj.business.bean.type.TipoDescargaProhibidos;

/**
 * @author ylopezconnectis
 *
 */
public class ProhibicionQueryBean  extends AbstractQueryEntity {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codComunidad;	
    private FormatoDescargaProhibidos formatoDescargaProhibidos;	
	private TipoDescargaProhibidos  tipoDescargaProhibidos;
	private Date desde;
	private Boolean service;
	
	
	/**
	 *  Valor numerico de ultima descarga
	 */
	private Long last;
	
	
	
	
	public ProhibicionQueryBean(String codComunidad,
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
	
	
	
	
	public ProhibicionQueryBean(String codComunidad) {
		super();
		this.codComunidad = codComunidad;
		setMaxResults(10);
		setFirstResult(0);
	}




	public ProhibicionQueryBean() {
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

	
	public static ProhibicionQueryBean toBean(JugProhibicionQueryRequest request){
		ProhibicionQueryBean bean= new ProhibicionQueryBean();
		if(request!=null){
			bean.setCalculateNumResults(request.isCalculateNumResults());
			bean.setCodComunidad(request.getCodComunidad());
			bean.setFirstResult(request.getFirstResult());
			bean.setFixDatetimes(request.isFixDatetimes());
			
			if(request.getMaxResults()!=0)
			  bean.setMaxResults(request.getMaxResults());
			if(request.getQueryTimeout()!=0)
			  bean.setQueryTimeout(request.getQueryTimeout());
			
			bean.setDesde(request.getDesde());
			
			bean.setFirstResult(request.getFirstResult());
			
			bean.setFormatoDescargaProhibidos(getFormatoDescargaProhibidos(request.getFormatoDescarga()));
			
			bean.setTipoDescargaProhibidos(getTipoDescargaProhibidos(request.getTipoDescarga()));
			
			bean.setService(request.isService());
			
			if(request.getLast()!=null && request.getLast()!=0)
			 bean.setLast(request.getLast());
			
		}	
		
		
		return bean;
	}

	
	public static FormatoDescargaProhibidos getFormatoDescargaProhibidos(String f){
		if(f!=null){
			if(FormatoDescargaProhibidos.XML.toString().equalsIgnoreCase(f))
				return FormatoDescargaProhibidos.XML;
			
			if(FormatoDescargaProhibidos.Texto.toString().equalsIgnoreCase(f))
				return FormatoDescargaProhibidos.Texto;
			
			if(FormatoDescargaProhibidos.Ambos.toString().equalsIgnoreCase(f))
				return FormatoDescargaProhibidos.Ambos;
		}
		
		return null;
	}
	
	public static TipoDescargaProhibidos getTipoDescargaProhibidos(String f){
		
		if(f!=null){
			if(TipoDescargaProhibidos.Completa.toString().equalsIgnoreCase(f))
				return TipoDescargaProhibidos.Completa;
			if(TipoDescargaProhibidos.Incremental.toString().equalsIgnoreCase(f))
				return TipoDescargaProhibidos.Incremental;
		}
		return null;
	}




	public Boolean isService() {
		return service;
	}




	public void setService(Boolean service) {
		this.service = service;
	}
	

}
