package es.gob.cnjuego.ws.dao;

import java.sql.SQLException;

import javax.naming.NamingException;

import oracle.ucp.jdbc.PoolDataSourceImpl;

import org.springframework.jndi.JndiObjectFactoryBean;

/**
 * Esta clase es un factory que permite sobreescribir el usuario y la contrase�a
 * de la conexi�n de la base de datos. De esta forma, tenemos la definici�n centralizada
 * del datasource en el servidor (server.xml), configurada para usar un pool de conexiones y
 * cada aplicaci�n utiliza su propio usuario/contrase�a para conectarse.
 * N�tese que este factory se invoca una vez solamente, cuando la aplicaci�n arranca.
 */
public class CustomJndiObjectFactoryBean extends JndiObjectFactoryBean {

	public void afterPropertiesSet() throws IllegalArgumentException, NamingException {

		super.afterPropertiesSet();
		Object jndiDatasource = getObject();
		try {
			if (jndiDatasource instanceof PoolDataSourceImpl) {
				((PoolDataSourceImpl) jndiDatasource).setUser("CNJ03");
				((PoolDataSourceImpl) jndiDatasource).setPassword("CN003pru"); //este es para PRE
				
//				((PoolDataSourceImpl) jndiDatasource).setPassword("CNJuego03"); //este es para PRO
			}
		} catch (SQLException e) {
			throw new IllegalArgumentException("Error con el usuario y la contrase�a");
		}
	}

}
