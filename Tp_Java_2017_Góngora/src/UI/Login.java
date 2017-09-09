package UI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

import Controlador.CtrlABMCPersona;
import Entidades.Personas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JInternalFrame {
	private JTextField txtUser;
	private JPasswordField passwordField;
	private JLabel lblPassword;
	private JButton btnIngresar;
	private JButton btnNuevoUsuario;
	private JLabel lblLogin;
    private Personas p;
    public boolean b;
    MenuAdmin menu;
    MainPrincipal main;
    
  
	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	private CtrlABMCPersona ctrl= new CtrlABMCPersona();
	   /**
	 * Launch the application.
	 */
	public Login( MainPrincipal main) {
		setClosable(true);
		setBounds(100, 100, 265, 229);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		JLabel lblUser = new JLabel("User:");
		
		lblPassword = new JLabel("Password:");
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				validar();
				if (b){
						main.admin();
				}}});
		
		passwordField = new JPasswordField();
		
		btnNuevoUsuario = new JButton("Nuevo Usuario");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(34)
									.addComponent(lblUser))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblPassword)))
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(passwordField)
								.addComponent(txtUser)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNuevoUsuario)
							.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
							.addComponent(btnIngresar))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(74)
							.addComponent(lblLogin)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogin)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUser))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIngresar)
						.addComponent(btnNuevoUsuario))
					.addGap(19))
		);
		getContentPane().setLayout(groupLayout);

	}

	// TODO Auto-generated method stub
	
	protected boolean validar(){
		buscaPersona();
		String contra =new String(p.getContraseña());
		char cont[] = this.passwordField.getPassword();
		String pass=new String (cont);
		if (pass.equals(contra) ){
			b=true;
			this.dispose();
		/*	menu=new MenuAdmin();
			main.setVisible(true);
			main.desktopPane.add(menu);
			menu.setVisible(true);*/
			}
		else 
		 b=false;
		return (b);
				}
	
	protected int categoriaUser(){
		return p.getCat().getIdCat();
	}
	
	protected void buscaPersona(){
		p=new Personas();
		p.setUser(txtUser.getText());
		p=ctrl.Mostrar(p);
	}
	
}