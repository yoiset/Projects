package es.dgoj.rgiaj.ws;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import es.dgoj.rgiaj.ComunidadBeanResponse;
import es.dgoj.rgiaj.ComunidadCertificadoBeanWS;
import es.dgoj.rgiaj.ComunidadQueryRequest;
import es.dgoj.rgiaj.ComunidadSearchResponse;
import es.dgoj.rgiaj.Fault;
import es.dgoj.rgiaj.FaultError;
import es.dgoj.rgiaj.JugHistoricoQueryRequest;
import es.dgoj.rgiaj.JugHistoricoSearchResponse;
import es.dgoj.rgiaj.JugProhibicionBeanWS;
import es.dgoj.rgiaj.JugProhibicionQueryRequest;
import es.dgoj.rgiaj.ProhibidosResponse;
import es.dgoj.rgiaj.UltimasDescargasConfirmadasResponse;
import es.dgoj.rgiaj.UsuarioQueryRequest;
import es.dgoj.rgiaj.business.bean.ComunidadBean;
import es.dgoj.rgiaj.business.bean.JugProhibicionBean;
import es.dgoj.rgiaj.business.bean.ProhibicionQueryBean;
import es.dgoj.rgiaj.business.bean.type.FormatoDescargaProhibidos;
import es.dgoj.rgiaj.business.bean.type.TipoDescargaProhibidos;
import es.dgoj.rgiaj.business.exceptions.JuegoExternoException;
import es.dgoj.rgiaj.business.service.IJugProhibicionService;


public class JuegoRGIAJController {
	
	@Autowired
	private IJugProhibicionService jugProhibicionService; 
	
//	@Autowired
//	private IComunidadService comunidadService;
//	
//	@Autowired
//	private IJugHistoricoDescargaService jugHistoricoDescargaService;
//	
//	@Autowired
//	private IComunidadUsuarioService comunidadUsuarioService;
	
	private static final Logger log = LoggerFactory.getLogger(JuegoRGIAJController.class);  
	
	
	
	
 /***************************************************************************************************
  *      Operaciones de IJugProhibicionService
  *    
  ***************************************************************************************************/
   
	/**
	 * @param request
	 * @return
	 * @throws Fault
	 */
	public ProhibidosResponse getProhibidos(JugProhibicionQueryRequest request) throws Fault{
		
		ProhibidosResponse response=new ProhibidosResponse();
		try {
			validateRequestProhibidos( request);
			byte[] flow= jugProhibicionService.getProhibidosList(ProhibicionQueryBean.toBean(request));
			response.setResultado(flow);
			return response;
		} catch (JuegoExternoException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			throw newFaul("Error Web Services Interno RGIAJ ", "Error intentando descargar archivo de Prohibidos ", "ER000") ;
//			TODO Aqui hay que poner el mensaje de la excepcion con el codigo y la desc	  
		}
		
	}
	
	
	private void validateRequestProhibidos(JugProhibicionQueryRequest request) throws Fault{
		  if( !(FormatoDescargaProhibidos.Ambos.toString().equals(request.getFormatoDescarga()) || FormatoDescargaProhibidos.XML.toString().equals(request.getFormatoDescarga()) || FormatoDescargaProhibidos.Texto.toString().equals(request.getFormatoDescarga())))
			  throw newFaul("Error Web Services RGIAJ ", "Formato de descarga del fichero Prohibidos erróneo. Solo se admite XML, Texto o Ambos", "ER001") ;
		  if( !(TipoDescargaProhibidos.Completa.toString().equals(request.getTipoDescarga()) || TipoDescargaProhibidos.Incremental.toString().equals(request.getTipoDescarga())))
			  throw newFaul("Error Web Services RGIAJ ", "Tipo de descarga erróneo. Sole se admite Incremental o Completa", "ER002") ;
		  
		  if(getComunidad(request.getCodComunidad())==null) {
			  throw newFaul("Error Web Services RGIAJ ", "El código de Comunidad enviado no corresponde a ninguna Comunidad", "ER003") ;
		  }
		  
	}


	/**
	 * @param request
	 * @return
	 * @throws Fault
	 */
	public boolean hayPendiente(JugProhibicionQueryRequest request)throws Fault{
		
		ProhibicionQueryBean queryBean=new ProhibicionQueryBean();
		queryBean.setCodComunidad(getComunidad(request.getCodComunidad()).getCodigo());
		boolean value= jugProhibicionService.hasPending(queryBean);
		
		return value;
	}
	
	
	/**
	 * @param request
	 * @return
	 * @throws Fault
	 */
	public UltimasDescargasConfirmadasResponse ultimaDescargaConfirmada(JugProhibicionQueryRequest request)throws Fault{
		
		ProhibicionQueryBean queryBean= ProhibicionQueryBean.toBean(request);
		
		List<JugProhibicionBean> list=null;
		try {
			list=jugProhibicionService.getUltimasDescargasConfirmadas(queryBean);
		} catch (JuegoExternoException e) {
			log.error(e.getMessage());
			throw newFaul(e.getMessage(),e.getMessage(),  " ") ;
		}
		UltimasDescargasConfirmadasResponse response= new UltimasDescargasConfirmadasResponse();
		if(list!=null){			
			for (JugProhibicionBean bean : list) {
				JugProhibicionBeanWS ultima=new JugProhibicionBeanWS();
				ultima.setCodigo(bean.getCodComunidad());
				ultima.setDescripcion(bean.getDescripcionComunidad());
				
				if(bean.getIdComunidad()!=null)
				 ultima.setIdComunidad(bean.getIdComunidad());
				
				ultima.setFechaDescarga(bean.getFechaDescarga());
				
				if(bean.getUltimo()!=null)
				 ultima.setUltimo(bean.getUltimo());
				
				
				response.getUltimasDescargas().add(ultima);
			}		
			
		}
		
		return response;
		
	}
	
	
	/** 
	 * @param request
	 * @throws Fault
	 */
	public void confirmarUltimaDescarga(JugProhibicionQueryRequest request) throws Fault{
		ProhibicionQueryBean queryBean=new ProhibicionQueryBean();
		queryBean.setCodComunidad(getComunidad(request.getCodComunidad()).getCodigo());
		try {
			jugProhibicionService.confirmHistoricoDescargas(queryBean);
		} catch (JuegoExternoException e) {
			log.error(e.getMessage());
			throw newFaul("", "", "") ;
			
		}
		
	}
	
	
	
	/** Retorna los datos de Comunidad dado el Usuario
	 * @param user
	 * @return
	 */
	public JugProhibicionBeanWS  getComunidadByUser(String user){
		
		JugProhibicionBeanWS result=new JugProhibicionBeanWS();
		JugProhibicionBean bean=jugProhibicionService.getComunidad(user);
		if(bean!=null){
			result.setCodigo(bean.getCodComunidad());
			result.setDescripcion(bean.getDescripcionComunidad());
			if(bean.getIdComunidad()!=null)
			  result.setIdComunidad(bean.getIdComunidad());
			
			result.setFechaDescarga(bean.getFechaDescarga());
			
			if(bean.getUltimo()!=null)
			 result.setUltimo(bean.getUltimo());
		}
		
		
		
		return result;
	}
	
	
	public void confirmHistoricoDescargasPendiente(JugProhibicionQueryRequest request){
		try {
			jugProhibicionService.confirmHistoricoDescargasPendiente(ProhibicionQueryBean.toBean(request));
		} catch (JuegoExternoException e) {
			// TODO Auto-generated catch block
			log.error("Error intentenado confirmar Descarga Pendiente: " + e);
		}
	}
		
	
	/**	 Devuelve la Comunidad Bea segun el código de la misma. Sino na la encuentra de devuelve un Fault.
	 * Es una forma de validar la comunidad recibida como param	 
	 * @param code
	 * @return
	 * @throws Fault
	 */
	private ComunidadBean getComunidad(String code) throws Fault{
		List<ComunidadBean> list=  jugProhibicionService.getComunidadList();
		for (ComunidadBean bean : list) 
			if(bean.getCodigo().equalsIgnoreCase(code))
				return bean;
		return null;
//		TODO Aqui hay que poner el mensaje de la excepcion con el codigo y la desc	  
	}	
	
	
 /***************************************************************************************************
  *      Operaciones de IComunidadService
  *    
  ***************************************************************************************************/
	
	
	/**
	 * @param request
	 * @return
	 */
	public ComunidadSearchResponse getCertificadoComunidad(ComunidadQueryRequest request){
	
		ComunidadSearchResponse result= new ComunidadSearchResponse();
//		ComunidadSearchResult bean= comunidadService.getCertificadoComunidad(ComunidadQueryBean.toBean(request));
//		if(bean.getHasNext()!=null)
//		 result.setHasNext(bean.getHasNext());
//		
//		if(bean.getLapse()!=null)
//		  result.setLapse(bean.getLapse());
//		
//		if(bean.getNumResults()!=null)
//		  result.setNumResults(bean.getNumResults());
//		
//		if(bean!=null){
//			List<ComunidadBean> list=   bean.getResults();
//			for (ComunidadBean c : list) {
//				es.dgoj.rgiaj.ComunidadCertificadoBean response= ComunidadCertificadoBean.toResponseBean((ComunidadCertificadoBean)c);
//				result.getListaComunidad().add(response);
//			}
//		}
//		
		return result;
	}
	
	
	/**
	 * @return
	 */
	public ComunidadBeanResponse  getComunidadList(){
		ComunidadBeanResponse result= new ComunidadBeanResponse();
//		List<ComunidadBean> list= comunidadService.getComunidadList();
//		for (ComunidadBean c : list) {
//			es.dgoj.rgiaj.ComunidadBean response= new es.dgoj.rgiaj.ComunidadBean();
//			response.setCodigo(c.getCodigo());
//			response.setIdComunidad(c.getIdComunidad());
//			response.setDescripcion(c.getDescripcion());
//			result.getComunidadBean().add(response);
//		}
//		
		
		return result;
	}
	
	
	/**
	 * @param request
	 */
	public void addCertificadoComunidad(ComunidadQueryRequest request){
		
//		try {
//			comunidadService.addCertificadoComunidad(ComunidadQueryBean.toBean(request));
//		} catch (JuegoExternoException e) {
//			// TODO Auto-generated catch block
//			log.error("Error intentando Calcular Hash y Finger del Certificado: " + e);
//		}
	}
	
	
	public boolean existOtrotCertificadoActivoComunidad(ComunidadQueryRequest request){
//		return comunidadService.existCertificadoActivoOtraComunidad(ComunidadQueryBean.toBean(request));
		return false;
	}
	
	
	public ComunidadCertificadoBeanWS getCertificadoActivoComunidad(ComunidadQueryRequest request){
//		ComunidadCertificadoBean bean=comunidadService.getCertificadoActivoComunidad(ComunidadQueryBean.toBean(request));
//		return ComunidadCertificadoBean.toResponseBean(bean);
		return null;
	}
	
	public void updateCertificadoComunidad(ComunidadQueryRequest request){
//		comunidadService.updateCertificadoComunidad(ComunidadQueryBean.toBean(request));
	}
	
	public boolean isCertificadoActivo(ComunidadQueryRequest request){
//		return comunidadService.isCertificadoActivo(ComunidadQueryBean.toBean(request));
		return false;
	}
	
	public void removeCertificadoComunidad(ComunidadQueryRequest request){
//		comunidadService.removeCertificadoComunidad(ComunidadQueryBean.toBean(request));
	}
	
	
	public boolean existCertificadoComunidad(ComunidadQueryRequest request){
//		return comunidadService.existCertificadoComunidad(ComunidadQueryBean.toBean(request));
		return false;
	}
	
	public boolean existCertificadoActivoOtraComunidad(ComunidadQueryRequest request){
//		return comunidadService.existCertificadoActivoOtraComunidad(ComunidadQueryBean.toBean(request));
		return false;
	}
	
	
	
	
	 /***************************************************************************************************
	  *      Operaciones de IJugHistoricoDescargaService
	  *    
	  ***************************************************************************************************/
		
	
	public JugHistoricoSearchResponse getHistorico(JugHistoricoQueryRequest request){
		   JugHistoricoSearchResponse result=new JugHistoricoSearchResponse();
//		   try {
//			   JugHistoricoSearchResult value=   jugHistoricoDescargaService.getHistorico(JugHistoricoQueryBean.toBean(request));
//			   if(value!=null){
//				   
//				   if(value.getNumResults()!=null)
//				     result.setNumResults(value.getNumResults());
//				   
//				   if(value.getLapse()!=null)
//				     result.setLapse(value.getLapse());
//				  
//				   if(value.getHasNext()!=null)
//				    result.setHasNext(value.getHasNext());
//				   
//				    List<es.dgoj.rgiaj.business.bean.JugHistoricoBean> list= value.getResults();
//				    if(list!=null && !list.isEmpty()){
//				    	for (es.dgoj.rgiaj.business.bean.JugHistoricoBean bean : list) 
//				    		result.getListaHistorico().add(bean.toResponse());
//						
//				    }
//				    
//			   }
//		} catch (Exception e) {
//			log.error("Error consultando histórico de descargas " + e);
//		}
//		   
		return result;
	}
	
	
	

	 /***************************************************************************************************
	  *      Operaciones de IComunidadUsuarioService
	  *    
	  ***************************************************************************************************/
	
	public boolean existUsuario(UsuarioQueryRequest request){
		
//		return comunidadUsuarioService.existUsuario(UsuarioQueryBean.toBean(request));
		return false;
		
	}
	
	
	
    public void addUsuario(UsuarioQueryRequest request){
		
//		comunidadUsuarioService.addUsuario(UsuarioQueryBean.toBean(request));
		
	} 
    
    public void editUsuario(UsuarioQueryRequest request){
		
//  		comunidadUsuarioService.editUsuario(UsuarioQueryBean.toBean(request));
  		
  	}
    
    public void removeUsuario(UsuarioQueryRequest request){
		
//  		comunidadUsuarioService.removeUsuario(UsuarioQueryBean.toBean(request));
  		
  	} 
    
     public ComunidadSearchResponse getUsuarioComunidad(ComunidadQueryRequest request){
    	 
    	  ComunidadSearchResponse result= new ComunidadSearchResponse();
		
//  		  ComunidadSearchResult value= comunidadUsuarioService.getUsuarioComunidad(ComunidadQueryBean.toBean(request));
//  		  if(value!=null){
//  			  if(value.getNumResults()!=null)
//  			   result.setNumResults(value.getNumResults());
//  			  if(value.getLapse()!=null)
//  			   result.setLapse(value.getLapse());
//  			  
//  			  if(value.getHasNext()!=null)
//  			   result.setHasNext(value.getHasNext());
//  			  
//  			  for (ComunidadBean bean : value.getResults()) 
//  				result.getListaUsuario().add(UsuarioComunidadBean.toResponse((UsuarioComunidadBean)bean));
//			
//  		  }
  		  
  		  return result;
  		
  	} 
	
	
	/** Devuelve el Formato de Descarga Enum segun el String que se pasa.
	 * Sino corresponde con ninguno devuelve un Faul
	 * Es una forma de validar el formato de descarga recibido	como param 
	 * @param param
	 * @return
	 * @throws Fault
	 */
	private FormatoDescargaProhibidos getFormatoDescarga(String param) throws Fault{
		if(FormatoDescargaProhibidos.XML.toString().equals(param))
			return FormatoDescargaProhibidos.XML;
		if(FormatoDescargaProhibidos.Texto.toString().equals(param))
			return FormatoDescargaProhibidos.Texto;
		if(FormatoDescargaProhibidos.Ambos.toString().equals(param))
			return FormatoDescargaProhibidos.Ambos;
		else throw newFaul("", "", "") ;	
//		TODO Aqui hay que poner el mensaje de la excepcion con el codigo y la desc
	}
	
	
	/** Devuelve el Tipo de Descraga Enum segun el String que se pasa.
	 * Sino corresponde con ninguno devuelve un Faul
	 * Es una forma de validar el Tipo de Descarga revisida como param	 
	 * @param tipo
	 * @return
	 * @throws Fault
	 */
	private TipoDescargaProhibidos getTipoDescarga(String tipo)throws Fault{
		if(TipoDescargaProhibidos.Completa.toString().equals(tipo))
		 return TipoDescargaProhibidos.Completa;
		
		if(TipoDescargaProhibidos.Incremental.toString().equals(tipo))
		  return TipoDescargaProhibidos.Incremental;
		else  throw newFaul("", "", "") ;	 
//	TODO Aqui hay que poner el mensaje de la excepcion con el codigo y la desc	  
		 
	}
	
	
	/** Método para generar Faults de este WebServices.
	 * @param messege  Mensahe de la excepcion capturada
	 * @param faultMessage   Descripcion del mensaje a enviar al cliente web service
	 * @param codeMessage Codigo del mensaje a enviar al cliente web service
	 * @return
	 */
	public Fault newFaul(String messege, String faultMessage, String codeMessage){		
		FaultError error=new FaultError();
		error.setCodigoError(codeMessage);
		error.setDescError(faultMessage);
		return new Fault(messege, error);
	}

}
