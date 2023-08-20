package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

public class Javaproject20223 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultarCocina;
	private JMenuItem mntmModificarCocina;
	private JMenuItem mntmListarCocina;
	private JMenu mnVentas;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenu mnConfiguracin;
	private JMenuItem mntmConfigurarDescuentos;
	private JMenuItem mntmConfigurarCantidadOptima;
	private JMenuItem mntmConfigurarObsequios;
	private JMenuItem mntmConfigurarCuotaDiaria;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercadetienda;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Javaproject20223 frame = new Javaproject20223();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Javaproject20223() {
		setForeground(Color.BLACK);
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 418);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.addActionListener(this);
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmConsultarCocina = new JMenuItem("Consultar Cocina");
		mntmConsultarCocina.addActionListener(this);
		mnMantenimiento.add(mntmConsultarCocina);
		
		mntmModificarCocina = new JMenuItem("Modificar Cocina");
		mntmModificarCocina.addActionListener(this);
		mnMantenimiento.add(mntmModificarCocina);
		
		mntmListarCocina = new JMenuItem("Listar Cocinas");
		mntmListarCocina.addActionListener(this);
		mnMantenimiento.add(mntmListarCocina);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar Reportes");
		mntmGenerarReportes.addActionListener(this);
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracin = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguracin);
		
		mntmConfigurarDescuentos = new JMenuItem("Configurar  Descuentos");
		mntmConfigurarDescuentos.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarDescuentos);
		
		mntmConfigurarObsequios = new JMenuItem("Configurar Obsequios");
		mntmConfigurarObsequios.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarObsequios);
		
		mntmConfigurarCantidadOptima = new JMenuItem("Configurar cantidad \u00F3ptima");
		mntmConfigurarCantidadOptima.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarCantidadOptima);
		
		mntmConfigurarCuotaDiaria = new JMenuItem("Configurar cuota diaria");
		mntmConfigurarCuotaDiaria.addActionListener(this);
		mnConfiguracin.add(mntmConfigurarCuotaDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercadetienda = new JMenuItem("Acerca de tienda");
		mntmAcercadetienda.addActionListener(this);
		mnAyuda.add(mntmAcercadetienda);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmAcercadetienda) {
			actionPerformedMntmAcercadetienda(arg0);
		}
		
		
		if (arg0.getSource() == mntmConfigurarCuotaDiaria) {
			actionPerformedMntmConfigurarCuotaDiaria(arg0);
		}
		
		if (arg0.getSource() == mntmConfigurarObsequios) {
			actionPerformedMntmConfigurarObsequios(arg0);
		}
		if (arg0.getSource() == mntmConfigurarDescuentos) {
			actionPerformedMntmConfigurarDescuentos(arg0);
		}
		if (arg0.getSource() == mntmGenerarReportes) {
			actionPerformedMntmGenerarReportes(arg0);
		}
		if (arg0.getSource() == mntmVender) {
			actionPerformedMntmVender(arg0);
		}
		if (arg0.getSource() == mntmListarCocina) {
			actionPerformedMntmListarCocina(arg0);
		}
		if (arg0.getSource() == mntmModificarCocina) {
			actionPerformedMntmModificarCocina(arg0);
		}
		if (arg0.getSource() == mntmConsultarCocina) {
			actionPerformedMntmConsultarCocina(arg0);
			
		}
		if (arg0.getSource() == mnArchivo) {
			actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	
		
	}
	
		
	
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		System.exit(0);
	}
	
	
	protected void actionPerformedMntmConsultarCocina(ActionEvent arg0) {
		DialogoConsultarCocina dc;
		dc = new DialogoConsultarCocina();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	
	protected void actionPerformedMntmModificarCocina(ActionEvent arg0) {
		DialogoModificarCocina dc;
		dc = new DialogoModificarCocina();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	protected void actionPerformedMntmListarCocina(ActionEvent arg0) {
		DialogoListarCocinas dc;
		dc = new DialogoListarCocinas();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	protected void actionPerformedMntmVender(ActionEvent arg0) {
		DialogoVender dc;
		dc = new DialogoVender();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	protected void actionPerformedMntmGenerarReportes(ActionEvent arg0) {
		DialogoGenerarReportes dc;
		dc = new DialogoGenerarReportes();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarDescuentos(ActionEvent arg0) {
		DialogoPorcentajeDescuento dc;
		dc = new DialogoPorcentajeDescuento();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	protected void actionPerformedMntmConfigurarObsequios(ActionEvent arg0) {
		DialogoConfigurarObsequios dc;
		dc = new DialogoConfigurarObsequios();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	
	
	protected void actionPerformedMntmConfigurarCuotaDiaria(ActionEvent arg0) {
		DialogoConfigurarCuotaDiaria dc;
		dc = new DialogoConfigurarCuotaDiaria();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
	protected void actionPerformedMntmAcercadetienda(ActionEvent arg0) {
		DialogoAcercadeTienda dc;
		dc = new DialogoAcercadeTienda();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}
}
