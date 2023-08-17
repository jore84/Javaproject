package tienda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenu mnAyuda;
	private JMenuItem mntmSalir;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmListar;
	private JMenuItem mntmAcercaDeTienda;
	
	// Datos minimos de la primera cocina
	public static String modelo0 = "Mabe EMP6120PG0";
	public static double precio0 = 949.0;
	public static double fondo0 = 58.6;
	public static double ancho0 = 60.0;
	public static double alto0 = 91.0;
	public static int quemadores0 = 4;
	
	// Datos minimos de la segunda cocina
	public static String modelo1 = "Indurama Parma";
	public static double precio1 = 1089.0;
	public static double ancho1 = 80.0;
	public static double alto1 = 94.0;
	public static double fondo1 = 67.5;
	public static int quemadores1 = 6;
	
	// Datos minimos de la tercera cocina
	public static String modelo2 = "Sole COSOL027";
	public static double precio2 = 850.0;
	public static double ancho2 = 60.0;
	public static double alto2 = 90.0;
	public static double fondo2 = 50.0;
	public static int quemadores2 = 4;
	
	// Datos minimos de la cuarta cocina
	public static String modelo3 = "Coldex CX602";
	public static double precio3 = 629.0;
	public static double ancho3 = 61.6;
	public static double alto3 = 95.0;
	public static double fondo3 = 51.5;
	public static int quemadores3 = 5;
	
	// Datos minimos de la quinta cocina
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

	// Cantidad Optima de unidades vendidas
	public static int cantidadOptima = 30;
	
	// Cuota diaria
	public static double cuotaDiaria = 75000;

	
	//Acumuladores
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
	
	private JMenu mnVentas;
	private JMenu mnConfiguracion;
	private JMenuItem mntmVender;
	private JMenuItem mntmReport;
	private JMenuItem mntmDescuentos;
	private JMenuItem mntmObsequios;
	private JMenuItem mntmCantOptima;
	private JMenuItem mntmCuotDiaria;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the Frame
	 */
	public FrmPrincipal() {
		setResizable(false);
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnMantenimiento);
		
		mntmConsultar = new JMenuItem("Consultar Cocina");
		mntmConsultar.addActionListener(this);
		mntmConsultar.setHorizontalAlignment(SwingConstants.CENTER);
		mnMantenimiento.add(mntmConsultar);
		
		mntmModificar = new JMenuItem("Modificar Cocina");
		mntmModificar.addActionListener(this);
		mnMantenimiento.add(mntmModificar);
		
		mntmListar = new JMenuItem("Listar Cocinas");
		mntmListar.addActionListener(this);
		mnMantenimiento.add(mntmListar);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);
		
		mntmReport = new JMenuItem("Generar Reportes");
		mntmReport.addActionListener(this);
		mnVentas.add(mntmReport);
		
		mnConfiguracion = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguracion);
		
		mntmDescuentos = new JMenuItem("Configurar Descuentos");
		mntmDescuentos.addActionListener(this);
		mnConfiguracion.add(mntmDescuentos);
		
		mntmObsequios = new JMenuItem("Configurar Obsequios");
		mntmObsequios.addActionListener(this);
		mnConfiguracion.add(mntmObsequios);
		
		mntmCantOptima = new JMenuItem("Configurar Cantidad \u00D3ptima");
		mntmCantOptima.addActionListener(this);
		mnConfiguracion.add(mntmCantOptima);
		
		mntmCuotDiaria = new JMenuItem("Configurar Cuota Diaria");
		mntmCuotDiaria.addActionListener(this);
		mnConfiguracion.add(mntmCuotDiaria);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de");
		mntmAcercaDeTienda.addActionListener(this);
		mnAyuda.add(mntmAcercaDeTienda);
	}
	
	//Menus
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmReport) {
			actionPerformedMntmReport(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmCuotDiaria) {
			actionPerformedMntmCuotDiaria(e);
		}
		if (e.getSource() == mntmCantOptima) {
			actionPerformedMntmCantOptima(e);
		}
		if (e.getSource() == mntmObsequios) {
			actionPerformedMntmObsequios(e);
		}
		if (e.getSource() == mntmDescuentos) {
			actionPerformedMntmDescuentos(e);
		}
		if (e.getSource() == mntmAcercaDeTienda) {
			actionPerformedMntmAcercaDeTienda(e);
		}
		if (e.getSource() == mntmListar) {
			actionPerformedMntmListar(e);
		}
		if (e.getSource() == mntmModificar) {
			actionPerformedMntmModificar(e);
		}
		if (e.getSource() == mntmConsultar) {
			actionPerformedMntmConsultar(e);
		}
		if (e.getSource() == mntmSalir) {
			actionPerformedMntmSalir(e);
		}
	}
	
	//Eventos
	protected void actionPerformedMntmSalir(ActionEvent e) {
		//Cerrar un programa
		System.exit(0);
	}
	
	protected void actionPerformedMntmConsultar(ActionEvent e) {
		DialogConsultar cons = new DialogConsultar();
		cons.setVisible(true);
		cons.setLocationRelativeTo(this);
	}
	
	protected void actionPerformedMntmModificar(ActionEvent e) {
        DialogModificarCocina mod = new DialogModificarCocina();
        mod.setVisible(true);
        mod.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmListar(ActionEvent e) {
		DialogListar list = new DialogListar();
		list.setVisible(true);
		list.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmAcercaDeTienda(ActionEvent e) {
		DialogAcercaDeTienda list = new DialogAcercaDeTienda();
		list.setVisible(true);
		list.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmDescuentos(ActionEvent e) {
		DialogConfDescuento list = new DialogConfDescuento();
        list.setVisible(true);
        list.setLocationRelativeTo(this);	
	}
	protected void actionPerformedMntmObsequios(ActionEvent e) {
		DialogConfObsequio list = new DialogConfObsequio();
        list.setVisible(true);
        list.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmCantOptima(ActionEvent e) {
		DialogConfCantidadOptima list = new DialogConfCantidadOptima();
        list.setVisible(true);
        list.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmCuotDiaria(ActionEvent e) {
		DialogConfCuotaDiaria list = new DialogConfCuotaDiaria();
        list.setVisible(true);
        list.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmVender(ActionEvent e) {
        DialogVender list = new DialogVender();
        list.setVisible(true);
        list.setLocationRelativeTo(this);
	}
	protected void actionPerformedMntmReport(ActionEvent e) {
        DialogGenerarReportes list = new DialogGenerarReportes();
        list.setVisible(true);
        list.setLocationRelativeTo(this);
	}
}
