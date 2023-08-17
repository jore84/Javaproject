package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class DialogoVender extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoVender dialog = new DialogoVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoVender() {
		setModal(true);
		setResizable(false);
		setTitle("Vender");
		setBounds(100, 100, 450, 327);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setBounds(10, 11, 46, 14);
			contentPanel.add(lblModelo);
		}
		{
			JLabel lblPrecio = new JLabel("Precio(S/)");
			lblPrecio.setBounds(10, 36, 67, 14);
			contentPanel.add(lblPrecio);
		}
		{
			JLabel lblCantidad = new JLabel("Cantidad");
			lblCantidad.setBounds(10, 66, 46, 14);
			contentPanel.add(lblCantidad);
		}
		{
			JComboBox<Object> comboBox = new JComboBox<Object>();
			comboBox.setBounds(87, 8, 122, 20);
			contentPanel.add(comboBox);
		}
		{
			txtPrecio = new JTextField();
			txtPrecio.setBounds(87, 33, 122, 20);
			contentPanel.add(txtPrecio);
			txtPrecio.setColumns(10);
		}
		{
			txtCantidad = new JTextField();
			txtCantidad.setColumns(10);
			txtCantidad.setBounds(87, 63, 122, 20);
			contentPanel.add(txtCantidad);
		}
		{
			JButton btnVender = new JButton("Vender");
			btnVender.setBounds(345, 7, 89, 23);
			contentPanel.add(btnVender);
		}
		{
			JButton btnCerrar = new JButton("Cerrar");
			btnCerrar.setBounds(345, 32, 89, 23);
			contentPanel.add(btnCerrar);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 91, 424, 196);
			contentPanel.add(scrollPane);
			{
				JTextArea txtS = new JTextArea();
				scrollPane.setViewportView(txtS);
			}
		}
	}

}
