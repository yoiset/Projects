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

import es.dgoj.rgiaj.business.beans.SituacionBean;
import es.dgoj.rgiaj.business.beans.SituacionQueryBean;
import es.dgoj.rgiaj.business.beans.SituacionSearchResult;
import es.dgoj.rgiaj.business.model.Situacion;
import es.dgoj.rgiaj.business.repository.SituacionRepository;
import es.dgoj.rgiaj.business.service.SituacionService;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;
import es.dgoj.rgiaj.business.util.UtilBusiness;

/**
 * Implementacion del servicio de mantenimiento de situaciones.
 * @author connectis
 */

@Service("situacionService")
public class SituacionServiceImpl implements SituacionService {

	/** Campo tipo prohibicion repository. */
	@Autowired
	private SituacionRepository<Situacion,Long> situacionRepository;
	
	/** Constante LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(SituacionServiceImpl.class);

	/**
	 * Interfaz de catalogo de Servicios de reporting.
	 */
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;	

	/**
	 * Devuelve las situaciones buscados.
	 * @param situacionQueryBean parametros de busqueda de las situaciones
	 * @return SituacionSearchResult resultados
	 */
	@Override
	public SituacionSearchResult getSituaciones(SituacionQueryBean situacionQueryBean){
	
		SituacionSearchResult resultado = new SituacionSearchResult();

		SearchResults<Situacion> lista = situacionRepository.getSituaciones(situacionQueryBean);
	
		ArrayList<SituacionBean> listaResultados = new ArrayList<SituacionBean>();
		
		for (Situacion tipo : lista.getResults()){
			SituacionBean nuevoJugadorBean = new SituacionBean(tipo);
			listaResultados.add(nuevoJugadorBean);
		}
		
		resultado.setResults(listaResultados);
		resultado.setNumResults(Long.valueOf(lista.getTotal()));
		
				
		return resultado;
	}

	@Override
	public List<ParamBean> getListaSituaciones(){
	
		SituacionQueryBean situacionQueryBean = new SituacionQueryBean();
		situacionQueryBean.setFirstResult(0);
		situacionQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);

		SearchResults<Situacion> lista = situacionRepository.getSituaciones(situacionQueryBean);
	
		ArrayList<ParamBean> listaResultados = new ArrayList<ParamBean>();
		
		for (Situacion situacion : lista.getResults()){
			ParamBean nuevoBean = new ParamBean(situacion.getId().toString(), situacion.getDescripcion());
			listaResultados.add(nuevoBean);
		}
				
		return listaResultados;
	}
	
	/**
	 * Devuelve la situacion por Id
	 *
	 * @param id 
	 * @return SituacionBean bean de la situacion
	 */
	@Override
	public SituacionBean getSituacionById(Long id){
	
		Situacion situacion = situacionRepository.getSituacionById(id);

		if (situacion == null){
			return null;
		} else {
			return new SituacionBean(situacion);
		} 
	
	}
	
	/**
	 * Devuelve la situacion por codigo.
	 * @param codigo
	 * @return SituacionBean bean de la situacion
	 */
	@Override
	public SituacionBean getSituacionByCodigo(String codigo){
		
		Situacion situacion = situacionRepository.getSituacionByCodigo(codigo);

		if (situacion==null){
			return null;
		} else {
			return new SituacionBean(situacion);
		}
	}
	
	/**
	 * Devuelve la situacion por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return SituacionBean bean de la situacion
	 */
	@Override
	public SituacionBean getSituacionByCodigoNoID(Long id, String codigo){
		
		Situacion situacion = situacionRepository.getSituacionByCodigoNoID(id, codigo);

		if (situacion == null){
			return null;
		} else {
			return new SituacionBean(situacion);
		}
	}
	
	/**
	 * Alta de una situacion.
	 * @param situacionBean bean de la situacion
	 * @param userBean bean con los datos de usuario
	 */
	@Override
	@Transactional	
	public void altaSituacion(SituacionBean situacionBean, UserBean userBean){
		situacionRepository.add(situacionBean.getEntity());

		//Registrando Auditoria de Negocio para alta de situaciones.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_SITUACION", "NUEVA", "Creada la situacion con el ID: " +  situacionBean.getId()
			+ ", codigo: " +  situacionBean.getCodigo()
			+ ", descripcion: " + situacionBean.getDescripcion()
			+ ", activo: " + situacionBean.getActivo()	
			+ " en la tabla JUG_SITUACION");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}

		return ;
	}

	/**
	 * Edicion de una situacion.
	 *
	 * @param situacionBean una situacion
	 * @param userBean datos del usuario
	 * @return SituacionBean la situacion modificada
	 */
	@Override
	@Transactional	
	public SituacionBean editarSituacion(SituacionBean situacionBean, UserBean userBean){
		situacionRepository.updateSituacion(situacionBean.getEntity());
		
		//Registrando Auditoria de Negocio para modificacion de situaciones.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_SITUACION", "MODIFICAR", "Modificada la situacion con el ID: " + situacionBean.getId()
			+ ", codigo: " +  situacionBean.getCodigo()
			+ ", descripcion: " + situacionBean.getDescripcion()
			+ ", activo: " + situacionBean.getActivo()	
			+ " en la tabla JUG_SITUACION");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		return situacionBean;
	}
		
	/**
	 * Baja de una situacion.
	 * @param id
	 * @param userBean bean con los datos de usuario
	 * @return true, en caso de exito
	 */
	@Override
	@Transactional	
	public boolean bajaSituacion(Long id, UserBean userBean){
		//Registrando Auditoria de Negocio para baja de situaciones.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_SITUACION", "BORRAR", "Borrado la situacion con el ID: " +  id
			+ " en la tabla JUG_SITUACION");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		
		return situacionRepository.deleteSituacion(id);
	}
	
	/**
	 * Exporta los datos de tipo de prohibicion a PDF
	 *
	 * @param username
	 * @param situacionQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	public byte[] exportSituacion(String username, SituacionQueryBean situacionQueryBean, String reportType, String reportName, String reportTitle){
		
		// Consultamos la informacion a exportar
		situacionQueryBean.setFirstResult(0);
		situacionQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);
		SituacionSearchResult situacionSearchResult = this.getSituaciones(situacionQueryBean);
		
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(situacionSearchResult.getResults()));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
	}
	

}
