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

import javax.swing.JButton;

import com.mysql.jdbc.log.Log;

import javax.swing.JSeparator;

public class MainPrincipal extends JFrame {

	private MenuAdmin menuA;
	private Login log;
	public JDesktopPane desktopPane;

	private JPanel contentPane;
	private JMenuItem btnMenuLogin;
	private JMenuItem btnNuevaReserva;
	private JMenuItem btnNuevoUsuario;
	private JMenuItem btnCerrarSes;
	private JMenuItem btnSalir;
	
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
		setBounds(100, 100, 450, 300);
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
			
			btnNuevaReserva = new JMenuItem("Nueva Reserva");
			mnMenu.add(btnNuevaReserva);
			
			btnNuevoUsuario = new JMenuItem("Nuevo Usuario");
			mnMenu.add(btnNuevoUsuario);
			
			JSeparator separator_1 = new JSeparator();
			mnMenu.add(separator_1);
			
			btnCerrarSes = new JMenuItem("Cerrar Sesion");
			mnMenu.add(btnCerrarSes);
			
			JSeparator separator_2 = new JSeparator();
			mnMenu.add(separator_2);
			
			btnSalir = new JMenuItem("Salir");
			btnSalir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
				}
			});
			mnMenu.add(btnSalir);
		
		desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.NORTH);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 424, Short.MAX_VALUE)
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 252, Short.MAX_VALUE)
		);
		desktopPane.setLayout(gl_desktopPane);
		contentPane = new JPanel();
		getContentPane().add(contentPane, BorderLayout.SOUTH);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
	}
	
	protected void admin() {
		menuA=new MenuAdmin();
		desktopPane.add(menuA);
		menuA.setVisible(true);
		
		// TODO Auto-generated method stub
		
	}

	protected void LoginPrin() {
		log=new Login(this);
		desktopPane.add(log);
		log.setVisible(true);
		
			
	}
}