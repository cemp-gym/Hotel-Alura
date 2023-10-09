package pe.com.hotelalura.modelo;

import java.sql.Date;

public class Huespedes {
	private Integer id;
	private String nombre;
	private String apellido;
	private Date fecha_de_nacimiento;
	private String nacionalidad;
	private String telefono;
	private Integer id_reserva;
	
	public Huespedes(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer idReserva) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_de_nacimiento = fechaNacimiento;
		this.nacionalidad= nacionalidad;
		this.telefono=telefono;
		this.id_reserva=idReserva;
	}
	
	public Huespedes(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer idReserva) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_de_nacimiento = fechaNacimiento;
		this.nacionalidad= nacionalidad;
		this.telefono=telefono;
		this.id_reserva=idReserva;
	}
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fecha_de_nacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fecha_de_nacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getIdReserva() {
		return id_reserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.id_reserva = idReserva;
	}

}
