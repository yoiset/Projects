package es.gob.cnjuego.ws.verificacionjugadores.control;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import es.gob.cnjuego.ws.dao.VerificacionDao;
import es.gob.cnjuego.ws.entity.JugadoresCambioRGIAJEntity;
import es.gob.cnjuego.ws.entity.OperadorEntity;
import es.gob.cnjuego.ws.service.GestionJugadoresService;
import es.gob.cnjuego.ws.service.JugadoresTestService;
import es.gob.cnjuego.ws.util.CodigoEstadoSCSP;
import es.gob.cnjuego.ws.util.Constantes;
import es.gob.cnjuego.ws.util.validation.ValidadorNIF;
import es.gob.cnjuego.ws.verificacionjugadores.Baja;
import es.gob.cnjuego.ws.verificacionjugadores.BajaJugadorFault_Exception;
import es.gob.cnjuego.ws.verificacionjugadores.CambioRGIAJ;
import es.gob.cnjuego.ws.verificacionjugadores.ClienteJuegoDniService;
import es.gob.cnjuego.ws.verificacionjugadores.ClienteSCSPService;
import es.gob.cnjuego.ws.verificacionjugadores.CodigosVerificacion;
import es.gob.cnjuego.ws.verificacionjugadores.Jugador;
import es.gob.cnjuego.ws.verificacionjugadores.ResultadoIdentidad;
import es.gob.cnjuego.ws.verificacionjugadores.ResultadoJugador;
import es.gob.cnjuego.ws.verificacionjugadores.ResultadoRGIAJ;
import es.gob.cnjuego.ws.verificacionjugadores.ResultadoType;
import es.gob.cnjuego.ws.verificacionjugadores.VerificarCambiosRGIAJFault_Exception;
import es.gob.cnjuego.ws.verificacionjugadores.VerificarIdentidadFault;
import es.gob.cnjuego.ws.verificacionjugadores.VerificarIdentidadFault_Exception;
import es.gob.cnjuego.ws.verificacionjugadores.VerificarJugadorFault;
import es.gob.cnjuego.ws.verificacionjugadores.VerificarJugadorFault_Exception;
import es.gob.cnjuego.ws.verificacionjugadores.VerificarRGIAJFault;
import es.gob.cnjuego.ws.verificacionjugadores.VerificarRGIAJFault_Exception;
import es.gob.cnjuego.ws.verificacionjugadores.control.validacion.ValidadorJugador;
import es.gob.cnjuego.ws.entity.*;

public class VerificacionJugadoresController {

	private Logger log = Logger.getLogger(VerificacionJugadoresController.class);

	// Operador y Lista de jugadores se asignan en el momento de creaci�n del
	// controller
	private OperadorEntity operador;
	private List<Jugador> jugadores;

	// DAOs y Services a los que se accede
	private VerificacionDao verificacionDao;
	private ClienteJuegoDniService clienteJuegoDniService;
	private ClienteSCSPService clienteSCSPService;
	private GestionJugadoresService gestionJugadoresService;
	private JugadoresTestService jugadoresTestService;

	/**
	 * @param operador
	 * @param jugadores
	 * @throws VerificarJugadorFault_Exception
	 */
	public VerificacionJugadoresController(OperadorEntity operador, VerificacionDao verificacionDao)
			throws VerificarCambiosRGIAJFault_Exception {
		super();
		if (operador == null) {
			throw new VerificarCambiosRGIAJFault_Exception();
		}

		this.operador = operador;
		this.verificacionDao=verificacionDao;
	}

	/**
	 * Constructor utilizado para la operaci�n VerificarIdentidad
	 * 
	 * @param operador
	 * @param jugadores
	 * @param gestionJugadoresService
	 * @param clienteSCSPService
	 * @param jugadoresTestService
	 * @param verificacionDao
	 * @throws VerificarIdentidadFault_Exception
	 */
	public VerificacionJugadoresController(OperadorEntity operador, List<Jugador> jugadores,
			GestionJugadoresService gestionJugadoresService, ClienteSCSPService clienteSCSPService,
			JugadoresTestService jugadoresTestService, VerificacionDao verificacionDao)
			throws VerificarIdentidadFault_Exception {
		super();
		log.debug("Creando controlador para VerificacionIdentidad");
		if ((operador == null) || (jugadores == null)) {
			throw new VerificarIdentidadFault_Exception();
		}

		this.operador = operador;
		this.jugadores = jugadores;
		this.clienteSCSPService = clienteSCSPService;
		this.gestionJugadoresService = gestionJugadoresService;
		this.jugadoresTestService = jugadoresTestService;
		this.verificacionDao = verificacionDao;
	}

	/**
	 * Constructor utilizado para la operaci�n VerificarRGIAJ
	 * 
	 * @param operador
	 * @param jugadores
	 * @param gestionJugadoresService
	 * @param clienteJuegoDniService
	 * @param jugadoresTestService
	 * @param verificacionDao
	 * @throws VerificarIdentidadFault_Exception
	 */
	public VerificacionJugadoresController(OperadorEntity operador, List<Jugador> jugadores,
			GestionJugadoresService gestionJugadoresService,
			ClienteJuegoDniService clienteJuegoDniService,
			JugadoresTestService jugadoresTestService, VerificacionDao verificacionDao)
			throws VerificarIdentidadFault_Exception {
		super();
		log.debug("Creando controlador para VerificacionRGIAJ");
		if ((operador == null) || (jugadores == null)) {
			throw new VerificarIdentidadFault_Exception();
		}

		this.operador = operador;
		this.jugadores = jugadores;
		this.clienteJuegoDniService = clienteJuegoDniService;
		this.gestionJugadoresService = gestionJugadoresService;
		this.jugadoresTestService = jugadoresTestService;
		this.verificacionDao = verificacionDao;
	}

	/* DGB */
	/**
	 * Constructor utilizado para la operaci�n VerificarJuego
	 * 
	 * @param operador
	 * @param jugadores
	 * @throws VerificarIdentidadFault_Exception
	 */
	public VerificacionJugadoresController(OperadorEntity operador, List<Jugador> jugadores,
			GestionJugadoresService gestionJugadoresService, ClienteSCSPService clienteSCSPService,
			ClienteJuegoDniService clienteJuegoDniService,
			JugadoresTestService jugadoresTestService, VerificacionDao verificacionDao)
			throws VerificarIdentidadFault_Exception {
		super();
		log.debug("Creando controlador para VerificacionJugadores");
		if ((operador == null) || (jugadores == null)) {
			throw new VerificarIdentidadFault_Exception();
		}

		this.operador = operador;
		this.jugadores = jugadores;
		this.clienteJuegoDniService = clienteJuegoDniService;
		this.clienteSCSPService = clienteSCSPService;
		this.gestionJugadoresService = gestionJugadoresService;
		this.jugadoresTestService = jugadoresTestService;
		this.verificacionDao = verificacionDao;
	}
	
	/* DGB */
	/**
	 * Constructor utilizado para la Operacion de Baja
	 * 
	 * @param operador
	 * @param jugadores
	 * @throws VerificarIdentidadFault_Exception
	 */
	public VerificacionJugadoresController(OperadorEntity operador,
			GestionJugadoresService gestionJugadoresService, ClienteSCSPService clienteSCSPService,
			ClienteJuegoDniService clienteJuegoDniService,
			JugadoresTestService jugadoresTestService, VerificacionDao verificacionDao)
			throws VerificarIdentidadFault_Exception {
		super();
		log.debug("Creando controlador para VerificacionJugadores");
		if ((operador == null)) {
			throw new VerificarIdentidadFault_Exception();
		}

		this.operador = operador;
		this.clienteJuegoDniService = clienteJuegoDniService;
		this.clienteSCSPService = clienteSCSPService;
		this.gestionJugadoresService = gestionJugadoresService;
		this.jugadoresTestService = jugadoresTestService;
		this.verificacionDao = verificacionDao;
	}

	/**
	 * Chequea el estado del Operador. Que no est� deshabilitado @ 0: Operador
	 * deshabilitado @ 1: Operador con peticiones de jugador para prueba @ 2:
	 * Operador con peticiones de jugador reales @ 3: Operador con ambos tipos
	 * de peticiones, reales y prueba
	 * 
	 * @param operador
	 * @throws VerificarIdentidadFault_Exception
	 */
	public void checkDesabilitado() throws VerificarIdentidadFault_Exception{
		log.debug("Chequeo de operador deshabilitado");
		if (operador.getModeEnabled() == 0) {
			log.debug("Operador deshabilitado");
			VerificarIdentidadFault fault2 = new VerificarIdentidadFault();
			fault2.setVerificarIdentidadFault(CodigosVerificacion.ERROR_OPERADOR_INCORRECTO);
			throw new VerificarIdentidadFault_Exception(CodigosVerificacion.DESC_ERROR_OPERADOR_INCORRECTO, fault2);
		}
	}

	/**
	 * Chequea la existencia de jugadores repetidos en la lista
	 * 
	 * @throws Exception
	 */
	public void checkJugadoresRepetidos() throws VerificarIdentidadFault_Exception {
		log.debug("Chequeo de jugadores repetidos en la lista proporcionada");
		List<String> dniList = new ArrayList<String>();
		for (Jugador jugador : jugadores) {
			if (dniList.contains(jugador.getDni().toUpperCase())) {
				log.debug("Hay jugadores repetidos");
				VerificarIdentidadFault fault = new VerificarIdentidadFault();
				fault.setVerificarIdentidadFault(CodigosVerificacion.ERROR_JUGADORES_DUPLICADOS);
				log.error("checkJugadoresRepetidos: Se han encontrado identificadores de jugador repetidos, la peticion no es valida");
				throw new VerificarIdentidadFault_Exception(CodigosVerificacion.DESC_ERROR_JUGADORES_DUPLICADOS, fault);
			}
			dniList.add(jugador.getDni().toUpperCase());
		}
	}

	/**
	 * Validaci�n del formato de DNI-NIE, Nombre, apellidos y Fecha Nacimiento.
	 * Validaci�n de los jugadores (SVDI o Pruebas) seg�n el estado del Operador
	 * 
	 * @return
	 * @throws VerificarIdentidadFault_Exception
	 */
	public List<ResultadoIdentidad> verificarIdentidad() throws VerificarIdentidadFault_Exception {
		List<ResultadoIdentidad> listaResultado = new ArrayList<ResultadoIdentidad>();
		List<ResultadoIdentidad> listaErrores = new ArrayList<ResultadoIdentidad>();
		List<ResultadoIdentidad> listaPruebas = new ArrayList<ResultadoIdentidad>();
		ResultadoIdentidad resIdentidad = null;

		log.debug("Verificar Identidad: comienzo de la verificacion");
		
		ValidadorJugador.setVerificacionDao(this.verificacionDao);

		for (Jugador jugador : jugadores) {
			boolean hayError = false;
			boolean hayPruebas = false;

			// Formatear Datos
			ValidadorJugador.formateaDatosJugador(jugador);

			// Valida los datos del jugador
			ResultadoType validation=ValidadorJugador.validarJugador(jugador);
			if (validation != null && CodigosVerificacion.COD_FORMATO_INCORRECTO.equals(validation.getCodigo())) {
				log.debug("Error Validando Jugador: " + validation.getDescripcion());
				listaErrores.add(this.generarResultadoIdentidadInvalido(jugador, validation));
				hayError = true;
			} else if (validation != null && CodigosVerificacion.COD_CARACTERES_INVALIDOS.equals(validation.getCodigo())) {
				log.debug("Error Validando Jugador: " + validation.getDescripcion());
				listaErrores.add(this.generarResultadoIdentidadInvalido(jugador, validation));
				hayError = true;
			}else if(validation!=null && CodigosVerificacion.COD_FALTA_CAMPO.equals(validation.getCodigo())){
				log.debug("Falta campo en el nombre o apellidos: " + validation.getDescripcion());
				listaErrores.add(this.generarResultadoIdentidadInvalido(jugador, validation));
				hayError = true;
			}else if(validation!=null && CodigosVerificacion.COD_FECHA_NACIMINENTO.equals(validation.getCodigo())){
				log.debug("Fecha de nacimiento del Jugador es inválida o anterior a 1900: " + validation.getDescripcion());
				listaErrores.add(this.generarResultadoIdentidadInvalido(jugador, validation));
				hayError = true;
			}else if(validation!=null && CodigosVerificacion.COD_NUM_SOPORTE.equals(validation.getCodigo())){
				log.debug("Error de Formato en el Numero de Soporte: " + validation.getDescripcion());
				listaErrores.add(this.generarResultadoIdentidadInvalido(jugador, validation));
				hayError = true;
			}else if(validation!=null && CodigosVerificacion.COD_NUM_SOPORTE_NIF.equals(validation.getCodigo())){
				log.debug("Error de Numero de Soporte: " + validation.getDescripcion());
				listaErrores.add(this.generarResultadoIdentidadInvalido(jugador, validation));
				hayError = true;
			}
			

			// Si el operador utiliza datos de prueba o datos de prueba y reales
			// se comprueban los usuarios en la BD
			if (!hayError && ((operador.getModeEnabled() == Constantes.OP_HABILITADO_PRU) || (operador.getModeEnabled() == Constantes.OP_HABILITADO_PRU_PRO))) {

				ResultadoIdentidad resJugador = null;

				log.debug("Operador permite usuarios de prueba (modo: "+operador.getModeEnabled()+")");
				try {
					resJugador = this.getJugadoresTestService().obtenerResultadoIdentidadTestWS(operador, jugador);
					if (resJugador != null) {
						log.debug("Es usuario de prueba: "+jugador.getDni());
						listaPruebas.add(resJugador);
						hayPruebas = true;
					}
				} catch (Exception ex) {
					log.error("Error llamada servicio : " + ex);
					VerificarIdentidadFault fault=new VerificarIdentidadFault();
					fault.setVerificarIdentidadFault(CodigosVerificacion.ERROR_INTERNO);
					throw new VerificarIdentidadFault_Exception(CodigosVerificacion.DESC_ERROR_INTERNO, fault);
				}
			}

			if (!hayError && !hayPruebas && (operador.getModeEnabled() == Constantes.OP_HABILITADO_PRU)){
				// El operador es de pruebas pero el usuario es de produccion se da como invalido
				listaPruebas.add(this.generarResultadoIdentidadInvalido(jugador, new ResultadoType(CodigosVerificacion.COD_IDENTIDAD_INCORRECTA_TEST, CodigosVerificacion.DESC_IDENTIDAD_INCORRECTA) ));
				hayPruebas = true;
			}
			
			resIdentidad = new ResultadoIdentidad();

			// Si el jugador no dio error en las comprobaciones y no es de
			// prueba se verifica su identidad
			if (!hayError && !hayPruebas) {

				log.debug("Es usuario real: "+jugador.getDni());
				// S�lo buscamos en cach� si no se cumple que est� activado el
				// debug y el DNI est� en la tabla de no cachear
				boolean debugActived=this.getVerificacionDao().getValorPropiedad(Constantes.PROP_MODO_DEBUG_IDENTIDAD).equals( "true");
				if (!debugActived || (debugActived && this.getGestionJugadoresService().esCacheable(jugador.getDni()))) {
					log.debug ("Se busca en cach\u00E9");
					// Buscar primero en la cach�
					String codResultadoBusquedaCache = null;

					try {
						codResultadoBusquedaCache = this.getGestionJugadoresService()
								.identidadJugadorCache(jugador.getDni(),
										jugador.getFechaNacimiento(), jugador.getNombre(),
										jugador.getApellido1(), jugador.getApellido2(), jugador.getNumSoporte());
					} catch (Exception e) {
						log.error("Error verificando Identidad " + e.getMessage(),e);
						VerificarIdentidadFault fault=new VerificarIdentidadFault();
						fault.setVerificarIdentidadFault(CodigosVerificacion.ERROR_INTERNO);
						throw new VerificarIdentidadFault_Exception(CodigosVerificacion.DESC_ERROR_INTERNO, fault);
					}

					// Si existe en cach� se devuelve el valor
					if (codResultadoBusquedaCache != null) {
						log.debug("Est\u00E1 en cach\u00E9");
						resIdentidad.setDni(jugador.getDni());
						resIdentidad.setResultadoIdentidad(new ResultadoType());
						resIdentidad.getResultadoIdentidad().setCodigo(codResultadoBusquedaCache);
						resIdentidad.getResultadoIdentidad().setDescripcion(CodigosVerificacion.getDescripcion(codResultadoBusquedaCache));
						
						// Si no existe en cach� se busca en el servicio de la
						// polic�a
					} else {
						log.debug("No est\u00E1 en cach\u00E9, se consulta al servicio de la policia");
						CodigoEstadoSCSP codigoResultado = null;
						try {
							codigoResultado = this.getClienteSCSPService().verificarIdentidad(jugador.getDni(),jugador.getNumSoporte(),  jugador.getNombre(), jugador.getApellido1(),
									jugador.getApellido2(), jugador.getFechaNacimiento());
						} catch (Exception e) {
							log.error("Error verificando Identidad con cliente SCP " + e.getMessage(),e);
							codigoResultado=new CodigoEstadoSCSP();						
							codigoResultado.setCodigo(CodigosVerificacion.COD_NO_VERIFICACION_IDENTIDAD);
							codigoResultado.setDescripcion(CodigosVerificacion.DESC_NO_VERIFICACION_IDENTIDAD);
//							throw new VerificarIdentidadFault_Exception(e.getMessage(),e);
						}
						resIdentidad.setDni(jugador.getDni());
						resIdentidad.setResultadoIdentidad(new ResultadoType());
						resIdentidad.getResultadoIdentidad().setCodigo(codigoResultado.getCodigo());
						resIdentidad.getResultadoIdentidad().setDescripcion(codigoResultado.getDescripcion());
						
					}

				} else {
					log.debug("No se debe consultar cach\u00E9, se consulta al servicio de la policia");
					
					// Se comprueba la identidad llamando al servicio
					CodigoEstadoSCSP codigoResultado = null;
					try {
						codigoResultado = this.getClienteSCSPService().verificarIdentidad(jugador.getDni(), jugador.getNumSoporte(), jugador.getNombre(), jugador.getApellido1(),
								jugador.getApellido2(), jugador.getFechaNacimiento());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						log.error("Error verificando Identidad " + e.getMessage(),e);
						codigoResultado=new CodigoEstadoSCSP();						
						codigoResultado.setCodigo(CodigosVerificacion.COD_NO_VERIFICACION_IDENTIDAD);
						codigoResultado.setDescripcion(CodigosVerificacion.DESC_NO_VERIFICACION_IDENTIDAD);
						
					}
					resIdentidad.setDni(jugador.getDni());
					resIdentidad.setResultadoIdentidad(new ResultadoType());
					resIdentidad.getResultadoIdentidad().setCodigo(codigoResultado.getCodigo());
					resIdentidad.getResultadoIdentidad().setDescripcion(
							codigoResultado.getDescripcion());
				}

				listaResultado.add(resIdentidad);
			}

		}

		listaResultado.addAll(listaErrores);
		listaResultado.addAll(listaPruebas);

		return listaResultado;

	}	
	
	/**
	 * @return listaResultados
	 * @throws VerificarRGIAJFault_Exception
	 */
	public List<ResultadoRGIAJ> verificarRGIAJ() throws VerificarRGIAJFault_Exception {
		List<ResultadoRGIAJ> listaResultado = new ArrayList<ResultadoRGIAJ>();
		List<ResultadoRGIAJ> listaErrores = new ArrayList<ResultadoRGIAJ>();
		List<ResultadoRGIAJ> listaPruebas = new ArrayList<ResultadoRGIAJ>();
		List<String> listaDni = new ArrayList<String>();
		
		log.debug("Verificar RGIAJ: comienzo de la verificacion");
		
		ValidadorJugador.setVerificacionDao(this.verificacionDao);

		for (Jugador jugador : jugadores) {
			boolean hayError = false;
			boolean hayPruebas = false;

			// Se formatean los datos del jugador
			ValidadorJugador.formateaDatosJugador(jugador);

			// Valida los datos del jugador
			ResultadoType validation=ValidadorJugador.validarJugador(jugador);
			if (validation!=null && CodigosVerificacion.COD_FORMATO_INCORRECTO.equals(validation.getCodigo())) {
				log.debug("Formato incorrecto en Jugador: " + validation.getDescripcion());
				listaErrores.add(this.generarResultadoRGIAJInvalido(jugador, validation));
				hayError = true;
			} else if (validation!=null && CodigosVerificacion.COD_CARACTERES_INVALIDOS.equals(validation.getCodigo())) {
				log.debug("Caracteres invalidos en jugador: " + validation.getDescripcion());
				listaErrores.add(this.generarResultadoRGIAJInvalido(jugador, validation));
				hayError = true;
			}else if(validation!=null && CodigosVerificacion.COD_FALTA_CAMPO.equals(validation.getCodigo())){
				log.debug("Falta campo en el nombre o apellidos: " + validation.getDescripcion());
				listaErrores.add(this.generarResultadoRGIAJInvalido(jugador, validation));
				hayError = true;
			}else if(validation!=null && CodigosVerificacion.COD_FECHA_NACIMINENTO.equals(validation.getCodigo())){
				log.debug("Fecha de nacimiento del Jugador es invalida o anterior a 1900: " + validation.getDescripcion());
				listaErrores.add(this.generarResultadoRGIAJInvalido(jugador, validation));
				hayError = true;
			} if(validation!=null && CodigosVerificacion.COD_NUM_SOPORTE.equals(validation.getCodigo())){
				log.debug("Error de Formato en el Numero de Soporte: " + validation.getDescripcion());
				listaErrores.add(this.generarResultadoRGIAJInvalido(jugador, validation));
				hayError = true;
			}else if(validation!=null && CodigosVerificacion.COD_NUM_SOPORTE_NIF.equals(validation.getCodigo())){
				log.debug("Error de Numero de Soporte: " + validation.getDescripcion());
				listaErrores.add(this.generarResultadoRGIAJInvalido(jugador, validation));
				hayError = true;
			}

			// Si el operador utiliza datos de prueba o datos de prueba y reales
			// se comprueban los usuarios en la BD
			if (!hayError && (operador.getModeEnabled() == Constantes.OP_HABILITADO_PRU	|| operador.getModeEnabled() == Constantes.OP_HABILITADO_PRU_PRO)) {

				ResultadoRGIAJ resJugador = null;
				log.debug("Operador permite usuarios de prueba (modo: "+operador.getModeEnabled()+")");
				try {
					resJugador = this.getJugadoresTestService().obtenerResultadoRGIAJTestWS(operador.getModeEnabled(), jugador);
					if (resJugador != null) {
						log.debug("Es usuario de prueba: "+jugador.getDni());
						listaPruebas.add(resJugador);
						hayPruebas = true;
					}
				} catch (Exception ex) {
					log.error("Error consultando Resultado RGIAJ", ex);
					VerificarRGIAJFault fault= new VerificarRGIAJFault();
					fault.setVerificarRGIAJFault(CodigosVerificacion.ERROR_INTERNO);
					throw new VerificarRGIAJFault_Exception(CodigosVerificacion.DESC_ERROR_INTERNO,fault);
				}
			}

			if (!hayError && !hayPruebas && (operador.getModeEnabled() == Constantes.OP_HABILITADO_PRU)){
				// El operador es de pruebas pero el usuario es de produccion se da como invalido
				listaPruebas.add(this.generarResultadoRGIAJInvalido(jugador, new ResultadoType(CodigosVerificacion.COD_NO_INSCRITO_RGIAJ, CodigosVerificacion.DESC_NO_INSCRITO_RGIAJ)));
				hayPruebas = true;
			}
			
			// Si el jugador no dio error en las comprobaciones y no es de
			// prueba a�adimos el DNI en la lista
			// para la consulta de incluidos en RGIAJ
			if (!hayError && !hayPruebas) {
				log.debug("Es usuario real: "+jugador.getDni());
				listaDni.add(jugador.getDni());
			}
		}

		if (!listaDni.isEmpty()) {
			try {
				log.debug("Se consulta al servicio que nos indica si estan en RGIAJ");
				listaResultado = this.getClienteJuegoDniService().verificarJuegoDni(listaDni);

			} catch (Exception e) {
				log.error("Error consultando estado RGIAJ " + e.getMessage(),e);
				VerificarRGIAJFault fault= new VerificarRGIAJFault();
				fault.setVerificarRGIAJFault(CodigosVerificacion.ERROR_INTERNO);
				throw new VerificarRGIAJFault_Exception(CodigosVerificacion.DESC_ERROR_INTERNO,fault);
			}
		}

		listaResultado.addAll(listaErrores);
		listaResultado.addAll(listaPruebas);

		return listaResultado;
	}

	/**
	 * @return
	 * @throws VerificarJugadorFault_Exception
	 */
	public List<ResultadoJugador> verificarJugador() throws VerificarJugadorFault_Exception {
		List<ResultadoJugador> listaResultado = new ArrayList<ResultadoJugador>();
		List<ResultadoIdentidad> listaResIdentidad = null;
		List<ResultadoRGIAJ> listaResRGIAJ = null;

		log.debug("Verificar Jugador: comienzo de la verificacion");
		
		// Se llama a los dos m�todos existentes para verificar la inclusi�n en
		// RGIAJ y su identidad
		// de la lista de jugadores.
		try {
			log.debug("Consultar estado de los jugadores en RGIAJ");
			listaResRGIAJ = this.verificarRGIAJ();
			log.debug("Consultar estado de la identidad de jugadores");
			listaResIdentidad = this.verificarIdentidad();
		} catch (VerificarRGIAJFault_Exception e) {
			log.error("Error verificando Jugador " + e.getMessage(),e);
			VerificarJugadorFault fault= new VerificarJugadorFault();
			fault.setVerificarJugadorFault(e.getFaultInfo().getVerificarRGIAJFault());
			throw new VerificarJugadorFault_Exception(e.getMessage(),fault);
		} catch (VerificarIdentidadFault_Exception e) {
			log.error("Error verificando Jugador " + e.getMessage(),e);
			VerificarJugadorFault fault= new VerificarJugadorFault();
			fault.setVerificarJugadorFault(e.getFaultInfo().getVerificarIdentidadFault());
			throw new VerificarJugadorFault_Exception(e.getMessage(),fault);
		}

		log.debug("Combinar resultados para Verificar Jugador");
		// Se unen ambas listas de resultados en una sola
		for (Jugador jugador : jugadores) {
			ResultadoJugador resultado = new ResultadoJugador();

			resultado.setDni(jugador.getDni());
			resultado.setResultadoRGIAJ(getResultadoRGIAJ(jugador.getDni(), listaResRGIAJ));
			resultado.setResultadoIdentidad(getResultadoIdentidad(jugador.getDni(),
					listaResIdentidad));

			listaResultado.add(resultado);
		}

		return listaResultado;

	}

	/*
	 * Metodo que devuelve el resultado RGIAJ para un DNI de una lista de
	 * resultados RGIAJ
	 */
	private ResultadoType getResultadoRGIAJ(String DNI, List<ResultadoRGIAJ> listaResultados) {
		for (ResultadoRGIAJ resultado : (ArrayList<ResultadoRGIAJ>) listaResultados) {
			if (resultado.getDni().equalsIgnoreCase(DNI)) {
				return resultado.getResultadoRGIAJ();
			}
		}
		return null;
	}

	/*
	 * Metodo que devuelve el resultado RGIAJ para un DNI de una lista de
	 * resultados RGIAJ
	 */
	private ResultadoType getResultadoIdentidad(String DNI, List<ResultadoIdentidad> listaResultados) {
		for (ResultadoIdentidad resultado : (ArrayList<ResultadoIdentidad>) listaResultados) {
			if (resultado.getDni().equalsIgnoreCase(DNI)) {
				return resultado.getResultadoIdentidad();
			}
		}
		return null;
	}

	/**
	 * Registra en la Tabla JugadoresOperadores (Cach�)
	 * 
	 * @param contexto
	 * @param list
	 * @param identidad
	 * @param rgia
	 * @throws Exception
	 */
	public void almacenarJugadoresConsultaRGIAJ(int idPeticion, List<ResultadoRGIAJ> listaResultados){
		almacenarConsultaJugadoresOperador(listaResultados, false, true, idPeticion);
	}

	public void almacenarJugadoresConsultaIdentidad(int idPeticion,
			List<ResultadoIdentidad> listaResultados){
		almacenarConsultaJugadoresOperador(listaResultados, true, false, idPeticion);
	}

	public void almacenarJugadoresConsultaJugadores(int idPeticion,
			List<ResultadoJugador> listaResultados){
		almacenarConsultaJugadoresOperador(listaResultados, true, true, idPeticion);
	}

	/**
	 * @param list
	 * @param identidad
	 * @param rgia
	 * @param idPeticion
	 * @throws Exception
	 */
	private void almacenarConsultaJugadoresOperador(List list, boolean identidad, boolean rgia, int idPeticion) {
		log.debug("<--------Inicio almacenar consulta jugadores con IdPeticion--------> ");
		log.debug("IdPeticion: " + idPeticion);
		
		if (jugadores != null) {
			for (Jugador jugador : jugadores) {
				String dni=jugador.getDni();
				StringBuffer buf= new StringBuffer();
				if (!ValidadorNIF.isNifNie(jugador.getDni())) {
                     if(jugador.getDni().length()>9)
                    	 dni=jugador.getDni().substring(0, 9);
                     if(dni==null || dni.trim().isEmpty()) return ;
                    	 
				}
				if (identidad && rgia) {
					log.debug("Almacenar jugador de consulta Verificar Jugadores");
					String res_rgiaj = null;
					String res_identidad = null;
					boolean validado = true;
					int indicador = 1;
					if(operador.getModeEnabled()==Constantes.OP_HABILITADO_PRU) indicador=4;
					if (!ValidadorJugador.todosCaracteresAlfanumericos(jugador))
						validado = false;
					for (Iterator<ResultadoJugador> iterRes = list.iterator(); iterRes.hasNext();) {
						ResultadoJugador resJugador = iterRes.next();
						if (resJugador.getDni().equalsIgnoreCase(jugador.getDni())) {
							res_rgiaj = resJugador.getResultadoRGIAJ()
									.getCodigo();
							res_identidad = resJugador.getResultadoIdentidad()
									.getCodigo();
							if (res_identidad
									.equals(CodigosVerificacion.COD_IDENTIDAD_CORRECTA_CACHE))
								resJugador
										.getResultadoIdentidad().setCodigo(CodigosVerificacion.COD_IDENTIDAD_CORRECTA);
							if (res_identidad
									.equals(CodigosVerificacion.COD_IDENTIDAD_INCORRECTA_CACHE))
								resJugador.getResultadoIdentidad().setCodigo(
												CodigosVerificacion.COD_IDENTIDAD_INCORRECTA);
							if (res_identidad
									.equals(CodigosVerificacion.COD_IDENTIDAD_CORRECTA_TEST))
								resJugador.getResultadoIdentidad().setCodigo(
												CodigosVerificacion.COD_IDENTIDAD_CORRECTA);
							if (res_identidad
									.equals(CodigosVerificacion.COD_IDENTIDAD_INCORRECTA_TEST))
								resJugador.getResultadoIdentidad().setCodigo(
												CodigosVerificacion.COD_IDENTIDAD_INCORRECTA);
							if (res_identidad
									.equals(CodigosVerificacion.COD_NO_VERIFICACION_IDENTIDAD_TEST))
								resJugador.getResultadoIdentidad().setCodigo(
												CodigosVerificacion.COD_NO_VERIFICACION_IDENTIDAD);
							
							if(res_rgiaj!=null && res_rgiaj.contains("TEST")){
								res_rgiaj=res_rgiaj.substring(0, 6);
								resJugador.getResultadoRGIAJ().setCodigo(res_rgiaj);
								indicador = 4;
							}
//							if (resJugador.getResultadoRGIAJ() != null	
//									&& resJugador.getResultadoRGIAJ().getCodigo() == "4")
//								indicador = 4;

							break;

						}
					}

					gestionJugadoresService.almacenarConsultaJugador(operador,
							dni, jugador.getNombre(),
							jugador.getApellido1(), jugador.getApellido2(),
							jugador.getFechaNacimiento(), indicador, indicador,
							res_rgiaj, res_identidad, idPeticion, validado, jugador.getNumSoporte());
				} else if (identidad) {
					log.debug("Almacenar jugador de consulta Verificar Identidad");

					String res_identidad = null;
					boolean validado = true;
					int indicador = 1;
					if(operador.getModeEnabled()==Constantes.OP_HABILITADO_PRU) indicador=4;
					if (!ValidadorJugador.todosCaracteresAlfanumericos(jugador))
						validado = false;
					for (Iterator<ResultadoIdentidad> iterRes = list.iterator(); iterRes
							.hasNext();) {
						ResultadoIdentidad resIdentidad = iterRes.next();
						if (resIdentidad.getDni().equalsIgnoreCase(jugador.getDni())) {
							res_identidad = resIdentidad.getResultadoIdentidad().getCodigo();
							
							if (res_identidad.equals(CodigosVerificacion.COD_IDENTIDAD_CORRECTA_CACHE))
								resIdentidad.getResultadoIdentidad().setCodigo(CodigosVerificacion.COD_IDENTIDAD_CORRECTA);
							
							if (res_identidad.equals(CodigosVerificacion.COD_IDENTIDAD_INCORRECTA_CACHE))
								resIdentidad.getResultadoIdentidad().setCodigo(CodigosVerificacion.COD_IDENTIDAD_INCORRECTA);
							
							if (res_identidad.equals(CodigosVerificacion.COD_IDENTIDAD_CORRECTA_TEST)) {
								indicador = 4;
								resIdentidad.getResultadoIdentidad().setCodigo(CodigosVerificacion.COD_IDENTIDAD_CORRECTA);
							}

							if (res_identidad.equals(CodigosVerificacion.COD_IDENTIDAD_INCORRECTA_TEST)) {
								indicador = 4;
								resIdentidad.getResultadoIdentidad().setCodigo(CodigosVerificacion.COD_IDENTIDAD_INCORRECTA);
							}
							if (res_identidad.equals(CodigosVerificacion.COD_NO_VERIFICACION_IDENTIDAD_TEST)) {
								indicador = 4;
								resIdentidad.getResultadoIdentidad().setCodigo(CodigosVerificacion.COD_NO_VERIFICACION_IDENTIDAD);
							}

							break;
						}
					}
					gestionJugadoresService.almacenarConsultaJugador(operador,
							dni, jugador.getNombre(),
							jugador.getApellido1(), jugador.getApellido2(),
							jugador.getFechaNacimiento(), indicador, 0, null,
							res_identidad, idPeticion, validado, jugador.getNumSoporte());
				} else if (rgia) {
					log.debug("Almacenar jugador de consulta Verificar RGIAJ");

					String res_rgiaj = null;
					int indicador = 1;
					if(operador.getModeEnabled()==Constantes.OP_HABILITADO_PRU) indicador=4;
					for (ResultadoRGIAJ resRGIAJ : (ArrayList<ResultadoRGIAJ>) list) {
						if (resRGIAJ.getDni().equalsIgnoreCase(jugador.getDni())) {
							res_rgiaj = resRGIAJ.getResultadoRGIAJ().getCodigo();
							if (res_rgiaj!=null && res_rgiaj.contains("TEST")) {
								res_rgiaj=res_rgiaj.substring(0, 6);
								resRGIAJ.getResultadoRGIAJ().setCodigo(res_rgiaj);
								indicador = 4;
							} 
							break;
						}
					}
					gestionJugadoresService.almacenarConsultaJugador(operador,
							dni, jugador.getNombre(),
							jugador.getApellido1(), jugador.getApellido2(),
							jugador.getFechaNacimiento(), 0, indicador,
							res_rgiaj, null, idPeticion, true,jugador.getNumSoporte());
				}

			}

		}
	}

	/**
	 * @param jugador
	 * @param codError
	 * @return
	 */
	private ResultadoRGIAJ generarResultadoRGIAJInvalido(Jugador jugador, ResultadoType type) {
		ResultadoRGIAJ res = new ResultadoRGIAJ();
		res.setDni(jugador.getDni());

		res.setResultadoRGIAJ(type);

		return res;
	}

	/**
	 * @param jugador
	 * @param codError
	 * @return resultadoIdentidad
	 */
	private ResultadoIdentidad generarResultadoIdentidadInvalido(Jugador jugador, ResultadoType type) {
		ResultadoIdentidad res = new ResultadoIdentidad();
		res.setDni(jugador.getDni());
		
		res.setResultadoIdentidad(type);

		return res;
	}
	
	/*
	 * M�todos get y set
	 */

	public ClienteJuegoDniService getClienteJuegoDniService() {
		return clienteJuegoDniService;
	}

	public void setClienteJuegoDniService(ClienteJuegoDniService clienteJuegoDniService) {
		this.clienteJuegoDniService = clienteJuegoDniService;
	}

	public VerificacionDao getVerificacionDao() {
		return verificacionDao;
	}

	public void setVerificacionDao(VerificacionDao verificacionDao) {
		this.verificacionDao = verificacionDao;
	}

	public GestionJugadoresService getGestionJugadoresService() {
		return gestionJugadoresService;
	}

	public void setGestionJugadoresService(GestionJugadoresService gestionJugadoresService) {
		this.gestionJugadoresService = gestionJugadoresService;
	}

	public JugadoresTestService getJugadoresTestService() {
		return jugadoresTestService;
	}

	public void setJugadoresTestService(JugadoresTestService jugadoresTestService) {
		this.jugadoresTestService = jugadoresTestService;
	}

	public ClienteSCSPService getClienteSCSPService() {
		return clienteSCSPService;
	}

	public void setClienteSCSPService(ClienteSCSPService clienteSCSPService) {
		this.clienteSCSPService = clienteSCSPService;
	}

	/** Se envia como DNI el valor XXXXXXXXX y COD=CODXXX
	 * Recarga la Tabla de configuracion
	 */
	public List<ResultadoIdentidad> reloadConf()throws VerificarIdentidadFault_Exception {
	  if(jugadores!=null)
		  for (Jugador jugador : jugadores) {
			if(jugador!=null && jugador.getDni()!=null && jugador.getDni().equalsIgnoreCase(Constantes.DNI_CHEQUEO_RECARGA_CONF)){
				if(verificacionDao!=null){
					List<ResultadoIdentidad> result=new ArrayList<ResultadoIdentidad>();
					verificacionDao.reloadCacheConfiguraciones();
					log.info("Recargada la Tabla de Configuracion");
					// se rellenan valores a esperar
					ResultadoIdentidad value= new ResultadoIdentidad();
					value.setDni(jugador.getDni());
					ResultadoType type=new ResultadoType();
					type.setCodigo("CODXXX");
					type.setDescripcion("Error de Formato");
					value.setResultadoIdentidad(type);
					result.add(value);
					return result;
				}
					
			}
			break;	
		}
      return null;
	}
	
	/** Retorna todos los cambios registrados en el estado de los jugadores de un operador en RGIAJ
	 */
	public List<CambioRGIAJ> verificarCambiosRGIAJ(){
		List<CambioRGIAJ> listaResultado = new ArrayList<CambioRGIAJ>();
		
        List<IJugadoresCambioRGIAJ> cambiosEntities = null;
		
        if(operador.getModeEnabled()==Constantes.OP_HABILITADO_PRU) // Se consultan los cambios en RGIAJ en Prueba
        	cambiosEntities = this.getVerificacionDao().getCambiosJugadoresTest(operador.getIdOperador());
        else // Se consultan los cambios en RGIAJ normalmente
		cambiosEntities = this.getVerificacionDao().getCambiosJugadores(operador.getIdOperador());
		
		// Para cada cambio se rellena el resultado a devolver en forma de lista
		for (IJugadoresCambioRGIAJ cambioEntity : cambiosEntities) {
			
			CambioRGIAJ cambio = new CambioRGIAJ();
			cambio.setDNI(cambioEntity.getId().getDni());
			cambio.setMotivoCambio(cambioEntity.getEvento());
			cambio.setFechaCambio(cambioEntity.getFechaValor());
			
			listaResultado.add(cambio);
		}
		
		return listaResultado;
		
	}

	public ResultadoType bajaJugador(Baja bajaJugador,  int idPeticion)throws BajaJugadorFault_Exception {
		// TODO Auto-generated method stub
		log.info("Peticion de Baja. **Operador " + operador.getIdOperador() + " **DNI: " + bajaJugador.getDni() + " **Causa: " + bajaJugador.getCausa());
		ResultadoType result=isInvalidDNI(bajaJugador.getDni());
		if(result!=null){
			if(bajaJugador.getDni()!=null && !bajaJugador.getDni().isEmpty())
			 gestionJugadoresService.almacenarBaja(operador,  bajaJugador, result,  idPeticion);
			return result;
		} 
		
		result=isInvalidCausa(bajaJugador.getCausa());
		if(result!=null){
			gestionJugadoresService.almacenarBaja(operador,  bajaJugador, result,  idPeticion);
			return result;
		} 
		
		result= gestionJugadoresService.getBaja(operador, bajaJugador.getDni());
		
		log.debug("Resultado de la Baja: " + result.getCodigo());		
		gestionJugadoresService.almacenarBaja(operador,  bajaJugador, result,  idPeticion);
		
		// Se actualiza el estado en el RGIAJ
		if(CodigosVerificacion.COD_BAJA_OK.equalsIgnoreCase(result.getCodigo()))
			gestionJugadoresService.actualizarBajaRIAGJ(operador, bajaJugador.getDni());
		
		return result;
	}
	
	private ResultadoType isInvalidDNI(String dni){
	  if(dni==null || dni.isEmpty())	
		return new ResultadoType(CodigosVerificacion.COD_FALTA_CAMPO, CodigosVerificacion.DESC_ERROR_DNI_NULL);
      if(ValidadorNIF.isNifNie(dni))
			return null;
		else return  new ResultadoType(CodigosVerificacion.COD_FORMATO_INCORRECTO, CodigosVerificacion.DESC_ERROR_DNI_INV); //CodigosVerificacion.COD_FORMATO_INCORRECTO;
		
	}
	
	private ResultadoType isInvalidCausa(String causa){
				
		if(causa!=null && !causa.isEmpty()){
			causa=causa.trim();
			if(causa.equalsIgnoreCase("A") || causa.equalsIgnoreCase("R"))
				return null;
		}		
		return 	new ResultadoType(CodigosVerificacion.COD_BAJA_CAUSA, CodigosVerificacion.DESC_ERROR_BAJA_CAUSA);	
	}

}
