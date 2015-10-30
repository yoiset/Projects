package es.dgoj.rgiaj.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgoj.core.auditoria.negocio.access.AudNegocioAccess;
import com.dgoj.core.common.bean.ParamBean;
import com.dgoj.core.common.bean.UserBean;
import com.dgoj.seguridad.business.webservice.securitywebservice.ResultAudNegocioBean;
import com.jeveris.core.reporting.ReportFactoryBean;
import com.jeveris.reporting.jasper.JRDatasourceReportFillManagerHelper;
import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.TipoProhibicionBean;
import es.dgoj.rgiaj.business.beans.TipoProhibicionQueryBean;
import es.dgoj.rgiaj.business.beans.TipoProhibicionSearchResult;
import es.dgoj.rgiaj.business.model.TipoProhibicion;
import es.dgoj.rgiaj.business.repository.TipoProhibicionRepository;
import es.dgoj.rgiaj.business.service.TipoProhibicionService;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;
import es.dgoj.rgiaj.business.util.UtilBusiness;

/**
 * Implementacion del servicio de mantenimiento de tipos de prohibicion.
 * @author connectis
 */

@Service("tipoProhibicionService")
public class TipoProhibicionServiceImpl implements TipoProhibicionService {

	/** Campo tipo prohibicion repository. */
	@Autowired
	private TipoProhibicionRepository<TipoProhibicion,Long> tipoProhibicionRepository;
	
	/** Constante LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(TipoProhibicionServiceImpl.class);

	/**
	 * Interfaz de catalogo de Servicios de reporting.
	 */
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;	

	/**
	 * Devuelve los tipos de prohibicion buscados.
	 * @param tipoProhibicionQueryBean parametros de busqueda del tipo de prohibicion
	 * @return TipoProhibicionSearchResult resultados
	 */
	@Override
	public TipoProhibicionSearchResult getTiposProhibicion(TipoProhibicionQueryBean tipoProhibicionQueryBean){
	
		TipoProhibicionSearchResult resultado = new TipoProhibicionSearchResult();

		SearchResults<TipoProhibicion> lista = tipoProhibicionRepository.getTiposProhibicion(tipoProhibicionQueryBean);
	
		ArrayList<TipoProhibicionBean> listaResultados = new ArrayList<TipoProhibicionBean>();
		
		for (TipoProhibicion tipo : lista.getResults()){
			TipoProhibicionBean nuevoJugadorBean = new TipoProhibicionBean(tipo);
			listaResultados.add(nuevoJugadorBean);
		}
		
		resultado.setResults(listaResultados);
		resultado.setNumResults(Long.valueOf(lista.getTotal()));
		
				
		return resultado;
	}

	@Override
	public List<ParamBean> getListaTiposProhibicion(){
	
		TipoProhibicionQueryBean tipoQueryBean = new TipoProhibicionQueryBean();
		tipoQueryBean.setFirstResult(0);
		tipoQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);

		SearchResults<TipoProhibicion> lista = tipoProhibicionRepository.getTiposProhibicion(tipoQueryBean);
	
		ArrayList<ParamBean> listaResultados = new ArrayList<ParamBean>();
		
		for (TipoProhibicion tipo : lista.getResults()){
			ParamBean nuevoBean = new ParamBean(tipo.getId().toString(), tipo.getDescripcion());
			listaResultados.add(nuevoBean);
		}
				
		return listaResultados;
	}
	
	/**
	 * Devuelve el tipo de prohibicion por Id
	 *
	 * @param id 
	 * @return TipoProhibicionBean bean del tipo de prohibicion
	 */
	@Override
	public TipoProhibicionBean getTipoProhibicionById(Long id){
	
		TipoProhibicion tipoProhibicion = tipoProhibicionRepository.getTipoProhibicionById(id);

		if (tipoProhibicion == null){
			return null;
		} else {
			return new TipoProhibicionBean(tipoProhibicion);
		} 
	
	}
	
	/**
	 * Devuelve el tipo de prohibicion por codigo.
	 * @param codigo
	 * @return TipoProhibicionBean bean del tipo de prohibicion
	 */
	@Override
	public TipoProhibicionBean getTipoProhibicionByCodigo(String codigo){
		
		TipoProhibicion tipoProhibicion = tipoProhibicionRepository.getTipoProhibicionByCodigo(codigo);

		if (tipoProhibicion==null){
			return null;
		} else {
			return new TipoProhibicionBean(tipoProhibicion);
		}
	}
	
	/**
	 * Devuelve el tipo de prohibicion por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return TipoProhibicionBean bean del tipo de prohibicion
	 */
	@Override
	public TipoProhibicionBean getTipoProhibicionByCodigoNoID(Long id, String codigo){
		
		TipoProhibicion tipoProhibicion = tipoProhibicionRepository.getTipoProhibicionByCodigoNoID(id, codigo);

		if (tipoProhibicion == null){
			return null;
		} else {
			return new TipoProhibicionBean(tipoProhibicion);
		}
	}
	
	/**
	 * Alta de un tipo de prohibicion.
	 * @param tipoProhibicionBean bean del tipo de prohibicion
	 * @param userBean bean con los datos de usuario
	 */
	@Override
	@Transactional	
	public void altaTipoProhibicion(TipoProhibicionBean tipoProhibicionBean, UserBean userBean){
		tipoProhibicionRepository.add(tipoProhibicionBean.getEntity());

		//Registrando Auditoria de Negocio para alta de tipos de prohibicion.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_TIPO_PROHIBICION", "NUEVA", "Creado el tipo de prohibicion con el ID: " +  tipoProhibicionBean.getId()
			+ ", codigo: " +  tipoProhibicionBean.getCodigo()
			+ ", descripcion: " + tipoProhibicionBean.getDescripcion()
			+ ", activo: " + tipoProhibicionBean.getActivo()	
			+ " en la tabla JUG_TIPO_PROHIBICION");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}

		return ;
	}

	/**
	 * Edicion de un tipo de prohibicion.
	 *
	 * @param tipoProhibicionBean un tipo de prohibicion
	 * @param userBean datos del usuario
	 * @return TipoProhibicionBean el tipo de prohibicion modificado
	 */
	@Override
	@Transactional	
	public TipoProhibicionBean editarTipoProhibicion(TipoProhibicionBean tipoProhibicionBean, UserBean userBean){
		tipoProhibicionRepository.updateTipoProhibicion(tipoProhibicionBean.getEntity());
		
		//Registrando Auditoria de Negocio para modificacion de tipos de prohibicion.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_TIPO_PROHIBICION", "MODIFICAR", "Modificado el tipo de prohibicion con el ID: " + tipoProhibicionBean.getId()
			+ ", codigo: " +  tipoProhibicionBean.getCodigo()
			+ ", descripcion: " + tipoProhibicionBean.getDescripcion()
			+ ", activo: " + tipoProhibicionBean.getActivo()	
			+ " en la tabla JUG_TIPO_PROHIBICION");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		return tipoProhibicionBean;
	}
		
	/**
	 * Baja de un tipo de prohibicion.
	 * @param id
	 * @param userBean bean con los datos de usuario
	 * @return true, en caso de exito
	 */
	@Override
	@Transactional	
	public boolean bajaTipoProhibicion(Long id, UserBean userBean){
		//Registrando Auditoria de Negocio para borrado de tipos de prohibicion.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_TIPO_PROHIBICION", "BORRAR", "Borrado el tipo de prohibicion con el ID: " +  id
			+ " en la tabla JUG_TIPO_PROHIBICION");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		
		return tipoProhibicionRepository.deleteTipoProhibicion(id);
	}
	
	/**
	 * Exporta los datos de tipo de prohibicion a PDF
	 *
	 * @param username
	 * @param tipoProhibicionQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	public byte[] exportTipoProhibicion(String username, TipoProhibicionQueryBean tipoProhibicionQueryBean, String reportType, String reportName, String reportTitle){
		
		// Consultamos la informacion a exportar
		tipoProhibicionQueryBean.setFirstResult(0);
		tipoProhibicionQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);
		TipoProhibicionSearchResult tipoProhibicionSearchResult = this.getTiposProhibicion(tipoProhibicionQueryBean);
		
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(tipoProhibicionSearchResult.getResults()));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
	}
	

}
