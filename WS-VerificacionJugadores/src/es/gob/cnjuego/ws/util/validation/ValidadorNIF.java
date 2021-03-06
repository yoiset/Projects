package es.gob.cnjuego.ws.util.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * Esta clase auxiliar sirve para validar NIFs
 */
public class ValidadorNIF {

	static Logger log = Logger.getLogger(ValidadorNIF.class);

	/**
	 * Retorna true si el string del par�metro corresponde a un NIF;
	 * o false en caso contrario.
	 */
	static public boolean validarNIF(String NIF) {
		// Pasarlo a may�sculas
		String valor = NIF.toUpperCase();

		// Comprobar que la longitud sea 9
		if (valor.length() != 9) {
			return false;
		}

		Pattern patron = Pattern.compile("[0-9]{8,8}[A-Z]");
		Matcher matcher = patron.matcher(valor);
		if (!matcher.matches()) {
			return false;
		}

		String dni = valor.substring(0, 8);
		String digitoControl = valor.substring(8, 9);

		// Calculamos la letra de control
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		int posicion_modulo = Integer.parseInt(dni) % 23;
		String digitoControlCalculado = letras.substring(posicion_modulo, posicion_modulo + 1);
		if (!digitoControl.equalsIgnoreCase(digitoControlCalculado)) {
			return false;
		}
		return true;
	}

	static public char generarControlNIF(String NIF) {
		// Pasarlo a may�sculas
		String valor = NIF.toUpperCase();

		// Comprobar que la longitud sea 9
		if (valor.length() != 9) {
			return ' ';
		}

		Pattern patron = Pattern.compile("[0-9]{8,8}[A-Z]");
		Matcher matcher = patron.matcher(valor);

		if (!matcher.matches()) {
			return ' ';
		}

		String dni = valor.substring(0, 8);
		String digitoControl = valor.substring(8, 9);

		// Calculamos la letra de control
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		int posicion_modulo = Integer.parseInt(dni) % 23;
		String digitoControlCalculado = letras.substring(posicion_modulo, posicion_modulo + 1);
		return digitoControlCalculado.charAt(0);
	}

	public static boolean isNifNie(String nif) {
		boolean nie=false;
		String DNI=nif;
		// si es NIE, eliminar la x,y,z inicial para tratarlo como nif
		if (nif.toUpperCase().startsWith("X")) {
			nif = nif.substring(1);
			nie=true;
		}
		if (nif.toUpperCase().startsWith("Y")) {
			nif = "1" + nif.substring(1);
			nie=true;
		}
		if (nif.toUpperCase().startsWith("Z")) {
			nif = "2" + nif.substring(1);
			nie=true;
		}	
		
		if(nie){
		  if(DNI.length() != 9)
		    return false;
		}else{
			if(nif.length() > 9)
				return false;				
		}	

		Pattern nifPattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKE])");
		
		Matcher m = nifPattern.matcher(nif);
		if (m.matches()) {
			String letra = m.group(2);
			// Extraer letra del NIF
			String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
			int dni = Integer.parseInt(m.group(1));
			dni = dni % 23;
			String reference = letras.substring(dni, dni + 1);

			if (reference.equalsIgnoreCase(letra)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// Para saber si tratamos un nif (true) o un nie(false)
	public static boolean isNifOrNie(String nif) {
		if (isNifNie(nif) == true) {
			if (isNumeric(nif.charAt(0)))
				return true;
		}
		return false;
	}

	public static boolean isNumeric(char caract) {
		String cadena = new String("" + caract);
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static boolean isNumeric(Object numer) {
		try {
			Long.parseLong((String) numer);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		for (int i = 1; i < 200; i++) {
			String fin = "" + i;
			String cifMolde = "0000000";
			String cif = cifMolde.substring(0, cifMolde.length() - fin.length() + 1) + i + 'A';
			char generarControlCIF = new ValidadorNIF().generarControlNIF(cif);
			String cifCorr = cif.substring(0, cif.length() - 1) + generarControlCIF;
			if (new ValidadorNIF().validarNIF(cifCorr)) {
				log.debug(cifCorr);
			} else {
				log.debug("Error");
			}
		}
	}

}
