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
public class DialogConfCantidadOptima extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCantidadOptima;
	private JTextField txtCantidadOptima;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogConfCantidadOptima frame = new DialogConfCantidadOptima();
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
	public DialogConfCantidadOptima() {
		setTitle("Configurar cantidad Óptima");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCantidadOptima = new JLabel("Cantidad Óptima de unidades vendidas");
		lblCantidadOptima.setBounds(10, 40, 290, 20);
		contentPane.add(lblCantidadOptima);
		
		txtCantidadOptima = new JTextField();
		txtCantidadOptima.setBounds(300, 40, 50, 20);
		contentPane.add(txtCantidadOptima);
		txtCantidadOptima.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(360, 20, 120, 25);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(360, 50, 120, 25);
		contentPane.add(btnCancelar);
		
		mostrarCantidadOptima();
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
		Double cantOpt;
		
		try {
			cantOpt = Double.parseDouble(txtCantidadOptima.getText());
			
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

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		//Cerrar una ventana secundaria
        dispose();
	}
	private void mostrarCantidadOptima() {
		txtCantidadOptima.setText(""+FrmPrincipal.cantidadOptima);
	}
	private void remplazarCantidadOptima() {
		FrmPrincipal.cantidadOptima = Integer.parseInt(txtCantidadOptima.getText());
		
		//Mostrando aviso de cambio realizado
		JOptionPane.showMessageDialog(this, "Cambio Realizado con Éxito", "Aviso", 1);
		dispose();
	}

}
