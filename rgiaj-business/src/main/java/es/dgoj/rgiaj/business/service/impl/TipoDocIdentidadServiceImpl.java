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

import es.dgoj.rgiaj.business.beans.TipoDocIdentidadBean;
import es.dgoj.rgiaj.business.beans.TipoDocIdentidadQueryBean;
import es.dgoj.rgiaj.business.beans.TipoDocIdentidadSearchResult;
import es.dgoj.rgiaj.business.model.TipoDocIdentidad;
import es.dgoj.rgiaj.business.repository.TipoDocIdentidadRepository;
import es.dgoj.rgiaj.business.service.TipoDocIdentidadService;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;
import es.dgoj.rgiaj.business.util.UtilBusiness;

/**
 * Implementacion del servicio de mantenimiento de tipos de documento de identidad.
 * @author connectis
 */

@Service("tipoDocIdentidadService")
public class TipoDocIdentidadServiceImpl implements TipoDocIdentidadService {

	/** Campo tipo documento de identidad repository. */
	@Autowired
	private TipoDocIdentidadRepository<TipoDocIdentidad,Long> tipoDocIdentidadRepository;
	
	/** Constante LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(TipoDocIdentidadServiceImpl.class);

	/**
	 * Interfaz de catalogo de Servicios de reporting.
	 */
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;	

	/**
	 * Devuelve los tipos de documento de identidad buscados.
	 * @param tipoDocIdentidadQueryBean parametros de busqueda del tipo de documento de identidad
	 * @return TipoDocIdentidadSearchResult resultados
	 */
	@Override
	public TipoDocIdentidadSearchResult getTiposDocIdentidad(TipoDocIdentidadQueryBean tipoDocIdentidadQueryBean){
	
		TipoDocIdentidadSearchResult resultado = new TipoDocIdentidadSearchResult();

		SearchResults<TipoDocIdentidad> lista = tipoDocIdentidadRepository.getTiposDocIdentidad(tipoDocIdentidadQueryBean);
	
		ArrayList<TipoDocIdentidadBean> listaResultados = new ArrayList<TipoDocIdentidadBean>();
		
		for (TipoDocIdentidad tipo : lista.getResults()){
			TipoDocIdentidadBean nuevoJugadorBean = new TipoDocIdentidadBean(tipo);
			listaResultados.add(nuevoJugadorBean);
		}
		
		resultado.setResults(listaResultados);
		resultado.setNumResults(Long.valueOf(lista.getTotal()));
		
				
		return resultado;
	}

	/**
	 * Devuelve el tipo de documento de identidad por Id
	 *
	 * @param id 
	 * @return TipoDocIdentidadBean bean del tipo de documento de identidad
	 */
	@Override
	public TipoDocIdentidadBean getTipoDocIdentidadById(Long id){
	
		TipoDocIdentidad tipoDocIdentidad = tipoDocIdentidadRepository.getTipoDocIdentidadById(id);

		if (tipoDocIdentidad == null){
			return null;
		} else {
			return new TipoDocIdentidadBean(tipoDocIdentidad);
		} 
	
	}
	
	/**
	 * Devuelve el tipo de documento de identidad por codigo.
	 * @param codigo
	 * @return TipoDocIdentidadBean bean del tipo de documento de identidad
	 */
	@Override
	public TipoDocIdentidadBean getTipoDocIdentidadByCodigo(String codigo){
		
		TipoDocIdentidad tipoDocIdentidad = tipoDocIdentidadRepository.getTipoDocIdentidadByCodigo(codigo);

		if (tipoDocIdentidad==null){
			return null;
		} else {
			return new TipoDocIdentidadBean(tipoDocIdentidad);
		}
	}
	
	/**
	 * Devuelve el tipo de documento de identidad por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return TipoDocIdentidadBean bean del tipo de documento de identidad
	 */
	@Override
	public TipoDocIdentidadBean getTipoDocIdentidadByCodigoNoID(Long id, String codigo){
		
		TipoDocIdentidad tipoDocIdentidad = tipoDocIdentidadRepository.getTipoDocIdentidadByCodigoNoID(id, codigo);

		if (tipoDocIdentidad == null){
			return null;
		} else {
			return new TipoDocIdentidadBean(tipoDocIdentidad);
		}
	}
	
	/**
	 * Alta de un tipo de documento de identidad.
	 * @param tipoDocIdentidadBean bean del tipo de documento de identidad
	 * @param userBean bean con los datos de usuario
	 */
	@Override
	@Transactional	
	public void altaTipoDocIdentidad(TipoDocIdentidadBean tipoDocIdentidadBean, UserBean userBean){
		tipoDocIdentidadRepository.add(tipoDocIdentidadBean.getEntity());

		//Registrando Auditoria de Negocio para alta de tipos de documentos de identidad.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_TIPO_DOC_IDENT", "NUEVA", "Creado el tipo de documento de identidad con el ID: " +  tipoDocIdentidadBean.getId()
			+ ", codigo: " +  tipoDocIdentidadBean.getCodigo()
			+ ", descripcion: " + tipoDocIdentidadBean.getDescripcion()
			+ ", activo: " + tipoDocIdentidadBean.getActivo()	
			+ " en la tabla JUG_TIPO_DOC_IDENT");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}

		return ;
	}

	/**
	 * Edicion de un tipo de documento de identidad.
	 *
	 * @param tipoDocIdentidadBean un tipo de documento de identidad
	 * @param userBean datos del usuario
	 * @return TipoDocIdentidadBean el tipo de documento de identidad modificado
	 */
	@Override
	@Transactional	
	public TipoDocIdentidadBean editarTipoDocIdentidad(TipoDocIdentidadBean tipoDocIdentidadBean, UserBean userBean){
		tipoDocIdentidadRepository.updateTipoDocIdentidad(tipoDocIdentidadBean.getEntity());
		
		//Registrando Auditoria de Negocio para modificacion de tipos de documentos de identidad.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_TIPO_DOC_IDENT", "MODIFICAR", "Modificado el tipo de documento de identidad con el ID: " + tipoDocIdentidadBean.getId()
			+ ", codigo: " +  tipoDocIdentidadBean.getCodigo()
			+ ", descripcion: " + tipoDocIdentidadBean.getDescripcion()
			+ ", activo: " + tipoDocIdentidadBean.getActivo()	
			+ " en la tabla JUG_TIPO_DOC_IDENT");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		return tipoDocIdentidadBean;
	}
		
	/**
	 * Baja de un tipo de documento de identidad.
	 * @param id
	 * @param userBean bean con los datos de usuario
	 * @return true, en caso de exito
	 */
	@Override
	@Transactional	
	public boolean bajaTipoDocIdentidad(Long id, UserBean userBean){
		//Registrando Auditoria de Negocio para baja de tipos de documentos de identidad.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_TIPO_DOC_IDENT", "BORRAR", "Borrado el tipo de documento de identidad con el ID: " +  id
			+ " en la tabla JUG_TIPO_DOC_IDENT");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		
		return tipoDocIdentidadRepository.deleteTipoDocIdentidad(id);
	}
	
	/**
	 * Exporta los datos de tipo de documento de identidad a PDF
	 *
	 * @param username
	 * @param tipoDocIdentidadQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	public byte[] exportTipoDocIdentidad(String username, TipoDocIdentidadQueryBean tipoDocIdentidadQueryBean, String reportType, String reportName, String reportTitle){
		
		// Consultamos la informacion a exportar
		tipoDocIdentidadQueryBean.setFirstResult(0);
		tipoDocIdentidadQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);
		TipoDocIdentidadSearchResult tipoDocIdentidadSearchResult = this.getTiposDocIdentidad(tipoDocIdentidadQueryBean);
		
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(tipoDocIdentidadSearchResult.getResults()));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
	}

	/**
	 * Devuelve los tipos de documento de identidad para mostrarlos en un combo desplegable.
	 * @return List<ParamBean> resultados
	 */
	@Override
	public List<ParamBean> getListaTiposDocIdentidad() {
		
		TipoDocIdentidadQueryBean tipoDocIdentidadQueryBean = new TipoDocIdentidadQueryBean();
		tipoDocIdentidadQueryBean.setFirstResult(0);
		tipoDocIdentidadQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);
		
		SearchResults<TipoDocIdentidad> lista = tipoDocIdentidadRepository.getTiposDocIdentidad(tipoDocIdentidadQueryBean);
		
		ArrayList<ParamBean> listaResultados = new ArrayList<ParamBean>();
		
		for (TipoDocIdentidad tipo : lista.getResults()){
			ParamBean nuevoTipoBean = new ParamBean(tipo.getId().toString(), tipo.getDescripcion());
			listaResultados.add(nuevoTipoBean);
		}
		
		return listaResultados;
	}
	

}
