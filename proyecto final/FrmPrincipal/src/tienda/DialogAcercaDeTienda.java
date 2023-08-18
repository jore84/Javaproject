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
		
		lblAlumno0 = new JLabel("ORE SANCHEZ JUAN JOSE");
		lblAlumno0.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno0.setBounds(50, 70, 380, 15);
		contentPanel.add(lblAlumno0);
		
		
		
		lblAlumno1 = new JLabel("ZELADA MARIN ALEXANDER");
		lblAlumno1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno1.setBounds(50, 110, 380, 15);
		contentPanel.add(lblAlumno1);
		
		
		
		lblAlumno2 = new JLabel("OLIVERA APAZA ALDAIR JAYLOR");
		lblAlumno2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno2.setBounds(50, 150, 380, 15);
		contentPanel.add(lblAlumno2);
		
	
		
		lblAlumno3 = new JLabel("IPANAQUE RODAS ENOC ISAAC");
		lblAlumno3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno3.setBounds(50, 190, 380, 15);
		contentPanel.add(lblAlumno3);
		
		
		
		lblAlumno4 = new JLabel("CAMERO CONDORI JORGE GUILLERMO");
		lblAlumno4.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumno4.setBounds(50, 230, 380, 15);
		contentPanel.add(lblAlumno4);
		
		
				
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
