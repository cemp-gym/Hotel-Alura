package pe.com.hotelalura.modelo;

import java.math.BigDecimal;
import java.sql.Date;

public class Reservas {
	
	private Integer id;
	private Date fecha_entrada;
	private Date fecha_salida;
	private BigDecimal valor;
	private String forma_pago;
	
	public Reservas(Date fechaEntrada, Date fechaSalida, BigDecimal valor, String formaPago) {
		super();
		this.fecha_entrada = fechaEntrada;
		this.fecha_salida = fechaSalida;
		this.valor = valor;
		this.forma_pago = formaPago;
	}
	
	public Reservas(Integer id, Date fechaEntrada, Date fechaSalida, BigDecimal valor, String formaPago) {
		super();
		this.id = id;
		this.fecha_entrada = fechaEntrada;
		this.fecha_salida = fechaSalida;
		this.valor = valor;
		this.forma_pago = formaPago;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getFechaEntrada() {
		return fecha_entrada;
	}
	
	public void setFechaEntrada(Date fechaEntrada) {
		this.fecha_entrada = fechaEntrada;
	}
	
	public Date getFechaSalida() {
		return fecha_salida;
	}
	
	public void setFechaSalida(Date fechaSalida) {
		this.fecha_salida = fechaSalida;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public String getFormaPago() {
		return forma_pago;
	}
	
	public void setFormaPago(String formaPago) {
		this.forma_pago = formaPago;
	}
}
