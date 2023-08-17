package tienda;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class DialogListar extends JDialog implements ActionListener {
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnCerrar;
	private JButton btnListar;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogListar dialog = new DialogListar();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DialogListar() {
		setTitle("Listar");
		setResizable(false);
		setBounds(100, 100, 460, 313);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 424, 212);
		getContentPane().add(scrollPane);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scrollPane.setViewportView(txtS);

		panel = new JPanel();
		panel.setBounds(128, 238, 188, 23);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(0, 0, 89, 23);
		panel.add(btnListar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(99, 0, 89, 23);
		panel.add(btnCerrar);
		btnCerrar.addActionListener(this);
		btnListar.addActionListener(this);

	}

	//Eventos
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}

	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}

	protected void actionPerformedBtnListar(ActionEvent e) {
		
		txtS.setText("Lista de Modelos de Cocinas:\n\n");
		txtS.append("Modelo\t\t:" 	+ FrmPrincipal.modelo0+"\n");
		txtS.append("Precio\t\t:" 	+ FrmPrincipal.precio0+ "\n");
		txtS.append("Ancho\t\t:" 	+ FrmPrincipal.ancho0+ "\n");
		txtS.append("Alto\t\t:" 	+ FrmPrincipal.alto0+ "\n");
		txtS.append("Fondo\t\t:" 	+ FrmPrincipal.fondo0+ "\n");
		txtS.append("Quemadores\t:" + FrmPrincipal.quemadores0+ "\n\n");
		
		txtS.append("Modelo\t\t:" 	+ FrmPrincipal.modelo1+"\n");
		txtS.append("Precio\t\t:" 	+ FrmPrincipal.precio1+ "\n");
		txtS.append("Ancho\t\t:" 	+ FrmPrincipal.ancho1+ "\n");
		txtS.append("Alto\t\t:" 	+ FrmPrincipal.alto1+ "\n");
		txtS.append("Fondo\t\t:" 	+ FrmPrincipal.fondo1+ "\n");
		txtS.append("Quemadores\t:"+ FrmPrincipal.quemadores1 + "\n\n");
		
		txtS.append("Modelo\t\t:"	+ FrmPrincipal.modelo2 +"\n");
		txtS.append("Precio\t\t:" 	+ FrmPrincipal.precio2 + "\n");
		txtS.append("Ancho\t\t:" 	+ FrmPrincipal.ancho2+ "\n");
		txtS.append("Alto\t\t:" 	+ FrmPrincipal.alto2 + "\n");
		txtS.append("Fondo\t\t:" 	+ FrmPrincipal.fondo2 + "\n");
		txtS.append("Quemadores\t:" + FrmPrincipal.quemadores2 + "\n\n");
		
		txtS.append("Modelo\t\t:" 	+ FrmPrincipal.modelo3+"\n");
		txtS.append("Precio\t\t:" 	+ FrmPrincipal.precio3+ "\n");
		txtS.append("Ancho\t\t:" 	+ FrmPrincipal.ancho3+ "\n");
		txtS.append("Alto\t\t:" 	+ FrmPrincipal.alto3+ "\n");
		txtS.append("Fondo\t\t:" 	+ FrmPrincipal.fondo3+ "\n");
		txtS.append("Quemadores\t:" + FrmPrincipal.quemadores3+ "\n\n");
		
		txtS.append("Modelo\t\t:" 	+ FrmPrincipal.modelo4+"\n");
		txtS.append("Precio\t\t:" 	+ FrmPrincipal.precio4+ "\n");
		txtS.append("Ancho\t\t:" 	+ FrmPrincipal.ancho4+ "\n");
		txtS.append("Alto\t\t:" 	+ FrmPrincipal.alto4+ "\n");
		txtS.append("Fondo\t\t:" 	+ FrmPrincipal.fondo4+ "\n");
		txtS.append("Quemadores\t:" + FrmPrincipal.quemadores4+ "\n\n");
		

	}
}
