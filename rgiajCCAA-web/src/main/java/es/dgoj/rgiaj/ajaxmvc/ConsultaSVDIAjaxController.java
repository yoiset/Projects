package es.dgoj.rgiaj.ajaxmvc;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import clienterawws.ConsultaDni;
import clienterawws.ConsultaDniException;
import clienterawws.DatosConsulta;

import com.dgoj.sprmvc.ajax.AbstractAjaxController;
import com.dgoj.sprmvc.web.util.RequestUtil;

import es.dgoj.rgiaj.business.service.PersonaService;
import es.dgoj.rgiaj.util.Utilidades;

/**
 * Clase que gestiona las peticiones asincronas realizadas 
 * para buscar los jugadores segun la informacion rellenada en el formulario de busqueda.
 * @author dgonzalez
 * @version 1.0
 */
@Controller
@RequestMapping(value="/consultaSVDI/*")
public class ConsultaSVDIAjaxController extends AbstractAjaxController {


	/**
	 * Servicio de acceso al contenedor de mensajes de spring.
	 */
	@Resource
	private MessageSource messageSource;
		
	@Resource
	private PersonaService personaService;
	
	private String dni;
	
	/**
	 * Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsultaSVDIAjaxController.class);
	
	/**
	 * Peticiones asincronas para la busqueda de personas a partir del formulario de busqueda.
	 * @param request peticion
	 * @param response respuesta
	 * @return Json con la respuesta a la peticion
	 */
	@ResponseBody
	@RequestMapping(value="/consultaSVDI/searchConsultaSVDI")
	public String searchConsultaSVDI(HttpServletRequest request, HttpServletResponse response) {
		dni = RequestUtil.getStringParameter(request,"dni");
		
		return super.process(request, response);
	}
	
	/* (non-Javadoc)
	 * @see com.dgoj.sprmvc.ajax.AbstractAjaxController#doProcess()
	 */
	@Override
	protected String doProcess() throws IOException {
		LOGGER.info("Buscando jugador por DNI al servicio SVDI");

		DatosConsulta datosConsulta = null;
		try {
			datosConsulta = buscaPersonaSVDI(dni);
		} catch (ConsultaDniException e) {
			LOGGER.error("ERROR al buscar el jugador en el servicio web SVDI "+ e.getMessage());
			return "Error al buscar el jugador en la consulta SVDI. Consulte con el administrador.";
		}
		
		Date fechaNacimiento = Utilidades.toBDDateOrNull(datosConsulta.getFecha());
		StringBuffer resultadoBuffer = new StringBuffer();
		resultadoBuffer.append(dni);
		resultadoBuffer.append("#");
		resultadoBuffer.append(datosConsulta.getNombre()==null?"":datosConsulta.getNombre());
		resultadoBuffer.append("#");
		resultadoBuffer.append(datosConsulta.getApellido1()==null?"":datosConsulta.getApellido1());
		resultadoBuffer.append("#");
		resultadoBuffer.append(datosConsulta.getApellido2()==null?"":datosConsulta.getApellido2());
		resultadoBuffer.append("#");
		resultadoBuffer.append(fechaNacimiento==null?"":Utilidades.fromDateOrNull(fechaNacimiento));
		resultadoBuffer.append("#");
		resultadoBuffer.append(datosConsulta.getCodigo());
		resultadoBuffer.append(" - ");
		resultadoBuffer.append(datosConsulta.getResultado());

		String resultado = resultadoBuffer.toString();

		return resultado;
	}
	
	/**
	 * Método que consulta al servicio SVDI obtener los datos de un jugador a partir del DNI
	 * 
	 * @param dni, Dni a buscar
	 * @return DatosConsulta
	 */
	private DatosConsulta buscaPersonaSVDI(String dni) throws ConsultaDniException {
		String tipoDocumento = "NIF";
		if ((dni.toUpperCase().charAt(0)=='X') || (dni.toUpperCase().charAt(0)=='Y') || (dni.toUpperCase().charAt(0)=='Z')){
			tipoDocumento = "NIE"; 
		}
			
		String endPoint = personaService.getEndPointSVDI() ;
		ConsultaDni miconsulta = new ConsultaDni();

		DatosConsulta misdatosconsulta = miconsulta.Consulta(tipoDocumento, dni, endPoint, "CDISFWS01");
			
		return misdatosconsulta;
	}
	
}
