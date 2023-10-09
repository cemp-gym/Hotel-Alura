package pe.com.hotelalura.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.com.hotelalura.modelo.Huespedes;

public class HuespedDAO {

	private Connection con;
	
	public HuespedDAO(Connection con) {
		this.con = con;
	}
	
	public void guardar(Huespedes huespedes) {
		try {
			String sql = "INSERT INTO huespedes (nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono, id_reserva) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			try(PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				statement.setString(1, huespedes.getNombre());
				statement.setString(2, huespedes.getApellido());
				statement.setDate(3, huespedes.getFechaNacimiento());
				statement.setString(4, huespedes.getNacionalidad());
				statement.setString(5, huespedes.getTelefono());
				statement.setInt(6, huespedes.getIdReserva());
				statement.execute();
				try(ResultSet resultSet = statement.getGeneratedKeys()){
					while (resultSet.next()) {
						huespedes.setId(resultSet.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huespedes> buscar() {
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {
			String sql = "SELECT id, nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono, id_reserva FROM huespedes";
			try(PreparedStatement statement = con.prepareStatement(sql)) {
				statement.execute();
				prepararReserva(huespedes, statement);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Huespedes> buscarId(Integer id) {
		List<Huespedes> huespedes = new ArrayList<Huespedes>();
		try {
			String sql = "SELECT id, nombre, apellido, fecha_de_nacimiento, nacionalidad, telefono, id_reserva FROM huespedes WHERE id_reserva=?";
			try(PreparedStatement statement = con.prepareStatement(sql)) {
				statement.setInt(1, id);
				statement.execute();
				prepararReserva(huespedes,statement);
			}
			return huespedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void actualizar(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer id_reserva, Integer id) {
		String sql = "UPDATE huespedes SET nombre=?, apellido=?, fecha_de_nacimiento=?, nacionalidad=?, telefono=?, id_reserva=? WHERE id=?";
		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, nombre);
			statement.setString(2, apellido);
			statement.setDate(3, fechaNacimiento);
			statement.setString(4, nacionalidad);
			statement.setString(5, telefono);
			statement.setInt(6, id_reserva);
			statement.setInt(7, id);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void eliminar(Integer id) {
		String sql = "DELETE FROM huespedes WHERE id = ?";
		try(PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	} 
	
	private void prepararReserva(List<Huespedes> huespedes, PreparedStatement statement) throws SQLException {
		try(ResultSet resultSet = statement.getResultSet()) {
			while(resultSet.next()) {
				Huespedes producto = new Huespedes(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDate(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7));
				huespedes.add(producto);
			}
		}
	}
	
}
