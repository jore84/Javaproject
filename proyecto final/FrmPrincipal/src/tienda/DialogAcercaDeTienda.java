package tienda;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class DialogAcercaDeTienda extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblTienda;
	private JLabel lblAutores;
	private JSeparator separator;
	private JLabel lblAlumno0;
	private JLabel lblAlumno1;
	private JLabel lblAlumno2;
	private JLabel lblAlumno3;
	private JLabel lblAlumno4;
	private JLabel lblCodigo0;
	private JLabel lblCodigo1;
	private JLabel lblCodigo2;
	private JLabel lblCodigo3;
	private JLabel lblCodigo4;
	
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			DialogAcercaDeTienda dialog = new DialogAcercaDeTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogAcercaDeTienda() {
		setResizable(false);
		setTitle("Acerca de Tienda");
		setBounds(100, 100, 490, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblTienda = new JLabel("Tienda 1.0");
		lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienda.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTienda.setBounds(175, 10, 130, 20);
		contentPanel.add(lblTienda);
		
		lblAutores = new JLabel("Autores");
		lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
		lblAutores.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutores.setBounds(175, 50, 130, 20);
		contentPanel.add(lblAutores);
		
		separator = new JSeparator();
		separator.setBounds(30, 40, 415, 2);
		contentPanel.add(separator);
		
		lblAlumno0 = new JLabel("Fachin Custodio Anabel Marisol");
		lblAlumno0.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno0.setBounds(50, 70, 380, 15);
		contentPanel.add(lblAlumno0);
		
		lblCodigo0 = new JLabel("202331178");
		lblCodigo0.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo0.setBounds(175, 85, 130, 20);
		contentPanel.add(lblCodigo0);
		
		lblAlumno1 = new JLabel("Gebhardt Venturo Sigmund Diego");
		lblAlumno1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno1.setBounds(50, 110, 380, 15);
		contentPanel.add(lblAlumno1);
		
		lblCodigo1 = new JLabel("202330948");
		lblCodigo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo1.setBounds(175, 125, 130, 20);
		contentPanel.add(lblCodigo1);
		
		lblAlumno2 = new JLabel("Mendoza Sáenz Paul André");
		lblAlumno2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno2.setBounds(50, 150, 380, 15);
		contentPanel.add(lblAlumno2);
		
		lblCodigo2 = new JLabel("202330941");
		lblCodigo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo2.setBounds(175, 165, 130, 20);
		contentPanel.add(lblCodigo2);
		
		lblAlumno3 = new JLabel("Ramírez Fuentes Juan José");
		lblAlumno3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno3.setBounds(50, 190, 380, 15);
		contentPanel.add(lblAlumno3);
		
		lblCodigo3 = new JLabel("202332295");
		lblCodigo3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo3.setBounds(175, 205, 130, 20);
		contentPanel.add(lblCodigo3);
		
		lblAlumno4 = new JLabel("Rincón González Rafael Angel");
		lblAlumno4.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno4.setBounds(50, 230, 380, 15);
		contentPanel.add(lblAlumno4);
		
		lblCodigo4 = new JLabel("202330794");
		lblCodigo4.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo4.setBounds(175, 245, 130, 20);
		contentPanel.add(lblCodigo4);
				
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(195, 275, 90, 25);
		contentPanel.add(btnCerrar);
	}
	
	//Eventos
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
