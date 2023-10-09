package pe.com.hotelalura.modelo;

public class Usuarios {
	private String usuario;
	private String contrasena;
	
	public Usuarios(String usuario, String contrasena) {
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	
	public String getNombre() {
		return usuario;
	}

	public void setNombre(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
