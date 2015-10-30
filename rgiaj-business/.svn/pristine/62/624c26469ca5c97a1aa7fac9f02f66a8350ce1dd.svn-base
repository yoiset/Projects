package es.dgoj.rgiaj.business.service.impl;

import java.util.Map;

import javax.xml.ws.BindingProvider;


import es.dgoj.rgiaj.JuegoRGIAJ;
import es.dgoj.rgiaj.business.repository.IConfigurationRepository;
import es.dgoj.rgiaj.business.util.Constantes;

public  abstract class  SpringServiceToWS {
	
	protected void init(){
		
		String endpointAddress= getConfigurationRepository().getEndPoint(Constantes.endpoint_RGIAJCCAA);//"http://localhost:18080/ws-rgiaj-in-ccaa/JuegoRGIAJ";
		BindingProvider proxy = (BindingProvider)this.getJuegoRGIAJServiceStub();
		Map<String, Object> map = proxy.getRequestContext();
		map.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointAddress);		
	}
	
	
	public abstract IConfigurationRepository getConfigurationRepository();
	
	
	public abstract JuegoRGIAJ getJuegoRGIAJServiceStub();

}
