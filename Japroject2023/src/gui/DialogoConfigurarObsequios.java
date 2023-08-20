package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoConfigurarObsequios extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoConfigurarObsequios dialog = new DialogoConfigurarObsequios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoConfigurarObsequios() {
		setModal(true);
		setResizable(false);
		setTitle("Configurar Obsequios");
		setBounds(100, 100, 450, 119);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lbl1 = new JLabel("1 unidad");
			lbl1.setBounds(10, 11, 66, 14);
			contentPanel.add(lbl1);
		}
		{
			JLabel lbl2 = new JLabel("2 a 5 unidades");
			lbl2.setBounds(10, 36, 82, 14);
			contentPanel.add(lbl2);
		}
		{
			JLabel lbl3 = new JLabel("6 a m\u00E1s unidades");
			lbl3.setBounds(10, 61, 100, 14);
			contentPanel.add(lbl3);
		}
		{
			txt1 = new JTextField();
			txt1.setBounds(117, 8, 86, 20);
			contentPanel.add(txt1);
			txt1.setColumns(10);
		}
		{
			txt2 = new JTextField();
			txt2.setColumns(10);
			txt2.setBounds(117, 33, 86, 20);
			contentPanel.add(txt2);
		}
		{
			txt3 = new JTextField();
			txt3.setColumns(10);
			txt3.setBounds(117, 58, 86, 20);
			contentPanel.add(txt3);
		}
		{
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(345, 7, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(345, 32, 89, 23);
			contentPanel.add(btnCancelar);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
