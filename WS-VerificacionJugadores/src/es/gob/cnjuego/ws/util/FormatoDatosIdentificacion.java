package es.gob.cnjuego.ws.util;

import java.util.Date;

public class FormatoDatosIdentificacion {

	
	static String original = "áàäâéèëêíìïîóòöôúùûÁÀÄÂÉÈËÊÍÌÏÎÓÒÖÔÚÙÛ";
	static String traduccion = "aaaaeeeeiiiioooouuuAAAAEEEEIIIIOOOOUUU";
	
	private static void initFormateo(String acentosOrig, String acentosTrad){
		// Método que inicializa las variables original y traducción con la traducción de acentos procedente de la BD
		if (acentosOrig != null){
			original = acentosOrig;
		}
		
		if (acentosTrad != null){
			traduccion = acentosTrad;
		}
	}
	
	/**
	 * Función que normaliza un nombre, pasándolo a minúsculas y eliminando acentuación innecesaria
	 * @param nombre
	 * @param acentosTrad 
	 * @param acentosOrig 
	 * @return la cadena del nombre en minúsculas y sin acentos
	 */
	public static String formateaAcentos(String nombre, String acentosOrig, String acentosTrad)
	{
		initFormateo(acentosOrig, acentosTrad);
		
		if (nombre==null){
			return null;
		}
		
		String resultado = nombre;
		//Se quitan los guiones sustituyéndolos por espacios en blanco
		resultado = resultado.replaceAll("-", " ");
		//Eliminar espacios en blanco duplicados
		resultado = resultado.replaceAll("\\s+", " ");

		if (nombre != null && nombre.length()>0){
			for (int i=0; i<original.length(); i++){
				// Reemplazamos los caracteres especiales.
				resultado = resultado.replace(original.charAt(i), traduccion.charAt(i));
			}
			resultado = resultado.toLowerCase();
		}
		
		//Elimina los espacios vacíos por la izquierda o derecha
		resultado = resultado.trim();
		
		return resultado;
	}
	
	
	/**
	 * FunciÃ³n que formatea una fecha de nacimiento eliminando la zona horaria
	 * @param fecha
	 */
	public static void formateaFechaNacimiento(Date fecha)
	{
//		fecha.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
	}
	
	
	/**
	 * FunciÃ³n que valida que un campo tenga contenido, y no sea una simple cadena de espacios en blanco
	 * @param nombre
	 * @return true si el campo tiene contenido, false si es nulo, o su longitud es 0, 
	 * o si es Ãºnicamente una secuencia de espacios en blanco
	 */
	public static boolean validarCampo(String nombre)
	{
		boolean res = false;
		if (nombre != null && nombre.length()>0 && nombre.trim().length() >0)
			res = true;
			
		return res;
	}
	
	
	
	
	public static boolean validarCaracteres(String nombre, String invalidos)
	{
		boolean res = true;
		for (int i=0; i<invalidos.length(); i++){
			// Reemplazamos los caracteres especiales.
			if (nombre.indexOf(invalidos.charAt(i)) != -1){
				res = false;
				break;
			}
		}
		return res;
	}
	
	
	public static boolean todosCaracteresPermitidos(String nombre, String permitidos)
	{
		boolean res = true;
		for (int i=0; i<nombre.length(); i++){
			// Reemplazamos los caracteres especiales.
			if (permitidos.indexOf(nombre.charAt(i)) == -1){
				res = false;
				break;
			}
		}
		return res;
		
	}
	
	
	
}
