package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoConsultarCocina extends JDialog implements ActionListener, ItemListener  {

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
		cboModelo.addItemListener(this);
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
		
		txtPrecio.setText(Javaproject20223.precio0 + "");
		txtAncho.setText(Javaproject20223.ancho0 + "");
		txtAlto.setText(Javaproject20223.alto0 + "");
		txtFondo.setText(Javaproject20223.fondo0 + "");
		txtQuemadores.setText(Javaproject20223.quemadores0 + "");
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(309, 25, 89, 23);
		contentPanel.add(btnCerrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	void solucion(){
	    int modelo;

		modelo = cboModelo.getSelectedIndex();

		switch (modelo) {
			case 0:
			    consultarModelo(Javaproject20223.precio0, Javaproject20223.ancho0, Javaproject20223.alto0, Javaproject20223.fondo0, Javaproject20223.quemadores0);
				break;
			case 1:
				consultarModelo(Javaproject20223.precio1, Javaproject20223.ancho1, Javaproject20223.alto1, Javaproject20223.fondo1, Javaproject20223.quemadores1);
				break;
			case 2:
				consultarModelo(Javaproject20223.precio2, Javaproject20223.ancho2, Javaproject20223.alto2, Javaproject20223.fondo2, Javaproject20223.quemadores2);
				break;
			case 3:
				consultarModelo(Javaproject20223.precio3, Javaproject20223.ancho3, Javaproject20223.alto3, Javaproject20223.fondo3, Javaproject20223.quemadores3);
				break;
			default:
				consultarModelo(Javaproject20223.precio4, Javaproject20223.ancho4, Javaproject20223.alto4, Javaproject20223.fondo4, Javaproject20223.quemadores4);
				break;
		}
	}
	 
	public void itemStateChangedCboModelo(ItemEvent arg0) {
		solucion();
	}

		
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cboModelo) {
			itemStateChangedCboModelo(arg0);
		}
	}

	void consultarModelo(double precio, double ancho, double alto, double fondo, int quemadores) {
		txtPrecio.setText(precio + "");
		txtAncho.setText(ancho + "");
		txtAlto.setText(alto + "");
		txtFondo.setText(fondo + "");
		txtQuemadores.setText(quemadores + "");
	}
}
