package pe.com.hotelalura.controllers;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import pe.com.hotelalura.dao.ReservaDAO;
import pe.com.hotelalura.factory.ConnectionFactory;
import pe.com.hotelalura.modelo.Reservas;

public class ReservaController {
	
	private ReservaDAO reservaDao;
	
	public ReservaController() {
		Connection con = new ConnectionFactory().abrirConexion();
		this.reservaDao = new ReservaDAO(con);	
	}
	
	public void guardar(Reservas reservas) {
		this.reservaDao.guardar(reservas);
	}
	
	public List<Reservas> buscar(){
		return this.reservaDao.buscar();
	}
	public List<Reservas> buscarId(Integer id){
		return this.reservaDao.buscarId(id);
	}
		
	public void actualizar(Date fechaEntrada, Date fechaSalida, BigDecimal valor, String formaPago, Integer id) {
		this.reservaDao.Actualizar(fechaEntrada, fechaSalida, valor, formaPago, id);
	}
	
	public void eliminar(Integer id) {
		this.reservaDao.Eliminar(id);
	}

	public List<Reservas> buscarId(String text) {
		// TODO Auto-generated method stub
		return null;
	}
}
