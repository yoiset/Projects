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

import es.dgoj.rgiaj.business.beans.ComunidadAutonomaBean;
import es.dgoj.rgiaj.business.beans.ComunidadAutonomaQueryBean;
import es.dgoj.rgiaj.business.beans.ComunidadAutonomaSearchResult;
import es.dgoj.rgiaj.business.model.ComunidadAutonoma;
import es.dgoj.rgiaj.business.repository.ComunidadAutonomaRepository;
import es.dgoj.rgiaj.business.service.ComunidadAutonomaService;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;
import es.dgoj.rgiaj.business.util.UtilBusiness;

/**
 * Implementacion del servicio de mantenimiento de comunidades autonomas.
 * @author connectis
 */

@Service("comunidadAutonomaService")
public class ComunidadAutonomaServiceImpl implements ComunidadAutonomaService {

	/** Campo comunidad autonoma repository. */
	@Autowired
	private ComunidadAutonomaRepository<ComunidadAutonoma,Long> comunidadAutonomaRepository;
	
	/** Constante LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ComunidadAutonomaServiceImpl.class);

	/**
	 * Interfaz de catalogo de Servicios de reporting.
	 */
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;	

	/**
	 * Devuelve las comunidades autonomas buscadas.
	 * @param comunidadAutonomaQueryBean parametros de busqueda de comunidades autónomas
	 * @return ComunidadAutonomaSearchResult resultados
	 */
	@Override
	public ComunidadAutonomaSearchResult getComunidadesAutonomas(ComunidadAutonomaQueryBean comunidadAutonomaQueryBean){
	
		ComunidadAutonomaSearchResult resultado = new ComunidadAutonomaSearchResult();

		SearchResults<ComunidadAutonoma> lista = comunidadAutonomaRepository.getComunidadesAutonomas(comunidadAutonomaQueryBean);
	
		ArrayList<ComunidadAutonomaBean> listaResultados = new ArrayList<ComunidadAutonomaBean>();
		
		for (ComunidadAutonoma tipo : lista.getResults()){
			ComunidadAutonomaBean nuevoJugadorBean = new ComunidadAutonomaBean(tipo);
			listaResultados.add(nuevoJugadorBean);
		}
		
		resultado.setResults(listaResultados);
		resultado.setNumResults(Long.valueOf(lista.getTotal()));
		
				
		return resultado;
	}

	/**
	 * Devuelve las comunidades autonomas buscadas.
	 * @param comunidadAutonomaQueryBean parametros de busqueda de comunidades autónomas
	 * @return ComunidadAutonomaSearchResult resultados
	 */
	@Override
	public List<ParamBean> getListaComunidadesAutonomas(){
	
		ComunidadAutonomaQueryBean comunidadAutonomaQueryBean = new ComunidadAutonomaQueryBean();
		comunidadAutonomaQueryBean.setFirstResult(0);
		comunidadAutonomaQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);

		SearchResults<ComunidadAutonoma> lista = comunidadAutonomaRepository.getComunidadesAutonomas(comunidadAutonomaQueryBean);
	
		ArrayList<ParamBean> listaResultados = new ArrayList<ParamBean>();
		
		for (ComunidadAutonoma ca : lista.getResults()){
			ParamBean nuevoJugadorBean = new ParamBean(ca.getId().toString(), ca.getDescripcion());
			listaResultados.add(nuevoJugadorBean);
		}
				
		return listaResultados;
	}	
	
	/**
	 * Devuelve la comunidad autonoma por Id
	 *
	 * @param id 
	 * @return ComunidadAutonomaBean bean de la comunidad autonoma
	 */
	@Override
	public ComunidadAutonomaBean getComunidadAutonomaById(Long id){
	
		ComunidadAutonoma comunidadAutonoma = comunidadAutonomaRepository.getComunidadAutonomaById(id);

		if (comunidadAutonoma == null){
			return null;
		} else {
			return new ComunidadAutonomaBean(comunidadAutonoma);
		} 
	
	}
	
	/**
	 * Devuelve la comunidad autonoma por codigo.
	 * @param codigo
	 * @return ComunidadAutonomaBean bean de la comunidad autonoma
	 */
	@Override
	public ComunidadAutonomaBean getComunidadAutonomaByCodigo(String codigo){
		
		ComunidadAutonoma comunidadAutonoma = comunidadAutonomaRepository.getComunidadAutonomaByCodigo(codigo);

		if (comunidadAutonoma==null){
			return null;
		} else {
			return new ComunidadAutonomaBean(comunidadAutonoma);
		}
	}
	
	/**
	 * Devuelve la comunidad autonoma por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return ComunidadAutonomaBean bean de la comunidad autonoma
	 */
	@Override
	public ComunidadAutonomaBean getComunidadAutonomaByCodigoNoID(Long id, String codigo){
		
		ComunidadAutonoma comunidadAutonoma = comunidadAutonomaRepository.getComunidadAutonomaByCodigoNoID(id, codigo);

		if (comunidadAutonoma == null){
			return null;
		} else {
			return new ComunidadAutonomaBean(comunidadAutonoma);
		}
	}
	
	/**
	 * Alta de una comunidad autonoma.
	 * @param comunidadAutonomaBean bean de la comunidad autonoma
	 * @param userBean bean con los datos de usuario
	 */
	@Override
	@Transactional	
	public void altaComunidadAutonoma(ComunidadAutonomaBean comunidadAutonomaBean, UserBean userBean){
		comunidadAutonomaRepository.add(comunidadAutonomaBean.getEntity());

		//Registrando Auditoria de Negocio para alta de comunidades autonomas.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_COMUNIDAD", "NUEVA", "Creada la comunidad autonoma con el ID: " +  comunidadAutonomaBean.getId()
			+ ", codigo: " +  comunidadAutonomaBean.getCodigo()
			+ ", descripcion: " + comunidadAutonomaBean.getDescripcion()
			+ ", activo: " + comunidadAutonomaBean.getActivo()	
			+ " en la tabla JUG_COMUNIDAD");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}

		return ;
	}

	/**
	 * Edicion de una comunidad autonoma.
	 *
	 * @param comunidadAutonomaBean una comunidad autonoma
	 * @param userBean datos del usuario
	 * @return ComunidadAutonomaBean la comunidad autonoma modificada
	 */
	@Override
	@Transactional	
	public ComunidadAutonomaBean editarComunidadAutonoma(ComunidadAutonomaBean comunidadAutonomaBean, UserBean userBean){
		comunidadAutonomaRepository.updateComunidadAutonoma(comunidadAutonomaBean.getEntity());
		
		//Registrando Auditoria de Negocio para modificar comunidades autonomas.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_COMUNIDAD", "MODIFICAR", "Modificada la comunidad autonoma con el ID: " + comunidadAutonomaBean.getId()
			+ ", codigo: " +  comunidadAutonomaBean.getCodigo()
			+ ", descripcion: " + comunidadAutonomaBean.getDescripcion()
			+ ", activo: " + comunidadAutonomaBean.getActivo()	
			+ " en la tabla JUG_COMUNIDAD");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		return comunidadAutonomaBean;
	}
		
	/**
	 * Baja de una comunidad autonoma.
	 * @param id
	 * @param userBean bean con los datos de usuario
	 * @return true, en caso de exito
	 */
	@Override
	@Transactional	
	public boolean bajaComunidadAutonoma(Long id, UserBean userBean){
		//Registrando Auditoria de Negocio para borrar comunidades autonomas
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_COMUNIDAD", "BORRAR", "Borrada la comunidad autonoma con el ID: " +  id
			+ " en la tabla JUG_COMUNIDAD");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		
		return comunidadAutonomaRepository.deleteComunidadAutonoma(id);
	}
	
	/**
	 * Exporta los datos de tipo de prohibicion a PDF
	 *
	 * @param username
	 * @param comunidadAutonomaQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	public byte[] exportComunidadAutonoma(String username, ComunidadAutonomaQueryBean comunidadAutonomaQueryBean, String reportType, String reportName, String reportTitle){
		
		// Consultamos la informacion a exportar
		comunidadAutonomaQueryBean.setFirstResult(0);
		comunidadAutonomaQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);
		ComunidadAutonomaSearchResult comunidadAutonomaSearchResult = this.getComunidadesAutonomas(comunidadAutonomaQueryBean);
		
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(comunidadAutonomaSearchResult.getResults()));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
	}
	

}
