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
public class DialogConfDescuento extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblPorcentaje1;
	private JLabel lblPorcentaje2;
	private JLabel lblPorcentaje3;
	private JLabel lblPorcentaje4;
	private JTextField txtPorcentaje1;
	private JTextField txtPorcentaje2;
	private JTextField txtPorcentaje3;
	private JTextField txtPorcentaje4;
	private JLabel lblSimbol1;
	private JLabel lblSimbol2;
	private JLabel lblSimbol3;
	private JLabel lblSimbol4;
	private JButton btnAceptar;
	private JButton btnCancelar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogConfDescuento frame = new DialogConfDescuento();
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
	public DialogConfDescuento() {
		setTitle("Configurar porcentaje de descuento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPorcentaje1 = new JLabel("1 a 5 unidades");
		lblPorcentaje1.setBounds(30, 30, 150, 20);
		contentPane.add(lblPorcentaje1);
		
		lblPorcentaje2 = new JLabel("6 a 10 unidades");
		lblPorcentaje2.setBounds(30, 60, 150, 20);
		contentPane.add(lblPorcentaje2);
		
		lblPorcentaje3 = new JLabel("11 a 15 unidades");
		lblPorcentaje3.setBounds(30, 90, 150, 20);
		contentPane.add(lblPorcentaje3);
		
		lblPorcentaje4 = new JLabel("Mas de 15 unidades");
		lblPorcentaje4.setBounds(30, 120, 150, 20);
		contentPane.add(lblPorcentaje4);
			
		txtPorcentaje1 = new JTextField();
		txtPorcentaje1.setBounds(180, 30, 80, 20);
		txtPorcentaje1.setColumns(10);
		contentPane.add(txtPorcentaje1);
		
		txtPorcentaje2 = new JTextField();
		txtPorcentaje2.setBounds(180, 60, 80, 20);
		txtPorcentaje2.setColumns(10);
		contentPane.add(txtPorcentaje2);
		
		txtPorcentaje3 = new JTextField();
		txtPorcentaje3.setBounds(180, 90, 80, 20);
		txtPorcentaje3.setColumns(10);
		contentPane.add(txtPorcentaje3);
		
		txtPorcentaje4 = new JTextField();
		txtPorcentaje4.setBounds(180, 120, 80, 20);
		txtPorcentaje4.setColumns(10);
		contentPane.add(txtPorcentaje4);
			
		lblSimbol1 = new JLabel("%");
		lblSimbol1.setBounds(270, 30, 20, 20);
		contentPane.add(lblSimbol1);
		
		lblSimbol2 = new JLabel("%");
		lblSimbol2.setBounds(270, 60, 20, 20);
		contentPane.add(lblSimbol2);
		
		lblSimbol3 = new JLabel("%");
		lblSimbol3.setBounds(270, 90, 20, 20);
		contentPane.add(lblSimbol3);
		
		lblSimbol4 = new JLabel("%");
		lblSimbol4.setBounds(270, 120, 20, 20);
		contentPane.add(lblSimbol4);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(305, 40, 120, 25);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(305, 80, 120, 25);
		contentPane.add(btnCancelar);
		
		mostrarPorcenajes();
	}
	
	

	//Eventos
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}
	protected void actionPerformedBtnAceptar(ActionEvent e) {
		double porc1, porc2, porc3, porc4;
		
		try {
			porc1 = Double.parseDouble(txtPorcentaje1.getText());
			porc2 = Double.parseDouble(txtPorcentaje1.getText());
			porc3 = Double.parseDouble(txtPorcentaje1.getText());
			porc4 = Double.parseDouble(txtPorcentaje1.getText());
			
			if (porc1 < 0) {
				JOptionPane.showMessageDialog(this, "Ingrese valores de porcentaje desde 0", "ERROR!", 0);
				txtPorcentaje1.setText(""+porc1);
				return;
			}else if (porc2 < 0) {
				JOptionPane.showMessageDialog(this, "Ingrese valores de porcentaje desde 0", "ERROR!", 0);
				txtPorcentaje1.setText(""+porc2);
				return;
			}else if (porc3 < 0) {
				JOptionPane.showMessageDialog(this, "Ingrese valores de porcentaje desde 0", "ERROR!", 0);
				txtPorcentaje1.setText(""+porc3);
				return;
			}else if (porc4 < 0) {
				JOptionPane.showMessageDialog(this, "Ingrese valores de porcentaje desde 0", "ERROR!", 0);
				txtPorcentaje1.setText(""+porc4);
				return;
			}
		}catch(NumberFormatException f){
			JOptionPane.showMessageDialog(this, "Ingrese Valores Numericos", "ERROR!", 0);
			return;	
		}
		remplazarPorcentajes();
	}


	protected void actionPerformedBtnCancelar(ActionEvent e) {
		//Cerrar una ventana secundaria
        dispose();
	}
	
	private void mostrarPorcenajes() {
		txtPorcentaje1.setText(""+FrmPrincipal.porcentaje1);
		txtPorcentaje2.setText(""+FrmPrincipal.porcentaje2);
		txtPorcentaje3.setText(""+FrmPrincipal.porcentaje3);
		txtPorcentaje4.setText(""+FrmPrincipal.porcentaje4);
	}
	
	private void remplazarPorcentajes() {
		FrmPrincipal.porcentaje1 = Double.parseDouble(txtPorcentaje1.getText());
		FrmPrincipal.porcentaje2 = Double.parseDouble(txtPorcentaje2.getText());
		FrmPrincipal.porcentaje3 = Double.parseDouble(txtPorcentaje3.getText());
		FrmPrincipal.porcentaje4 = Double.parseDouble(txtPorcentaje4.getText());
		
		//Mostrando aviso de cambio realizado
		JOptionPane.showMessageDialog(this, "Cambio Realizado con Éxito", "Aviso", 1);
		dispose();
	}
}


