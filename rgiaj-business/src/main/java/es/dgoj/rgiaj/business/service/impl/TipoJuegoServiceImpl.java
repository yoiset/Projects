package es.dgoj.rgiaj.business.service.impl;

import java.util.ArrayList;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgoj.core.auditoria.negocio.access.AudNegocioAccess;
import com.dgoj.core.common.bean.UserBean;
import com.dgoj.seguridad.business.webservice.securitywebservice.ResultAudNegocioBean;
import com.jeveris.core.reporting.ReportFactoryBean;
import com.jeveris.reporting.jasper.JRDatasourceReportFillManagerHelper;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.TipoJuegoBean;
import es.dgoj.rgiaj.business.beans.TipoJuegoQueryBean;
import es.dgoj.rgiaj.business.beans.TipoJuegoSearchResult;
import es.dgoj.rgiaj.business.model.TipoJuego;
import es.dgoj.rgiaj.business.repository.TipoJuegoRepository;
import es.dgoj.rgiaj.business.service.TipoJuegoService;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;
import es.dgoj.rgiaj.business.util.UtilBusiness;

/**
 * Implementacion del servicio de mantenimiento de tipos de prohibicion.
 * @author connectis
 */

@Service("tipoJuegoService")
public class TipoJuegoServiceImpl implements TipoJuegoService {

	/** Campo tipo prohibicion repository. */
	@Autowired
	private TipoJuegoRepository<TipoJuego,Long> tipoJuegoRepository;
	
	/** Constante LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(TipoJuegoServiceImpl.class);

	/**
	 * Interfaz de catalogo de Servicios de reporting.
	 */
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;	

	/**
	 * Devuelve los tipos de prohibicion buscados.
	 * @param tipoJuegoQueryBean parametros de busqueda del tipo de prohibicion
	 * @return TipoJuegoSearchResult resultados
	 */
	@Override
	public TipoJuegoSearchResult getTiposJuego(TipoJuegoQueryBean tipoJuegoQueryBean){
	
		TipoJuegoSearchResult resultado = new TipoJuegoSearchResult();

		SearchResults<TipoJuego> lista = tipoJuegoRepository.getTiposJuego(tipoJuegoQueryBean);
	
		ArrayList<TipoJuegoBean> listaResultados = new ArrayList<TipoJuegoBean>();
		
		for (TipoJuego tipo : lista.getResults()){
			TipoJuegoBean nuevoJugadorBean = new TipoJuegoBean(tipo);
			listaResultados.add(nuevoJugadorBean);
		}
		
		resultado.setResults(listaResultados);
		resultado.setNumResults(Long.valueOf(lista.getTotal()));
		
				
		return resultado;
	}

	/**
	 * Devuelve el tipo de prohibicion por Id
	 *
	 * @param id 
	 * @return TipoJuegoBean bean del tipo de prohibicion
	 */
	@Override
	public TipoJuegoBean getTipoJuegoById(Long id){
	
		TipoJuego tipoJuego = tipoJuegoRepository.getTipoJuegoById(id);

		if (tipoJuego == null){
			return null;
		} else {
			return new TipoJuegoBean(tipoJuego);
		} 
	
	}
	
	/**
	 * Devuelve el tipo de prohibicion por codigo.
	 * @param codigo
	 * @return TipoJuegoBean bean del tipo de prohibicion
	 */
	@Override
	public TipoJuegoBean getTipoJuegoByCodigo(String codigo){
		
		TipoJuego tipoJuego = tipoJuegoRepository.getTipoJuegoByCodigo(codigo);

		if (tipoJuego==null){
			return null;
		} else {
			return new TipoJuegoBean(tipoJuego);
		}
	}
	
	/**
	 * Devuelve el tipo de prohibicion por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return TipoJuegoBean bean del tipo de prohibicion
	 */
	@Override
	public TipoJuegoBean getTipoJuegoByCodigoNoID(Long id, String codigo){
		
		TipoJuego tipoJuego = tipoJuegoRepository.getTipoJuegoByCodigoNoID(id, codigo);

		if (tipoJuego == null){
			return null;
		} else {
			return new TipoJuegoBean(tipoJuego);
		}
	}
	
	/**
	 * Alta de un tipo de prohibicion.
	 * @param tipoJuegoBean bean del tipo de prohibicion
	 * @param userBean bean con los datos de usuario
	 */
	@Override
	@Transactional	
	public void altaTipoJuego(TipoJuegoBean tipoJuegoBean, UserBean userBean){
		tipoJuegoRepository.add(tipoJuegoBean.getEntity());

		//Registrando Auditoria de Negocio para alta de jugadores de prueba.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_TIPO_PROHIBICION", "NUEVA", "Creado el tipo de prohibicion con el ID: " +  tipoJuegoBean.getId()
			+ ", codigo: " +  tipoJuegoBean.getCodigo()
			+ ", descripcion: " + tipoJuegoBean.getDescripcion()
			+ ", activo: " + tipoJuegoBean.getActivo()	
			+ " en la tabla JUG_TIPO_PROHIBICION");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}

		return ;
	}

	/**
	 * Edicion de un tipo de prohibicion.
	 *
	 * @param tipoJuegoBean un tipo de prohibicion
	 * @param userBean datos del usuario
	 * @return TipoJuegoBean el tipo de prohibicion modificado
	 */
	@Override
	@Transactional	
	public TipoJuegoBean editarTipoJuego(TipoJuegoBean tipoJuegoBean, UserBean userBean){
		tipoJuegoRepository.updateTipoJuego(tipoJuegoBean.getEntity());
		
		//Registrando Auditoria de Negocio para alta de jugadores de prueba.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_TIPO_PROHIBICION", "MODIFICAR", "Modificado el tipo de prohibicion con el ID: " + tipoJuegoBean.getId()
			+ ", codigo: " +  tipoJuegoBean.getCodigo()
			+ ", descripcion: " + tipoJuegoBean.getDescripcion()
			+ ", activo: " + tipoJuegoBean.getActivo()	
			+ " en la tabla JUG_TIPO_PROHIBICION");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		return tipoJuegoBean;
	}
		
	/**
	 * Baja de un tipo de prohibicion.
	 * @param id
	 * @param userBean bean con los datos de usuario
	 * @return true, en caso de exito
	 */
	@Override
	@Transactional	
	public boolean bajaTipoJuego(Long id, UserBean userBean){
		//Registrando Auditoria de Negocio para alta de jugadores de prueba.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_TIPO_PROHIBICION", "BORRAR", "Borrado el tipo de prohibicion con el ID: " +  id
			+ " en la tabla JUG_TIPO_PROHIBICION");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		
		return tipoJuegoRepository.deleteTipoJuego(id);
	}
	
	/**
	 * Exporta los datos de tipo de prohibicion a PDF
	 *
	 * @param username
	 * @param tipoJuegoQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	public byte[] exportTipoJuego(String username, TipoJuegoQueryBean tipoJuegoQueryBean, String reportType, String reportName, String reportTitle){
		
		// Consultamos la informacion a exportar
		tipoJuegoQueryBean.setFirstResult(0);
		tipoJuegoQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);
		TipoJuegoSearchResult tipoJuegoSearchResult = this.getTiposJuego(tipoJuegoQueryBean);
		
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(tipoJuegoSearchResult.getResults()));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
	}
	

}
