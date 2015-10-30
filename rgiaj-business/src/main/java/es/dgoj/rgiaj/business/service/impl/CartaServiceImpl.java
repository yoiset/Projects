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

import es.dgoj.rgiaj.business.beans.CartaBean;
import es.dgoj.rgiaj.business.beans.CartaQueryBean;
import es.dgoj.rgiaj.business.beans.CartaSearchResult;
import es.dgoj.rgiaj.business.model.Carta;
import es.dgoj.rgiaj.business.repository.CartaRepository;
import es.dgoj.rgiaj.business.service.CartaService;
import es.dgoj.rgiaj.business.util.ConstantesBusiness;
import es.dgoj.rgiaj.business.util.UtilBusiness;

/**
 * Implementacion del servicio de mantenimiento de cartas.
 * @author connectis
 */

@Service("cartaService")
public class CartaServiceImpl implements CartaService {

	/** Campo carta repository. */
	@Autowired
	private CartaRepository<Carta,Long> cartaRepository;
	
	/** Constante LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CartaServiceImpl.class);

	/**
	 * Interfaz de catalogo de Servicios de reporting.
	 */
	@Autowired
	private ReportFactoryBean reportListDatasourceRunner;	

	/**
	 * Devuelve las cartas buscadas.
	 * @param cartaQueryBean, parametros de busqueda de la carta
	 * @return CartaSearchResult, resultados
	 */
	@Override
	public CartaSearchResult getCartas(CartaQueryBean cartaQueryBean){
	
		CartaSearchResult resultado = new CartaSearchResult();

		SearchResults<Carta> lista = cartaRepository.getCartas(cartaQueryBean);
	
		ArrayList<CartaBean> listaResultados = new ArrayList<CartaBean>();
		
		for (Carta tipo : lista.getResults()){
			CartaBean nuevoJugadorBean = new CartaBean(tipo);
			listaResultados.add(nuevoJugadorBean);
		}
		
		resultado.setResults(listaResultados);
		resultado.setNumResults(Long.valueOf(lista.getTotal()));
		
				
		return resultado;
	}

	/**
	 * Devuelve la carta por Id
	 *
	 * @param id 
	 * @return CartaBean, bean de la carta
	 */
	@Override
	public CartaBean getCartaById(Long id){
	
		Carta carta = cartaRepository.getCartaById(id);

		if (carta == null){
			return null;
		} else {
			return new CartaBean(carta);
		} 
	
	}
	
	/**
	 * Devuelve el carta por codigo.
	 * @param codigo
	 * @return CartaBean bean del carta
	 
	@Override
	public CartaBean getCartaByCodigo(String codigo){
		
		Carta carta = cartaRepository.getCartaByCodigo(codigo);

		if (carta==null){
			return null;
		} else {
			return new CartaBean(carta);
		}
	}*/
	
	/**
	 * Devuelve el carta por codigo que no tenga el Id.
	 * @param id 
	 * @param codigo
	 * @return CartaBean bean del carta
	
	@Override
	public CartaBean getCartaByCodigoNoID(Long id, String codigo){
		
		Carta carta = cartaRepository.getCartaByCodigoNoID(id, codigo);

		if (carta == null){
			return null;
		} else {
			return new CartaBean(carta);
		}
	} */
	
	/**
	 * Alta de una carta.
	 * @param cartaBean, bean de la carta
	 * @param userBean, bean con los datos de usuario
	 */
	@Override
	@Transactional	
	public void altaCarta(CartaBean cartaBean, UserBean userBean){
		cartaRepository.add(cartaBean.getEntity());

		//Registrando Auditoria de Negocio para alta de cartas.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_CARTAS", "NUEVA", "Creada la carta con el ID: " +  cartaBean.getId()
			+ ", descripcion: " + cartaBean.getDescripcion()
			+ ", texto: " + cartaBean.getTexto()
			+ ", pie: " + cartaBean.getPie()
			+ ", cargo: " + cartaBean.getCargo()
			+ ", responsable: " + cartaBean.getResponsable()
			+ " en la tabla JUG_CARTAS");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}

		return ;
	}

	/**
	 * Edicion de una carta.
	 *
	 * @param cartaBean, una carta
	 * @param userBean, datos del usuario
	 * @return CartaBean, la carta modificada
	 */
	@Override
	@Transactional	
	public CartaBean editarCarta(CartaBean cartaBean, UserBean userBean){
		cartaRepository.updateCarta(cartaBean.getEntity());
		
		//Registrando Auditoria de Negocio para modificacion de cartas.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_CARTAS", "MODIFICAR", "Modificada la carta con el ID: " + cartaBean.getId()
			+ ", descripcion: " + cartaBean.getDescripcion()
			+ ", texto: " + cartaBean.getTexto()
			+ ", pie: " + cartaBean.getPie()
			+ ", cargo: " + cartaBean.getCargo()
			+ ", responsable: " + cartaBean.getResponsable()
			+ " en la tabla JUG_CARTAS");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		return cartaBean;
	}
		
	/**
	 * Baja de una carta.
	 * @param id
	 * @param userBean, bean con los datos de usuario
	 * @return true, en caso de exito
	 */
	@Override
	@Transactional	
	public boolean bajaCarta(Long id, UserBean userBean){
		//Registrando Auditoria de Negocio para borrado de cartas.
		ResultAudNegocioBean result = AudNegocioAccess.accesAudNegocio(userBean.getUsername(), userBean.getAppcode(), "RGIAJ", 
			"JUG_CARTAS", "BORRAR", "Borrada la carta con el ID: " +  id
			+ " en la tabla JUG_CARTAS");
		if (result.getResultCode() == AudNegocioAccess.ERROR) {
			LOGGER.info(result.getResultDescription());
		}
		
		return cartaRepository.deleteCarta(id);
	}
	
	/**
	 * Exporta los datos de carta a PDF
	 *
	 * @param username
	 * @param cartaQueryBean 
	 * @param reportType 
	 * @param reportName 
	 * @param reportTitle 
	 * @return byte[]
	 */
	public byte[] exportCarta(String username, CartaQueryBean cartaQueryBean, String reportType, String reportName, String reportTitle){
		
		// Consultamos la informacion a exportar
		cartaQueryBean.setFirstResult(0);
		cartaQueryBean.setMaxResults(ConstantesBusiness.INTMAXCONSULTAS);
		CartaSearchResult cartaSearchResult = this.getCartas(cartaQueryBean);
		
		JRDatasourceReportFillManagerHelper.setCurrentDataSource(new JRBeanCollectionDataSource(cartaSearchResult.getResults()));
		byte[] reportBytes =  UtilBusiness.preparaInformePDF(reportListDatasourceRunner, reportType, reportName, reportTitle);

		return reportBytes;
	}
	

}
