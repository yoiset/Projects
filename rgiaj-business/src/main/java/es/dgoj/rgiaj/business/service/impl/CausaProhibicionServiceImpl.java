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

import es.dgoj.rgiaj.business.beans.CausaProhibicionBean;
import es.dgoj.rgiaj.business.beans.CausaProhibicionQueryBean;
import es.dgoj.rgiaj.business.beans.CausaProhibicionSearchResult;
import es.dgoj.rgiaj.business.model.CausaProhibicion;
import es.dgoj.rgiaj.business.repository.CausaProhibicionRepository;
import es.dgoj.rgiaj.business.service.CausaProhibicionService;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;
import es.dgoj.rgiaj.business.util.UtilBusiness;

/**
 * Implementacion del servicio de mantenimiento de causas de prohibicion.
 * @author connectis
 */

@Service("causaProhibicionService")
public class CausaProhibicionServiceImpl implements CausaProhibicionService {

	/** Campo causa prohibicion repository. */
	@Autowired
	private CausaProhibicionRepository<CausaProhibicion,Long> causaProhibicionRepository;
	
	/** Constante LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CausaProhibicionServiceImpl.class);

	/**
	 * Interfaz de catalogo de Servicios de reporting.
	 */
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;	

	/**
	 * Devuelve las causas de prohibicion buscadas.
	 * @param causaProhibicionQueryBean parametros de busqueda de la causa de prohibicion
	 * @return CausaProhibicionSearchResult resultados
	 */
	@Override
	public CausaProhibicionSearchResult getCausasProhibicion(CausaProhibicionQueryBean causaProhibicionQueryBean){
	
		CausaProhibicionSearchResult resultado = new CausaProhibicionSearchResult();

		SearchResults<CausaProhibicion> lista = causaProhibicionRepository.getCausasProhibicion(causaProhibicionQueryBean);
	
		ArrayList<CausaProhibicionBean> listaResultados = new ArrayList<CausaProhibicionBean>();
		
		for (CausaProhibicion causa : lista.getResults()){
			CausaProhibicionBean nuevoJugadorBean = new CausaProhibicionBean(causa);
			listaResultados.add(nuevoJugadorBean);
		}
		
		resultado.setResults(listaResultados);
		resultado.setNumResults(Long.valueOf(lista.getTotal()));
		
				
		return resultado;
	}
	
	@Override
	public List<ParamBean> getListaCausasProhibicion(){
	
		CausaProhibicionQueryBean causaQueryBean = new CausaProhibicionQueryBean();
		causaQueryBean.setFirstResult(0);
		causaQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);

		SearchResults<CausaProhibicion> lista = causaProhibicionRepository.getCausasProhibicion(causaQueryBean);
	
		ArrayList<ParamBean> listaResultados = new ArrayList<ParamBean>();
		
		for (CausaProhibicion causa : lista.getResults()){
			ParamBean nuevoBean = new ParamBean(causa.getId().toString(), causa.getDescripcion());
			listaResultados.add(nuevoBean);
		}
				
		return listaResultados;
	}

	/**
	 * Devuelve la causa de prohibicion por Id
	 *
	 * @param id 
	 * @return CausaProhibicionBean bean de la causa de prohibicion
	 */
	@Override
	public CausaProhibicionBean getCausaProhibicionById(Long id){
	
		CausaProhibicion causaProhibicion = causaProhibicionRepository.getCausaProhibicionById(id);

		if (causaProhibicion == null){
			return null;
		} else {
			return new CausaProhibicionBean(causaProhibicion);
		} 
	
	}
	
	/**
	 * Devuelve la causa de prohibicion por codigo.
	 * @param codigo
	 * @return CausaProhibicionBean bean de la causa de prohibicion
	 */
	@Override
	public CausaProhibicionBean getCausaProhibicionByCodigo(String codigo){
		
		CausaProhibicion causaProhibicion = causaProhibicionRepository.getCausaProhibicionByCodigo(codigo);

		if (causaProhibicion==null){
			return null;
		} else {
			return new CausaProhibicionBean(causaProhibicion);
		}
	}
	
	/**
	 * Devuelve la causa de prohibicion por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return CausaProhibicionBean bean de la causa de prohibicion
	 */
	@Override
	public CausaProhibicionBean getCausaProhibicionByCodigoNoID(Long id, String codigo){
		
		CausaProhibicion causaProhibicion = causaProhibicionRepository.getCausaProhibicionByCodigoNoID(id, codigo);

		if (causaProhibicion == null){
			return null;
		} else {
			return new CausaProhibicionBean(causaProhibicion);
		}
	}
	
	/**
	 * Alta de una causa de prohibicion.
	 * @param causaProhibicionBean bean de la causa de prohibicion
	 * @param userBean bean con los datos de usuario
	 */
	@Override
	@Transactional	
	public void altaCausaProhibicion(CausaProhibicionBean causaProhibicionBean, UserBean userBean){
		causaProhibicionRepository.add(causaProhibicionBean.getEntity());

		//Registrando Auditoria de Negocio para alta de causas de prohibicion.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_CAUSA_PROHIBICION", "NUEVA", "Creada la causa de prohibicion con el ID: " +  causaProhibicionBean.getId()
			+ ", codigo: " +  causaProhibicionBean.getCodigo()
			+ ", descripcion: " + causaProhibicionBean.getDescripcion()
			+ ", activo: " + causaProhibicionBean.getActivo()	
			+ " en la tabla JUG_CAUSA_PROHIBICION");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}

		return ;
	}

	/**
	 * Edicion de una causa de prohibicion.
	 *
	 * @param causaProhibicionBean una causa de prohibicion
	 * @param userBean datos del usuario
	 * @return CausaProhibicionBean la causa de prohibicion modificada
	 */
	@Override
	@Transactional	
	public CausaProhibicionBean editarCausaProhibicion(CausaProhibicionBean causaProhibicionBean, UserBean userBean){
		causaProhibicionRepository.updateCausaProhibicion(causaProhibicionBean.getEntity());
		
		//Registrando Auditoria de Negocio para modificacion de causas de prohibicion.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_CAUSA_PROHIBICION", "MODIFICAR", "Modificada la causa de prohibicion con el ID: " + causaProhibicionBean.getId()
			+ ", codigo: " +  causaProhibicionBean.getCodigo()
			+ ", descripcion: " + causaProhibicionBean.getDescripcion()
			+ ", activo: " + causaProhibicionBean.getActivo()	
			+ " en la tabla JUG_CAUSA_PROHIBICION");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		return causaProhibicionBean;
	}
		
	/**
	 * Baja de una causa de prohibicion.
	 * @param id
	 * @param userBean bean con los datos de usuario
	 * @return true, en caso de exito
	 */
	@Override
	@Transactional	
	public boolean bajaCausaProhibicion(Long id, UserBean userBean){
		//Registrando Auditoria de Negocio para baja de causas de prohibicion.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_CAUSA_PROHIBICION", "BORRAR", "Borrada la causa de prohibicion con el ID: " +  id
			+ " en la tabla JUG_CAUSA_PROHIBICION");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		
		return causaProhibicionRepository.deleteCausaProhibicion(id);
	}
	
	/**
	 * Exporta los datos de causas de prohibicion a PDF
	 *
	 * @param username
	 * @param causaProhibicionQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	public byte[] exportCausaProhibicion(String username, CausaProhibicionQueryBean causaProhibicionQueryBean, String reportType, String reportName, String reportTitle){
		
		// Consultamos la informacion a exportar
		causaProhibicionQueryBean.setFirstResult(0);
		causaProhibicionQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);
		CausaProhibicionSearchResult causaProhibicionSearchResult = this.getCausasProhibicion(causaProhibicionQueryBean);
		
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(causaProhibicionSearchResult.getResults()));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
	}
	

}
