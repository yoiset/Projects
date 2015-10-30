package es.dgoj.rgiaj.ws;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

import es.dgoj.rgiaj.ComunidadBeanResponse;
import es.dgoj.rgiaj.ComunidadCertificadoBeanWS;
import es.dgoj.rgiaj.ComunidadQueryRequest;
import es.dgoj.rgiaj.ComunidadSearchResponse;
import es.dgoj.rgiaj.Fault;
import es.dgoj.rgiaj.JuegoRGIAJ;
import es.dgoj.rgiaj.JugHistoricoQueryRequest;
import es.dgoj.rgiaj.JugHistoricoSearchResponse;
import es.dgoj.rgiaj.JugProhibicionBeanWS;
import es.dgoj.rgiaj.JugProhibicionQueryRequest;
import es.dgoj.rgiaj.ProhibidosResponse;
import es.dgoj.rgiaj.UltimasDescargasConfirmadasResponse;
import es.dgoj.rgiaj.UsuarioQueryRequest;


public class JuegoRGIAJImpl implements  JuegoRGIAJ {
	
	 private JuegoRGIAJController controller;

	
	

	
	public void setController(JuegoRGIAJController controller) {
		this.controller = controller;
	}


	@Override
	@WebResult(name = "Boolean", targetNamespace = "http://rgiaj.dgoj.es/", partName = "parameters")
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/hayPendiente")
	public boolean hayPendiente(
			@WebParam(partName = "parameters", name = "JugProhibicionQueryRequest4", targetNamespace = "http://rgiaj.dgoj.es/") JugProhibicionQueryRequest parameters)
			throws Fault {
		return controller.hayPendiente(parameters);
	}


	@Override
	@Oneway
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/confirmHistoricoDescargasPendientes")
	public void confirmHistoricoDescargasPendientes(
			@WebParam(partName = "parameters", name = "JugProhibicionQueryRequest3", targetNamespace = "http://rgiaj.dgoj.es/") JugProhibicionQueryRequest parameters)
			throws Fault {
		controller.confirmHistoricoDescargasPendiente(parameters);
		
	}

	@Override
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/updateCertificadoComunidad")
	public void updateCertificadoComunidad(
			@WebParam(partName = "parameters", name = "ComunidadQueryRequest4", targetNamespace = "http://rgiaj.dgoj.es/") ComunidadQueryRequest parameters)
			throws Fault {
		controller.updateCertificadoComunidad(parameters);
		
	}

	@Override
	@WebResult(name = "Boolean", targetNamespace = "http://rgiaj.dgoj.es/", partName = "parameters")
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/existCertificadoActivoOtraComunidad")
	public boolean existCertificadoActivoOtraComunidad(
			@WebParam(partName = "parameters", name = "ComunidadQueryRequest8", targetNamespace = "http://rgiaj.dgoj.es/") ComunidadQueryRequest parameters)
			throws Fault {
		
		return controller.existCertificadoActivoOtraComunidad(parameters);
	}





	@Override
	@WebResult(name = "ultimasDescargasConfirmadasResponse", targetNamespace = "http://rgiaj.dgoj.es/", partName = "parameters")
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/ultimasDescargasConfirmadas")
	public UltimasDescargasConfirmadasResponse ultimasDescargasConfirmadas(
			@WebParam(partName = "parameters", name = "JugProhibicionQueryRequest5", targetNamespace = "http://rgiaj.dgoj.es/") JugProhibicionQueryRequest parameters)
			throws Fault {
		return controller.ultimaDescargaConfirmada(parameters);
	}





	@Override
	@Oneway
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/confirmHistoricoDescargas")
	public void confirmHistoricoDescargas(
			@WebParam(partName = "parameters", name = "JugProhibicionQueryRequest2", targetNamespace = "http://rgiaj.dgoj.es/") JugProhibicionQueryRequest parameters)
			throws Fault {
		controller.confirmarUltimaDescarga(parameters);
	}





	@Override
	@WebResult(name = "Boolean", targetNamespace = "http://rgiaj.dgoj.es/", partName = "parameters")
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/existCertificadoComunidad")
	public boolean existCertificadoComunidad(
			@WebParam(partName = "parameters", name = "ComunidadQueryRequest7", targetNamespace = "http://rgiaj.dgoj.es/") ComunidadQueryRequest parameters)
			throws Fault {
		return controller.existCertificadoComunidad(parameters);
	}





	@Override
	@WebResult(name = "Boolean", targetNamespace = "http://rgiaj.dgoj.es/", partName = "parameters")
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/isCertificadoActivo")
	public boolean isCertificadoActivo(
			@WebParam(partName = "parameters", name = "ComunidadQueryRequest5", targetNamespace = "http://rgiaj.dgoj.es/") ComunidadQueryRequest parameters)
			throws Fault {
		return controller.isCertificadoActivo(parameters);
	}





	@Override
	@WebResult(name = "ComunidadBeanResponse", targetNamespace = "http://rgiaj.dgoj.es/", partName = "parameters")
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/getComunidadList")
	public ComunidadBeanResponse getComunidadList() throws Fault {
		return controller.getComunidadList();
	}





	@Override
	@Oneway
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/addCertificadoComunidad")
	public void addCertificadoComunidad(
			@WebParam(partName = "parameters", name = "ComunidadQueryRequest14", targetNamespace = "http://rgiaj.dgoj.es/") ComunidadQueryRequest parameters)
			throws Fault {
		controller.addCertificadoComunidad(parameters);
		
	}



	@Override
	@WebResult(name = "Boolean", targetNamespace = "http://rgiaj.dgoj.es/", partName = "parameters")
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/existOtroCertificadoActivoComunidad")
	public boolean existOtroCertificadoActivoComunidad(
			@WebParam(partName = "parameters", name = "ComunidadQueryRequest2", targetNamespace = "http://rgiaj.dgoj.es/") ComunidadQueryRequest parameters)
			throws Fault {
		return controller.existOtrotCertificadoActivoComunidad(parameters);
	}





	@Override
	@WebResult(name = "ComunidadSearchResponse", targetNamespace = "http://rgiaj.dgoj.es/", partName = "parameters")
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/getUsuarioComunidad")
	public ComunidadSearchResponse getUsuarioComunidad(
			@WebParam(partName = "parameters", name = "ComunidadQueryRequest13", targetNamespace = "http://rgiaj.dgoj.es/") ComunidadQueryRequest parameters)
			throws Fault {
		return controller.getUsuarioComunidad(parameters);
	}





	@Override
	@WebResult(name = "JugProhibicionBean", targetNamespace = "http://rgiaj.dgoj.es/", partName = "parameters")
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/getComunidad")
	public JugProhibicionBeanWS getComunidad(
			@WebParam(partName = "user", name = "user", targetNamespace = "") String user)
			throws Fault {
		return controller.getComunidadByUser(user);
	}





	@Override
	@WebResult(name = "ComunidadSearchResponse", targetNamespace = "http://rgiaj.dgoj.es/", partName = "parameters")
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/getCertificadoComunidad")
	public ComunidadSearchResponse getCertificadoComunidad(
			@WebParam(partName = "parameters", name = "ComunidadQueryRequest", targetNamespace = "http://rgiaj.dgoj.es/") ComunidadQueryRequest parameters)
			throws Fault {
		return controller.getCertificadoComunidad(parameters);
	}





	@Override
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/removeCertificadoComunidad")
	public void removeCertificadoComunidad(
			@WebParam(partName = "parameters", name = "ComunidadQueryRequest6", targetNamespace = "http://rgiaj.dgoj.es/") ComunidadQueryRequest parameters)
			throws Fault {
		controller.removeCertificadoComunidad(parameters);
		
	}





	@Override
	@WebResult(name = "prohibidosResponse", targetNamespace = "http://rgiaj.dgoj.es/", partName = "parameters")
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/prohibidosList")
	public ProhibidosResponse prohibidosList(
			@WebParam(partName = "parameters", name = "JugProhibicionQueryRequest", targetNamespace = "http://rgiaj.dgoj.es/") JugProhibicionQueryRequest parameters)
			throws Fault {
		return controller.getProhibidos(parameters);
	}





	@Override
	@WebResult(name = "ComunidadCertificadoBeanResponse", targetNamespace = "http://rgiaj.dgoj.es/", partName = "parameters")
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/getCertificadoActivoComunidad")
	public ComunidadCertificadoBeanWS getCertificadoActivoComunidad(
			@WebParam(partName = "parameters", name = "ComunidadQueryRequest3", targetNamespace = "http://rgiaj.dgoj.es/") ComunidadQueryRequest parameters)
			throws Fault {
		return controller.getCertificadoActivoComunidad(parameters);
	}





	@Override
	@WebResult(name = "JugHistoricoSearchResponse", targetNamespace = "http://rgiaj.dgoj.es/", partName = "parameters")
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/JuegoRGIAJ/getHistorico")
	public JugHistoricoSearchResponse getHistorico(
			@WebParam(partName = "parameters", name = "JugHistoricoQueryRequest", targetNamespace = "http://rgiaj.dgoj.es/") JugHistoricoQueryRequest parameters)
			throws Fault {
		return controller.getHistorico(parameters);
	}





	@Override
	@Oneway
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/editUsuario")
	public void editUsuario(
			@WebParam(partName = "parameters", name = "UsuarioQueryRequest2", targetNamespace = "http://rgiaj.dgoj.es/") UsuarioQueryRequest parameters)
			throws Fault {
		controller.editUsuario(parameters);
		
	}





	@Override
	@Oneway
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/addUsuario")
	public void addUsuario(
			@WebParam(partName = "parameters", name = "UsuarioQueryRequest1", targetNamespace = "http://rgiaj.dgoj.es/") UsuarioQueryRequest parameters)
			throws Fault {
		controller.addUsuario(parameters);
		
	}





	@Override
	@WebResult(name = "Boolean", targetNamespace = "http://rgiaj.dgoj.es/", partName = "parameters")
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/existUsuario")
	public boolean existUsuario(
			@WebParam(partName = "parameters", name = "UsuarioQueryRequest", targetNamespace = "http://rgiaj.dgoj.es/") UsuarioQueryRequest parameters)
			throws Fault {
		// TODO Auto-generated method stub
		return controller.existUsuario(parameters);
	}





	@Override
//	@Oneway
	@WebMethod(action = "http://rgiaj.dgoj.es/JuegoRGIAJ/removeUsuario")
	public void removeUsuario(
			@WebParam(partName = "parameters", name = "UsuarioQueryRequest3", targetNamespace = "http://rgiaj.dgoj.es/") UsuarioQueryRequest parameters)
			throws Fault {
		controller.removeUsuario(parameters);
		
	}




}
