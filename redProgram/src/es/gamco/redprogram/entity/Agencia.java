/**
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * %(c) Copyright 2007. GAMCO S.L.
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * % Proyecto: Red Program
 * % Modulo: redProgram Web App
 * % Autor/es: Yoiset Lopez<nombre>
 * % Fecha: 05/08/2013
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * % Modificaciones (autor, fecha, modificaciones)
 * % <Autor>, <fecha>, <modificaciones>
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 * %
 * %  The persistence class module
 * %
 * %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 */
package es.gamco.redprogram.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Agencias database table.
 * 
 */
@Entity
@Table(name="Agencias")
public class Agencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Coordinador
	@OneToMany(mappedBy="agencia")
	private List<Coordinador> coordinadors;

	//bi-directional many-to-one association to M_Escuderia
	@OneToMany(mappedBy="agencia")
	private List<M_Escuderia> MEscuderias;

	//bi-directional many-to-one association to Res_Agencia_Mes
	@OneToMany(mappedBy="agencia")
	private List<Res_Agencia_Mes> resAgenciaMes;

	//bi-directional many-to-one association to Res_Agencia_P
	@OneToMany(mappedBy="agencia")
	private List<Res_Agencia_P> resAgenciaPs;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Agencias_id", nullable=true)
	private UsuarioWeb usuarioWeb;

	public Agencia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Coordinador> getCoordinadors() {
		return this.coordinadors;
	}

	public void setCoordinadors(List<Coordinador> coordinadors) {
		this.coordinadors = coordinadors;
	}

	public Coordinador addCoordinador(Coordinador coordinador) {
		getCoordinadors().add(coordinador);
		coordinador.setAgencia(this);

		return coordinador;
	}

	public Coordinador removeCoordinador(Coordinador coordinador) {
		getCoordinadors().remove(coordinador);
		coordinador.setAgencia(null);

		return coordinador;
	}

	public List<M_Escuderia> getMEscuderias() {
		return this.MEscuderias;
	}

	public void setMEscuderias(List<M_Escuderia> MEscuderias) {
		this.MEscuderias = MEscuderias;
	}

	public M_Escuderia addMEscuderia(M_Escuderia MEscuderia) {
		getMEscuderias().add(MEscuderia);
		MEscuderia.setAgencia(this);

		return MEscuderia;
	}

	public M_Escuderia removeMEscuderia(M_Escuderia MEscuderia) {
		getMEscuderias().remove(MEscuderia);
		MEscuderia.setAgencia(null);

		return MEscuderia;
	}

	public List<Res_Agencia_Mes> getResAgenciaMes() {
		return this.resAgenciaMes;
	}

	public void setResAgenciaMes(List<Res_Agencia_Mes> resAgenciaMes) {
		this.resAgenciaMes = resAgenciaMes;
	}

	public Res_Agencia_Mes addResAgenciaMe(Res_Agencia_Mes resAgenciaMe) {
		getResAgenciaMes().add(resAgenciaMe);
		resAgenciaMe.setAgencia(this);

		return resAgenciaMe;
	}

	public Res_Agencia_Mes removeResAgenciaMe(Res_Agencia_Mes resAgenciaMe) {
		getResAgenciaMes().remove(resAgenciaMe);
		resAgenciaMe.setAgencia(null);

		return resAgenciaMe;
	}

	public List<Res_Agencia_P> getResAgenciaPs() {
		return this.resAgenciaPs;
	}

	public void setResAgenciaPs(List<Res_Agencia_P> resAgenciaPs) {
		this.resAgenciaPs = resAgenciaPs;
	}

	public Res_Agencia_P addResAgenciaP(Res_Agencia_P resAgenciaP) {
		getResAgenciaPs().add(resAgenciaP);
		resAgenciaP.setAgencia(this);

		return resAgenciaP;
	}

	public Res_Agencia_P removeResAgenciaP(Res_Agencia_P resAgenciaP) {
		getResAgenciaPs().remove(resAgenciaP);
		resAgenciaP.setAgencia(null);

		return resAgenciaP;
	}

}