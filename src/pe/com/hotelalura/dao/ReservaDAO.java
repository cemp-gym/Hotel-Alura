package pe.com.hotelalura.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.com.hotelalura.modelo.Reservas;

public class ReservaDAO {
	
	private Connection con;

	public ReservaDAO(Connection con) {
		this.con = con;
	}
	
	public void guardar (Reservas reservas) {
		String sql = "INSERT INTO reservas (fecha_entrada, fecha_salida, valor, forma_pago) VALUES (?, ?, ?, ?)";
		try (PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setDate(1, reservas.getFechaEntrada());
			statement.setDate(2, reservas.getFechaSalida());
			statement.setBigDecimal(3, reservas.getValor());
			statement.setString(4, reservas.getFormaPago());
			statement.executeUpdate();
			try(ResultSet resultSet = statement.getGeneratedKeys()){
				while (resultSet.next()) {
					reservas.setId(resultSet.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reservas> buscar(){
		List<Reservas> reservas = new ArrayList<Reservas>();
		try {
			String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_pago FROM reservas";
			try(PreparedStatement statement = con.prepareStatement(sql)) {
				statement.execute();
				obtenerReserva(statement, reservas);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Reservas> buscarId(Integer id){
		List<Reservas> reservas = new ArrayList<Reservas>();
		try {
			String sql = "SELECT id, fecha_entrada, fecha_salida, valor, forma_pago FROM reservas WHERE id=?";
			try(PreparedStatement statement = con.prepareStatement(sql)) {
				statement.setInt(1, id);
				statement.execute();
				obtenerReserva(statement, reservas);
			}
			return reservas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void Eliminar(Integer id) {
		String sql = "DELETE FROM reservas WHERE id = ?";
		try(PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.execute();  
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void Actualizar(Date fechaEntrada, Date fechaSalida, BigDecimal valor, String formaPago, Integer id) {
		String sql = "UPDATE reservas SET fecha_entrada=?, fecha_salida=?, valor=?, forma_pago=? WHERE id=?";
		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setDate(1, fechaEntrada);
			statement.setDate(2, fechaSalida);
			statement.setBigDecimal(3, valor);
			statement.setString(4, formaPago);
			statement.setInt(5, id);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void obtenerReserva(PreparedStatement statement, List<Reservas> reservas) throws SQLException{
		try(ResultSet resultSet = statement.getResultSet()){
			while(resultSet.next()) {
				Integer id = resultSet.getInt(1);
				Date fechaEntrada = resultSet.getDate(2);
				Date fechaSalida = resultSet.getDate(3);
				BigDecimal valor = resultSet.getBigDecimal(4);
				String formaPago = resultSet.getString(5);
				Reservas producto = new Reservas(id, fechaEntrada, fechaSalida, valor, formaPago);
				reservas.add(producto);
			}
		}
	}
	
}
