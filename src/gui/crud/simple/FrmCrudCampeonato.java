package gui.crud.simple;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class FrmCrudCampeonato extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtAnno;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JButton btnActualizar;
	private JCheckBox chkEstado;
	
	// Es el id de la fila seleccionado 
	// -1 ==> NO se selecciono NADA
	int idSeleccionado = -1;

	// ModelCampeonato-->Es la clase donde estan los
	// métodos insert, update, delete, listar en la BD

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
					FrmCrudCampeonato frame = new FrmCrudCampeonato();
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
	public FrmCrudCampeonato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMantenimientoCampeonato = new JLabel("Mantenimiento Campeonato");
		lblMantenimientoCampeonato.setOpaque(true);
		lblMantenimientoCampeonato.setBackground(Color.RED);
		lblMantenimientoCampeonato.setHorizontalAlignment(SwingConstants.CENTER);
		lblMantenimientoCampeonato.setForeground(Color.WHITE);
		lblMantenimientoCampeonato.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMantenimientoCampeonato.setBounds(10, 11, 508, 59);
		contentPane.add(lblMantenimientoCampeonato);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(105, 95, 84, 26);
		contentPane.add(lblNombre);

		JLabel lblAnno = new JLabel("A\u00F1o");
		lblAnno.setBounds(104, 132, 46, 26);
		contentPane.add(lblAnno);

		txtNombre = new JTextField();
		txtNombre.setBounds(184, 98, 211, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtAnno = new JTextField();
		txtAnno.setBounds(183, 135, 86, 20);
		contentPane.add(txtAnno);
		txtAnno.setColumns(10);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmCrudCampeonato.class.getResource("/iconos/add.gif")));
		btnRegistrar.setBounds(57, 216, 114, 33);
		contentPane.add(btnRegistrar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(FrmCrudCampeonato.class.getResource("/iconos/edit.gif")));
		btnActualizar.setBounds(357, 216, 114, 33);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmCrudCampeonato.class.getResource("/iconos/delete.gif")));
		btnEliminar.setBounds(205, 216, 114, 33);
		contentPane.add(btnEliminar);

	
		chkEstado = new JCheckBox("Activo");
		chkEstado.setSelected(true);
		chkEstado.setBounds(185, 175, 84, 23);
		contentPane.add(chkEstado);


	}



	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}

	void limpiarCajasTexto() {
		txtNombre.setText("");
		txtAnno.setText("");
		txtNombre.requestFocus();
	}

	



}



