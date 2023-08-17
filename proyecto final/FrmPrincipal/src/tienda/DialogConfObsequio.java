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
public class DialogConfObsequio extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblObsequio1;
	private JLabel lblObsequio2;
	private JLabel lblObsequio3;
	private JTextField txtObsequio1;
	private JTextField txtObsequio2;
	private JTextField txtObsequio3;
	private JButton btnAceptar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogConfObsequio frame = new DialogConfObsequio();
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
	public DialogConfObsequio() {
		setTitle("Configurar Obsequios");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblObsequio1 = new JLabel("1 Unidad");
		lblObsequio1.setBounds(30, 30, 150, 20);
		contentPane.add(lblObsequio1);
		
		lblObsequio2 = new JLabel("2 a 5 unidades");
		lblObsequio2.setBounds(30, 60, 150, 20);
		contentPane.add(lblObsequio2);
		
		lblObsequio3 = new JLabel("6 o más unidades");
		lblObsequio3.setBounds(30, 90, 150, 20);
		contentPane.add(lblObsequio3);
		
		txtObsequio1 = new JTextField();
		txtObsequio1.setBounds(165, 30, 120, 20);
		txtObsequio1.setColumns(10);
		contentPane.add(txtObsequio1);
		
		txtObsequio2 = new JTextField();
		txtObsequio2.setBounds(165, 60, 120, 20);
		txtObsequio2.setColumns(10);
		contentPane.add(txtObsequio2);
		
		txtObsequio3 = new JTextField();
		txtObsequio3.setBounds(165, 90, 120, 20);
		txtObsequio3.setColumns(10);
		contentPane.add(txtObsequio3);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(305, 40, 120, 25);
		contentPane.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(305, 80, 120, 25);
		contentPane.add(btnCancelar);
		
		mostrarObsequios();
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
		remplazarObsequios();	
	}
	
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		//Cerrar una ventana secundaria
        dispose();
	}
	private void mostrarObsequios() {
		txtObsequio1.setText(""+FrmPrincipal.obsequio1);
		txtObsequio2.setText(""+FrmPrincipal.obsequio2);
		txtObsequio3.setText(""+FrmPrincipal.obsequio3);
	}
	private void remplazarObsequios() {
		FrmPrincipal.obsequio1 = (txtObsequio1.getText());
		FrmPrincipal.obsequio2 = (txtObsequio2.getText());
		FrmPrincipal.obsequio3 = (txtObsequio3.getText());
		
		//Mostrando aviso de cambio realizado
		JOptionPane.showMessageDialog(this, "Cambio Realizado con Éxito", "Aviso", 1);
		dispose();
	}

	
	
}
