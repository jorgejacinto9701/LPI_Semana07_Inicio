package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class FrmCrudJugador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtFecha;
	private JButton btnIngresar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudJugador frame = new FrmCrudJugador();
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
	public FrmCrudJugador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMantenimientoDeJugador = new JLabel("Mantenimiento de Jugador");
		lblMantenimientoDeJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoDeJugador.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMantenimientoDeJugador.setBounds(10, 24, 641, 38);
		contentPane.add(lblMantenimientoDeJugador);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(50, 95, 130, 14);
		contentPane.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(50, 135, 130, 14);
		contentPane.add(lblApellido);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setBounds(50, 176, 130, 14);
		contentPane.add(lblFechaDeNacimiento);

		txtNombre = new JTextField();
		txtNombre.setBounds(259, 92, 181, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setBounds(259, 132, 181, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);

		txtFecha = new JTextField();
		txtFecha.setBounds(259, 173, 146, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setIcon(new ImageIcon(FrmCrudJugador.class.getResource("/iconos/add.gif")));
		btnIngresar.setBounds(495, 91, 130, 30);
		contentPane.add(btnIngresar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(FrmCrudJugador.class.getResource("/iconos/edit.gif")));
		btnActualizar.setBounds(495, 168, 130, 30);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmCrudJugador.class.getResource("/iconos/delete.gif")));
		btnEliminar.setBounds(495, 127, 130, 30);
		contentPane.add(btnEliminar);

	}

	
	

	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}

	void limpiarCajasTexto() {
		txtNombre.setText("");
		txtApellido.setText("");
		txtFecha.setText("");
		txtNombre.requestFocus();
	}
	
	
}



