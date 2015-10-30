package es.dgoj.rgiaj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.dgoj.sprmvc.ajax.bean.GridBean;
import com.dgoj.sprmvc.ajax.bean.GridRowBean;
import com.jeveris.core.exception.impl.CoreException;

import es.dgoj.rgiaj.form.PersonaForm;
import es.dgoj.rgiaj.form.ProhibicionForm;

/**
 * Clase estatica con un conjunto de utilidades comunes.
 * @author connectis
 */
public final class Utilidades {
	
	private static final String SEPARADOR = ";";

    private Utilidades() {
        super();
    }	
	
	public static String normalizarTexto (String texto) {
		String textoNormalizado = texto.replaceAll("[\r\n]", "");
		return textoNormalizado;
	}
	
	static public Long longOrNull(String valorStr){
		if (valorStr != null){
			return Long.valueOf(valorStr);
		} else {
			return null;
		}
	}
	
	static public Integer integerOrNull(String valorStr){
		if (valorStr != null){
			return Integer.valueOf(valorStr);
		} else {
			return null;
		}
	}
	
	static public String stringOrNull(Long valor){
		if (valor != null){
			return valor.toString();
		} else {
			return null;	
		}
	}

	static public String stringOrNull(Integer valor){
		if (valor != null){
			return valor.toString();
		} else {
			return null;	
		}
	}

	
	static public Date toDateOrNull(String valorStr){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if (valorStr != null){
			try {
				return dateFormat.parse(valorStr);
			} catch (ParseException e) {
				return null;
			}
		} else {
			return null;
		}
	}
	
	static public String fromDateOrNull(Date valorDate){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if (valorDate != null){
			return dateFormat.format(valorDate);
		} else {
			return null;
		}
	}
	
	static public Date toDateTimeOrNull(String valorStr){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if (valorStr != null){
			try {
				return dateFormat.parse(valorStr);
			} catch (ParseException e) {
				return null;
			}
		} else {
			return null;
		}
	}
	
	static public String fromDateTimeOrNull(Date valorDate){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if (valorDate != null){
			return dateFormat.format(valorDate);
		} else {
			return null;
		}
	}
	
	static public Date toBDDateOrNull(String valorStr){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		if (valorStr != null){
			try {
				return dateFormat.parse(valorStr);
			} catch (ParseException e) {
				return null;
			}
		} else {
			return null;
		}
	}
	
	/**
	 * Convierte una listado de beans en formato JSON para ser mostrado en un tabla.
	 * El elemento bean debe tener implementado el metodo toString, el cual devuelve los atributos
	 * del elemento separados por ;.
	 * @param beanList
	 * @return cadena JSON
	 */
	static public String processProhibicionesList(PersonaForm personaForm) {
		
		Set<String> ids = new HashSet<String>();
		
		if (personaForm.getListaProhibiciones() == null){
			return "";
		}
		
		List<ProhibicionForm> beanList = personaForm.getListaProhibiciones();
		
		GridBean gridBean = new GridBean();
		GridRowBean[] rows = new GridRowBean[beanList.size()];
		
		int idx = 0;
		for (Iterator<ProhibicionForm> iterator = beanList.iterator(); iterator.hasNext();) {
			ProhibicionForm bean = iterator.next();
			//String id = String.valueOf(bean.getIdProcedimiento()+"-"+bean.getOrden());
			String id = String.valueOf(bean.getIdProhibicion());
			if (id == null) {
				throw new CoreException("El ID de la fila de la grid no puede ser null");
			}
			if (ids.contains(id)) {
				throw new CoreException("Ya existe un ID de fila con el valor " + id + " agregado a la grid");
			}
			ids.add(id);
			String[] fields = bean.toString().split(SEPARADOR);
			GridRowBean row = new GridRowBean();
			row.setId(id);
			row.setCells(fields);
			rows[idx++] = row;
		}
		gridBean.setRows(rows);
		gridBean.setTotalResults(Long.valueOf(idx));
		return gridBean.toJSON();
	}
	
	public static String trunkString(String str, int begin, int end){
		if(str==null) return null;
	     str= str.substring(begin, end);
	     return str + ":...";
	}
}
