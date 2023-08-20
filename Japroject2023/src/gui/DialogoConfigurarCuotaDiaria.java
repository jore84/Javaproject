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

public class DialogoConfigurarCuotaDiaria extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCuota;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConfigurarCuotaDiaria dialog = new DialogoConfigurarCuotaDiaria();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConfigurarCuotaDiaria() {
		setTitle("Configurar cuota diaria");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 127);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCuota = new JLabel("Cuota diaria esperada (S/.)");
		lblCuota.setBounds(10, 11, 159, 14);
		contentPanel.add(lblCuota);
		
		txtCuota = new JTextField();
		txtCuota.setBounds(164, 8, 86, 20);
		contentPanel.add(txtCuota);
		txtCuota.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(345, 7, 89, 23);
		contentPanel.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(345, 32, 89, 23);
		contentPanel.add(btnCancelar);
		
		mostrarCuotaDiaria();
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
		Double cuotaDiaria;
		
		try {
			cuotaDiaria = Double.parseDouble(txtCuota.getText());
		
			if (cuotaDiaria <= 0) {
				JOptionPane.showMessageDialog(this, "Ingrese valores mayores a 0", "ERROR!", 0);
				mostrarCuotaDiaria();
				return;
			}
		}catch(NumberFormatException f){
			JOptionPane.showMessageDialog(this, "Ingrese Valores Numericos", "ERROR!", 0);
			mostrarCuotaDiaria();
			return;	
		}
	
		remplazarCuotaDiaria();
	}
	
	private void mostrarCuotaDiaria() {
		txtCuota.setText(""+Javaproject20223.cuotaDiaria);
	}
	
	private void remplazarCuotaDiaria() {
		Javaproject20223.cuotaDiaria = Double.parseDouble(txtCuota.getText());
	
		//Mostrando aviso de cambio realizado
		JOptionPane.showMessageDialog(this, "Cambio Realizado con Éxito", "Aviso", 1);
		dispose();
	}
}
