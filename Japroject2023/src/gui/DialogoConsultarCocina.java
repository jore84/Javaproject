package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class DialogoConsultarCocina extends JDialog implements ActionListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JLabel lblFondo;
	private JLabel lblQuemadores;
	private JComboBox<String> cboModelo;
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtAlto;
	private JTextField txtFondo;
	private JTextField txtQuemadores;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConsultarCocina dialog = new DialogoConsultarCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConsultarCocina() {
		setModal(true);
		setResizable(false);
		setTitle("Consultar Cocina");
		setBounds(100, 100, 425, 222);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 29, 73, 14);
		contentPanel.add(lblModelo);

		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setBounds(10, 54, 73, 14);
		contentPanel.add(lblPrecio);

		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setBounds(10, 79, 73, 14);
		contentPanel.add(lblAncho);

		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setBounds(10, 104, 73, 14);
		contentPanel.add(lblAlto);

		lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setBounds(10, 129, 73, 14);
		contentPanel.add(lblFondo);

		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setBounds(10, 154, 83, 14);
		contentPanel.add(lblQuemadores);

		cboModelo = new JComboBox<String>();
		cboModelo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota" }));
		cboModelo.setBounds(103, 26, 135, 20);
		contentPanel.add(cboModelo);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(103, 51, 135, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setColumns(10);
		txtAncho.setBounds(103, 76, 135, 20);
		contentPanel.add(txtAncho);

		txtAlto = new JTextField();
		txtAlto.setEditable(false);
		txtAlto.setColumns(10);
		txtAlto.setBounds(103, 101, 135, 20);
		contentPanel.add(txtAlto);

		txtFondo = new JTextField();
		txtFondo.setEditable(false);
		txtFondo.setColumns(10);
		txtFondo.setBounds(103, 126, 135, 20);
		contentPanel.add(txtFondo);

		txtQuemadores = new JTextField();
		txtQuemadores.setEditable(false);
		txtQuemadores.setColumns(10);
		txtQuemadores.setBounds(103, 151, 135, 20);
		contentPanel.add(txtQuemadores);

		txtPrecio.setText(Tienda1.precio0 + "");
		txtAncho.setText(Tienda1.ancho0 + "");
		txtAlto.setText(Tienda1.alto0 + "");
		txtFondo.setText(Tienda1.fondo0 + "");
		txtQuemadores.setText(Tienda1.quemadores0 + "");

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(309, 25, 89, 23);
		contentPanel.add(btnCerrar);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);

		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		this.dispose();

	}

	public void itemStateChanged1(ItemEvent arg0) {
		if (arg0.getSource() == cboModelo) {
			itemStateChangedCboModelo(arg0);
		}
	}

	protected void itemStateChangedCboModelo(ItemEvent arg0) {
		int modelo;

		modelo = cboModelo.getSelectedIndex();

		switch (modelo) {
		case 0:
		
			// consultarModelo(Tienda1.precio0, Tienda1.ancho0, Tienda1.alto0, Tienda1.fondo0, Tienda1.quemadores0);
			break;
		case 1:
			consultarModelo(Tienda1.precio1, Tienda1.ancho1, Tienda1.alto1, Tienda1.fondo1, Tienda1.quemadores1);
			break;
		case 2:
			consultarModelo(Tienda1.precio2, Tienda1.ancho2, Tienda1.alto2, Tienda1.fondo2, Tienda1.quemadores2);
			break;
		case 3:
			consultarModelo(Tienda1.precio3, Tienda1.ancho3, Tienda1.alto3, Tienda1.fondo3, Tienda1.quemadores3);
			break;
		default:
			consultarModelo(Tienda1.precio4, Tienda1.ancho4, Tienda1.alto4, Tienda1.fondo4, Tienda1.quemadores4);
			break;
		}
	}

	int leerModelo() {
		
		return cboModelo.getSelectedIndex();
	}

	public void itemStateChanged(ItemEvent arg0) {

	}

	void consultarModelo(double precio, double ancho, double alto, double fondo, int quemadores) {
		txtPrecio.setText(precio + "");
		txtAncho.setText(ancho + "");
		txtAlto.setText(alto + "");
		txtFondo.setText(fondo + "");
		txtQuemadores.setText(quemadores + "");
	}
	// Datos m�nimos de la primera cocina
		public static String modelo0 = "Mabe EMP6120PG0";
		public static double precio0 = 949.0;
		
		public static double fondo0 = 58.6;
		public static double ancho0 = 60.0;
		public static double alto0 = 91.0;
		public static int quemadores0 = 4;
		// Datos m�nimos de la segunda cocina
		public static String modelo1 = "Indurama Parma";
		public static double precio1 = 1089.0;
		public static double ancho1 = 80.0;
		public static double alto1 = 94.0;
		public static double fondo1 = 67.5;
		public static int quemadores1 = 6;
		// Datos m�nimos de la tercera cocina
		public static String modelo2 = "Sole COSOL027";
		public static double precio2 = 850.0;
		public static double ancho2 = 60.0;
		public static double alto2 = 90.0;
		public static double fondo2 = 50.0;
		public static int quemadores2 = 4;
		// Datos m�nimos de la cuarta cocina
		public static String modelo3 = "Coldex CX602";
		public static double precio3 = 629.0;
		public static double ancho3 = 61.6;
		public static double alto3 = 95.0;
		public static double fondo3 = 51.5;
		public static int quemadores3 = 5;
		// Datos m�nimos de la quinta cocina
		public static String modelo4 = "Reco Dakota";
		public static double precio4 = 849.0;
		public static double ancho4 = 75.4;
		public static double alto4 = 94.5;
		public static double fondo4 = 66.0;
		public static int quemadores4 = 5;
}
