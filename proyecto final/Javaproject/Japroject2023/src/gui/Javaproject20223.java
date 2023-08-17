package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Javaproject20223 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmListarCocina;
	private JMenu mnVentas;
	private JMenuItem mntmVender;
	private JMenuItem mntmGenerarReportes;
	private JMenu mnConfiguracin;
	private JMenuItem mntmConfigurar;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenu mnAyuda;
	private JMenuItem mntmAcercaDeTienda;
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
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 418);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmNewMenuItem = new JMenuItem("Consultar Cocina");
		mnMantenimiento.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Modificar Cocina");
		mnMantenimiento.add(mntmNewMenuItem_1);
		
		mntmListarCocina = new JMenuItem("Listar Cocinas");
		mnMantenimiento.add(mntmListarCocina);
		
		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);
		
		mntmVender = new JMenuItem("Vender");
		mnVentas.add(mntmVender);
		
		mntmGenerarReportes = new JMenuItem("Generar Reportes");
		mnVentas.add(mntmGenerarReportes);
		
		mnConfiguracin = new JMenu("Configuraci\u00F3n");
		menuBar.add(mnConfiguracin);
		
		mntmConfigurar = new JMenuItem("Configurar  Descuentos");
		mnConfiguracin.add(mntmConfigurar);
		
		mntmNewMenuItem_3 = new JMenuItem("Configurar Obsequios");
		mnConfiguracin.add(mntmNewMenuItem_3);
		
		mntmNewMenuItem_2 = new JMenuItem("Configurar cantidad \u00F3ptima");
		mnConfiguracin.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_4 = new JMenuItem("Configurar cuota diaria");
		mnConfiguracin.add(mntmNewMenuItem_4);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAcercaDeTienda = new JMenuItem("Acerca de tienda");
		mnAyuda.add(mntmAcercaDeTienda);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		System.exit(0);
	}
}
