package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class DialogoModificarCocina extends JDialog implements ActionListener, ItemListener {

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
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		try {
			DialogoModificarCocina dialog = new DialogoModificarCocina();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoModificarCocina() {
		setModal(true);
		setResizable(false);
		setTitle("ModificarCocina");
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
		cboModelo.addItemListener(this); //Te faltaba esto
		cboModelo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota" }));
		cboModelo.setBounds(103, 26, 135, 20);
		contentPanel.add(cboModelo);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(103, 51, 135, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtAncho = new JTextField();
		txtAncho.setColumns(10);
		txtAncho.setBounds(103, 76, 135, 20);
		contentPanel.add(txtAncho);

		txtAlto = new JTextField();
		txtAlto.setColumns(10);
		txtAlto.setBounds(103, 101, 135, 20);
		contentPanel.add(txtAlto);

		txtFondo = new JTextField();
		txtFondo.setColumns(10);
		txtFondo.setBounds(103, 126, 135, 20);
		contentPanel.add(txtFondo);

		txtQuemadores = new JTextField();
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
		btnCerrar.setBounds(319, 25, 89, 23);
		contentPanel.add(btnCerrar);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(319, 50, 89, 23);
		contentPanel.add(btnGrabar);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
			
		}
		
	}

	protected void actionPerformedBtnGrabar(ActionEvent e) {
		grabar();
		
	}
	private void grabar(){
		int modelo;

		modelo = cboModelo.getSelectedIndex();

		switch (modelo) {
		case 0:
			Tienda1.precio0 = Double.parseDouble(txtPrecio.getText());
			Tienda1.ancho0 = Double.parseDouble(txtAncho.getText());
			Tienda1.alto0 = Double.parseDouble(txtAlto.getText());
			Tienda1.fondo0 = Double.parseDouble(txtFondo.getText());
			Tienda1.quemadores0 = Integer.parseInt(txtQuemadores.getText());
			break;
		case 1:
			Tienda1.precio1 = Double.parseDouble(txtPrecio.getText());
			Tienda1.ancho1 = Double.parseDouble(txtAncho.getText());
			Tienda1.alto1 = Double.parseDouble(txtAlto.getText());
			Tienda1.fondo1 = Double.parseDouble(txtFondo.getText());
			Tienda1.quemadores1 = Integer.parseInt(txtQuemadores.getText());
		case 2:
			Tienda1.precio2 = Double.parseDouble(txtPrecio.getText());
			Tienda1.ancho2= Double.parseDouble(txtAncho.getText());
			Tienda1.alto2 = Double.parseDouble(txtAlto.getText());
			Tienda1.fondo2 = Double.parseDouble(txtFondo.getText());
			Tienda1.quemadores2 = Integer.parseInt(txtQuemadores.getText());
			break;
		case 3:
			Tienda1.precio3 = Double.parseDouble(txtPrecio.getText());
			Tienda1.ancho3 = Double.parseDouble(txtAncho.getText());
			Tienda1.alto3 = Double.parseDouble(txtAlto.getText());
			Tienda1.fondo3 = Double.parseDouble(txtFondo.getText());
			Tienda1.quemadores3 = Integer.parseInt(txtQuemadores.getText());
			break;
		default:
			Tienda1.precio4 = Double.parseDouble(txtPrecio.getText());
			Tienda1.ancho4 = Double.parseDouble(txtAncho.getText());
			Tienda1.alto4 = Double.parseDouble(txtAlto.getText());
			Tienda1.fondo4 = Double.parseDouble(txtFondo.getText());
			Tienda1.quemadores4 = Integer.parseInt(txtQuemadores.getText());
			break;
		}
		
		this.dispose();
		JOptionPane.showMessageDialog(this, "Datos modificados", null, JOptionPane.INFORMATION_MESSAGE);
	
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		this.dispose();
	
	}
	
		void lista(){
			int modelo;

			modelo = cboModelo.getSelectedIndex();

			switch (modelo) {
			case 0:
				modificarModelo(Tienda1.precio0, Tienda1.ancho0, Tienda1.alto0, Tienda1.fondo0, Tienda1.quemadores0);
				break;
			case 1:
				modificarModelo(Tienda1.precio1, Tienda1.ancho1, Tienda1.alto1, Tienda1.fondo1, Tienda1.quemadores1);
				break;
			case 2:
				modificarModelo(Tienda1.precio2, Tienda1.ancho2, Tienda1.alto2, Tienda1.fondo2, Tienda1.quemadores2);
				break;
			case 3:
				modificarModelo(Tienda1.precio3, Tienda1.ancho3, Tienda1.alto3, Tienda1.fondo3, Tienda1.quemadores3);
				break;
			default:
				modificarModelo(Tienda1.precio4, Tienda1.ancho4, Tienda1.alto4, Tienda1.fondo4, Tienda1.quemadores4);
				break;
		}
		}
		
		public void itemStateChangedCboModelo(ItemEvent arg0) {
			lista();
		}
	
	
	 public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cboModelo) {
			itemStateChangedCboModelo(arg0);
		}
		
	}

	void modificarModelo(double precio, double ancho, double alto, double fondo, int quemadores) {
		txtPrecio.setText(precio + "");
		txtAncho.setText(ancho + "");
		txtAlto.setText(alto + "");
		txtFondo.setText(fondo + "");
		txtQuemadores.setText(quemadores + "");
	}
}
	