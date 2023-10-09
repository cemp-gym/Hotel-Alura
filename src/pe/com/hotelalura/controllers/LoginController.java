package pe.com.hotelalura.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import pe.com.hotelalura.dao.UsuarioDAO;
import pe.com.hotelalura.views.Login;
import pe.com.hotelalura.views.MenuUsuario;

public class LoginController implements ActionListener {
	private Login acceso;
	
	public LoginController(Login acceso) {
		this.acceso = acceso;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nombre = acceso.getNombre();
		String contrasena = acceso.getContrasena();	

        if(UsuarioDAO.validarUsuario(nombre, contrasena)){
            MenuUsuario menu = new MenuUsuario();
            menu.setVisible(true);
            acceso.dispose();	 
        }else {
        	JLabel mensaje = new JLabel("¡Usuario o Password Incorrecto!");
        	JOptionPane.showMessageDialog(acceso, mensaje, "Error, Acceso Denegado", JOptionPane.ERROR_MESSAGE);
        }
	}

}
