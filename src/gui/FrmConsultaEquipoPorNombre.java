package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import entidad.Equipo;
import model.EquipoModel;

public class FrmConsultaEquipoPorNombre extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFiltro;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
					FrmConsultaEquipoPorNombre frame = new FrmConsultaEquipoPorNombre();
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
	public FrmConsultaEquipoPorNombre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConsultaEquipoPor = new JLabel("Consulta equipo por nombre");
		lblConsultaEquipoPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaEquipoPor.setBounds(10, 24, 622, 40);
		lblConsultaEquipoPor.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblConsultaEquipoPor);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(88, 94, 133, 14);
		contentPane.add(lblNombre);
		
		txtFiltro = new JTextField();
		txtFiltro.addKeyListener(this);
		txtFiltro.setBounds(231, 91, 387, 20);
		contentPane.add(txtFiltro);
		txtFiltro.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 140, 671, 219);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nombre", "Pa\u00EDs"
			}
		));
		scrollPane.setViewportView(table);
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getSource() == txtFiltro) {
			keyReleasedTxtFiltroJTextField(arg0);
		}
	}
	public void keyTyped(KeyEvent arg0) {
	}
	protected void keyReleasedTxtFiltroJTextField(KeyEvent arg0) {
		String filtro = txtFiltro.getText().trim();
	
		EquipoModel m = new EquipoModel();
		ArrayList<Equipo> lista = m.listaEquipoPorNombre(filtro);
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		for (Equipo x : lista) {
			Object[] fila = {x.getIdEquipo(), x.getNombre(), x.getPais()};
			dtm.addRow(fila);
		}
		
	}
}