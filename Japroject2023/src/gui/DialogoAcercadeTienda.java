package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoAcercadeTienda extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JSeparator separator;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblZeladaMarinAlexander;
	private JLabel lblOliveraApazaAldair;
	private JLabel lblCameroCondoriJorge;
	private JLabel lblIpanaqueRodasEnoc;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoAcercadeTienda dialog = new DialogoAcercadeTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoAcercadeTienda() {
		setTitle("Acerca de tienda");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 467, 265);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Tienda 1.0");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(176, 11, 115, 30);
		contentPanel.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(30, 39, 404, 12);
		contentPanel.add(separator);
		
		lblNewLabel_1 = new JLabel("Autores");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(197, 52, 62, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Ore Sanchez Juan Jose");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(119, 77, 213, 14);
		contentPanel.add(lblNewLabel_2);
		
		lblZeladaMarinAlexander = new JLabel("Zelada Marin Alexander ");
		lblZeladaMarinAlexander.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblZeladaMarinAlexander.setBounds(119, 100, 213, 14);
		contentPanel.add(lblZeladaMarinAlexander);
		
		lblOliveraApazaAldair = new JLabel("Olivera Apaza Aldair");
		lblOliveraApazaAldair.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblOliveraApazaAldair.setBounds(119, 123, 213, 14);
		contentPanel.add(lblOliveraApazaAldair);
		
		lblCameroCondoriJorge = new JLabel("Camero Condori Jorge Guillermo");
		lblCameroCondoriJorge.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblCameroCondoriJorge.setBounds(119, 146, 213, 14);
		contentPanel.add(lblCameroCondoriJorge);
		
		lblIpanaqueRodasEnoc = new JLabel("Ipanaque Rodas Enoc Isaac");
		lblIpanaqueRodasEnoc.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblIpanaqueRodasEnoc.setBounds(119, 169, 213, 14);
		contentPanel.add(lblIpanaqueRodasEnoc);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(182, 197, 89, 23);
		contentPanel.add(btnCerrar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
}
