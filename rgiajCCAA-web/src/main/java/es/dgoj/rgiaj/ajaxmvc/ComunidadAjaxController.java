package es.dgoj.rgiaj.ajaxmvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.dgoj.core.common.entity.SearchResult;
import com.dgoj.core.common.util.WriteUtil;
import com.dgoj.sprmvc.ajax.AbstractPaginatedGridAjaxController;
import com.dgoj.sprmvc.json.JSONUtil;
import com.dgoj.sprmvc.web.util.RequestUtil;
import com.jeveris.core.exception.impl.CoreException;

import es.dgoj.rgiaj.bean.CertificateBean;
import es.dgoj.rgiaj.business.beans.ComunidadBean;
import es.dgoj.rgiaj.business.beans.ComunidadCertificadoBean;
import es.dgoj.rgiaj.business.beans.ComunidadQueryBean;
import es.dgoj.rgiaj.business.beans.ComunidadSearchResult;
import es.dgoj.rgiaj.business.beans.UsuarioComunidadBean;
import es.dgoj.rgiaj.business.beans.UsuarioQueryBean;
import es.dgoj.rgiaj.business.exceptions.JuegoExternoException;
import es.dgoj.rgiaj.business.service.IComunidadServ;
import es.dgoj.rgiaj.business.service.IComunidadUsuarioServ;
import es.dgoj.rgiaj.business.util.UtilidadCertificados;
import es.dgoj.rgiaj.encrypt.TimestampEncrypter;
import es.dgoj.rgiaj.form.AttachmentForm;
import es.dgoj.rgiaj.util.Utilidades;

@Controller
@RequestMapping(value="/comunidadAjax/*")
public class ComunidadAjaxController  extends AbstractPaginatedGridAjaxController<ComunidadBean, ComunidadQueryBean> {
	
	/**
	 * Servicio de acceso al contenedor de mensajes de spring.
	 */
	@Resource
	private MessageSource messageSource;	
	
	@Resource  IComunidadServ comunidadService;
	
	@Resource IComunidadUsuarioServ  comunidadUsuarioService;
	
	/**
	 * Tiempo de sesion de la vista
	 */
	@Resource(name="viewTimeout")
	private Long viewTimeout;
	
	private static final Logger log = LoggerFactory.getLogger(ComunidadAjaxController.class);  
	
	
	@ResponseBody
	@RequestMapping(value = "/comunidadAjax/start")
	public String start(HttpServletRequest request,HttpServletResponse response ) {
		
				return super.process(request, response);
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/comunidadAjax/newCertificate")
	public String newCertificate(HttpServletRequest request, HttpServletResponse response) {
		
		ComunidadQueryBean query= new ComunidadQueryBean();
		query.setIdComunidad(getIdComunidad(request));
		query.setCertificado(getCertificado(request));
		query.setIndActivo(getActivo(request));
		query.setFechaCarga(getFechaCargaCert(request));
		
		
		if(comunidadService.existCertificadoActivoOtraComunidad(query))
			return "ERROR. Ya existe este certificado activo en otra Comunidad";
		
		if(comunidadService.existCertificadoComunidad(query))
			return "ERROR. Ya existe este certificado en la Comunidad";
		
		if(comunidadService.existOtrotCertificadoActivoComunidad(query)){
			boolean notify= getNotify(request);
			if(!notify)
				return "NOTIFY. Ya existe otro certificado activo en la Comunidad. ¿Desea poner el mismo como activo?";
		}
		try {
			comunidadService.addCertificadoComunidad(query);
		} catch (JuegoExternoException e) {
			// TODO Auto-generated catch block
			log.error("Error intentando guardar el certificado" + e);
			return "ERROR. El certificado introducido no es válido ";
		}
		
		
		// Informacion para el renderizado de la pagina
					
		return super.process(request, response);
		

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/comunidadAjax/editCertificate")
	public String editCertificate(HttpServletRequest request, HttpServletResponse response) {
		
		ComunidadQueryBean query= new ComunidadQueryBean();
		query.setIdComunidad(getIdComunidad(request));
		query.setHashCertificado(getHash(request));
		query.setIndActivo(getActivo(request));
		query.setFechaCarga(getFechaCargaCert(request));
		
		if(comunidadService.existCertificadoActivoOtraComunidad(query))
			return "ERROR. Ya existe este certificado activo en otra Comunidad";
		
		if(comunidadService.existOtrotCertificadoActivoComunidad(query)){
			boolean notify= getNotify(request);
			if(!notify)
				return "NOTIFY. Ya existe otro certificado activo. ¿Desea poner este como activo?";
		}
		comunidadService.updateCertificadoComunidad(query);
		
		
		// Informacion para el renderizado de la pagina
					
		return super.process(request, response);
		

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/comunidadAjax/removeCertificate")
	public String removeCertificate(HttpServletRequest request, HttpServletResponse response) {
		
		ComunidadQueryBean query= new ComunidadQueryBean();
		
		query.setIdComunidad(getIdComunidad(request));
		query.setHashCertificado(getHash(request));
				
		if(!comunidadService.isCertificadoActivo(query))
		  comunidadService.removeCertificadoComunidad(query);
		else return "ERROR. El certificado está activo. Para borrarlo debe poner otro como activo en la comunidads.";
		
		// Informacion para el renderizado de la pagina
					
		return super.process(request, response);
		

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/comunidadAjax/newUser")
	public String newUser(HttpServletRequest request, HttpServletResponse response) {
		
		ComunidadQueryBean query= new UsuarioQueryBean();
		query.setIdComunidad((getIdComunidad(request)));
//		((UsuarioQueryBean)query).setId(id);
		((UsuarioQueryBean)query).setUsuario(getUser(request));
		((UsuarioQueryBean)query).setDescripcion(getUserDes(request));
		((UsuarioQueryBean)query).setActivo(getActivo(request));
		
			
		if(!comunidadUsuarioService.existUsuario(query))
			comunidadUsuarioService.addUsuario(query);
		else 
			return "ERROR. Ya existe este usuario en la Comunidad";
		
		
		
		
		// Informacion para el renderizado de la pagina
					
		super.process(request, response);
		return super.process(request, response);
		

	}
	
	@ResponseBody
	@RequestMapping(value = "/comunidadAjax/editUser")
	public String editUser(HttpServletRequest request, HttpServletResponse response) {
		
		ComunidadQueryBean query= new UsuarioQueryBean();
//		query.setIdComunidad((getIdComunidad(request)));
		((UsuarioQueryBean)query).setId(getIdUser(request));
		((UsuarioQueryBean)query).setUsuario(getUser(request));
		((UsuarioQueryBean)query).setDescripcion(getUserDes(request));
		((UsuarioQueryBean)query).setActivo(getActivo(request));
		
		comunidadUsuarioService.editUsuario(query);
		
		
		
		
		// Informacion para el renderizado de la pagina
		
		 super.process(request, response);
					
		return super.process(request, response);
		

	}
	
	@ResponseBody
	@RequestMapping(value = "/comunidadAjax/removeUser")
	public String removeUser(HttpServletRequest request, HttpServletResponse response) {
		
		ComunidadQueryBean query= new UsuarioQueryBean();
		((UsuarioQueryBean)query).setId(getIdUser(request));
		
		
		comunidadUsuarioService.removeUsuario(query);
			
		// Informacion para el renderizado de la pagina
		 super.process(request, response);			
		return super.process(request, response);
		

	}
	
	/**
	 * Peticiones asincronas para aniadir un nuevo fichero adjunto.
	 * @param request peticion
	 * @param response respuesta
	 * @return Json con la respuesta a la peticion
	 */
	@ResponseBody
	@RequestMapping(value="/comunidadAjax/addFicheroCertificado")
	public String addFicheroCertificado(HttpServletRequest request, HttpServletResponse response, AttachmentForm attachmentForm) {
		CertificateBean bean= new CertificateBean();
		String cert=null;
		Date fechaIni=null;
		Date fechaFin=null;
		try{
			if(ServletFileUpload.isMultipartContent(request)){
				CommonsMultipartFile file = attachmentForm.getFileToUpload();
				// Comprobamos la recepcion de un fichero
				if (file.getSize()!= 0) {
					cert=new String(file.getBytes(),"UTF-8")   ;
					fechaIni=UtilidadCertificados.getFechaInicialValidez(cert);
					fechaFin=UtilidadCertificados.getFechaFinalValidez(cert);
				}
			}
			

		} catch (CoreException e) {
			//Cuando se produce una excepcion tecnica, se presenta
	        //al usuario un mensaje de error generico, y el error
	        //se registra en un log
	        log.error("Error en la Aplicacion", e);
	        cert = "Error en la Aplicacion " + e.getMessage();
	    } catch (Exception e) {
	        log.error("Error generico", e);
	        if (e.getMessage() == null) {
	        	cert = "error: Error generico de la aplicacion";
	        } else {
	        	cert = "Error en la Aplicacion " + e.getMessage();
	        }
	    }
		bean.setCertificado(cert);
		SimpleDateFormat parser=new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		if(fechaIni!=null)
		 bean.setFechaIni(parser.format(fechaIni)) ;
		
		if(fechaFin!=null)
			 bean.setFechaFin(parser.format(fechaFin)) ;
		
		return JSONUtil.obj2str(bean);
		
	}	
	
	



	@Override
	protected SearchResult<ComunidadBean> doSearch(ComunidadQueryBean query) {
		// TODO Auto-generated method stub
		 ComunidadSearchResult resultComunidad=null;
		 if(isUserGrid(getRequest()))
			 resultComunidad= comunidadUsuarioService.getUsuarioComunidad(query);
		 else resultComunidad= comunidadService.getCertificadoComunidad(query);
		 
		
		SearchResult<ComunidadBean> result= new SearchResult<ComunidadBean>(resultComunidad.getResults());
		result.setNumResults(resultComunidad.getNumResults());

		return result;
	}


	@Override
	protected ComunidadQueryBean toQuery() {
		// TODO Auto-generated method stub
		ComunidadQueryBean query= new ComunidadQueryBean();
		query.setIdComunidad(getIdComunidad(getRequest()));
		
		getRequest().getSession().setAttribute(es.dgoj.rgiaj.util.Constantes.comunidadQueryBean, query);
		  
		return query;
	}


	@Override
	protected String beanId(ComunidadBean bean) {
		// TODO Auto-generated method stub
		if(bean instanceof ComunidadCertificadoBean){
			return new TimestampEncrypter().encrypt(String.valueOf(((ComunidadCertificadoBean)bean).getFechaDesde()));
		}else {
			return new TimestampEncrypter().encrypt(String.valueOf(((UsuarioComunidadBean)bean).getId()));
		}
	}


	@Override
	protected String[] beanToStrings(ComunidadBean bean) {
		String[] retorno=null;
		if(bean instanceof ComunidadCertificadoBean){
			
			String fingerCut=((ComunidadCertificadoBean)bean).getFingerSha1();
			if(fingerCut.length()>15)
				fingerCut=  Utilidades.trunkString(((ComunidadCertificadoBean)bean).getFingerSha1() , 0, 15); 
			
			String certificadoCut=((ComunidadCertificadoBean)bean).getCertificado();
			if(certificadoCut.length()> 53)
			  certificadoCut= Utilidades.trunkString(certificadoCut , 28, 53); 
			
			 retorno = new String[] {
					WriteUtil.formatValue(((ComunidadCertificadoBean)bean).getIndActivo()),
					WriteUtil.formatValue(((ComunidadCertificadoBean)bean).getFechaDesde(),this.messageSource.getMessage("common.dateTimeFormat", null, this.getLocale())),
					WriteUtil.formatValue(((ComunidadCertificadoBean)bean).getFechaHasta(),this.messageSource.getMessage("common.dateTimeFormat", null, this.getLocale())),
					WriteUtil.formatValue(((ComunidadCertificadoBean)bean).getFechaCarga(),this.messageSource.getMessage("common.dateTimeFormat", null, this.getLocale())),
					WriteUtil.formatValue(((ComunidadCertificadoBean)bean).getHashCertificado()),
					
					WriteUtil.formatValue(fingerCut),
					WriteUtil.formatValue( certificadoCut ),
					
					WriteUtil.formatValue(((ComunidadCertificadoBean)bean).getFingerSha1()),
					WriteUtil.formatValue(((ComunidadCertificadoBean)bean).getCertificado())
					
					
				};
		}else{
			
			retorno = new String[] {
					WriteUtil.formatValue(((UsuarioComunidadBean)bean).getActivo()),
					WriteUtil.formatValue(((UsuarioComunidadBean)bean).getUsuario()),
					WriteUtil.formatValue(((UsuarioComunidadBean)bean).getDescripcion()),
					WriteUtil.formatValue(((UsuarioComunidadBean)bean).getId())
									
					
				};
			
		} 
		// TODO Auto-generated method stub
		return retorno;
	}
	
	


		
	private Long getIdComunidad(HttpServletRequest request){
		Long value=RequestUtil.getLongParameter(request, "idComunidad");
		return value;
	}
	
	private String getCertificado(HttpServletRequest request){
		String value=RequestUtil.getStringParameter(request, "certificado");
		return value;
	}
	
	private Date getFechaCargaCert(HttpServletRequest request){
		Date value=RequestUtil.getDateParameter(request, "fechaCargaCert",this.messageSource.getMessage("common.dateTimeFormat", null, this.getLocale()));
		return value;
	}
   
	private int getActivo(HttpServletRequest request){
    	boolean value=RequestUtil.getBooleanParameter(request, "indActivo", true);
	if(value) return 1;
		
	return 0;
	}
	
	private String getHash(HttpServletRequest request){
		String value=RequestUtil.getStringParameter(request, "hash");
		return value;
	}
	
	private boolean getNotify(HttpServletRequest request){
		boolean value=RequestUtil.getBooleanParameter(request, "notify", true);
		return value;
		}
	
	private boolean isUserGrid(HttpServletRequest request){
		boolean value=RequestUtil.getBooleanParameter(request, "userGrid", true);
		return value;
	}
	
	private String getUser(HttpServletRequest request){
		String value=RequestUtil.getStringParameter(request, "userName");
		return value;
	}
	
	private String getUserDes(HttpServletRequest request){
		String value=RequestUtil.getStringParameter(request, "userDescription");
		return value;
	}
	
	private Long getIdUser(HttpServletRequest request){
		String value=RequestUtil.getStringParameter(request, "id");
		 return new Long(new TimestampEncrypter().decryptAndValidate(value, 1000 * viewTimeout));  
	}
	
	
	

}
