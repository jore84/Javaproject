package tienda;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial", "unused" })
public class DialogVender extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblModelo;
	private JLabel lblPrecios;
	private JLabel lblCantidad;
	private JComboBox<Object> cboModelo;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JTextArea textArea;
	private JButton btnVender;
	private JButton btnCerrar;
	
	//Decimal Format
	DecimalFormat df = new DecimalFormat("0.00");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogVender frame = new DialogVender();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DialogVender() {
		setResizable(false);
		setTitle("Vender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(10, 10, 125, 20);
		contentPane.add(lblModelo);
		
		lblPrecios = new JLabel("Precio (S/)");
		lblPrecios.setBounds(10, 35, 125, 20);
		contentPane.add(lblPrecios);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 60, 125, 20);
		contentPane.add(lblCantidad);
		
		cboModelo = new JComboBox<Object>();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel<Object>(new String[] {
		"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		cboModelo.setBounds(130, 10, 200, 22);
		contentPane.add(cboModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(130, 35, 200, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(130, 60, 200, 20);
		contentPane.add(txtCantidad);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 95, 490, 210);
		contentPane.add(textArea);
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setBounds(375, 10, 125, 25);
		contentPane.add(btnVender);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(375, 50, 125, 25);
		contentPane.add(btnCerrar);
		
		//mostrar datos de la primer modelo
		mostrarDatosPrimerModelo();
	}

	//Eventos
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
	protected void actionPerformedCboModelo(ActionEvent e) {
		//Declaración de variables
		int modelo;
		//Entrada de Datos
		modelo = getModelo();
		//Mostar resultados
		mostrarModelo(modelo);
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
		if ((FrmPrincipal.ventasTotales % 5) == 0) {
			//JOptionPane.showMessageDialog(this, FrmPrincipal.ventasTotales, "VENTAS", 1);
			mostrarMensaje();
			
		}
		
	}	private void incrementador(double impPagar) {
		FrmPrincipal.ventasTotales++;
		FrmPrincipal.impTotalAcumulado += impPagar;
		FrmPrincipal.porcCuotaTotal += (impPagar/FrmPrincipal.cuotaDiaria)*100;
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		//Cerrar una ventana secundaria
        dispose();
	}
	
	//Desarrollo de Métodos
	private void mostrarDatosPrimerModelo() {
		txtPrecio.setText(FrmPrincipal.precio0+"");
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
			return (FrmPrincipal.porcentaje1 /100)*impCompra;
		else if (cantidad <= 10)
			return (FrmPrincipal.porcentaje2 /100)*impCompra;
		else if (cantidad <= 15 )
			return (FrmPrincipal.porcentaje3 /100)*impCompra;
		else
			return (FrmPrincipal.porcentaje4 /100)*impCompra;
	}
	
	private double	calcImpPagar(double impCompra, double impDescuento) {
		return impCompra-impDescuento;
	}
	
	private String calcObsequio(int cantidad) {
		if (cantidad == 1)
			return FrmPrincipal.obsequio1;
		else if (cantidad <= 5)
			return FrmPrincipal.obsequio2;
		else
			return FrmPrincipal.obsequio3;
	}
	
	private void mostrarModelo(int modelo) {
		switch (modelo) {
		case 0:
			txtPrecio.setText(FrmPrincipal.precio0+"");
			break;
		case 1:
			txtPrecio.setText(FrmPrincipal.precio1+"");
			break;
		case 2:
			txtPrecio.setText(FrmPrincipal.precio2+"");
			break;
		case 3:
			txtPrecio.setText(FrmPrincipal.precio3+"");
			break;	
		default:
			txtPrecio.setText(FrmPrincipal.precio4+"");
			break;
		}	
	}
	
	private void mostrarMensaje() {
		JOptionPane.showMessageDialog(
				this,"Venta Nro."+FrmPrincipal.ventasTotales
					+"\nImporte total general acumulado: S/."+df.format(FrmPrincipal.impTotalAcumulado)+" "
					+"\nPorcentaje de la cuota diaria: "+df.format(FrmPrincipal.porcCuotaTotal)+"%",
					"Avance de Ventas", 1);
	}
	
	private void mostrarResultados(double precio, int cant, double x, double y, double z, String obs) {
	
	//Mostrando el resultado de la venta en el txtArea
	textArea.setText("BOLETA DE VENTA\n\n");
	textArea.append("Modelo\t\t:"		 		+cboModelo.getSelectedItem()+"\n");
	textArea.append("Precio\t\t:"				+"S/. "+df.format(precio)+"\n");
	textArea.append("Cantidad\t\t:"				+cant+"\n\n");
	
	textArea.append("Importe de Compra\t:"		+"S/. "+df.format(x)+"\n");
	textArea.append("Importe de Descuento\t:"	+"S/. "+df.format(y)+"\n");
	textArea.append("Importe a Pagar\t:"		+"S/. "+df.format(z)+"\n\n");
	
	textArea.append("Obsequio\t\t: "			+obs);
	}

}