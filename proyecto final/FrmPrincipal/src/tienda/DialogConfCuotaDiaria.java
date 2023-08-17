package tienda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DialogConfCuotaDiaria extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCuotaDiaria;
	private JTextField txtCuotaDiaria;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogConfCuotaDiaria frame = new DialogConfCuotaDiaria();
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
	public DialogConfCuotaDiaria() {
		setTitle("Configurar cuota diaria");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCuotaDiaria = new JLabel("Cuota diaria esperada (S/.)");
		lblCuotaDiaria.setBounds(10, 40, 200, 20);
		contentPane.add(lblCuotaDiaria);
		
		txtCuotaDiaria = new JTextField();
		txtCuotaDiaria.setBounds(210, 40, 140, 20);
		contentPane.add(txtCuotaDiaria);
		txtCuotaDiaria.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(360, 20, 120, 25);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(360, 50, 120, 25);
		contentPane.add(btnCancelar);
		
		mostrarCuotaDiaria();
	}
	
	//Eventos
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		Double cuotaDiaria;
	
		try {
			cuotaDiaria = Double.parseDouble(txtCuotaDiaria.getText());
		
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

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		//Cerrar una ventana secundaria
	    dispose();
	}
	private void mostrarCuotaDiaria() {
		txtCuotaDiaria.setText(""+FrmPrincipal.cuotaDiaria);
	}
	private void remplazarCuotaDiaria() {
		FrmPrincipal.cuotaDiaria = Double.parseDouble(txtCuotaDiaria.getText());
	
		//Mostrando aviso de cambio realizado
		JOptionPane.showMessageDialog(this, "Cambio Realizado con Éxito", "Aviso", 1);
		dispose();
	}
}
