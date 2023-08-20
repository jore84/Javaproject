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
		cboModelo.addActionListener(this);
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
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
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
	
		int modelo = Leermodelo();
		
		String preciotexto = leerPreciotexto();
		String anchotexto = leerAnchotexto();
		String altotexto = leerAltotexto();
		String fondotexto = leerFondotexto();
		String quemadorestexto = leerQuemadorestexto();
		
		
			
		
		
		if (preciotexto.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El precio es requedido","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);	
		    return;
		}
		if (anchotexto.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El ancho es requedido","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);	
		    return;
		}
		if (altotexto.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El alto es requedido","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);	
		    return;
		}
		if (fondotexto.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El fondo es requedido","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);	
		    return;
		}
		if (quemadorestexto.isEmpty()) {
			JOptionPane.showMessageDialog(this, "El quemadores es requedido","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);	
		    return;
		}
		
	
		
		try {
			double Precio = leerPrecio();
			double Ancho = leerAncho();
			double Alto = leerAlto();
			double Fondo = leerFondo();
			int Quemadores = leerQuemadores();
			if (Precio <= 0) {
				JOptionPane.showMessageDialog(this, "La cantidada debe ser mayor a 0", preciotexto, JOptionPane.WARNING_MESSAGE );
				return ;
			}
			if (Ancho <= 0) {
				JOptionPane.showMessageDialog(this, "La cantidada debe ser mayor a 0", anchotexto, JOptionPane.WARNING_MESSAGE );
				return ;
			}
			if (Alto <= 0) {
				JOptionPane.showMessageDialog(this, "La cantidada debe ser mayor a 0", altotexto, JOptionPane.WARNING_MESSAGE );
				return ;
			}
			if (Fondo <= 0) {
				JOptionPane.showMessageDialog(this, "La cantidada debe ser mayor a 0", fondotexto, JOptionPane.WARNING_MESSAGE );
				return ;
			}
			if (Quemadores <= 0) {
				JOptionPane.showMessageDialog(this, "La cantidada debe ser mayor a 0", quemadorestexto, JOptionPane.WARNING_MESSAGE );
				return ;
			}
			
			switch (modelo) {
			case 0:
				Tienda1.precio0 = Precio;
				Tienda1.ancho0 =Ancho;
				Tienda1.alto0 =Alto;
				Tienda1.fondo0 =Fondo;
				Tienda1.quemadores0 =Quemadores;
				break;
			case 1:
				Tienda1.precio1 =Precio;
				Tienda1.ancho1 =Ancho;
				Tienda1.alto1 =Alto;
				Tienda1.fondo1 =Fondo;
				Tienda1.quemadores1 =Quemadores;
			case 2:
				Tienda1.precio2 =Precio;
				Tienda1.ancho2 =Ancho;
				Tienda1.alto2 =Alto;
				Tienda1.fondo2 =Fondo;
				Tienda1.quemadores2 =Quemadores;
				break;
			case 3:
				Tienda1.precio3 =Precio;
				Tienda1.ancho3 =Ancho;
				Tienda1.alto3 =Alto;
				Tienda1.fondo3 =Fondo;
				Tienda1.quemadores3 =Quemadores;
				break;
			default:
				Tienda1.precio4 =Precio;
				Tienda1.ancho4 =Ancho;
				Tienda1.alto4=Alto;
				Tienda1.fondo4 =Fondo;
				Tienda1.quemadores4 =Quemadores;
				break;
			}
			
			this.dispose();
			JOptionPane.showMessageDialog(this, "Datos modificados", null, JOptionPane.INFORMATION_MESSAGE);
		
			
	
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "El precio es un numero","ADVERTENCIO",JOptionPane.WARNING_MESSAGE);
			JOptionPane.showMessageDialog(this, "El Ancho es un numero","ADVERTENCIO",JOptionPane.WARNING_MESSAGE);
			JOptionPane.showMessageDialog(this, "El Alto es un numero","ADVERTENCIO",JOptionPane.WARNING_MESSAGE);
			JOptionPane.showMessageDialog(this, "El Fondo es un numero","ADVERTENCIO",JOptionPane.WARNING_MESSAGE);
		}
	  
		
	}	
	
	int Leermodelo(){
		return cboModelo.getSelectedIndex();
	}
	
	String leerPreciotexto(){
		return txtPrecio.getText();
	}
	String leerAnchotexto(){
		return txtAncho.getText();
	}
	String leerAltotexto(){
		return txtAlto.getText();
	}
	String leerFondotexto(){
		return txtFondo.getText();
	}
	String leerQuemadorestexto(){
		return txtQuemadores.getText();
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		this.dispose();
	
	}
	
		 private void lista(){
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
	double leerPrecio(){
		return Double.parseDouble(txtPrecio.getText());
	}
	double leerAncho(){
		return Double.parseDouble(txtAncho.getText());
	}
	double leerAlto(){
		return Double.parseDouble(txtAlto.getText());
	}
	double leerFondo(){
		return Double.parseDouble(txtFondo.getText());
	}
	int leerQuemadores(){
		return Integer.parseInt(txtQuemadores.getText());
	}

	 private void modificarModelo(double precio, double ancho, double alto, double fondo, int quemadores) {
		txtPrecio.setText(precio + "");
		txtAncho.setText(ancho + "");
		txtAlto.setText(alto + "");
		txtFondo.setText(fondo + "");
		txtQuemadores.setText(quemadores + "");
	}
	protected void actionPerformedCboModelo(ActionEvent e) {
		lista();
	}
}
	