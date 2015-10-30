package es.dgoj.rgiaj.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgoj.core.common.bean.ParamBean;

import es.dgoj.rgiaj.business.model.Operador;
import es.dgoj.rgiaj.business.repository.OperadorRepository;
import es.dgoj.rgiaj.business.service.OperadorService;


/**
 * The Class OperadorServiceImpl.
 */
@Service("operadorService")
public class OperadorServiceImpl implements OperadorService {

	/** Campo operador repository. */
	@Autowired
	private OperadorRepository<Operador,Long> operadorRepository;
	
	
	/**
	 *  Log de la clase.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(OperadorServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see es.dgoj.rgiaj.business.service.OperadorService#getListaOperadores()
	 */
	@Override
	public List<ParamBean> getListaOperadores() {

		LOGGER.debug("getListaOperadores");
		
		List<Operador> listResult = operadorRepository.getListaOperadores();
		
		List<ParamBean> list = new ArrayList<ParamBean>();
		for (Operador operador: listResult) {
			list.add(new ParamBean(operador.getIdOperador().toString() , operador.getIdOperador().toString()+" - "+((operador.getRazonSocial()!=null)?operador.getRazonSocial():operador.getNombreCorto())));
		}
		
		return list;
	}

}
