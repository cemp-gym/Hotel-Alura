package pe.com.hotelalura.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pe.com.hotelalura.utils.ConfirmarSalir;

@SuppressWarnings("serial")
public class MenuUsuario extends JFrame {

	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelRegReserva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);

		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});

		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 153, 153));
		panelMenu.setBounds(0, 0, 257, 609);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(50, 58, 150, 150);
		panelMenu.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/aH-150px.png")));

		JPanel btnRegReserva = new JPanel();
		btnRegReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegReserva.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegReserva.setBackground(new Color(0, 153, 153));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();
			}
		});
		btnRegReserva.setBounds(0, 255, 257, 56);
		btnRegReserva.setBackground(new Color(0, 153, 153));
		panelMenu.add(btnRegReserva);
		btnRegReserva.setLayout(null);

		labelRegReserva = new JLabel("Registro de reservas");
		labelRegReserva.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/reservado.png")));
		labelRegReserva.setForeground(SystemColor.text);
		labelRegReserva.setBounds(25, 11, 205, 34);
		labelRegReserva.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelRegReserva.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegReserva.add(labelRegReserva);

		JPanel btnBusqueda = new JPanel();
		btnBusqueda.addMouseListener(new MouseAdapter() { 
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBusqueda.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBusqueda.setBackground(new Color(0, 153, 153));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Busqueda busqueda = new Busqueda();
				busqueda.setVisible(true);
				dispose();
			}
		});
		btnBusqueda.setBounds(0, 312, 257, 56);
		btnBusqueda.setBackground(new Color(0, 153, 153));
		panelMenu.add(btnBusqueda);
		btnBusqueda.setLayout(null);

		JLabel lblBusquedaDeReservas = new JLabel("B�squeda");
		lblBusquedaDeReservas.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/pessoas.png")));
		lblBusquedaDeReservas.setBounds(27, 11, 200, 34);
		lblBusquedaDeReservas.setHorizontalAlignment(SwingConstants.LEFT);
		lblBusquedaDeReservas.setForeground(Color.WHITE);
		lblBusquedaDeReservas.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnBusqueda.add(lblBusquedaDeReservas);

		JSeparator separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);
		panelMenu.add(separator);
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 944, 36);
		contentPane.add(header);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConfirmarSalir confirmarSalir = new ConfirmarSalir();
				confirmarSalir.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setToolTipText("Salir");
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});

		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(891, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Humanst521 Lt BT", Font.BOLD, 18));

		JPanel panelFecha = new JPanel();
		panelFecha.setBackground(new Color(118, 187, 223));
		panelFecha.setBounds(256, 84, 688, 121);
		contentPane.add(panelFecha);
		panelFecha.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Sistema de Reservas Hotel Alura");
		lblNewLabel_1.setBounds(0, 11, 688, 42);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelFecha.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(SystemColor.windowText);
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 24));

		JLabel labelFecha = new JLabel("New label");
		labelFecha.setBounds(0, 64, 688, 36);
		labelFecha.setHorizontalAlignment(SwingConstants.CENTER);
		panelFecha.add(labelFecha);
		labelFecha.setForeground(Color.WHITE);
		labelFecha.setFont(new Font("Roboto", Font.PLAIN, 33));
		Date fechaActual = new Date();
		String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaActual);
		labelFecha.setText("Hoy es " + fecha);

		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setFont(new Font("Roboto", Font.BOLD, 24));
		lblNewLabel.setBounds(312, 234, 147, 46);
		contentPane.add(lblNewLabel);

		String textoDescripcion = "<html><body>Sistema de reserva del hotel. Controle y administre de forma �ptima y f�cil <br> el flujo de reservas y de hu�spedes del hotel.</body></html>";
		JLabel labelDescripcion = new JLabel(textoDescripcion);
		labelDescripcion.setFont(new Font("Roboto", Font.PLAIN, 17));

		labelDescripcion.setBounds(312, 291, 598, 66);
		contentPane.add(labelDescripcion);

		String textoDescripcion1 = "<html><body>Esta herramienta le permitir� llevar un control completo y detallado de sus reservas y hu�spedes, tendr� acceso a heramientas especiales para tareas espec�ficas como lo son:</body></html>";
		JLabel labelDescripcion_1 = new JLabel(textoDescripcion1);
		labelDescripcion_1.setFont(new Font("Roboto", Font.PLAIN, 17));
		labelDescripcion_1.setBounds(311, 345, 569, 88);
		contentPane.add(labelDescripcion_1);

		JLabel lblNewLabel_3 = new JLabel("- Registro de Reservas y Hu�spedes.");
		lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(312, 444, 295, 27);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("- Edici�n de Reservas y Hu�spedes existentes.");
		lblNewLabel_3_1.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblNewLabel_3_1.setBounds(312, 482, 355, 27);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("- Eliminar todo tipo de registros.");
		lblNewLabel_3_2.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblNewLabel_3_2.setBounds(312, 520, 295, 27);
		contentPane.add(lblNewLabel_3_2);
	}

	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
	
}