package es.dgoj.rgiaj.business.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;



/**
 * Esta clase ofrece funcionalidad que se usa para el tratamiento de los
 * certificados enviados por los operadores.
 */
public final class UtilidadCertificados {
	
	private final static char[] HEXDIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

	
	private UtilidadCertificados() {
		super();
	}

	/**
	 * Retorna el hash correspondiente al certificado. Antes de calcular el hash se normaliza el certificado.
	 * Notese que esta misma estrategia es la que se usa en el servicio web
	 * VerificacionOperadores para calcular el hash del certificado que viaja en
	 * las cabeceras de los mensajes SOAP.
	 */
	public static String calcularHashCertificado(String certificado) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			String certificadoNormalizado = normalizarCertificado(certificado);
			byte[] input = digest.digest(certificadoNormalizado.getBytes());
			return encodeBase64(input);
		} catch (NoSuchAlgorithmException e) {
			throw new ErrorCertificado(e);
		}
	}

	/**
	 * Retorna el hash correspondiente al certificado. Si el certificado incluye
	 * caracteres de final de linea, estos se ignoran para calcular el hash.
	 * Notese que esta misma estrategia es la que se usa en el servicio web
	 * VerificacionOperadores para calcular el hash del certificado que viaja en
	 * las cabeceras de los mensajes SOAP.
	 */
	public static String calcularHashCertificado(InputStream input) {
		try {
			ByteArrayOutputStream into = new ByteArrayOutputStream();
			byte[] buf = new byte[4096];
			int n = input.read(buf);
			while (0 < n) {
			    into.write(buf, 0, n);
			    n = input.read(buf);
			}
			into.close();
			String certificado = new String(into.toByteArray(), "UTF-8");
			return calcularHashCertificado(certificado);
		} catch (Exception e) {
			throw new ErrorCertificado(e);
		}
	}

	/**
	 * Retorna un array de bytes que corresponde a la decodificacion del string
	 * codificado en Base64 del string del parametro.
	 */
	public static byte[] decodeBase64(String base64Data) {
		if (base64Data == null) {
			return null;
		}
		byte[] bytes = base64Data.getBytes();
		return Base64.decodeBase64(bytes);
	}

	/**
	 * Retorna un string con la codificacion en Base64 de los bytes del array
	 * del parametro
	 */
	public static String encodeBase64(byte[] binaryData) {
		if (binaryData == null) {
			return null;
		}
		byte[] bytes = Base64.encodeBase64(binaryData);
		return new String(bytes);
	}

	/**
	 * Obtiene y retorna la huella "SHA-1" del certificado recibido en el
	 * stream del parametro.
	 */
	public static String getFingerPrint(String input) {
		return getFingerPrint(new ByteArrayInputStream(input.getBytes()));
	}

	/**
	 * Obtiene y retorna la huella "SHA-1" del certificado recibido en el
	 * stream del parametro.
	 */
	public static String getFingerPrint(InputStream input) {
		try {
			CertificateFactory x509CertFact = CertificateFactory.getInstance("X.509");
			X509Certificate cert = (X509Certificate)x509CertFact.generateCertificate(input);
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] der = cert.getEncoded();
			md.update(der);
			byte[] digest = md.digest();
			return hexify(digest);
		} catch (Exception e) {
			throw new ErrorCertificado(e);
		}
	}

	/**
	 * Retorna un string con los bytes del parametro en formato hexadecimal.
	 * Ej: "5C:4C:CC:D1:05:6F:69:21:80:73:5D:28:99:7E:B8:DB:87:32:B4:99"
	 */
	private static String hexify(byte bytes[]) {
		StringBuffer buf = new StringBuffer(bytes.length * 2);
		boolean insertarSeparador = false;
		for (int i = 0; i < bytes.length; ++i) {
			if (insertarSeparador) {
				buf.append(":");
			} else {
				insertarSeparador = true;
			}
			buf.append(HEXDIGITS[(bytes[i] & 0xf0) >> 4]);
			buf.append(HEXDIGITS[bytes[i] & 0x0f]);
		}
		return buf.toString();
	}

	/**
	 * Retorna un certificado normalizado:
	 * - Se eliminan los caracteres de final de linea
	 * - Se elimina el encabezado: "-----BEGIN CERTIFICATE-----"
	 * - Se elimina el pie: "-----END CERTIFICATE-----"
	 */
	public static String normalizarCertificado (String certificado) {
		String certificadoNormalizado = certificado.replaceAll("-----BEGIN CERTIFICATE-----", "");
		certificadoNormalizado = certificadoNormalizado.replaceAll("-----END CERTIFICATE-----", "");
		certificadoNormalizado = certificadoNormalizado.replaceAll("[\r\n]", "");
		return certificadoNormalizado;
	}
	
	/**
	 * Retorna la fecha inicial del período de validez del certificado
	 */
	public static Date getFechaInicialValidez(String certificado) {
		return getFechaInicialValidez(new ByteArrayInputStream(certificado.getBytes())); 
	}
	
	/**
	 * Retorna la fecha inicial del período de validez del certificado
	 */
	public static Date getFechaInicialValidez(InputStream input) {
		try {
			CertificateFactory x509CertFact = CertificateFactory.getInstance("X.509");
			X509Certificate cert = (X509Certificate)x509CertFact.generateCertificate(input);
			return cert.getNotBefore();
		} catch (Exception e) {
			throw new ErrorCertificado(e);
		}
	}
	
	/**
	 * Retorna la fecha de caducidad del certificado (fecha final del período de validez)
	 */
	public static Date getFechaFinalValidez(String certificado) {
		return getFechaFinalValidez(new ByteArrayInputStream(certificado.getBytes())); 
	}
	
	/**
	 * Retorna la fecha de caducidad del certificado (fecha final del período de validez)
	 */
	public static Date getFechaFinalValidez(InputStream input) {
		try {
			CertificateFactory x509CertFact = CertificateFactory.getInstance("X.509");
			X509Certificate cert = (X509Certificate)x509CertFact.generateCertificate(input);
			return cert.getNotAfter();
		} catch (Exception e) {
			throw new ErrorCertificado(e);
		}
	}
	
}
