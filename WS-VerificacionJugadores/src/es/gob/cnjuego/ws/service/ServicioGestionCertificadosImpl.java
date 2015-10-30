package es.gob.cnjuego.ws.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Encoder;
import es.gob.cnjuego.ws.dao.OperadorDAO;
import es.gob.cnjuego.ws.entity.OperadorEntity;

@Service(value="servicioGestionCertificados")
public class ServicioGestionCertificadosImpl implements ServicioGestionCertificados {

	Logger log = Logger.getLogger(ServicioGestionCertificadosImpl.class);
	
	@Autowired
	private OperadorDAO operadorDAO;
	
	@Override
	public OperadorEntity validarCertificadoObtenerOperador(String certificado)
	{
		 
		OperadorEntity operador = operadorDAO.obtenerOperadorPorHashCertificado(obtenerHashCertificado(certificado));
		return operador;
	}
	
	@Override
	public String obtenerHashCertificado(String certificado)
	{
		String res = null;
		try{
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			byte[] input = digest.digest(certificado.getBytes());
			res = new BASE64Encoder().encode(input);
		} catch (NoSuchAlgorithmException ex)
		{
			log.error("ServicioGestionCertificadosImpl.obtenerHashCertificado(): Algoritmo de Hash SHA-1 no encontrado", ex);
		}
		return res;
	}
	
	
	
}
