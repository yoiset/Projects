package es.dgoj.rgiaj.business.util;

import java.util.Comparator;

import es.dgoj.rgiaj.business.model.JugProhibicion;


public class ProhibicionesComparator implements Comparator<JugProhibicion>{

	public int compare(JugProhibicion o1, JugProhibicion o2) {
		JugProhibicion p1 = (JugProhibicion)o1;
		JugProhibicion p2 = (JugProhibicion)o2;

		if( p1.getJugSituacion().getCodigo().equals(p2.getJugSituacion().getCodigo()) ){
			if( p1.getFechaSituacion().before(p2.getFechaSituacion()) ){
				return 1;
			}else if( p1.getFechaSituacion().after(p2.getFechaSituacion()) ){
				return -1;
			}
		}else if( p1.getJugSituacion().getCodigo().equals("AC") ){
			return -1;
		}else if( p2.getJugSituacion().getCodigo().equals("AC") ){
			return 1;
		}else if( p1.getFechaSituacion().before(p2.getFechaSituacion()) ){
			return 1;
		}else if( p1.getFechaSituacion().after(p2.getFechaSituacion()) ){
			return -1;
		}
		return 0;
	}

}
