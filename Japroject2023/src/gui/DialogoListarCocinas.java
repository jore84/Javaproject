package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoListarCocinas extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JButton btnCerrar;
	private JButton btnListar;
	private JTextArea txtS;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		try {
			DialogoListarCocinas dialog = new DialogoListarCocinas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoListarCocinas() {
		setTitle("Listado de cocinas");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 502, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(424, 11, -412, 239);
		contentPanel.add(scrollPane);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(150, 288, 89, 23);
		contentPanel.add(btnCerrar);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(258, 288, 89, 23);
		contentPanel.add(btnListar);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 476, 266);
		contentPanel.add(scrollPane_1);

		txtS = new JTextArea();
		scrollPane_1.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
		if (arg0.getSource() == btnCerrar) {

			cerrar();
		}
	}

	void cerrar() {
		this.dispose();
	}

	protected void actionPerformedBtnListar(ActionEvent arg0) {
		txtS.setText("LISTADO DE COCINAS\n\n");
		txtS.append("Modelo\t\t:" + Tienda1.modelo0 + "\n");
		txtS.append("Precio\t\t:S/" + Tienda1.precio0 + "\n");
		txtS.append("Profundidad\t:" + Tienda1.fondo0 + "\n");
		txtS.append("Ancho\t\t:" + Tienda1.ancho0 + "\n");
		txtS.append("Altura\t\t:" + Tienda1.alto0 + "\n");
		txtS.append("Quemadores\t:" + Tienda1.quemadores0 + "\n\n");

		txtS.append("Modelo\t\t:" + Tienda1.modelo1 + "\n");
		txtS.append("Precio\t\t:/S" + Tienda1.precio1 + "\n");
		txtS.append("Profundidad\t:" + Tienda1.fondo1 + "\n");
		txtS.append("Ancho\t\t:" + Tienda1.ancho1 + "\n");
		txtS.append("Altura\t\t:" + Tienda1.alto1 + "\n");
		txtS.append("Quemadores\t:" + Tienda1.quemadores1 + "\n\n");

		txtS.append("Modelo\t\t:" + Tienda1.modelo2 + "\n");
		txtS.append("Precio\t\t:/S" + Tienda1.precio2 + "\n");
		txtS.append("Profundidad\t:" + Tienda1.fondo2 + "\n");
		txtS.append("Ancho\t\t:" + Tienda1.ancho2 + "\n");
		txtS.append("Altura\t\t:" + Tienda1.alto2 + "\n");
		txtS.append("Quemadores\t:" + Tienda1.quemadores2 + "\n\n");

		txtS.append("Modelo\t\t:" + Tienda1.modelo3 + "\n");
		txtS.append("Precio\t\t:/S" + Tienda1.precio3 + "\n");
		txtS.append("Profundidad\t:" + Tienda1.fondo3 + "\n");
		txtS.append("Ancho\t\t:" + Tienda1.ancho3 + "\n");
		txtS.append("Altura\t\t:" + Tienda1.alto3 + "\n");
		txtS.append("Quemadores\t:" + Tienda1.quemadores3 + "\n\n");

		txtS.append("Modelo\t\t:" + Tienda1.modelo4 + "\n");
		txtS.append("Precio\t\t:S/" + Tienda1.precio4 + "\n");
		txtS.append("Profundidad\t:" + Tienda1.fondo4 + "\n");
		txtS.append("Ancho\t\t:" + Tienda1.ancho4 + "\n");
		txtS.append("Altura\t\t:" + Tienda1.alto4 + "\n");
		txtS.append("Quemadores\t:" + Tienda1.quemadores4 + "\n");
	}

}
