package es.dgoj.rgiaj.encrypt;

import com.jeveris.core.exception.impl.CoreException;


/**
 * Clase encargada de encriptar y desencriptar.
 * @author dbeltran
 * @version 1.0
 */
public class TimestampEncrypter {
	
	/**
	 * Objeto con la informacion de encriptado y desencriptado.
	 */
	private StringEncrypter stringEncrypter;
	
	/**
	 * Constructor vacio.
	 */
	public TimestampEncrypter() {
		this.stringEncrypter = new StringEncrypter();
	}
	
	/**
	 * Metodo para encriptar dado un objeto con la informacion de encriptado.
	 * @param unencryptedString Cadena a encriptar
	 * @return cadena encriptada
	 */
	public String encrypt(String unencryptedString) {
		return this.stringEncrypter.encrypt(unencryptedString + "|" + System.currentTimeMillis());
	}

	/**
	 * Metodo para desencriptar dado un objeto de encriptado y un tiempo maximo de caducidad del token.
	 * @param encryptedString  Cadena a desencriptar
	 * @param maxTimeout Tiempo de caducidad del token
	 * @return Cadena desencriptada
	 */
	public String decryptAndValidate(String encryptedString, long maxTimeout) {
		String dec = this.stringEncrypter.decrypt(encryptedString);
		
		int idx = dec.lastIndexOf('|');
		
		if (idx == -1) {
			throw new CoreException("Missing timestamp part");
		}
		
		String strTs = dec.substring(idx + 1);
		
		long timestamp = -1; 
		
		try {
			timestamp = Long.parseLong(strTs);
		} catch (NumberFormatException e) {
			throw new CoreException(e, "Malformed timestamp part");
		}
		
		if (System.currentTimeMillis() - timestamp > maxTimeout) {
			throw new CoreException("Expired encryption");
		}
		
		return dec.substring(0, idx);
	}

}
