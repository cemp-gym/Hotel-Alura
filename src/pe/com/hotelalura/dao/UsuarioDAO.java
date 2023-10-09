package pe.com.hotelalura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pe.com.hotelalura.factory.ConnectionFactory;

public class UsuarioDAO {
	
	private Connection con;
	
	public UsuarioDAO(Connection con) {
		this.con = con;
	}

	public static boolean validarUsuario(String usuario, String contrasena) {		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?";
		try {
			con = connectionFactory.abrirConexion();
			statement = con.prepareStatement(sql);
			statement.setString(1, usuario);
			statement.setString(2, contrasena);
			resultSet = statement.executeQuery();
			return resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (resultSet !=null) {
					resultSet.close();
				}
				if (statement !=null) {
					statement.close();
				}
				if (con !=null) {
					con.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}	
	}
}
