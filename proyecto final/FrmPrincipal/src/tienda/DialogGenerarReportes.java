package tienda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DialogGenerarReportes extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox<String> cboReportes;
	private JButton btnCerrar;
	private JTextArea txtArea;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogGenerarReportes frame = new DialogGenerarReportes();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	int modelo;
	
	//variables que guardan los valores de las variables
	String 	modelo0 = FrmPrincipal.modelo0, 
			modelo1 = FrmPrincipal.modelo1, 
			modelo2 = FrmPrincipal.modelo2, 
			modelo3 = FrmPrincipal.modelo3, 
			modelo4 = FrmPrincipal.modelo4;
	
	int 	cantVentas0 = FrmPrincipal.contadorVenta0, 
			cantVentas1 = FrmPrincipal.contadorVenta1,
			cantVentas2 = FrmPrincipal.contadorVenta2, 
			cantVentas3 = FrmPrincipal.contadorVenta3,
			cantVentas4 = FrmPrincipal.contadorVenta4;
	
	int 	unidVendidas0 = FrmPrincipal.cantUniVendidas0, 
			unidVendidas1 = FrmPrincipal.cantUniVendidas1, 
			unidVendidas2 = FrmPrincipal.cantUniVendidas2, 
			unidVendidas3 = FrmPrincipal.cantUniVendidas3, 
			unidVendidas4 = FrmPrincipal.cantUniVendidas4;
	
	double 	impAcum0 = FrmPrincipal.importeAcumulado0, 
			impAcum1 = FrmPrincipal.importeAcumulado1, 
			impAcum2 = FrmPrincipal.importeAcumulado2, 
			impAcum3 = FrmPrincipal.importeAcumulado3, 
			impAcum4 = FrmPrincipal.importeAcumulado4;
	
	double 	porCuota0 = FrmPrincipal.porcentajeCuota0, 
			porCuota1 = FrmPrincipal.porcentajeCuota1, 
			porCuota2 = FrmPrincipal.porcentajeCuota2, 
			porCuota3 = FrmPrincipal.porcentajeCuota3, 
			porCuota4 = FrmPrincipal.porcentajeCuota4;
	
	int 	cantOptima = FrmPrincipal.cantidadOptima;
	
	double 	precio0 = FrmPrincipal.precio0,
			precio1 = FrmPrincipal.precio1, 
			precio2 = FrmPrincipal.precio2, 
			precio3 = FrmPrincipal.precio3, 
			precio4 = FrmPrincipal.precio4;
	
	double 	ancho0 = FrmPrincipal.ancho0, 
			ancho1 = FrmPrincipal.ancho1, 
			ancho2 = FrmPrincipal.ancho2, 
			ancho3 = FrmPrincipal.ancho3, 
			ancho4 = FrmPrincipal.ancho4;
	
	//Calculando variables globales precioPromedio y anchoPromedio
	double precioPromedio = (precio0 + precio1 + precio2 + precio3 + precio4)/5;
	double anchoPromedio = (ancho0 + ancho1 + ancho2 + ancho3 + ancho4)/5;
	
	//Creando formato1 tipo DecimalFormat
	DecimalFormat formato1 = new DecimalFormat("0.00");
	private JComboBox<String> cboTipoReporte;
	
	/**
	 * Create the frame.
	 */
	public DialogGenerarReportes() {
		setTitle("Generar Reportes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Tipo de reporte");
		lblNewLabel.setBounds(10, 11, 107, 14);
		contentPane.add(lblNewLabel);
		
		cboReportes = new JComboBox<String>();
		cboReportes.setBounds(106, 7, 471, 22);
		cboReportes.setModel(new DefaultComboBoxModel<String>(new String[] {"Venta por modelo", "Venta en relaci\u00F3n a la venta \u00F3ptima", "Precios en relaci\u00F3n al precio promedio", "Promedios, menores y mayores"}));
		contentPane.add(cboReportes);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(646, 7, 89, 23);
		contentPane.add(btnCerrar);
		
		txtArea = new JTextArea();
		txtArea.setBounds(10, 40, 736, 332);
		contentPane.add(txtArea);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(744, 40, -20, 210);
		contentPane.add(scrollPane);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(734, 41, 12, 331);
		contentPane.add(scrollPane_1);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 40, 736, 332);
		contentPane.add(scrollPane_2);
		
	}
	
	
	private void itemStateChangedCboTipoReporte(ItemEvent e) {
		Object cboTipoReporte = null;
		if (e.getSource() == cboTipoReporte) {
		itemStateChangedCboTipoReporte(e);
	}
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		//Cerrar una ventana secundaria
        dispose();
	}
	
	private void reportePorModelo() {
		reportePorModelo();
		
	}
	
		
	//Metodo para el tipo de reporte
	private void obtenerTipoReporte() {
		
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
				
	txtArea.setCaretPosition(0);
	}
		//imprimir titulo del reporte generado
			txtArea.setText("VENTAS POR MODELO \n\n");
		
		//imprimiendo listado del reporte por modelo
		
			txtArea.append("Modelo : " + modelo0 + "\n");
			txtArea.append("Cantidad de Ventas : " + cantVentas0 + "\n");
			txtArea.append("Cantidad de Unidades Vendidas : " + unidVendidas0 + "\n");
			txtArea.append("Importe total vendido : S/." + formato1.format(impAcum0) + "\n");
			txtArea.append("Aporte a la cuota diaria : " + formato1.format(porCuota0) + "%" + "\n\n");
			
			txtArea.append("Modelo : " + modelo1 + "\n");
			txtArea.append("Cantidad de Ventas : " + cantVentas1 + "\n");
			txtArea.append("Cantidad de Unidades Vendidas : " + unidVendidas1 + "\n");
			txtArea.append("Importe total vendido : S/." + formato1.format(impAcum1) + "\n");
			txtArea.append("Aporte a la cuota diaria : " + formato1.format(porCuota1) + "%" + "\n\n");
			
			txtArea.append("Modelo : " + modelo2 + "\n");
			txtArea.append("Cantidad de Ventas : " + cantVentas2 + "\n");
			txtArea.append("Cantidad de Unidades Vendidas : " + unidVendidas2 + "\n");
			txtArea.append("Importe total vendido : S/." + formato1.format(impAcum2) + "\n");
			txtArea.append("Aporte a la cuota diaria : " + formato1.format(porCuota2) + "%" + "\n\n");
			
			txtArea.append("Modelo : " + modelo3 + "\n");
			txtArea.append("Cantidad de Ventas : " + cantVentas3 + "\n");
			txtArea.append("Cantidad de Unidades Vendidas : " + unidVendidas3 + "\n");
			txtArea.append("Importe total vendido : S/." + formato1.format(impAcum3) + "\n");
			txtArea.append("Aporte a la cuota diaria : " + formato1.format(porCuota3) + "%" + "\n\n");
			
			txtArea.append("Modelo : " + modelo4 + "\n");
			txtArea.append("Cantidad de Ventas : " + cantVentas4 + "\n");
			txtArea.append("Cantidad de Unidades Vendidas : " + unidVendidas4 + "\n");
			txtArea.append("Importe total vendido : S/." + formato1.format(impAcum4) + "\n");
			txtArea.append("Aporte a la cuota diaria : " + formato1.format(porCuota4) + "%" + "\n\n");
		
			//colocando el cursor en la posicion 0 para que muestre la primera linea del reporte
			
			txtArea.setCaretPosition(0);
		}
	
		//Reporte de la venta optima
			void reporteVentaOptima() {
				
		//imprimir titulo del reporte generado
			txtArea.setText("VENTAS EN RELACI�N A LA VENTA �PTIMA" + "\n\n");
		
		//Imprimiendo el listado por modelo 
			//Modelo0
			txtArea.append("Modelo : " + modelo0 + "\n");
			
			if (unidVendidas0 < cantOptima)
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas0 + "(" + (cantOptima - unidVendidas0) + " menos que la cantidad �ptima)" + "\n\n");
			
			else if(unidVendidas0 > cantOptima)
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas0 + "(" + (unidVendidas0 - cantOptima) + " m�s que la cantidad �ptima)" + "\n\n");
			
			else
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas0 + "(igual a la cantidad �ptima)" + "\n\n");
						
			//Modelo1
			txtArea.append("Modelo : " + modelo1 + "\n");
			
			if (unidVendidas1 < cantOptima)
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas1 + "(" + (cantOptima - unidVendidas1) + " menos que la cantidad �ptima)" + "\n\n");
			
			else if(unidVendidas1 > cantOptima)
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas1 + "(" + (unidVendidas1 - cantOptima) + " m�s que la cantidad �ptima)" + "\n\n");
						
			else
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas1 + "(igual a la cantidad �ptima)" + "\n\n");
						
			//Modelo2
			txtArea.append("Modelo : " + modelo2 + "\n");
			
			if (unidVendidas2 < cantOptima)
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas2 + "(" + (cantOptima - unidVendidas2) + " menos que la cantidad �ptima)" + "\n\n");
			
			else if(unidVendidas2 > cantOptima)
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas2 + "(" + (unidVendidas2 - cantOptima) + " m�s que la cantidad �ptima)" + "\n\n");
			
			else
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas2 + "(igual a la cantidad �ptima)" + "\n\n");
			
			//Modelo3
			txtArea.append("Modelo : " + modelo3 + "\n");
			
			if (unidVendidas3 < cantOptima)
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas3 + "(" + (cantOptima - unidVendidas3) + " menos que la cantidad �ptima)" + "\n\n");
			
			else if(unidVendidas3 > cantOptima)
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas3 + "(" + (unidVendidas3 - cantOptima) + " m�s que la cantidad �ptima)" + "\n\n");
			
			else
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas3 + "(igual a la cantidad �ptima)" + "\n\n");
						
			//Modelo4
			txtArea.append("Modelo : " + modelo4 + "\n");
			
			if (unidVendidas4 < cantOptima)
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas4 + "(" + (cantOptima - unidVendidas4) + " menos que la cantidad �ptima)" + "\n\n");
			
			else if(unidVendidas4 > cantOptima)
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas4 + "(" + (unidVendidas4 - cantOptima) + " m�s que la cantidad �ptima)" + "\n\n");
			
			else
			txtArea.append("Cantidad de unidades vendidas : " + unidVendidas4 + "(igual a la cantidad �ptima)" + "\n\n");
	
	}

	
	//Reporte del precio promedio
	void reportePrecioPromedio() {
			
		//imprimir titulo del reporte generado
			txtArea.setText("PRECIO EN RELACI�N AL PRECIO PROMEDIO" + "\n\n");
			
		//Imprimiendo el listado por modelo
			
			//Modelo0
			txtArea.append("Modelo : " + modelo0 + "\n");
			
			if (precio0 < precioPromedio)
				txtArea.append("Precio : S/. " + precio0 + "(Menor al Promedio)\n\n");
			
			else if(precio0 > precioPromedio)
				txtArea.append("Precio : S/. " + precio0 + "(Mayor al Promedio)\n\n");
			
			else
				txtArea.append("Precio : S/. " + precio0 + "(Igual al Promedio)\n\n");
			
			//Modelo1
			txtArea.append("Modelo : " + modelo1 + "\n");
			
			if (precio1 < precioPromedio)
				txtArea.append("Precio : S/. " + precio1 + "(Menor al Promedio)\n\n");
			
			else if(precio1 > precioPromedio)
				txtArea.append("Precio : S/. " + precio1 + "(Mayor al Promedio)\n\n");
			else
				txtArea.append("Precio : S/. " + precio1 + "(Igual al Promedio)\n\n");
			
			//Modelo2
			txtArea.append("Modelo : " + modelo2 + "\n");
			
			if (precio2 < precioPromedio)
				txtArea.append("Precio : S/. " + precio2 + "(Menor al Promedio)\n\n");
			
			else if(precio2 > precioPromedio)
				txtArea.append("Precio : S/. " + precio2 + "(Mayor al Promedio)\n\n");
			
			else
				txtArea.append("Precio : S/. " + precio2 + "(Igual al Promedio)\n\n");
			
			//Modelo3
			txtArea.append("Modelo : " + modelo3 + "\n");
			
			if (precio3 < precioPromedio)
				txtArea.append("Precio : S/. " + precio3 + "(Menor al Promedio)\n\n");
			
			else if(precio3 > precioPromedio)
				txtArea.append("Precio : S/. " + precio3 + "(Mayor al Promedio)\n\n");
			
			else
				txtArea.append("Precio : S/. " + precio3 + "(Igual al Promedio)\n\n");
			
			//Modelo4
			txtArea.append("Modelo : " + modelo4 + "\n");
			
			if (precio4 < precioPromedio)
				txtArea.append("Precio : S/. " + precio4 + "(Menor al Promedio)\n\n");
			
			else if(precio4 > precioPromedio)
				txtArea.append("Precio : S/. " + precio4 + "(Mayor al Promedio)\n\n");
			else
				txtArea.append("Precio : S/. " + precio4 + "(Igual al Promedio)\n\n");
			}
			
	//Reporte promedio, menores y mayores
		void reportePromedioMenoresMayores() {
			
		//imprimir titulo del reporte generado
			txtArea.setText("PROMEDIOS, MENORES Y MAYORES" + "\n\n");
			txtArea.append("Precio Promedio : S/. " + formato1.format(precioPromedio) + "\n");
			
		//Imprimiendo el precio menor
			if (precio0 <= precio1 && precio0 <= precio2 && precio0 <= precio3 && precio0 <= precio4)
				txtArea.append("Precio menor : S/. " + precio0 + "\n");
			
			else if (precio1 <= precio0 && precio1 <= precio2 && precio1 <= precio3 && precio1 <= precio4)
				txtArea.append("Precio menor : S/. " + precio1 + "\n");
			
			else if (precio2 <= precio0 && precio2 <= precio1 && precio2 <= precio3 && precio2 <= precio4)
				txtArea.append("Precio menor : S/. " + precio2 + "\n");
			
			else if (precio3 <= precio0 && precio3 <= precio2 && precio3 <= precio1 && precio3 <= precio4)
				txtArea.append("Precio menor : S/. " + precio3 + "\n");
			
			else
				txtArea.append("Precio menor : S/. " + precio4 + "\n");
			
		//hallando e imprimiendo el precio mayor
			if (precio0 >= precio1 && precio0 >= precio2 && precio0 >= precio3 && precio0 >= precio4)
				txtArea.append("Precio mayor : S/. " + precio0 + "\n\n");
			
			else if (precio1 >= precio0 && precio1 >= precio2 && precio1 >= precio3 && precio1 >= precio4)
				txtArea.append("Precio mayor : S/. " + precio1 + "\n\n");
			
			else if (precio2 >= precio0 && precio2 >= precio1 && precio2 >= precio3 && precio2 >= precio4)
				txtArea.append("Precio mayor : S/. " + precio2 + "\n\n");
			
			else if (precio3 >= precio0 && precio3 >= precio2 && precio3 >= precio1 && precio3 >= precio4)
				txtArea.append("Precio mayor : S/. " + precio3 + "\n\n");
			
			else
				txtArea.append("Precio mayor : S/. " + precio4 + "\n\n");
			
		//Imprimiendo ancho promedio
			txtArea.append("Ancho promedio : " + anchoPromedio + " cm\n");
			
		//Imprimiendo el ancho menor
			if (ancho0 <= ancho1 && ancho0 <= ancho2 && ancho0 <= ancho3 && ancho0 <= ancho4)
				txtArea.append("Ancho menor : " + ancho0 + " cm\n");
			
			else if (ancho1 <= ancho0 && ancho1 <= ancho2 && ancho1 <= ancho3 && ancho1 <= ancho4)
				txtArea.append("Ancho menor : " + ancho1 + " cm\n");
			
			else if (ancho2 <= ancho0 && ancho2 <= ancho1 && ancho2 <= ancho3 && ancho2 <= ancho4)
				txtArea.append("Ancho menor : " + ancho2 + " cm\n");
			
			else if (ancho3 <= ancho0 && ancho3 <= ancho2 && ancho3 <= ancho1 && ancho3 <= ancho4)
				txtArea.append("Ancho menor : " + ancho3 + " cm\n");
			
			else
				txtArea.append("Ancho menor : " + ancho4 + " cm\n");
		
		//Imprimiendo el ancho mayor
			if (ancho0 >= ancho1 && ancho0 >= ancho2 && ancho0 >= ancho3 && ancho0 >= ancho4)
				txtArea.append("Ancho mayor : " + ancho0 + " cm");
			
			else if (ancho1 >= ancho0 && ancho1 >= ancho2 && ancho1 >= ancho3 && ancho1 >= ancho4)
				txtArea.append("Ancho mayor : " + ancho1 + " cm");
			
			else if (ancho2 >= ancho0 && ancho2 >= ancho1 && ancho2 >= ancho3 && ancho2 >= ancho4)
				txtArea.append("Ancho mayor : " + ancho2 + " cm");
			
			else if (ancho3 >= ancho0 && ancho3 >= ancho2 && ancho3 >= ancho1 && ancho3 >= ancho4)
				txtArea.append("Ancho mayor : " + ancho3 + " cm");
			
			else
				txtArea.append("Ancho mayor : " + ancho4 + " cm");
	}
}

	
		
	
