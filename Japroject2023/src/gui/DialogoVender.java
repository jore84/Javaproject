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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class DialogoVender extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnCerrar;
	private JTextArea txtS;

	//Decimal Format
	DecimalFormat df = new DecimalFormat("0.00");
	private JButton btnVender;
	private JComboBox<Object> cboModelo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoVender dialog = new DialogoVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoVender() {
		setModal(true);
		setResizable(false);
		setTitle("Vender");
		setBounds(100, 100, 450, 327);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 11, 46, 14);
		contentPanel.add(lblModelo);
		
		JLabel lblPrecio = new JLabel("Precio(S/)");
		lblPrecio.setBounds(10, 36, 67, 14);
		contentPanel.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 66, 67, 14);
		contentPanel.add(lblCantidad);
		
		cboModelo = new JComboBox<Object>();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<Object>(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.setBounds(87, 8, 122, 20);
		contentPanel.add(cboModelo);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(87, 33, 122, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(87, 63, 122, 20);
		contentPanel.add(txtCantidad);
		
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(345, 7, 89, 23);
		contentPanel.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(345, 32, 89, 23);
		contentPanel.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 91, 424, 196);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		mostrarDatosPrimerModelo();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnVender(ActionEvent e) {
		//Declaración de Variables
		int cantidad;
		double precio, impCompra, impDescuento, impPagar;
		String obsequio;
		//Datos de Entrada
		precio =  getPrecio();
				
		try {
			cantidad = getCantidad();
					
			//Validaciones
			if(cantidad <= 0) {
				JOptionPane.showMessageDialog(this, "Ingrese una cantidad mayor a 0", "ERROR!", 0);
				txtCantidad.setText("1");
				return;
			}
		} catch (NumberFormatException f) {
			JOptionPane.showMessageDialog(this, "Ingrese Valores Numericos", "ERROR!", 0);
			return;	
		}
				
		//Operaciones
		impCompra = calcImpCompra(cantidad, precio);
		impDescuento = calcImpDescuento(cantidad, impCompra);
		impPagar = calcImpPagar(impCompra, impDescuento);	
		obsequio = calcObsequio(cantidad);
				
		//Salidad de Datos
		mostrarResultados(precio, cantidad, impCompra, impDescuento, impPagar, obsequio);
				
		incrementador(impPagar);
		if ((Javaproject20223.ventasTotales % 5) == 0) {
			mostrarMensaje();
		}
		guardarDatosVenta(impPagar);
	}
	
	protected void actionPerformedCboModelo(ActionEvent e) {
		//Declaración de variables
		int modelo;
		//Entrada de Datos
		modelo = getModelo();
		//Mostar resultados
		mostrarModelo(modelo);
	}
	
	private void guardarDatosVenta(double impPagar){
		switch(getModelo()){
			case 0:
				Javaproject20223.contVenta0++;
				Javaproject20223.uniVendidas0 += Integer.parseInt(txtCantidad.getText());
				Javaproject20223.impAcumulado0 += impPagar;
				break;
			case 1:
				Javaproject20223.contVenta1++;
				Javaproject20223.uniVendidas1 += Integer.parseInt(txtCantidad.getText());
				Javaproject20223.impAcumulado1 += impPagar;
				break;
			case 2:
				Javaproject20223.contVenta2++;
				Javaproject20223.uniVendidas2 += Integer.parseInt(txtCantidad.getText());
				Javaproject20223.impAcumulado2 += impPagar;
				break;
			case 3:
				Javaproject20223.contVenta3++;
				Javaproject20223.uniVendidas3 += Integer.parseInt(txtCantidad.getText());
				Javaproject20223.impAcumulado3 += impPagar;
				break;
			case 4:
				Javaproject20223.contVenta4++;
				Javaproject20223.uniVendidas4 += Integer.parseInt(txtCantidad.getText());
				Javaproject20223.impAcumulado4 += impPagar;
				break;
			default:
				break;
		}
	}
	
	private void incrementador(double impPagar) {
		Javaproject20223.ventasTotales++;
		Javaproject20223.impTotalAcumulado += impPagar;
		Javaproject20223.porcCuotaTotal += (impPagar/Javaproject20223.cuotaDiaria)*100;
	}
	
	//Desarrollo de Métodos
	private void mostrarDatosPrimerModelo() {
		txtPrecio.setText(Javaproject20223.precio0+"");
	}
	
	private int getModelo() {
		return cboModelo.getSelectedIndex();
	}
	
	private int getCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}
	
	private double getPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
		
	private double calcImpCompra(int cantidad, double precio) {
		return cantidad * precio;	
	}
	
	private double	calcImpDescuento(int cantidad, double impCompra) {
		if (cantidad <= 5)
			return (Javaproject20223.porcentaje1 /100)*impCompra;
		else if (cantidad <= 10)
			return (Javaproject20223.porcentaje2 /100)*impCompra;
		else if (cantidad <= 15 )
			return (Javaproject20223.porcentaje3 /100)*impCompra;
		else
			return (Javaproject20223.porcentaje4 /100)*impCompra;
	}
	
	private double	calcImpPagar(double impCompra, double impDescuento) {
		return impCompra-impDescuento;
	}
	
	private String calcObsequio(int cantidad) {
		if (cantidad == 1)
			return Javaproject20223.obsequio1;
		else if (cantidad <= 5)
			return Javaproject20223.obsequio2;
		else
			return Javaproject20223.obsequio3;
	}
	
	private void mostrarModelo(int modelo) {
		switch (modelo) {
		case 0:
			txtPrecio.setText(Javaproject20223.precio0+"");
			break;
		case 1:
			txtPrecio.setText(Javaproject20223.precio1+"");
			break;
		case 2:
			txtPrecio.setText(Javaproject20223.precio2+"");
			break;
		case 3:
			txtPrecio.setText(Javaproject20223.precio3+"");
			break;	
		default:
			txtPrecio.setText(Javaproject20223.precio4+"");
			break;
		}	
	}
	
	private void mostrarMensaje() {
		JOptionPane.showMessageDialog(
				this,"Venta Nro."+Javaproject20223.ventasTotales
					+"\nImporte total general acumulado: S/."+df.format(Javaproject20223.impTotalAcumulado)+" "
					+"\nPorcentaje de la cuota diaria: "+df.format(Javaproject20223.porcCuotaTotal)+"%",
					"Avance de Ventas", 1);
	}
	
	private void mostrarResultados(double precio, int cant, double x, double y, double z, String obs) {
		
		//Mostrando el resultado de la venta en el txtArea
		txtS.setText("BOLETA DE VENTA\n\n");
		txtS.append("Modelo\t\t:"		 		+cboModelo.getSelectedItem()+"\n");
		txtS.append("Precio\t\t:"				+"S/. "+df.format(precio)+"\n");
		txtS.append("Cantidad\t\t:"				+cant+"\n\n");
		
		txtS.append("Importe de Compra\t:"		+"S/. "+df.format(x)+"\n");
		txtS.append("Importe de Descuento\t:"	+"S/. "+df.format(y)+"\n");
		txtS.append("Importe a Pagar\t:"		+"S/. "+df.format(z)+"\n\n");
		
		txtS.append("Obsequio\t\t: "			+obs);
		}
	
}
