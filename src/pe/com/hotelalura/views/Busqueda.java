package pe.com.hotelalura.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import pe.com.hotelalura.controllers.HuespedController;
import pe.com.hotelalura.controllers.ReservaController;
import pe.com.hotelalura.modelo.Huespedes;
import pe.com.hotelalura.modelo.Reservas;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloH;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;

	private ReservaController reservasControl;
	private HuespedController huespedesControl;

	String reserva;
	String huespedes;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		reservasControl = new ReservaController();
		huespedesControl = new HuespedController();

		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/pe/com/hotelalura/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		new JScrollPane(tbReservas);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(0, 62, 910, 42);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_4);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
//		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/pe/com/hotelalura/imagenes/reservado.png")), tbReservas, null);
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Número de Reserva");
		modelo.addColumn("Fecha de entrada");
		modelo.addColumn("Fecha de salida");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		tbReservas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		mostrarTablaReservas();
		
		JScrollPane scroll_tableReservas = new JScrollPane(tbReservas);
		scroll_tableReservas.setVisible(true);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/pe/com/hotelalura/imagenes/reservado.png")), scroll_tableReservas, null);
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
//		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/pe/com/hotelalura/imagenes/pessoas.png")), tbHuespedes, null);
		modeloH = (DefaultTableModel) tbHuespedes.getModel();
		modeloH.addColumn("Número de Huésped");
		modeloH.addColumn("Nombre");
		modeloH.addColumn("Apellido");
		modeloH.addColumn("Fecha de Nacimiento");
		modeloH.addColumn("Nacionalidad");
		modeloH.addColumn("Teléfono");
		modeloH.addColumn("Número de Reserva");
		mostrarTablaHuespedes();

		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		scroll_tableHuespedes.setVisible(true);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/pe/com/hotelalura/imagenes/pessoas.png")), scroll_tableHuespedes, null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/pe/com/hotelalura/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);

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
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
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
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Humanst521 Lt BT", Font.BOLD, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);

		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminarTabla();
				String idStr = txtBuscar.getText();
				if(idStr.equals("")) {
					mostrarTablaHuespedes();
					mostrarTablaReservas();
				} else {
					try {
						Integer idInt = Integer.parseInt(idStr);
						mostrarTablaHuespedesId(idInt);
						mostrarTablaReservasId(idInt);
					} catch (NumberFormatException nfe) {
						JOptionPane.showMessageDialog(null, "Error, debe ingresar el número de id de la reserva", "Error", JOptionPane.OK_OPTION);
			            return;
					}
				}
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel btnActualizar = new JPanel();
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int tabSelect = panel.getSelectedIndex();
				System.out.println(tabSelect);
				if (tabSelect == 0) {
					int filaReservas = tbReservas.getSelectedRow();
					if (filaReservas >= 0) {
						actualizarReservas();
						eliminarTabla();
						mostrarTablaHuespedes();
						mostrarTablaReservas();
					} else {
						JOptionPane.showMessageDialog(null, "Error, no se actualizó ninguna reserva");
					}
				}
				if (tabSelect == 1) {
					int filaHuespedes = tbHuespedes.getSelectedRow();
					if (filaHuespedes >= 0) {
						actualizarHuespedes();
						eliminarTabla();
						mostrarTablaHuespedes();
						mostrarTablaReservas();
					} else {
						JOptionPane.showMessageDialog(null, "Error, no se actualizó ningún huésped");
					}
				}
			}
		});

		btnActualizar.setLayout(null);
		btnActualizar.setBackground(new Color(12, 138, 199));
		btnActualizar.setBounds(635, 508, 122, 35);
		btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnActualizar);

		JLabel lblActualizar = new JLabel("ACTUALIZAR");
		lblActualizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizar.setForeground(Color.WHITE);
		lblActualizar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblActualizar.setBounds(0, 0, 122, 35);
		btnActualizar.add(lblActualizar);

		JPanel btnEliminar = new JPanel();
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int tabSelect = panel.getSelectedIndex();
				System.out.println(tabSelect);
				if (tabSelect == 0) {
					int filaReservas = tbReservas.getSelectedRow();
					if (filaReservas >= 0) {
						reserva = tbReservas.getValueAt(filaReservas, 0).toString();
						int confirmaReserva = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la reserva?", "Seleccione una opción", JOptionPane.YES_NO_OPTION);
						if(confirmaReserva == JOptionPane.YES_OPTION) {
							String valor = tbReservas.getValueAt(filaReservas, 0).toString();
							reservasControl.eliminar(Integer.valueOf(valor));
							JOptionPane.showMessageDialog(contentPane, "Reserva eliminada");
							eliminarTabla();
							mostrarTablaHuespedes();
							mostrarTablaReservas();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Error, no se seleccionó ninguna reserva");
					}
				}
				if (tabSelect == 1) {
					int filaHuespedes = tbHuespedes.getSelectedRow();
					if (filaHuespedes >= 0) {
						huespedes = tbHuespedes.getValueAt(filaHuespedes, 0).toString();
						int confirmaHuesped = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro del huésped?", "Seleccione una opción", JOptionPane.YES_NO_OPTION);
						if(confirmaHuesped == JOptionPane.YES_OPTION) {
							String valor = tbHuespedes.getValueAt(filaHuespedes, 0).toString();
							huespedesControl.Eliminar(Integer.valueOf(valor));
							JOptionPane.showMessageDialog(contentPane, "Huésped eliminado");
							eliminarTabla();
							mostrarTablaHuespedes();
							mostrarTablaReservas();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Error, no se seleccionó ningún huésped");
					}
				} 
			}
		});

		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}

	// Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}

	private List<Reservas> BuscarReservas(){
		return this.reservasControl.buscar();
	}

	private List<Reservas> BuscarReservasId(Integer id) {
		return this.reservasControl.buscarId(id);
	}

	private List<Huespedes> BuscarHuespedes() {
		return this.huespedesControl.buscarHuespedes();
	}

	private List<Huespedes> BuscarHuespedesId(Integer id){
		return this.huespedesControl.buscarHuespedesId(id);
	}

	private void eliminarTabla() {
		((DefaultTableModel) tbHuespedes.getModel()).setRowCount(0);
		((DefaultTableModel) tbReservas.getModel()).setRowCount(0);
	}

	private void mostrarTablaReservas() {
		List<Reservas> reservas = BuscarReservas();
		try {
			for (Reservas res : reservas) {
				modelo.addRow(new Object[] {
						res.getId(),res.getFechaEntrada(),res.getFechaSalida(),res.getValor(),res.getFormaPago()
				});
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void mostrarTablaReservasId(Integer id) {
		List<Reservas> reservas = BuscarReservasId(id);
		try {
			for (Reservas res : reservas) {
				modelo.addRow(new Object[] {
						res.getId(),res.getFechaEntrada(),res.getFechaSalida(),res.getValor(),res.getFormaPago()
				});
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void mostrarTablaHuespedes() {
		List<Huespedes> huespedes = BuscarHuespedes();
		try {
			for (Huespedes huespedes1 : huespedes ) {
				modeloH.addRow(new Object[] {
						huespedes1.getId(), huespedes1.getNombre(), huespedes1.getApellido(),
						huespedes1.getFechaNacimiento(), huespedes1.getNacionalidad(), huespedes1.getTelefono(),huespedes1.getIdReserva()
				});
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void mostrarTablaHuespedesId(Integer id) {
		List<Huespedes> huespedes= BuscarHuespedesId(id);
		try {
			for (Huespedes huespedes1 : huespedes ) {
				modeloH.addRow(new Object[] {
						huespedes1.getId(), huespedes1.getNombre(), huespedes1.getApellido(),
						huespedes1.getFechaNacimiento(), huespedes1.getNacionalidad(), huespedes1.getTelefono(),huespedes1.getIdReserva()
				});
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void actualizarReservas() {
		Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
		.ifPresentOrElse(filaReservas ->{

			Date fechaE = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(),1 ).toString());
			Date fechaS = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(),2 ).toString());
			String valorStr = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString();
			BigDecimal valor = new BigDecimal(valorStr);
			String formaPago = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 4);
			Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0 ).toString());
			this.reservasControl.actualizar(fechaE, fechaS, valor, formaPago, id);
			JOptionPane.showMessageDialog(this, String.format("Se actualizaron datos de la reserva"));

		}, ()-> JOptionPane.showMessageDialog(this, "Error, vuelva a intentar"));
	}

	private void actualizarHuespedes() {
		Optional.ofNullable(modeloH.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
		.ifPresentOrElse(filaHuespedes ->{

			String nombre = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 1);
			String apellido = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 2);
			Date fechaNacimiento = Date.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(),3 ).toString());
			String nacionalidad = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 4);
			String telefono = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 5);
			Integer id_reserva = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(),6).toString());
			Integer id = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());

			this.huespedesControl.actualizar(nombre, apellido, fechaNacimiento, nacionalidad, telefono, id_reserva, id);
			JOptionPane.showMessageDialog(this, String.format("Se actualizaron datos del huésped"));

		}, ()-> JOptionPane.showMessageDialog(this, "Error, vuelva a intentar"));

	}
}
