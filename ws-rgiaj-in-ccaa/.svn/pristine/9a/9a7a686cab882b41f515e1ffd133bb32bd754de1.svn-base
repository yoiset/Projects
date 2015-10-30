package es.dgoj.rgiaj.business.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;

import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.bean.ComunidadBean;
import es.dgoj.rgiaj.business.bean.JugProhibicionBean;
import es.dgoj.rgiaj.business.bean.ProhibicionQueryBean;
import es.dgoj.rgiaj.business.exceptions.JuegoExternoException;
import es.dgoj.rgiaj.business.model.JugComunidad;
import es.dgoj.rgiaj.business.model.JugHistoricodescargasproh;
import es.dgoj.rgiaj.business.model.JugProhibicion;
import es.dgoj.rgiaj.business.repository.IJugHistoricoDescargasprohRepository;
import es.dgoj.rgiaj.business.repository.IJugProhibicionRepository;
import es.dgoj.rgiaj.business.service.IJugProhibicionService;

/**
 * @author ylopezconnectis
 *
 */
@Service("jugProhibicionService")
public class JugProhibicionServiceImpl implements IJugProhibicionService {
	
	
	
	
	@Autowired
	private IJugProhibicionRepository<JugProhibicion, Long> jugProhibicionRepository;
	
	@Autowired
	private IJugHistoricoDescargasprohRepository<JugHistoricodescargasproh, Long> jugHistoricodescargasprohRepository;
	
	
	private Logger log= Logger.getLogger(IJugProhibicionService.class);

	
	@PostConstruct
	private void init(){
		
	}
	

	/* (non-Javadoc)
	 * @see es.dgoj.rgiaj.business.service.IJugProhibicionService#getProhibidosList(es.dgoj.rgiaj.business.bean.JugProhibicionQueryBean)
	 */
	@Override
	public byte[] getProhibidosList(ProhibicionQueryBean queryBean) throws JuegoExternoException {
		// TODO Auto-generated method stub
		SearchResults<JugProhibicion> search=jugProhibicionRepository.getProhibidoList(queryBean);
		
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		ZipOutputStream zipOut=new ZipOutputStream(out);
		
		if(search.getResults()!=null){			
		   switch (queryBean.getFormatoDescargaProhibidos()) {
				case XML:
					 getXML(search.getResults(), queryBean, zipOut, out);
					 break;
				case Texto:
					getText(search.getResults(), queryBean,  zipOut, out);
					break;
				case Ambos:
					getAmbos(search.getResults(), queryBean, zipOut, out);
					break;
			}
		   insertHistoricoDescargas(queryBean);
		 }
		
		closeOutputStream(zipOut);
		return out.toByteArray();
	}
	
	
	
	/** Actualiza el historial de Descargas de Prohibidos
	 * @param queryBean
	 * @throws JuegoExternoException
	 */
	@Transactional
	private void insertHistoricoDescargas(ProhibicionQueryBean queryBean) throws JuegoExternoException {
		jugHistoricodescargasprohRepository.insertHistoricoDescargas(queryBean);
	}
//	
//	
	/** Confirma el historial de Descargas de Prohibidos
	 * @see es.dgoj.rgiaj.business.service.IJugProhibicionService#confirmHistoricoDescargas(es.dgoj.rgiaj.business.bean.ProhibicionQueryBean)
	 */
	@Transactional
	public void confirmHistoricoDescargas(ProhibicionQueryBean queryBean) throws JuegoExternoException {
		JugHistoricodescargasproh entity=jugProhibicionRepository.getLast(queryBean.getCodComunidad());
		entity.setConfirmada(1);
		jugHistoricodescargasprohRepository.updateHistoricoDescargas(entity);
	}
	
	

	/** Retorna si la ultima descarga esta por confirmar
	 * @see es.dgoj.rgiaj.business.service.IJugProhibicionService#hasPending(es.dgoj.rgiaj.business.bean.ProhibicionQueryBean)
	 */
	@Override
	public boolean hasPending(ProhibicionQueryBean queryBean) {
		JugHistoricodescargasproh entity=jugProhibicionRepository.getLast(queryBean.getCodComunidad());
		if(entity.getConfirmada()!=null && entity.getConfirmada().equals(1)) return false;
		return true;
	}
	
	/** Confirma el historial de Descargas de Prohibidos Pendiente
	 * @param queryBean
	 * @throws JuegoExternoException 
	 */
	@Transactional
	public void confirmHistoricoDescargasPendiente(ProhibicionQueryBean queryBean) throws JuegoExternoException{
		JugHistoricodescargasproh entity=jugProhibicionRepository.getLast(queryBean.getCodComunidad());
		entity.setConfirmada(1);
		jugHistoricodescargasprohRepository.updateHistoricoDescargas(entity);
	}
	
	
	
	
	/** Devuelve el Bean con la comunidad y el codigo
	 * @see es.dgoj.rgiaj.business.service.IJugProhibicionService#getComunidad(java.lang.String)
	 */
	public JugProhibicionBean getComunidad(String user){
		JugComunidad entity=jugProhibicionRepository.getComunidad(user);
		JugProhibicionBean bean=new JugProhibicionBean();
		 if(entity!=null){
			 bean.setIdComunidad(entity.getId());
			 bean.setCodComunidad(entity.getCodigo());			 
			 bean.setDescripcionComunidad(entity.getDescripcion());
		 }
		 return bean;
	}
	
	
	/** Devuelve el Bean con las ultimas descargas confirmadas por una comunidad
	 * @see es.dgoj.rgiaj.business.service.IJugProhibicionService#getUltimasDescargasConfirmadas(es.dgoj.rgiaj.business.bean.ProhibicionQueryBean)
	 */
	public List<JugProhibicionBean> getUltimasDescargasConfirmadas(ProhibicionQueryBean queryBean)throws JuegoExternoException{
		List<JugHistoricodescargasproh> list=jugHistoricodescargasprohRepository.getUltimasDescargasConfirmadas(queryBean);
		List<JugProhibicionBean> result=new ArrayList<JugProhibicionBean>();
		
		if(list!=null)
		for (JugHistoricodescargasproh entity : list) 
			result.add(new JugProhibicionBean(entity.getFechaDescarga(), entity.getUltimo()));
		
		return result;
	}
	
	
	/* (non-Javadoc)
	 * @see es.dgoj.rgiaj.business.service.IJugProhibicionService#getComunidadList()
	 */
	@Override
	public List<ComunidadBean> getComunidadList() {
		// TODO Auto-generated method stub
		List<ComunidadBean> result=new ArrayList<ComunidadBean>();
		
		List<JugComunidad> list=jugProhibicionRepository.getComunidadList();
		for (JugComunidad entiry : list) 
             		result.add(new ComunidadBean(entiry.getId(), entiry.getCodigo(), entiry.getDescripcion()));	
		
		return result;
	}
	
	
	
	
	/**
	 * @param prohibicionList
	 * @param query
	 * @param zipOut
	 * @param out
	 * @throws JuegoExternoException
	 */
	private void getXML(List<JugProhibicion> prohibicionList, ProhibicionQueryBean query,  ZipOutputStream zipOut,ByteArrayOutputStream out) throws JuegoExternoException{
		XMLFileSupport xmlFile=new XMLFileSupport();
		try {
			long last = xmlFile.writeProhibidosXml(zipOut, prohibicionList);
			query.setLast(last);
		} catch (IOException e) {
			log.error("Error creando el outPut Stream: ", e);
			throw new JuegoExternoException(e);
		} catch (SAXException e) {
			log.error("Error creando fichero XML: ", e);
			throw new JuegoExternoException(e);
		}
	}
	

	
	/**
	 * @param prohibicionList
	 * @param query
	 * @param zipOut
	 * @param out
	 * @throws JuegoExternoException
	 */
	private void getText(List<JugProhibicion> prohibicionList,ProhibicionQueryBean query, ZipOutputStream zipOut,ByteArrayOutputStream out) throws JuegoExternoException{
		TextFileSupport textFile=new TextFileSupport();
		try {
			long last = textFile.writeProhibidosTexto(zipOut, prohibicionList);
			query.setLast(last);
		} catch (IOException e) {
			log.error("Error creando el outPut Stream: ", e);
			throw new JuegoExternoException(e);
		}
		
	}


	
	/**
	 * @param prohibicionList
	 * @param query
	 * @param zipOut
	 * @param out
	 * @throws JuegoExternoException
	 */
	private void getAmbos(List<JugProhibicion> prohibicionList, ProhibicionQueryBean query, ZipOutputStream zipOut,ByteArrayOutputStream out) throws JuegoExternoException{
		getText(prohibicionList, query, zipOut, out);
        getXML(prohibicionList, query, zipOut, out);	
		
	}
	
	
	/**
	 * @param zipOut
	 * @throws JuegoExternoException
	 */
	private void closeOutputStream(ZipOutputStream zipOut)	throws JuegoExternoException {
		try {
			zipOut.close();
		} catch (IOException e) {
			log.error("Error cerrando el fichero zip: ", e);
			throw new JuegoExternoException(e);
		}
	}

	
}
