package es.gob.cnjuego.ws.verificacionjugadores;

public class CodigosVerificacion {

	public static final String COD_INSCRITO_RGIAJ="COD001";
	public static final String COD_NO_INSCRITO_RGIAJ ="COD002";
	public static final String COD_IDENTIDAD_CORRECTA="COD003";
	public static final String COD_IDENTIDAD_INCORRECTA="COD004";
	public static final String COD_NO_VERIFICACION_IDENTIDAD="COD005";
	public static final String COD_IMPORTACION_REALIZADA="COD006";
	public static final String COD_IDENTIDAD_CORRECTA_CACHE="003_CACHE";
	public static final String COD_IDENTIDAD_INCORRECTA_CACHE="004_CACHE";
	public static final String COD_IDENTIDAD_CORRECTA_TEST="003 TEST";
	public static final String COD_IDENTIDAD_INCORRECTA_TEST="004 TEST";
	public static final String COD_NO_VERIFICACION_IDENTIDAD_TEST="005 TEST";
	
	public static final String COD_FORMATO_INCORRECTO="COD901";
	public static final String COD_IMPORTACION_NO_REALIZADA="COD903";
	public static final String COD_CARACTERES_INVALIDOS="COD902";
	public static final String COD_FALTA_CAMPO="COD903";
	public static final String COD_FECHA_NACIMINENTO="COD904";
	public static final String COD_NUM_SOPORTE="COD905";
	public static final String COD_NUM_SOPORTE_NIF="COD906";
	
	public static final String COD_BAJA_CAUSA="COD023";
	public static final String COD_BAJA_DNI_NO_ACTIVADO="COD021";
	public static final String COD_BAJA_DNI_BAJA="COD022";
	public static final String COD_BAJA_OK="COD010";

	
	public static final String ERROR_INTERNO="ERR001";
	public static final String ERROR_OPERADOR_INCORRECTO="ERR002";
	public static final String ERROR_JUGADORES_DUPLICADOS="ERR003";
	public static final String ERROR_OPERADOR_DESHABILITADO_O_EN_PRUEBA="ERR004";
	
	public static final String DESC_INSCRITO_RGIAJ="El usuario est\u00E1 inscrito en el RGIAJ";
	public static final String DESC_NO_INSCRITO_RGIAJ="El usuario no est\u00E1 inscrito en el RGIAJ";
	public static final String DESC_IDENTIDAD_CORRECTA="La identidad del usuario es correcta";
	public static final String DESC_IDENTIDAD_INCORRECTA="La identidad del usuario es incorrecta";
	public static final String DESC_IDENTIDAD_INCORRECTA_TEST="La identidad del usuario es incorrecta - TITULAR NO IDENTIFICADO";
	public static final String DESC_NO_VERIFICACION_IDENTIDAD="No se ha podido verificar la identidad del usuario";
	public static final String DESC_FORMATO_INCORRECTO="Formato de datos incorrecto";
	public static final String DESC_IMPORTACION_REALIZADA="Importaci\u00F3n de vinculadas realizada correctamente";
	public static final String DESC_IMPORTACION_NO_REALIZADA="No se ha podido realizar la importaci\u00F3n. Por favor, corrija los errores para reenviar la petici\u00F3n";
	public static final String DESC_CARACTERES_INVALIDOS="La petici\u00F3n tiene caracteres no v\u00E1lidos";
	
	
	
	public static final String DESC_ERROR_INTERNO="Error de aplicaci\u00F3n, consulte a la Direcci\u00F3n General de Ordenaci\u00F3n del Juego";
	public static final String DESC_ERROR_OPERADOR_INCORRECTO="Operador de Juego inv\u00E1lido, revise su certificado de firma";
	public static final String DESC_ERROR_JUGADORES_DUPLICADOS="La petici\u00F3n tiene identificadores de jugador duplicados, no es v\u00E1lida";
	public static final String DESC_ERROR_OPERADOR_DESHABILITADO_O_EN_PRUEBA="El operador esta deshabilitado o en modo de prueba";
	
	public static String DESC_ERROR_NOMBRE_CARACTERES_INV="La petici\u00F3n tiene caract\u00E9res no v\u00E1lidos en el Nombre"; 
	public static String DESC_ERROR_NOMBRE_NULL="Formato de datos incorrecto - Es obligatorio el nombre";	
	public static String DESC_ERROR_Apellido1_CARACTERES_INV="La petici\u00F3n tiene caract\u00E9res no v\u00E1lidos en el primer apellido"; 
	public static String DESC_ERROR_APELLIDO1_NULL="Formato de datos incorrecto - Es obligatorio el primer apellido";
	public static String DESC_ERROR_Apellido2_CARACTERES_INV="La petici\u00F3n tiene caract\u00E9res no v\u00E1lidos en el segundo apellido";
	public static String DESC_ERROR_Apellido2_NULL="Formato de datos incorrecto - Es obligatorio el segundo apellido";
	public static String DESC_ERROR_DNI_INV="Formato de datos incorrecto - DNI no v\u00E1lido";
	public static String DESC_ERROR_FECHA_NULL="Formato de datos incorrecto - Es obligatorio la fecha de nacimiento";
	public static String DESC_ERROR_FECHA_ANTERIOR_1900="Formato de datos incorrecto - Fecha de nacimiento anterior a 1900";
	public static String DESC_ERROR_DNI_NULL="Formato de datos incorrecto - Es obligatorio el DNI";
	
	public static String DESC_ERROR_NUM_SOPORTE="Formato de datos incorrecto - N\u00FAmero de Soporte err\u00F3neo";
	public static String DESC_ERROR_NUM_SOPORTE_NIF="Formato de datos incorrecto - Con NIF no se puede enviar N\u00FAmero de Soporte";	
	
	public static String DESC_ERROR_BAJA_CAUSA="Formato de datos incorrecto - Baja no realizada, causa de la baja err\u00F3nea";
	public static String DESC_ERROR_BAJA_DNI_NO_ACTIVADO="Baja no realizada, el DNI no est\u00E1 activado para este Operador";
	public static String DESC_ERROR_BAJA_DNI_BAJA="Baja no realizada, el DNI ya est\u00E1 dado de baja para este Operador";
	public static final String DESC_BAJA_OK="Baja realizada correctamente";
	
	
	
	public static String getDescripcion(String codigo) {
		String res = null;
		if (codigo.equals(COD_IDENTIDAD_CORRECTA))
			res = DESC_IDENTIDAD_CORRECTA;
		else if (codigo.equals(COD_IDENTIDAD_INCORRECTA))
			res = DESC_IDENTIDAD_INCORRECTA;
		else if (codigo.equals(COD_IDENTIDAD_CORRECTA_CACHE))
			res = DESC_IDENTIDAD_CORRECTA;
		else if (codigo.equals(COD_IDENTIDAD_INCORRECTA_CACHE))
			res = DESC_IDENTIDAD_INCORRECTA;
		return res;
	}
	
}
