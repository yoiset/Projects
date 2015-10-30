package es.gob.cnjuego.ws.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


	@Entity
	@Table(name ="TEST_WS")
	@SequenceGenerator(name="sq_test_ws",sequenceName="SEQ_TEST_WS", allocationSize=1,initialValue=1)
	public class JugadorTestWS {
		
		@Id
		@Column(name = "ID" )
		@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sq_test_ws")
		private int idJugadorOperador;
		
		

		@Column(name = "DNI" )
		private String dni;

		@Column(name = "NOMBRE" )
		private String nombre;
		
		@Column(name = "APELLIDO1" )
		private String apellido1;

		@Column(name = "APELLIDO2" )
		private String apellido2;

		@Column(name = "FECHA_NACIMIENTO" )
		private Date fechaNacimiento;
		
		@Column(name = "RES_RGIAJ" )
		private String resultadoRGIAJ;

		@Column(name = "RES_IDENTIDAD" )
		private String resultadoIdentidad;
		
		@Column(name = "MSG_RGIAJ" )
		private String mensajeRGIAJ;

		@Column(name = "MSG_IDENTIDAD" )
		private String mensajeIdentidad;

		public int getIdJugadorOperador() {
			return idJugadorOperador;
		}

		public void setIdJugadorOperador(int idJugadorOperador) {
			this.idJugadorOperador = idJugadorOperador;
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

		public Date getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(Date fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
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

		public void setResultadoIdentidad(String resultadoIdentidad) {
			this.resultadoIdentidad = resultadoIdentidad;
		}

		public String getMensajeRGIAJ() {
			return mensajeRGIAJ;
		}

		public void setMensajeRGIAJ(String mensajeRGIAJ) {
			this.mensajeRGIAJ = mensajeRGIAJ;
		}

		public String getMensajeIdentidad() {
			return mensajeIdentidad;
		}

		public void setMensajeIdentidad(String mensajeIdentidad) {
			this.mensajeIdentidad = mensajeIdentidad;
		}

		
		

		
}
