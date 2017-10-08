package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.server.UID;

import javax.swing.JButton;

import Controlador.CtrlABMCPersona;

import com.mysql.jdbc.log.Log;

import javax.swing.JSeparator;

public class MainPrincipal extends JFrame {

	private MenuAdmin menuA;
	private Login log;
	public JDesktopPane desktopPane;
	private JMenuItem btnMenuLogin;
	private JMenuItem btnNuevaReservaMenu;
	private JMenuItem btnNuevoUsuario;
	private JMenuItem btnCerrarSes;
	private JMenuItem btnSalir;
	private JMenu mnUsuario;
	private JMenu mnReserva;
	private JMenu mnElementos;
	private JMenuItem btnNuevoUsuario_1;
	private JMenuItem btnListado;
	NuevoUsuario usuario;
	private JMenuItem mntmNuevaReserva;
	private JMenuItem mntmNuevoElemento;
	private NuevaReserva nuevaReserva;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPrincipal frame = new MainPrincipal();
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
	public  MainPrincipal(){
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		btnMenuLogin = new JMenuItem("Login");
		btnMenuLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginPrin();
							
			}
		});
		
			mnMenu.add(btnMenuLogin);
			
			JSeparator separator = new JSeparator();
			mnMenu.add(separator);
			
			btnNuevaReservaMenu = new JMenuItem("Nueva Reserva");
			btnNuevaReservaMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NuevaReserva();
				}
			});
			mnMenu.add(btnNuevaReservaMenu);
			
			btnNuevoUsuario = new JMenuItem("Nuevo Usuario");
			mnMenu.add(btnNuevoUsuario);
			
			JSeparator separator_1 = new JSeparator();
			mnMenu.add(separator_1);
			
			btnCerrarSes = new JMenuItem("Cerrar Sesion");
			mnMenu.add(btnCerrarSes);
			
			JSeparator separator_2 = new JSeparator();
			mnMenu.add(separator_2);
			
			btnSalir = new JMenuItem("Salir");
			
			mnMenu.add(btnSalir);
			
			mnUsuario = new JMenu("Usuario");
			menuBar.add(mnUsuario);
			
			btnNuevoUsuario_1 = new JMenuItem("Usuario");
			btnNuevoUsuario_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					usuario();
				}
			});
			mnUsuario.add(btnNuevoUsuario_1);
			
			btnListado = new JMenuItem("Listado");
			mnUsuario.add(btnListado);
			
			mnReserva = new JMenu("Reserva");
			menuBar.add(mnReserva);
			
			mnElementos = new JMenu("Elementos");
			menuBar.add(mnElementos);
		
		desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.NORTH);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, Short.MAX_VALUE, Short.MAX_VALUE)
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, Short.MAX_VALUE, Short.MAX_VALUE)
		);
		this.mnElementos.setEnabled(false);
		
		mntmNuevoElemento = new JMenuItem("Nuevo Elemento");
		mnElementos.add(mntmNuevoElemento);
		this.mnUsuario.setEnabled(false);
		this.mnReserva.setEnabled(false);
		
		mntmNuevaReserva = new JMenuItem("Nueva Reserva");
		mntmNuevaReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NuevaReserva();
			}
		});
		mnReserva.add(mntmNuevaReserva);
		this.btnNuevaReservaMenu.setEnabled(false);
		this.btnNuevoUsuario.setEnabled(false);
		this.btnCerrarSes.setEnabled(false);
	
		desktopPane.setLayout(gl_desktopPane);
		
		
	}
	
	
	protected void NuevaReserva() {
	 nuevaReserva = new NuevaReserva();
	 desktopPane.add(nuevaReserva);
	 nuevaReserva.setVisible(true);
		// TODO Auto-generated method stub
		
	}

	protected void usuario() {
		usuario=new NuevoUsuario();
		desktopPane.add(usuario);
		usuario.setVisible(true);
		// TODO Auto-generated method stub
		
	}

	protected void admin() {
		menuA=new MenuAdmin();
		desktopPane.add(menuA);
		menuA.setVisible(true);
		validacion();
		
		// TODO Auto-generated method stub
		
	}

	protected void LoginPrin() {
		log=new Login(this);
		desktopPane.add(log);
		log.setVisible(true);
							
	}
	protected void validacion(){
		int bandera=log.Bandera();
		switch(bandera){
		case(1):
			this.mnElementos.setEnabled(true);
			this.mnReserva.setEnabled(true);
			this.mnUsuario.setEnabled(true);
			this.btnNuevaReservaMenu.setEnabled(true);
			this.btnNuevoUsuario.setEnabled(true);
			this.btnCerrarSes.setEnabled(true);
		break;
		case(2):
			this.mnElementos.setEnabled(false);
			this.mnReserva.setEnabled(true);
			this.mnUsuario.setEnabled(true);
			this.btnNuevaReservaMenu.setEnabled(true);
			this.btnNuevoUsuario.setEnabled(false);
			this.btnCerrarSes.setEnabled(true);
		
		}
	}
}