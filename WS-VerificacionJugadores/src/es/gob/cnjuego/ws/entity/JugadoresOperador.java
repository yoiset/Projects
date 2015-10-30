package es.gob.cnjuego.ws.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


	@Entity
	@Table(name ="JUGADORES_OPERADOR")
	@SequenceGenerator(name="sq_jugadores_op",sequenceName="SEQ_JUGADORES_OP", allocationSize=1,initialValue=1)
	public class JugadoresOperador {
		
		@Id
		@Column(name = "ID" )
		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sq_jugadores_op")
		private int idJugadorOperador;
		
		
		@ManyToOne
	    @JoinColumn(name="ID_OPERADOR")
	    private OperadorEntity operador;

		@Column(name = "DNI" )
		private String dni;

		@Column(name = "NOMBRE" )
		private String nombre;
		
		@Column(name = "APELLIDO1" )
		private String apellido1;

		@Column(name = "APELLIDO2" )
		private String apellido2;

		@Column(name = "FECHA_NAC" )
		private Date fechaNac;
		
		@Column(name = "FECHA_ALTA" )
		private Date fechaAlta;

		@Column(name = "IND_RGIAJ" )
		private int indicadorRGIAJ;

		@Column(name = "IND_IDENTIDAD" )
		private int indicadorIDentidad;
		
		@Column(name = "RES_RGIAJ" )
		private String resultadoRGIAJ;

		@Column(name = "RES_IDENTIDAD" )
		private String resultadoIdentidad;

		@Column(name = "CACHE_IDENTIDAD" )
		private int cacheIdentidad;
		
		@Column(name = "PETICION_WS_ID" )
		private Integer peticionWSId;
		
		@Column(name = "NUMSOPORTE" )
		private String numSoporte;
		
		
		public int getIdJugadorOperador() {
			return idJugadorOperador;
		}

		public void setIdJugadorOperador(int idJugadorOperador) {
			this.idJugadorOperador = idJugadorOperador;
		}

		public OperadorEntity getOperador() {
			return operador;
		}

		public void setOperador(OperadorEntity operador) {
			this.operador = operador;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido1() {
			return apellido1;
		}

		public void setApellido1(String apellido1) {
			this.apellido1 = apellido1;
		}

		public String getApellido2() {
			return apellido2;
		}

		public void setApellido2(String apellido2) {
			this.apellido2 = apellido2;
		}

		public Date getFechaNac() {
			return fechaNac;
		}

		public void setFechaNac(Date fechaNac) {
			this.fechaNac = fechaNac;
		}

		public Date getFechaAlta() {
			return fechaAlta;
		}

		public void setFechaAlta(Date fechaAlta) {
			this.fechaAlta = fechaAlta;
		}



		public int getIndicadorRGIAJ() {
			return indicadorRGIAJ;
		}

		public void setIndicadorRGIAJ(int indicadorRGIAJ) {
			this.indicadorRGIAJ = indicadorRGIAJ;
		}

		public int getIndicadorIDentidad() {
			return indicadorIDentidad;
		}

		public void setIndicadorIDentidad(int indicadorIDentidad) {
			this.indicadorIDentidad = indicadorIDentidad;
		}

		public String getResultadoRGIAJ() {
			return resultadoRGIAJ;
		}

		public void setResultadoRGIAJ(String resultadoRGIAJ) {
			this.resultadoRGIAJ = resultadoRGIAJ;
		}

		public String getResultadoIdentidad() {
			return resultadoIdentidad;
		}

		public void setResultadoIdentidad(String resultadoIDentidad) {
			this.resultadoIdentidad = resultadoIDentidad;
		}

		public int getCacheIdentidad() {
			return cacheIdentidad;
		}

		public void setCacheIdentidad(int cacheIdentidad) {
			this.cacheIdentidad = cacheIdentidad;
		}

		public Integer getPeticionWSId() {
			return peticionWSId;
		}

		public void setPeticionWSId(Integer peticionWSId) {
			this.peticionWSId = peticionWSId;
		}

		public String getNumSoporte() {
			return numSoporte;
		}

		public void setNumSoporte(String numSoporte) {
			this.numSoporte = numSoporte;
		}

		
}
