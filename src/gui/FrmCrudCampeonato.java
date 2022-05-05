package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class FrmCrudCampeonato extends JFrame{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtAnno;
	private JTable table;
	private JButton btnRegistrar;
	private JButton btnEliminar;
	private JButton btnActualizar;

	// Es el id de la fila seleccionado
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
		setBounds(100, 100, 450, 466);
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
		lblMantenimientoCampeonato.setBounds(10, 11, 414, 59);
		contentPane.add(lblMantenimientoCampeonato);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(105, 95, 84, 26);
		contentPane.add(lblNombre);

		JLabel lblAnno = new JLabel("A\u00F1o");
		lblAnno.setBounds(105, 142, 46, 26);
		contentPane.add(lblAnno);

		txtNombre = new JTextField();
		txtNombre.setBounds(184, 98, 211, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtAnno = new JTextField();
		txtAnno.setBounds(184, 145, 86, 20);
		contentPane.add(txtAnno);
		txtAnno.setColumns(10);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setIcon(new ImageIcon(FrmCrudCampeonato.class.getResource("/iconos/add.gif")));
		btnRegistrar.setBounds(10, 179, 114, 33);
		contentPane.add(btnRegistrar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon(FrmCrudCampeonato.class.getResource("/iconos/edit.gif")));
		btnActualizar.setBounds(310, 179, 114, 33);
		contentPane.add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(FrmCrudCampeonato.class.getResource("/iconos/delete.gif")));
		btnEliminar.setBounds(158, 179, 114, 33);
		contentPane.add(btnEliminar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 414, 184);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Id", "Nombre", "A\u00F1o" }));
		scrollPane.setViewportView(table);

		// Traer todos los campeonatos de la BD
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


