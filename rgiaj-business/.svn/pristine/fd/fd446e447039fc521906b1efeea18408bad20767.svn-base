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

import es.dgoj.rgiaj.business.beans.TipoFirmaBean;
import es.dgoj.rgiaj.business.beans.TipoFirmaQueryBean;
import es.dgoj.rgiaj.business.beans.TipoFirmaSearchResult;
import es.dgoj.rgiaj.business.model.TipoFirma;
import es.dgoj.rgiaj.business.repository.TipoFirmaRepository;
import es.dgoj.rgiaj.business.service.TipoFirmaService;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;
import es.dgoj.rgiaj.business.util.UtilBusiness;

/**
 * Implementacion del servicio de mantenimiento de tipos de firma.
 * @author connectis
 */

@Service("tipoFirmaService")
public class TipoFirmaServiceImpl implements TipoFirmaService {

	/** Campo tipo firma repository. */
	@Autowired
	private TipoFirmaRepository<TipoFirma,Long> tipoFirmaRepository;
	
	/** Constante LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(TipoFirmaServiceImpl.class);

	/**
	 * Interfaz de catalogo de Servicios de reporting.
	 */
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;	

	/**
	 * Devuelve los tipos de firma buscados.
	 * @param tipoFirmaQueryBean parametros de busqueda del tipo de firma
	 * @return TipoFirmaSearchResult resultados
	 */
	@Override
	public TipoFirmaSearchResult getTiposFirma(TipoFirmaQueryBean tipoFirmaQueryBean){
	
		TipoFirmaSearchResult resultado = new TipoFirmaSearchResult();

		SearchResults<TipoFirma> lista = tipoFirmaRepository.getTiposFirma(tipoFirmaQueryBean);	
		ArrayList<TipoFirmaBean> listaResultados = new ArrayList<TipoFirmaBean>();
		
		for (TipoFirma tipo : lista.getResults()){
			TipoFirmaBean nuevoJugadorBean = new TipoFirmaBean(tipo);
			listaResultados.add(nuevoJugadorBean);
		}
		
		resultado.setResults(listaResultados);
		resultado.setNumResults(Long.valueOf(lista.getTotal()));
		
				
		return resultado;
	}

	/**
	 * Devuelve el tipo de firma por Id
	 *
	 * @param id 
	 * @return TipoFirmaBean bean del tipo de firma
	 */
	@Override
	public TipoFirmaBean getTipoFirmaById(Long id){
	
		TipoFirma tipoFirma = tipoFirmaRepository.getTipoFirmaById(id);

		if (tipoFirma == null){
			return null;
		} else {
			return new TipoFirmaBean(tipoFirma);
		} 
	
	}
	
	/**
	 * Devuelve el tipo de firma por codigo.
	 * @param codigo
	 * @return TipoFirmaBean bean del tipo de firma
	 */
	@Override
	public TipoFirmaBean getTipoFirmaByCodigo(String codigo){
		
		TipoFirma tipoFirma = tipoFirmaRepository.getTipoFirmaByCodigo(codigo);

		if (tipoFirma==null){
			return null;
		} else {
			return new TipoFirmaBean(tipoFirma);
		}
	}
	
	/**
	 * Devuelve el tipo de firma por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return TipoFirmaBean bean del tipo de firma
	 */
	@Override
	public TipoFirmaBean getTipoFirmaByCodigoNoID(Long id, String codigo){
		
		TipoFirma tipoFirma = tipoFirmaRepository.getTipoFirmaByCodigoNoID(id, codigo);

		if (tipoFirma == null){
			return null;
		} else {
			return new TipoFirmaBean(tipoFirma);
		}
	}
	
	/**
	 * Alta de un tipo de firma.
	 * @param tipoFirmaBean bean del tipo de firma
	 * @param userBean bean con los datos de usuario
	 */
	@Override
	@Transactional	
	public void altaTipoFirma(TipoFirmaBean tipoFirmaBean, UserBean userBean){
		tipoFirmaRepository.add(tipoFirmaBean.getEntity());

		//Registrando Auditoria de Negocio para alta de tipos de firma.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_FIRMA", "NUEVA", "Creado el tipo de firma con el ID: " +  tipoFirmaBean.getId()
			+ ", codigo: " +  tipoFirmaBean.getCodigo()
			+ ", descripcion: " + tipoFirmaBean.getDescripcion()
			+ ", activo: " + tipoFirmaBean.getActivo()	
			+ " en la tabla JUG_FIRMA");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}

		return ;
	}

	/**
	 * Edicion de un tipo de firma.
	 *
	 * @param tipoFirmaBean un tipo de firma
	 * @param userBean datos del usuario
	 * @return TipoFirmaBean el tipo de firma modificado
	 */
	@Override
	@Transactional	
	public TipoFirmaBean editarTipoFirma(TipoFirmaBean tipoFirmaBean, UserBean userBean){
		tipoFirmaRepository.updateTipoFirma(tipoFirmaBean.getEntity());
		
		//Registrando Auditoria de Negocio para modificacion de tipos de firma.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_FIRMA", "MODIFICAR", "Modificado el tipo de firma con el ID: " + tipoFirmaBean.getId()
			+ ", codigo: " +  tipoFirmaBean.getCodigo()
			+ ", descripcion: " + tipoFirmaBean.getDescripcion()
			+ ", activo: " + tipoFirmaBean.getActivo()	
			+ " en la tabla JUG_FIRMA");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		return tipoFirmaBean;
	}
		
	/**
	 * Baja de un tipo de firma.
	 * @param id
	 * @param userBean bean con los datos de usuario
	 * @return true, en caso de exito
	 */
	@Override
	@Transactional	
	public boolean bajaTipoFirma(Long id, UserBean userBean){
		//Registrando Auditoria de Negocio para borrado de tipos de firma.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_FIRMA", "BORRAR", "Borrado el tipo de firma con el ID: " +  id
			+ " en la tabla JUG_FIRMA");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		
		return tipoFirmaRepository.deleteTipoFirma(id);
	}
	
	/**
	 * Exporta los datos de tipo de firma a PDF
	 *
	 * @param username
	 * @param tipoFirmaQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	public byte[] exportTipoFirma(String username, TipoFirmaQueryBean tipoFirmaQueryBean, String reportType, String reportName, String reportTitle){
		
		// Consultamos la informacion a exportar
		tipoFirmaQueryBean.setFirstResult(0);
		tipoFirmaQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);
		TipoFirmaSearchResult tipoFirmaSearchResult = this.getTiposFirma(tipoFirmaQueryBean);
		
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(tipoFirmaSearchResult.getResults()));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
	}
	

}
