package pe.com.hotelalura.controllers;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import pe.com.hotelalura.dao.HuespedDAO;
import pe.com.hotelalura.factory.ConnectionFactory;
import pe.com.hotelalura.modelo.Huespedes;

public class HuespedController {
	
	private HuespedDAO huespedDao;
	
	public HuespedController() {
		Connection connection = new ConnectionFactory().abrirConexion();
		this.huespedDao = new HuespedDAO(connection);
	}
	
	public void guardar(Huespedes huespedes) {
		this.huespedDao.guardar(huespedes);
	}
	
	public  List<Huespedes> buscarHuespedes(){
		return this.huespedDao.buscar();
	}
	
	public  List<Huespedes> buscarHuespedesId(Integer id){
		return this.huespedDao.buscarId(id);
	}
	
	public void actualizar(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono,Integer id_reserva, Integer id) {
		this.huespedDao.actualizar(nombre, apellido, fechaNacimiento, nacionalidad, telefono, id_reserva, id);
	}
	 
	public void Eliminar(Integer idReserva) {
		this.huespedDao.eliminar(idReserva);
	}
	
}
