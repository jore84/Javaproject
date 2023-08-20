package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoPorcentajeDescuento extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoPorcentajeDescuento dialog = new DialogoPorcentajeDescuento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoPorcentajeDescuento() {
		setTitle("Configurar Porcentajes de descuento");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 465, 146);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lbl1 = new JLabel("1 a 5 unidades");
		lbl1.setBounds(10, 11, 89, 14);
		contentPanel.add(lbl1);
				
		JLabel lbl2 = new JLabel("6 a 10 unidades");
		lbl2.setBounds(10, 36, 103, 14);
		contentPanel.add(lbl2);
				
		JLabel lbl3 = new JLabel("11 a 15 unidades");
		lbl3.setBounds(10, 61, 114, 14);
		contentPanel.add(lbl3);
				
		JLabel lbl4 = new JLabel("M\u00E1s de 15 unidades");
		lbl4.setBounds(10, 86, 114, 14);
		contentPanel.add(lbl4);
				
		txt1 = new JTextField();
		txt1.setBounds(134, 8, 86, 20);
		contentPanel.add(txt1);
		txt1.setColumns(10);
				
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(134, 33, 86, 20);
		contentPanel.add(txt2);
				
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(134, 58, 86, 20);
		contentPanel.add(txt3);
				
		txt4 = new JTextField();
		txt4.setColumns(10);
		txt4.setBounds(134, 83, 86, 20);
		contentPanel.add(txt4);
				
		JLabel lblNewLabel_1 = new JLabel("%");
		lblNewLabel_1.setBounds(230, 11, 20, 14);
		contentPanel.add(lblNewLabel_1);
				
		JLabel label = new JLabel("%");
		label.setBounds(230, 36, 20, 14);
		contentPanel.add(label);
				
		JLabel label_3 = new JLabel("%");
		label_3.setBounds(230, 61, 20, 14);
		contentPanel.add(label_3);
				
		JLabel label_4 = new JLabel("%");
		label_4.setBounds(230, 86, 20, 14);
		contentPanel.add(label_4);
				
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(345, 7, 89, 23);
		contentPanel.add(btnAceptar);
				
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(345, 32, 89, 23);
		contentPanel.add(btnCancelar);
		
		mostrardatos(Javaproject20223.porcentaje1, Javaproject20223.porcentaje2, Javaproject20223.porcentaje3, Javaproject20223.porcentaje4);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try{
			
			String descuento1 = leerdescuento1();
			String descuento2 = leerdescuento2();
			String descuento3 = leerdescuento3();
			String descuento4 = leerdescuento4();
			if (descuento1.isEmpty()){
				mostrarmensaje("El monto de descuento es requerido");
				return;
			}
			if (descuento2.isEmpty()){
				mostrarmensaje("El monto de descuento es requerido");
				return;
			}
			if (descuento3.isEmpty()){
				mostrarmensaje("El monto de descuento es requerido");
				return;
			}
			if (descuento4.isEmpty()){
				mostrarmensaje("El monto de descuento es requerido");
				return;
			}
			Javaproject20223.porcentaje1 = Double.parseDouble(descuento1);
			Javaproject20223.porcentaje2 = Double.parseDouble(descuento2);
			Javaproject20223.porcentaje3 = Double.parseDouble(descuento3);
			Javaproject20223.porcentaje4 = Double.parseDouble(descuento4);
			mostrarmensaje("Datos Guardados");
			dispose();
			
		} catch (Exception e2) {
			mostrarmensaje("no es el descuento indicado");
		}
	}
	
	String leerdescuento1(){
		return txt1.getText();
	}
	
	String leerdescuento2(){
		return txt2.getText();
	}
	
	String leerdescuento3(){
		return txt3.getText();
	}
	
	String leerdescuento4(){
		return txt4.getText();
	}
	
	void mostrardatos(double porcentaje1, double porcentaje2, double porcentaje3, double porcentaje4){
		txt1.setText(porcentaje1 + "");
		txt2.setText(porcentaje2 + "");
		txt3.setText(porcentaje3 + "");
		txt4.setText(porcentaje4 + "");
	}
	
	void mostrarmensaje(String mensaje){
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
