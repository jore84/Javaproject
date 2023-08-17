package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogoPorcentajeDescuento extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;

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
		{
			JLabel lbl1 = new JLabel("1 a 5 unidades");
			lbl1.setBounds(10, 11, 89, 14);
			contentPanel.add(lbl1);
		}
		{
			JLabel lbl2 = new JLabel("6 a 10 unidades");
			lbl2.setBounds(10, 36, 103, 14);
			contentPanel.add(lbl2);
		}
		{
			JLabel lbl3 = new JLabel("11 a 15 unidades");
			lbl3.setBounds(10, 61, 114, 14);
			contentPanel.add(lbl3);
		}
		{
			JLabel lbl4 = new JLabel("M\u00E1s de 15 unidades");
			lbl4.setBounds(10, 86, 114, 14);
			contentPanel.add(lbl4);
		}
		{
			txt1 = new JTextField();
			txt1.setBounds(134, 8, 86, 20);
			contentPanel.add(txt1);
			txt1.setColumns(10);
		}
		{
			txt2 = new JTextField();
			txt2.setColumns(10);
			txt2.setBounds(134, 33, 86, 20);
			contentPanel.add(txt2);
		}
		{
			txt3 = new JTextField();
			txt3.setColumns(10);
			txt3.setBounds(134, 58, 86, 20);
			contentPanel.add(txt3);
		}
		{
			txt4 = new JTextField();
			txt4.setColumns(10);
			txt4.setBounds(134, 83, 86, 20);
			contentPanel.add(txt4);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("%");
			lblNewLabel_1.setBounds(230, 11, 20, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel label = new JLabel("%");
			label.setBounds(230, 36, 20, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("%");
			label.setBounds(230, 61, 20, 14);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("%");
			label.setBounds(230, 86, 20, 14);
			contentPanel.add(label);
		}
		{
			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(345, 7, 89, 23);
			contentPanel.add(btnAceptar);
		}
		{
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(345, 32, 89, 23);
			contentPanel.add(btnCancelar);
		}
	}

}
