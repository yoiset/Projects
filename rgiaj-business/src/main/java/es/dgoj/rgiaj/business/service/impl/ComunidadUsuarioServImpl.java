package es.dgoj.rgiaj.business.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mysema.query.SearchResults;

import es.dgoj.rgiaj.business.beans.ComunidadBean;
import es.dgoj.rgiaj.business.beans.ComunidadQueryBean;
import es.dgoj.rgiaj.business.beans.ComunidadSearchResult;
import es.dgoj.rgiaj.business.beans.UsuarioComunidadBean;
import es.dgoj.rgiaj.business.beans.UsuarioQueryBean;
import es.dgoj.rgiaj.business.model.JugComunidadCertificado;
import es.dgoj.rgiaj.business.model.JugComunidadCertificadoPK;
import es.dgoj.rgiaj.business.model.JugUsuariocomunidad;
import es.dgoj.rgiaj.business.repository.IComunidadRepository;
import es.dgoj.rgiaj.business.repository.IConfigurationRepository;
import es.dgoj.rgiaj.business.repository.IUsuarioComunidadRepository;
import es.dgoj.rgiaj.business.service.IComunidadUsuarioServ;
import es.dgoj.rgiaj.business.util.Constantes;

@Service("comunidadUsuarioService")
public class ComunidadUsuarioServImpl  implements IComunidadUsuarioServ{
	
	private @Autowired IUsuarioComunidadRepository<JugUsuariocomunidad, Long> usuarioComunidadRepository;
	
	private @Autowired IComunidadRepository<JugComunidadCertificado, JugComunidadCertificadoPK> comunidadRepository;

	@Override
	public boolean existUsuario(ComunidadQueryBean query) {
		// TODO Auto-generated method stub
		if(query!=null && query.getIdComunidad()!=null){
			JugUsuariocomunidad entity= usuarioComunidadRepository.getUsuarioComunidad((UsuarioQueryBean)query);
			if(entity!=null) return true;
		}
		
		
		return false;
		
	}

	@Transactional
	@Override
	public void addUsuario(ComunidadQueryBean query) {
		// TODO Auto-generated method stub
		if(query!=null){
			JugUsuariocomunidad entity=new JugUsuariocomunidad();
			fillEntity(query, entity);
			usuarioComunidadRepository.add(entity);
//			usuarioComunidadRepository.flush();
		}
		
	}

	
	@Transactional
	@Override
	public void editUsuario(ComunidadQueryBean query) {
		// TODO Auto-generated method stub
		JugUsuariocomunidad entity= usuarioComunidadRepository.get(((UsuarioQueryBean)query).getId());
		if(entity!=null){
			fillEntity(query,entity);
			usuarioComunidadRepository.update(entity);
		}
			
		
	}

	@Transactional
	@Override
	public void removeUsuario(ComunidadQueryBean query) {
		// TODO Auto-generated method stub
		JugUsuariocomunidad entity= usuarioComunidadRepository.get(((UsuarioQueryBean)query).getId());
		if(entity!=null){
			usuarioComunidadRepository.remove(entity);
			usuarioComunidadRepository.flush();
		}
		 
		
	}
	
	/** 
	 * @see es.dgoj.rgiaj.business.service.IComunidadService#getUsuarioComunidad(es.dgoj.rgiaj.business.bean.ComunidadQueryBean)
	 */
	@Override
	public ComunidadSearchResult getUsuarioComunidad(ComunidadQueryBean query) {
		// TODO Auto-generated method stub
		SearchResults<JugUsuariocomunidad> search=usuarioComunidadRepository.getListaUsuarios(query);
		
		ComunidadSearchResult result=new ComunidadSearchResult();
		
		List<JugUsuariocomunidad> list=search.getResults();
		List<ComunidadBean> listResult=new ArrayList<ComunidadBean>();
		
		if(list!=null)
			for (JugUsuariocomunidad entity : list) 
				listResult.add(UsuarioComunidadBean.getBean(entity));
		
		result.setNumResults(new Long(search.getTotal()));	
		result.setResults(listResult);	
			
		return result;
	}
	
	private void fillEntity(ComunidadQueryBean query, JugUsuariocomunidad entity){
		if(query.getIdComunidad()!=null)
			entity.setJugComunidad( comunidadRepository.getComunidad(query.getIdComunidad()) );
		
		if(((UsuarioQueryBean)query).getUsuario()!=null)
		    entity.setUsuario(((UsuarioQueryBean)query).getUsuario());
		
		if(((UsuarioQueryBean)query).getDescripcion()!=null)
		    entity.setDescripcion(((UsuarioQueryBean)query).getDescripcion());
		
		if(((UsuarioQueryBean)query).getActivo()!=null)
		    entity.setActivo(((UsuarioQueryBean)query).getActivo());
		else entity.setActivo(0);
		
	}

}
