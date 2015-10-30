package es.dgoj.rgiaj.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeveris.core.exception.impl.CoreException;


/**
 * Clase contenedora de la informacion de encriptado.
 * @author dbeltran
 * @version 1.0
 */
public class StringEncrypter {
	
	/**
	 *  Log de la clase.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(StringEncrypter.class);

	/**
	 * Esquema de encriptado de tipo DESede.
	 */
	public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	
	/**
	 * Esquema de encriptado de tipo DES.
	 */
	public static final String DES_ENCRYPTION_SCHEME = "DES";
	
	/**
	 * Clave por defecto de encriptado.
	 */
	public static final String DEFAULT_ENCRYPTION_KEY = "dfhjkdklfdjofhfdjsdk9475";
	
	/**
	 * Formato de codificacion.
	 */
	public static final String UNICODE_FORMAT = "UTF8";

	/**
	 * Clave.
	 */
	private KeySpec keySpec = null;

	/**
	 * Factoria.
	 */
	private SecretKeyFactory keyFactory = null;

	/**
	 * Cifrado.
	 */
	private Cipher cipher = null;

	/**
	 * Constructor.
	 * 
	 * @throws CoreException
	 */
	public StringEncrypter() {
		this(StringEncrypter.DES_ENCRYPTION_SCHEME, StringEncrypter.DEFAULT_ENCRYPTION_KEY);
	}

	/**
	 * Constructor.
	 * 
	 * @param encryptionScheme String
	 * @throws CoreException
	 */
	public StringEncrypter(String encryptionScheme) {
		this(encryptionScheme, StringEncrypter.DEFAULT_ENCRYPTION_KEY);
	}

	/**
	 * Constructor.
	 * 
	 * @param encryptionScheme String
	 * @param encryptionKey String
	 * @throws CoreException
	 */
	public StringEncrypter(String encryptionScheme, String encryptionKey) {

		if (encryptionKey == null) {
			throw new IllegalArgumentException("encryption key was null");
		}

		if (encryptionKey.trim().length() < 24) {
			throw new IllegalArgumentException(
					"encryption key was less than 24 characters");
		}

		try {

			byte[] keyAsBytes = encryptionKey.getBytes(StringEncrypter.UNICODE_FORMAT);

			if (encryptionScheme.equals(StringEncrypter.DESEDE_ENCRYPTION_SCHEME)) {
				this.keySpec = new DESedeKeySpec(keyAsBytes);
			} else if (encryptionScheme.equals(StringEncrypter.DES_ENCRYPTION_SCHEME)) {
				this.keySpec = new DESKeySpec(keyAsBytes);
			} else {
				throw new IllegalArgumentException(
						"Encryption scheme not supported: "
								+ encryptionScheme);
			}

			this.keyFactory = SecretKeyFactory.getInstance(encryptionScheme);
			this.cipher = Cipher.getInstance(encryptionScheme);

		} catch (InvalidKeyException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (UnsupportedEncodingException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (NoSuchAlgorithmException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (NoSuchPaddingException e) {
			throw new CoreException(e, "error.cifrado");
		}

	}

	/**
	 * Encripta una cadena de texto.
	 * 
	 * @param unencryptedString String
	 * @return String
	 * @throws CoreException
	 */
	public String encrypt(String unencryptedString) {

		if (StringEncrypter.isBlank(unencryptedString)) {
			throw new IllegalArgumentException(
					"unencrypted string was null or empty");
		}

		try {
			SecretKey key = this.keyFactory.generateSecret(this.keySpec);
			this.cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] cleartext = unencryptedString.getBytes(StringEncrypter.UNICODE_FORMAT);
			byte[] ciphertext = this.cipher.doFinal(cleartext);

			return StringUtils.newStringUtf8(Base64.encodeBase64(ciphertext));
			
		} catch (InvalidKeySpecException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (InvalidKeyException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (UnsupportedEncodingException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (IllegalBlockSizeException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (BadPaddingException e) {
			throw new CoreException(e, "error.cifrado");
		}
	}

	/**
	 * Encripta un array de bytes.
	 * 
	 * @param bytes datos a encriptar
	 * @return bytes datos encriptados
	 * @throws CoreException
	 */
	public byte[] encrypt(byte[] bytes) {
		
		try {
			SecretKey key = this.keyFactory.generateSecret(this.keySpec);
			this.cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] ciphertext = this.cipher.doFinal(bytes);

			return ciphertext;
		} catch (InvalidKeySpecException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (InvalidKeyException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (IllegalBlockSizeException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (BadPaddingException e) {
			throw new CoreException(e, "error.cifrado");
		}
	}

	/**
	 * Desencripta una cadena de texto.
	 * 
	 * @param encryptedString Cadena de texto
	 * @return String
	 * @throws CoreException
	 */
	public String decrypt(String encryptedString) {

		if (StringEncrypter.isBlank(encryptedString)) {
			throw new IllegalArgumentException(
					"encrypted string was null or empty");
		}

		try {

			SecretKey key = this.keyFactory.generateSecret(this.keySpec);
			this.cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] clearText = Base64.decodeBase64(encryptedString);
			byte[] cipherBytes = this.cipher.doFinal(clearText);
			String cypherText = StringEncrypter.bytes2String(cipherBytes);

			return cypherText;

		} catch (InvalidKeySpecException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (InvalidKeyException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (IllegalBlockSizeException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (BadPaddingException e) {
			throw new CoreException(e, "error.cifrado");
		}
	}

	/**
	 * Desencripta un array de bytes.
	 * 
	 * @param bytes array de bytes para desencriptar
	 * @return array de bytes desencriptados
	 * @throws CoreException
	 */
	public byte[] decrypt(byte[] bytes) {
		try {

			SecretKey key = this.keyFactory.generateSecret(this.keySpec);
			this.cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] cipherBytes = this.cipher.doFinal(bytes);

			return cipherBytes;

		} catch (InvalidKeySpecException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (InvalidKeyException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (IllegalBlockSizeException e) {
			throw new CoreException(e, "error.cifrado");
		} catch (BadPaddingException e) {
			throw new CoreException(e, "error.cifrado");
		}
	}

	/**
	 * Convirte un array de bytes en cadena de texto.
	 * 
	 * @param bytes Array de bytes
	 * @return String cadena de texto
	 */
	public static String bytes2String(byte[] bytes) {
		String result = null;

		try {
			result = new String(bytes, StringEncrypter.UNICODE_FORMAT);
		} catch (UnsupportedEncodingException ignored) {
			if (StringEncrypter.LOG.isWarnEnabled()){
				StringEncrypter.LOG.warn("Ignorado, porque el formado unicode es correcto");
			}
		}

		return result;
	}

	/**
	 * Comprueba que la cadena de texto este vacia.
	 * 
	 * @param str Cadena de texto
	 * @return boolean Devuelve true si la cadena esta vacia o solo contiene espacios
	 * 					Devuelve false en el resto de casos
	 */
	public static boolean isBlank(String str) {
		return (str == null || str.trim().length() == 0);
	}

}
