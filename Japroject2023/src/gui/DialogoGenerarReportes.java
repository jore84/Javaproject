package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class DialogoGenerarReportes extends JDialog implements ActionListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JTextArea txtS;
	private JComboBox<Object> cboTipoReporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoGenerarReportes dialog = new DialogoGenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	int modelo;
	
	//variables que guardan los valores de las variables
	String 	modelo0 = Javaproject20223.modelo0, 
			modelo1 = Javaproject20223.modelo1, 
			modelo2 = Javaproject20223.modelo2, 
			modelo3 = Javaproject20223.modelo3, 
			modelo4 = Javaproject20223.modelo4;
		
	int 	cantVentas0 = Javaproject20223.contVenta0, 
			cantVentas1 = Javaproject20223.contVenta1,
			cantVentas2 = Javaproject20223.contVenta2,
			cantVentas3 = Javaproject20223.contVenta3,
			cantVentas4 = Javaproject20223.contVenta4;
		
	int 	unidVendidas0 = Javaproject20223.uniVendidas0, 
			unidVendidas1 = Javaproject20223.uniVendidas1, 
			unidVendidas2 = Javaproject20223.uniVendidas2, 
			unidVendidas3 = Javaproject20223.uniVendidas3, 
			unidVendidas4 = Javaproject20223.uniVendidas4;
		
	double 	impAcum0 = Javaproject20223.impAcumulado0, 
			impAcum1 = Javaproject20223.impAcumulado1, 
			impAcum2 = Javaproject20223.impAcumulado2, 
			impAcum3 = Javaproject20223.impAcumulado3, 
			impAcum4 = Javaproject20223.impAcumulado4;
		
	double 	porCuota0 = Javaproject20223.porcCuota0, 
			porCuota1 = Javaproject20223.porcCuota1, 
			porCuota2 = Javaproject20223.porcCuota2, 
			porCuota3 = Javaproject20223.porcCuota3, 
			porCuota4 = Javaproject20223.porcCuota4;
		
	int 	cantOptima = Javaproject20223.cantidadOptima;
		
	double 	precio0 = Javaproject20223.precio0,
			precio1 = Javaproject20223.precio1, 
			precio2 = Javaproject20223.precio2, 
			precio3 = Javaproject20223.precio3, 
			precio4 = Javaproject20223.precio4;
		
	double 	ancho0 = Javaproject20223.ancho0, 
			ancho1 = Javaproject20223.ancho1, 
			ancho2 = Javaproject20223.ancho2, 
			ancho3 = Javaproject20223.ancho3, 
			ancho4 = Javaproject20223.ancho4;
		
		//Calculando variables globales precioPromedio y anchoPromedio
		double precioPromedio = (precio0 + precio1 + precio2 + precio3 + precio4)/5;
		double anchoPromedio = (ancho0 + ancho1 + ancho2 + ancho3 + ancho4)/5;
		
		//Creando formato1 tipo DecimalFormat
		DecimalFormat formato1 = new DecimalFormat("0.00");

	/**
	 * Create the dialog.
	 */
	public DialogoGenerarReportes() {
		setModal(true);
		setResizable(false);
		setTitle("Generar Reportes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblReporte = new JLabel("Tipo de reporte");
		lblReporte.setBounds(10, 24, 89, 14);
		contentPanel.add(lblReporte);
		
		cboTipoReporte = new JComboBox<Object>();
		cboTipoReporte.addItemListener(this);
		cboTipoReporte.addActionListener(this);
		cboTipoReporte.setModel(new DefaultComboBoxModel<Object>(new String[] {"Ventas por modelo", "Ventas en relaci\u00F3n a la venta \u00F3ptima", "Precios en relaci\u00F3n al precio promedio", "Promedios, menores y mayores"}));
		cboTipoReporte.setBounds(97, 21, 206, 20);
		contentPanel.add(cboTipoReporte);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(345, 20, 89, 23);
		contentPanel.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 424, 210);
		contentPanel.add(scrollPane);
			
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		reportePorModelo();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	private void itemStateChangedCboTipoReporte(ItemEvent e) {
		obtenerTipoReporte();
	}
	
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cboTipoReporte) {
			itemStateChangedCboTipoReporte(arg0);
		}
	}
	
	private void reportePorModelo() {
		//imprimir titulo del reporte generado
		txtS.setText("VENTAS POR MODELO \n\n");
				
		//imprimiendo listado del reporte por modelo
		txtS.append("Modelo : " + modelo0 + "\n");
		txtS.append("Cantidad de Ventas : " + cantVentas0 + "\n");
		txtS.append("Cantidad de Unidades Vendidas : " + unidVendidas0 + "\n");
		txtS.append("Importe total vendido : S/." + formato1.format(impAcum0) + "\n");
		txtS.append("Aporte a la cuota diaria : " + formato1.format(porCuota0) + "%" + "\n\n");
				
		txtS.append("Modelo : " + modelo1 + "\n");
		txtS.append("Cantidad de Ventas : " + cantVentas1 + "\n");
		txtS.append("Cantidad de Unidades Vendidas : " + unidVendidas1 + "\n");
		txtS.append("Importe total vendido : S/." + formato1.format(impAcum1) + "\n");
		txtS.append("Aporte a la cuota diaria : " + formato1.format(porCuota1) + "%" + "\n\n");
				
		txtS.append("Modelo : " + modelo2 + "\n");
		txtS.append("Cantidad de Ventas : " + cantVentas2 + "\n");
		txtS.append("Cantidad de Unidades Vendidas : " + unidVendidas2 + "\n");
		txtS.append("Importe total vendido : S/." + formato1.format(impAcum2) + "\n");
		txtS.append("Aporte a la cuota diaria : " + formato1.format(porCuota2) + "%" + "\n\n");
				
		txtS.append("Modelo : " + modelo3 + "\n");
		txtS.append("Cantidad de Ventas : " + cantVentas3 + "\n");
		txtS.append("Cantidad de Unidades Vendidas : " + unidVendidas3 + "\n");
		txtS.append("Importe total vendido : S/." + formato1.format(impAcum3) + "\n");
		txtS.append("Aporte a la cuota diaria : " + formato1.format(porCuota3) + "%" + "\n\n");
				
		txtS.append("Modelo : " + modelo4 + "\n");
		txtS.append("Cantidad de Ventas : " + cantVentas4 + "\n");
		txtS.append("Cantidad de Unidades Vendidas : " + unidVendidas4 + "\n");
		txtS.append("Importe total vendido : S/." + formato1.format(impAcum4) + "\n");
		txtS.append("Aporte a la cuota diaria : " + formato1.format(porCuota4) + "%" + "\n\n");
			
		//colocando el cursor en la posicion 0 para que muestre la primera linea del reporte
				
		txtS.setCaretPosition(0);
	}
	
	private int devolverTipoReporte(){
		return cboTipoReporte.getSelectedIndex();
	}
	
	//Metodo para el tipo de reporte
	private void obtenerTipoReporte() {
		
		modelo = devolverTipoReporte();
		
		//Obteniendo el reporte de acuerdo al item seleccionado
		switch	(modelo) {
			case 0: 
				reportePorModelo();
				break;
			case 1: 
				reporteVentaOptima();
				break;
					
			case 2: 
				reportePrecioPromedio();
				break;
			
			default:
				reportePromedioMenoresMayores();
				txtS.setCaretPosition(0);
		}
	}
	
	//Reporte de la venta optima
	void reporteVentaOptima() {
		//imprimir titulo del reporte generado
		txtS.setText("VENTAS EN RELACI�N A LA VENTA �PTIMA" + "\n\n");
		//Imprimiendo el listado por modelo 
		//Modelo0
		txtS.append("Modelo : " + modelo0 + "\n");
		
		if (unidVendidas0 < cantOptima)
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas0 + "(" + (cantOptima - unidVendidas0) + " menos que la cantidad �ptima)" + "\n\n");
		
		else if(unidVendidas0 > cantOptima)
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas0 + "(" + (unidVendidas0 - cantOptima) + " m�s que la cantidad �ptima)" + "\n\n");
		
		else
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas0 + "(igual a la cantidad �ptima)" + "\n\n");
					
		//Modelo1
		txtS.append("Modelo : " + modelo1 + "\n");
		
		if (unidVendidas1 < cantOptima)
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas1 + "(" + (cantOptima - unidVendidas1) + " menos que la cantidad �ptima)" + "\n\n");
		
		else if(unidVendidas1 > cantOptima)
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas1 + "(" + (unidVendidas1 - cantOptima) + " m�s que la cantidad �ptima)" + "\n\n");
					
		else
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas1 + "(igual a la cantidad �ptima)" + "\n\n");
					
		//Modelo2
		txtS.append("Modelo : " + modelo2 + "\n");
		
		if (unidVendidas2 < cantOptima)
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas2 + "(" + (cantOptima - unidVendidas2) + " menos que la cantidad �ptima)" + "\n\n");
		
		else if(unidVendidas2 > cantOptima)
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas2 + "(" + (unidVendidas2 - cantOptima) + " m�s que la cantidad �ptima)" + "\n\n");
		
		else
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas2 + "(igual a la cantidad �ptima)" + "\n\n");
		
		//Modelo3
		txtS.append("Modelo : " + modelo3 + "\n");
		
		if (unidVendidas3 < cantOptima)
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas3 + "(" + (cantOptima - unidVendidas3) + " menos que la cantidad �ptima)" + "\n\n");
		
		else if(unidVendidas3 > cantOptima)
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas3 + "(" + (unidVendidas3 - cantOptima) + " m�s que la cantidad �ptima)" + "\n\n");
		
		else
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas3 + "(igual a la cantidad �ptima)" + "\n\n");
					
		//Modelo4
		txtS.append("Modelo : " + modelo4 + "\n");
		
		if (unidVendidas4 < cantOptima)
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas4 + "(" + (cantOptima - unidVendidas4) + " menos que la cantidad �ptima)" + "\n\n");
		
		else if(unidVendidas4 > cantOptima)
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas4 + "(" + (unidVendidas4 - cantOptima) + " m�s que la cantidad �ptima)" + "\n\n");
		
		else
			txtS.append("Cantidad de unidades vendidas : " + unidVendidas4 + "(igual a la cantidad �ptima)" + "\n\n");
	}
	
	//Reporte del precio promedio
	void reportePrecioPromedio() {
		//imprimir titulo del reporte generado
		txtS.setText("PRECIO EN RELACI�N AL PRECIO PROMEDIO" + "\n\n");
		//Imprimiendo el listado por modelo
		
		//Modelo0
		txtS.append("Modelo : " + modelo0 + "\n");
		
		if (precio0 < precioPromedio)
			txtS.append("Precio : S/. " + precio0 + "(Menor al Promedio)\n\n");
		
		else if(precio0 > precioPromedio)
			txtS.append("Precio : S/. " + precio0 + "(Mayor al Promedio)\n\n");
		
		else
			txtS.append("Precio : S/. " + precio0 + "(Igual al Promedio)\n\n");
		
		//Modelo1
		txtS.append("Modelo : " + modelo1 + "\n");
		
		if (precio1 < precioPromedio)
			txtS.append("Precio : S/. " + precio1 + "(Menor al Promedio)\n\n");
		
		else if(precio1 > precioPromedio)
			txtS.append("Precio : S/. " + precio1 + "(Mayor al Promedio)\n\n");
		else
			txtS.append("Precio : S/. " + precio1 + "(Igual al Promedio)\n\n");
		
		//Modelo2
		txtS.append("Modelo : " + modelo2 + "\n");
		
		if (precio2 < precioPromedio)
			txtS.append("Precio : S/. " + precio2 + "(Menor al Promedio)\n\n");
		
		else if(precio2 > precioPromedio)
			txtS.append("Precio : S/. " + precio2 + "(Mayor al Promedio)\n\n");
		
		else
			txtS.append("Precio : S/. " + precio2 + "(Igual al Promedio)\n\n");
		
		//Modelo3
		txtS.append("Modelo : " + modelo3 + "\n");
		
		if (precio3 < precioPromedio)
			txtS.append("Precio : S/. " + precio3 + "(Menor al Promedio)\n\n");
		
		else if(precio3 > precioPromedio)
			txtS.append("Precio : S/. " + precio3 + "(Mayor al Promedio)\n\n");
		
		else
			txtS.append("Precio : S/. " + precio3 + "(Igual al Promedio)\n\n");
		
		//Modelo4
		txtS.append("Modelo : " + modelo4 + "\n");
		
		if (precio4 < precioPromedio)
			txtS.append("Precio : S/. " + precio4 + "(Menor al Promedio)\n\n");
		
		else if(precio4 > precioPromedio)
			txtS.append("Precio : S/. " + precio4 + "(Mayor al Promedio)\n\n");
		else
			txtS.append("Precio : S/. " + precio4 + "(Igual al Promedio)\n\n");
	}
	
	//Reporte promedio, menores y mayores
	void reportePromedioMenoresMayores() {
		//imprimir titulo del reporte generado
		txtS.setText("PROMEDIOS, MENORES Y MAYORES" + "\n\n");
		txtS.append("Precio Promedio : S/. " + formato1.format(precioPromedio) + "\n");
		
		//Imprimiendo el precio menor
		if (precio0 <= precio1 && precio0 <= precio2 && precio0 <= precio3 && precio0 <= precio4)
			txtS.append("Precio menor : S/. " + precio0 + "\n");
		
		else if (precio1 <= precio0 && precio1 <= precio2 && precio1 <= precio3 && precio1 <= precio4)
			txtS.append("Precio menor : S/. " + precio1 + "\n");
		
		else if (precio2 <= precio0 && precio2 <= precio1 && precio2 <= precio3 && precio2 <= precio4)
			txtS.append("Precio menor : S/. " + precio2 + "\n");
		
		else if (precio3 <= precio0 && precio3 <= precio2 && precio3 <= precio1 && precio3 <= precio4)
			txtS.append("Precio menor : S/. " + precio3 + "\n");
		
		else
			txtS.append("Precio menor : S/. " + precio4 + "\n");
		
		//hallando e imprimiendo el precio mayor
		if (precio0 >= precio1 && precio0 >= precio2 && precio0 >= precio3 && precio0 >= precio4)
			txtS.append("Precio mayor : S/. " + precio0 + "\n\n");
		
		else if (precio1 >= precio0 && precio1 >= precio2 && precio1 >= precio3 && precio1 >= precio4)
			txtS.append("Precio mayor : S/. " + precio1 + "\n\n");
		
		else if (precio2 >= precio0 && precio2 >= precio1 && precio2 >= precio3 && precio2 >= precio4)
			txtS.append("Precio mayor : S/. " + precio2 + "\n\n");
		
		else if (precio3 >= precio0 && precio3 >= precio2 && precio3 >= precio1 && precio3 >= precio4)
			txtS.append("Precio mayor : S/. " + precio3 + "\n\n");
		
		else
			txtS.append("Precio mayor : S/. " + precio4 + "\n\n");
		
		//Imprimiendo ancho promedio
		txtS.append("Ancho promedio : " + anchoPromedio + " cm\n");
		
		//Imprimiendo el ancho menor
		if (ancho0 <= ancho1 && ancho0 <= ancho2 && ancho0 <= ancho3 && ancho0 <= ancho4)
			txtS.append("Ancho menor : " + ancho0 + " cm\n");
		
		else if (ancho1 <= ancho0 && ancho1 <= ancho2 && ancho1 <= ancho3 && ancho1 <= ancho4)
			txtS.append("Ancho menor : " + ancho1 + " cm\n");
		
		else if (ancho2 <= ancho0 && ancho2 <= ancho1 && ancho2 <= ancho3 && ancho2 <= ancho4)
			txtS.append("Ancho menor : " + ancho2 + " cm\n");
		
		else if (ancho3 <= ancho0 && ancho3 <= ancho2 && ancho3 <= ancho1 && ancho3 <= ancho4)
			txtS.append("Ancho menor : " + ancho3 + " cm\n");
		
		else
			txtS.append("Ancho menor : " + ancho4 + " cm\n");
	
		//Imprimiendo el ancho mayor
		if (ancho0 >= ancho1 && ancho0 >= ancho2 && ancho0 >= ancho3 && ancho0 >= ancho4)
			txtS.append("Ancho mayor : " + ancho0 + " cm");
		
		else if (ancho1 >= ancho0 && ancho1 >= ancho2 && ancho1 >= ancho3 && ancho1 >= ancho4)
			txtS.append("Ancho mayor : " + ancho1 + " cm");
		
		else if (ancho2 >= ancho0 && ancho2 >= ancho1 && ancho2 >= ancho3 && ancho2 >= ancho4)
			txtS.append("Ancho mayor : " + ancho2 + " cm");
		
		else if (ancho3 >= ancho0 && ancho3 >= ancho2 && ancho3 >= ancho1 && ancho3 >= ancho4)
			txtS.append("Ancho mayor : " + ancho3 + " cm");
		
		else
			txtS.append("Ancho mayor : " + ancho4 + " cm");
	}
	
}
