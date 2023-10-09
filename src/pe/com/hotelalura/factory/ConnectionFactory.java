package pe.com.hotelalura.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private final String conexion = "jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC";
	private final String usuario = "root";
	private final String contrasena = "root1234";
	private final int maxPoolSize = 10;
	private final int maxIdleTime = 300;
	private DataSource datasource;
	
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl(conexion);
		comboPooledDataSource.setUser(usuario);
		comboPooledDataSource.setPassword(contrasena);
		comboPooledDataSource.setMaxPoolSize(maxPoolSize);
		comboPooledDataSource.setMaxIdleTime(maxIdleTime);
		this.datasource = comboPooledDataSource;
	}

	public Connection abrirConexion() {
		try {
			return this.datasource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
