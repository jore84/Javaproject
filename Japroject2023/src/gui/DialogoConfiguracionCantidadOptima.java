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

public class DialogoConfiguracionCantidadOptima extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantidad;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConfiguracionCantidadOptima dialog = new DialogoConfiguracionCantidadOptima();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConfiguracionCantidadOptima() {
		setTitle("Configurar Cantidad \u00F3ptima");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 154);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCantidad = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
		lblCantidad.setBounds(10, 11, 218, 14);
		contentPanel.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(242, 8, 48, 20);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(345, 7, 89, 23);
		contentPanel.add(btnAceptar);
			
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(345, 32, 89, 23);
		contentPanel.add(btnCancelar);
		
		mostrarCantidadOptima();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		dispose();
	}
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		Double cantOpt;
		
		try {
			cantOpt = Double.parseDouble(txtCantidad.getText());
			
			if (cantOpt <= 0) {
				JOptionPane.showMessageDialog(this, "Ingrese valores mayores a 0", "ERROR!", 0);
				mostrarCantidadOptima();
				return;
			}
		}catch(NumberFormatException f){
			JOptionPane.showMessageDialog(this, "Ingrese Valores Numericos", "ERROR!", 0);
			mostrarCantidadOptima();
			return;	
		}
		
		remplazarCantidadOptima();
	}
	
	private void mostrarCantidadOptima() {
		txtCantidad.setText(""+Javaproject20223.cantidadOptima);
	}
	
	private void remplazarCantidadOptima() {
		Javaproject20223.cantidadOptima = Integer.parseInt(txtCantidad.getText());
		
		//Mostrando aviso de cambio realizado
		JOptionPane.showMessageDialog(this, "Cambio Realizado con �xito", "Aviso", 1);
		dispose();
	}
}
