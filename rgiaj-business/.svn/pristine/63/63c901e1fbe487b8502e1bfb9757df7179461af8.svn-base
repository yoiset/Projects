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

import es.dgoj.rgiaj.business.beans.CargoBean;
import es.dgoj.rgiaj.business.beans.CargoQueryBean;
import es.dgoj.rgiaj.business.beans.CargoSearchResult;
import es.dgoj.rgiaj.business.model.Cargo;
import es.dgoj.rgiaj.business.repository.CargoRepository;
import es.dgoj.rgiaj.business.service.CargoService;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;
import es.dgoj.rgiaj.business.util.UtilBusiness;

/**
 * Implementacion del servicio de mantenimiento de tipos de prohibicion.
 * @author connectis
 */

@Service("cargoService")
public class CargoServiceImpl implements CargoService {

	/** Campo cargo repository. */
	@Autowired
	private CargoRepository<Cargo,Long> cargoRepository;
	
	/** Constante LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CargoServiceImpl.class);

	/**
	 * Interfaz de catalogo de Servicios de reporting.
	 */
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;	

	/**
	 * Devuelve los tipos de prohibicion buscados.
	 * @param cargoQueryBean parametros de busqueda del cargo
	 * @return CargoSearchResult resultados
	 */
	@Override
	public CargoSearchResult getCargos(CargoQueryBean cargoQueryBean){
	
		CargoSearchResult resultado = new CargoSearchResult();

		SearchResults<Cargo> lista = cargoRepository.getCargos(cargoQueryBean);
	
		ArrayList<CargoBean> listaResultados = new ArrayList<CargoBean>();
		
		for (Cargo tipo : lista.getResults()){
			CargoBean nuevoJugadorBean = new CargoBean(tipo);
			listaResultados.add(nuevoJugadorBean);
		}
		
		resultado.setResults(listaResultados);
		resultado.setNumResults(Long.valueOf(lista.getTotal()));
		
				
		return resultado;
	}
	
	@Override
	public List<ParamBean> getListaCargos(){
	
		CargoQueryBean cargoQueryBean = new CargoQueryBean();
		cargoQueryBean.setFirstResult(0);
		cargoQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);

		SearchResults<Cargo> lista = cargoRepository.getCargos(cargoQueryBean);
	
		ArrayList<ParamBean> listaResultados = new ArrayList<ParamBean>();
		
		for (Cargo cargo : lista.getResults()){
			ParamBean nuevoBean = new ParamBean(cargo.getId().toString(), cargo.getDescripcion());
			listaResultados.add(nuevoBean);
		}
				
		return listaResultados;
	}

	/**
	 * Devuelve el cargo por Id
	 *
	 * @param id 
	 * @return CargoBean bean del cargo
	 */
	@Override
	public CargoBean getCargoById(Long id){
	
		Cargo cargo = cargoRepository.getCargoById(id);

		if (cargo == null){
			return null;
		} else {
			return new CargoBean(cargo);
		} 
	
	}
	
	/**
	 * Devuelve el cargo por codigo.
	 * @param codigo
	 * @return CargoBean bean del cargo
	 */
	@Override
	public CargoBean getCargoByCodigo(String codigo){
		
		Cargo cargo = cargoRepository.getCargoByCodigo(codigo);

		if (cargo==null){
			return null;
		} else {
			return new CargoBean(cargo);
		}
	}
	
	/**
	 * Devuelve el cargo por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return CargoBean bean del cargo
	 */
	@Override
	public CargoBean getCargoByCodigoNoID(Long id, String codigo){
		
		Cargo cargo = cargoRepository.getCargoByCodigoNoID(id, codigo);

		if (cargo == null){
			return null;
		} else {
			return new CargoBean(cargo);
		}
	}
	
	/**
	 * Alta de un cargo.
	 * @param cargoBean bean del cargo
	 * @param userBean bean con los datos de usuario
	 */
	@Override
	@Transactional	
	public void altaCargo(CargoBean cargoBean, UserBean userBean){
		cargoRepository.add(cargoBean.getEntity());

		//Registrando Auditoria de Negocio para alta de cargos.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_CARGO", "NUEVA", "Creado el cargo con el ID: " +  cargoBean.getId()
			+ ", codigo: " +  cargoBean.getCodigo()
			+ ", descripcion: " + cargoBean.getDescripcion()
			+ ", activo: " + cargoBean.getActivo()	
			+ " en la tabla JUG_CARGO");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}

		return ;
	}

	/**
	 * Edicion de un cargo.
	 *
	 * @param cargoBean un cargo
	 * @param userBean datos del usuario
	 * @return CargoBean el cargo modificado
	 */
	@Override
	@Transactional	
	public CargoBean editarCargo(CargoBean cargoBean, UserBean userBean){
		cargoRepository.updateCargo(cargoBean.getEntity());
		
		//Registrando Auditoria de Negocio para modificacion de cargos.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_CARGO", "MODIFICAR", "Modificado el cargo con el ID: " + cargoBean.getId()
			+ ", codigo: " +  cargoBean.getCodigo()
			+ ", descripcion: " + cargoBean.getDescripcion()
			+ ", activo: " + cargoBean.getActivo()	
			+ " en la tabla JUG_CARGO");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		return cargoBean;
	}
		
	/**
	 * Baja de un cargo.
	 * @param id
	 * @param userBean bean con los datos de usuario
	 * @return true, en caso de exito
	 */
	@Override
	@Transactional	
	public boolean bajaCargo(Long id, UserBean userBean){
		//Registrando Auditoria de Negocio para borrado de cargos.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_CARGOS", "BORRAR", "Borrado el cargo con el ID: " +  id
			+ " en la tabla JUG_CARGOS");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		
		return cargoRepository.deleteCargo(id);
	}
	
	/**
	 * Exporta los datos de cargo a PDF
	 *
	 * @param username
	 * @param cargoQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	public byte[] exportCargo(String username, CargoQueryBean cargoQueryBean, String reportType, String reportName, String reportTitle){
		
		// Consultamos la informacion a exportar
		cargoQueryBean.setFirstResult(0);
		cargoQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);
		CargoSearchResult cargoSearchResult = this.getCargos(cargoQueryBean);
		
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(cargoSearchResult.getResults()));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
	}
	

}
