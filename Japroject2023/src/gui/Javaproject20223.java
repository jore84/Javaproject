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
	
	// Datos mínimos de la primera cocina
		public static String modelo0 = "Mabe EMP6120PG0";
		public static double precio0 = 949.0;

		public static double fondo0 = 58.6;
		public static double ancho0 = 60.0;
		public static double alto0 = 91.0;
		public static int quemadores0 = 4;
		// Datos mínimos de la segunda cocina
		public static String modelo1 = "Indurama Parma";
		public static double precio1 = 1089.0;
		public static double ancho1 = 80.0;
		public static double alto1 = 94.0;
		public static double fondo1 = 67.5;
		public static int quemadores1 = 6;
		// Datos mínimos de la tercera cocina
		public static String modelo2 = "Sole COSOL027";
		public static double precio2 = 850.0;
		public static double ancho2 = 60.0;
		public static double alto2 = 90.0;
		public static double fondo2 = 50.0;
		public static int quemadores2 = 4;
		// Datos mínimos de la cuarta cocina
		public static String modelo3 = "Coldex CX602";
		public static double precio3 = 629.0;
		public static double ancho3 = 61.6;
		public static double alto3 = 95.0;
		public static double fondo3 = 51.5;
		public static int quemadores3 = 5;
		// Datos mínimos de la quinta cocina
		public static String modelo4 = "Reco Dakota";
		public static double precio4 = 849.0;
		public static double ancho4 = 75.4;
		public static double alto4 = 94.5;
		public static double fondo4 = 66.0;
		public static int quemadores4 = 5;
		// Porcentajes de descuento
		public static double porcentaje1 = 7.5;
		public static double porcentaje2 = 10.0;
		public static double porcentaje3 = 12.5;
		public static double porcentaje4 = 15.0;
		// Obsequios
		public static String obsequio1 = "Cafetera";
		public static String obsequio2 = "Licuadora";
		public static String obsequio3 = "Extractor";
		// Cantidad óptima de unidades vendidas
		public static int cantidadOptima = 30;
		// Cuota diaria
		public static double cuotaDiaria = 75000;
		
		public static int ventasTotales;
		public static double impTotalAcumulado;
		public static double porcCuotaTotal;
		
		public static int contVenta0;
		public static int contVenta1;
		public static int contVenta2;
		public static int contVenta3;
		public static int contVenta4;
		
		public static int uniVendidas0;
		public static int uniVendidas1;
		public static int uniVendidas2;
		public static int uniVendidas3;
		public static int uniVendidas4;
		
		public static double impAcumulado0;
		public static double impAcumulado1;
		public static double impAcumulado2;
		public static double impAcumulado3;
		public static double impAcumulado4;
		
		public static double porcCuota0;
		public static double porcCuota1;
		public static double porcCuota2;
		public static double porcCuota3;
		public static double porcCuota4;
		

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
		if (arg0.getSource() == mntmConfigurarCantidadOptima) {
			actionPerformedMntmConfigurarCantidadOptima(arg0);
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
		dispose();
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
	
	protected void actionPerformedMntmConfigurarCantidadOptima(ActionEvent arg0) {
		DialogoConfiguracionCantidadOptima dc;
		dc = new DialogoConfiguracionCantidadOptima();
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
