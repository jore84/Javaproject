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
		txtS.setEditable(false);
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
		mostrarDatos(Tienda1.modelo0, Tienda1.precio0, Tienda1.ancho0, Tienda1.alto0,Tienda1.fondo0, Tienda1.quemadores0);
		mostrarDatos(Tienda1.modelo1, Tienda1.precio1, Tienda1.ancho1, Tienda1.alto1,Tienda1.fondo1, Tienda1.quemadores1);
		mostrarDatos(Tienda1.modelo2, Tienda1.precio2, Tienda1.ancho2, Tienda1.alto2,Tienda1.fondo2, Tienda1.quemadores2);
		mostrarDatos(Tienda1.modelo3, Tienda1.precio3, Tienda1.ancho3, Tienda1.alto3,Tienda1.fondo3, Tienda1.quemadores3);
		mostrarDatos(Tienda1.modelo4, Tienda1.precio4, Tienda1.ancho4, Tienda1.alto4,Tienda1.fondo4, Tienda1.quemadores4);
	}
	private void imprimir(String cadena){
		txtS.append("n"+ cadena);
		
	}
		
	
	 private void mostrarDatos(String modelo ,double precio, double ancho, double alto, double fondo, int quemadores) {
		imprimir("\n Modelo\t\t:" + modelo);
		imprimir("Precio\t\t:" + modelo);
		imprimir("Profundidad\t\t:" + modelo);
		imprimir("Ancho\t\t:" + modelo);
		imprimir("Quemadores\t\t:" + modelo);
		
	}
}
