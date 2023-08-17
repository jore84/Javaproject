package tienda;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DialogModificarCocina extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblModelo;
	private JComboBox<Object> cboModelo;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JLabel lblAncho;
	private JTextField txtAncho;
	private JLabel lblAlto;
	private JTextField txtAlto;
	private JLabel lblFondo;
	private JTextField txtFondo;
	private JLabel lblQuemadores;
	private JTextField txtQuemadores;
	private JButton btnCerrar;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogModificarCocina dialog = new DialogModificarCocina();
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
	public DialogModificarCocina() {
		setResizable(false);
		setTitle("Modificar Cocina");
		setBounds(100, 100, 462, 280);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 68, 20);
		contentPanel.add(lblModelo);
		
		cboModelo = new JComboBox<Object>();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<Object>(new String[] {
		"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.setBounds(135, 7, 160, 22);
		contentPanel.add(cboModelo);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setBounds(10, 45, 110, 20);
		contentPanel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(135, 45, 160, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		lblAncho = new JLabel("Ancho (Cm.)");
		lblAncho.setBounds(10, 85, 110, 20);
		contentPanel.add(lblAncho);
		
		txtAncho = new JTextField();
		txtAncho.setBounds(135, 85, 160, 20);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);
		
		lblAlto = new JLabel("Alto (Cm.)");
		lblAlto.setBounds(10, 125, 110, 20);
		contentPanel.add(lblAlto);
		
		txtAlto = new JTextField();
		txtAlto.setBounds(135, 125, 160, 20);
		contentPanel.add(txtAlto);
		txtAlto.setColumns(10);
		
		lblFondo = new JLabel("Fondo (Cm.)");
		lblFondo.setBounds(10, 165, 110, 20);
		contentPanel.add(lblFondo);
		
		txtFondo = new JTextField();
		txtFondo.setBounds(135, 165, 160, 20);
		contentPanel.add(txtFondo);
		txtFondo.setColumns(10);
		
		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setBounds(10, 205, 110, 20);
		contentPanel.add(lblQuemadores);
		
		txtQuemadores = new JTextField();
		txtQuemadores.setBounds(135, 205, 160, 20);
		contentPanel.add(txtQuemadores);
		txtQuemadores.setColumns(10);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(310, 5, 120, 25);
		contentPanel.add(btnModificar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(310, 40, 120, 25);
		contentPanel.add(btnCerrar);
		
		
		
		//mostrar datos de la primer modelo
		mostrarDatosPrimerModelo();

	}
			//Eventos
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == cboModelo) {
					actionPerformedCboModelo(e);
				}
				if (e.getSource() == btnCerrar) {
					actionPerformedBtnCerrar(e);
				}
				if (e.getSource() == btnModificar) {
					actionPerformedBtnModificar(e);
				}
			}
			
			protected void actionPerformedBtnModificar(ActionEvent e) {
				
				//Declaración de Variables
				int modelo, quemadores;
				double precio, ancho, alto, fondo;
				
				//Entrada de datos
				modelo = getModelo();
				
				try {
					
					precio = Double.parseDouble(txtPrecio.getText());
					ancho = Double.parseDouble(txtAncho.getText());
					alto = Double.parseDouble(txtAlto.getText());
					fondo = Double.parseDouble(txtFondo.getText());
					quemadores = Integer.parseInt(txtQuemadores.getText());
					
					//Validaciones
					if(precio <= 0) {
						JOptionPane.showMessageDialog(this, "Ingrese valores de Precio mayores a 0", "ERROR!", 0);
						txtPrecio.setText(""+precio);
						return;
					}else if(ancho <= 0){
						JOptionPane.showMessageDialog(this, "Ingrese Medidas Correctas", "ERROR!", 0);
						txtAncho.setText(""+ancho);
						return;
					}else if(alto <= 0){
						JOptionPane.showMessageDialog(this, "Ingrese Medidas Correctas", "ERROR!", 0);
						txtAlto.setText(""+alto);
						return;
					}else if(fondo <= 0){
						JOptionPane.showMessageDialog(this, "Ingrese Medidas Correctas", "ERROR!", 0);
						txtFondo.setText(""+fondo);
						return;
					}else if(quemadores <= 0){
						JOptionPane.showMessageDialog(this, "Ingrese Cantidad Correcta", "ERROR!", 0);
						txtQuemadores.setText(""+quemadores);
						return;
					}
				}catch(NumberFormatException f){
					JOptionPane.showMessageDialog(this, "Ingrese Valores Numericos", "ERROR!", 0);
					return;	
				}
				
				modificarResultados(modelo);
				JOptionPane.showMessageDialog(this, "Se Modifico Correctamente", "AVISO!", 1);
				dispose();	
			}
	

			protected void actionPerformedBtnCerrar(ActionEvent e) {
				//Cerrar una ventana secundaria
				dispose();
			}
			
			protected void actionPerformedCboModelo(ActionEvent e) {
				//Declaración de variable
				int modelo;
				//Entrada de Datos
				modelo = getModelo();
				//Mostar resultados
				mostrarResultados(modelo);
			}
	
			private int getModelo() {
				return cboModelo.getSelectedIndex();
			}
	
			private void mostrarDatosPrimerModelo() {
				txtPrecio.setText(FrmPrincipal.precio0+"");
				txtAncho.setText(FrmPrincipal.ancho0+"");
				txtAlto.setText(FrmPrincipal.alto0+"");
				txtFondo.setText(FrmPrincipal.fondo0+"");
				txtQuemadores.setText(FrmPrincipal.quemadores0+"");
				
			}
			private void mostrarResultados(int modelo) {
				switch(modelo) {
					case 0:
						txtPrecio.setText(FrmPrincipal.precio0+"");
						txtAncho.setText(FrmPrincipal.ancho0+"");
						txtAlto.setText(FrmPrincipal.alto0+"");
						txtFondo.setText(FrmPrincipal.fondo0+"");
						txtQuemadores.setText(FrmPrincipal.quemadores0+"");
						break;
					case 1:
						txtPrecio.setText(FrmPrincipal.precio1+"");
						txtAncho.setText(FrmPrincipal.ancho1+"");
						txtAlto.setText(FrmPrincipal.alto1+"");
						txtFondo.setText(FrmPrincipal.fondo1+"");
						txtQuemadores.setText(FrmPrincipal.quemadores1+"");
						break;
					case 2:
						txtPrecio.setText(FrmPrincipal.precio2+"");
						txtAncho.setText(FrmPrincipal.ancho2+"");
						txtAlto.setText(FrmPrincipal.alto2+"");
						txtFondo.setText(FrmPrincipal.fondo2+"");
						txtQuemadores.setText(FrmPrincipal.quemadores2+"");
						break;
					case 3:
						txtPrecio.setText(FrmPrincipal.precio3+"");
						txtAncho.setText(FrmPrincipal.ancho3+"");
						txtAlto.setText(FrmPrincipal.alto3+"");
						txtFondo.setText(FrmPrincipal.fondo3+"");
						txtQuemadores.setText(FrmPrincipal.quemadores3+"");
						break;
					default:
						txtPrecio.setText(FrmPrincipal.precio4+"");
						txtAncho.setText(FrmPrincipal.ancho4+"");
						txtAlto.setText(FrmPrincipal.alto4+"");
						txtFondo.setText(FrmPrincipal.fondo4+"");
						txtQuemadores.setText(FrmPrincipal.quemadores4+"");
				}
			}
			private void modificarResultados(int modelo) {
					switch(modelo) {
						case 0:
							FrmPrincipal.precio0= Double.parseDouble(txtPrecio.getText());
							FrmPrincipal.ancho0 = Double.parseDouble(txtAncho.getText());
							FrmPrincipal.alto0 = Double.parseDouble(txtAlto.getText());
							FrmPrincipal.fondo0 = Double.parseDouble(txtFondo.getText());
							FrmPrincipal.quemadores0 = Integer.parseInt(txtQuemadores.getText());
							break;
						case 1:
							FrmPrincipal.precio1 = Double.parseDouble(txtPrecio.getText());
							FrmPrincipal.ancho1 = Double.parseDouble(txtAncho.getText());
							FrmPrincipal.alto1 = Double.parseDouble(txtAlto.getText());
							FrmPrincipal.fondo1 = Double.parseDouble(txtFondo.getText());
							FrmPrincipal.quemadores1 = Integer.parseInt(txtQuemadores.getText());
							break;
						case 2:
							FrmPrincipal.precio2 = Double.parseDouble(txtPrecio.getText());
							FrmPrincipal.ancho2 = Double.parseDouble(txtAncho.getText());
							FrmPrincipal.alto2 = Double.parseDouble(txtAlto.getText());
							FrmPrincipal.fondo2 = Double.parseDouble(txtFondo.getText());
							FrmPrincipal.quemadores2 = Integer.parseInt(txtQuemadores.getText());
							break;
						case 3:
							FrmPrincipal.precio3 = Double.parseDouble(txtPrecio.getText());
							FrmPrincipal.ancho3 = Double.parseDouble(txtAncho.getText());
							FrmPrincipal.alto3 = Double.parseDouble(txtAlto.getText());
							FrmPrincipal.fondo3 = Double.parseDouble(txtFondo.getText());
							FrmPrincipal.quemadores3 = Integer.parseInt(txtQuemadores.getText());
							break;
						default :
							FrmPrincipal.precio4 = Double.parseDouble(txtPrecio.getText());
							FrmPrincipal.ancho4 = Double.parseDouble(txtAncho.getText());
							FrmPrincipal.alto4 = Double.parseDouble(txtAlto.getText());
							FrmPrincipal.fondo4 = Double.parseDouble(txtFondo.getText());
							FrmPrincipal.quemadores4 = Integer.parseInt(txtQuemadores.getText());
							break;
					}
			
			}
		}
