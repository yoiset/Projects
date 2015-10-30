package es.gob.cnjuego.ws.dao;

import java.sql.BatchUpdateException;
import java.util.Collection;

import es.gob.cnjuego.ws.entity.OperadorEntity;

public interface OperadorDAO {


	void altaOperador(OperadorEntity operador) throws BatchUpdateException;
	void modificarOperador(OperadorEntity operador) throws BatchUpdateException;
	OperadorEntity obtenerOperador(String cif);

	Collection<OperadorEntity> obtenerOperadores();
	OperadorEntity obtenerOperadorPorHashCertificado(String certificado);
	OperadorEntity obtenerOperadorPorHashCertificadoAll(String hashCertificado);
}