package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FocusTraversalPolicy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;





import Controlador.CtrlABMCPersona;
import Controlador.CtrlCategorias;
import Data.DataCategorias;
import Entidades.Categorias;
import Entidades.Personas;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class NuevoUsuario extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApe;
	private JTextField txtUser;
	private JPasswordField txtPasswordField;
	private JButton btnCancelar;
	private JButton btnGuardar;
	Personas pers;
	Categorias cat=new Categorias();
	CtrlCategorias ctrlCat= new CtrlCategorias();
	CtrlABMCPersona ctrl=new CtrlABMCPersona();
	private JComboBox cBoxCateg;
	private JButton btnEliminar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoUsuario frame = new NuevoUsuario();
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
	public NuevoUsuario() {
		setClosable(true);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 296, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDni = new JLabel("DNI:");
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		JLabel lblApellido = new JLabel("Apellido:");
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtApe = new JTextField();
		txtApe.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		
		btnCancelar = new JButton("Mostrar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrar();
			}
		});
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaUser();
			}
		});
		
		txtPasswordField = new JPasswordField();
		
		JLabel lblCategoria = new JLabel("Categoria");
		
		cBoxCateg = new JComboBox();
		listaCombo();
		cBoxCateg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				seleccion();
			}
		});
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarUser();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblUsuario)
									.addGap(53)
									.addComponent(txtUser, 150, 150, 150))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDni)
										.addComponent(lblNombre)
										.addComponent(lblApellido)
										.addComponent(lblContrasea))
									.addGap(33)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtApe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
										.addComponent(txtNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
										.addComponent(txtDni, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
										.addComponent(txtPasswordField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
										.addComponent(cBoxCateg, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(btnEliminar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancelar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
						.addComponent(lblCategoria))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellido)
						.addComponent(txtApe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea)
						.addComponent(txtPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCategoria)
						.addComponent(cBoxCateg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar)
						.addComponent(btnCancelar)
						.addComponent(btnEliminar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		}

	protected void borrarUser() {
		pers=ctrl.buscaPersonaDni(txtDni.getText());
		ctrl.borrar(pers);
		// TODO Auto-generated method stub
		
	}

	protected void seleccion() {
	cBoxCateg.addItem("admin");
	cBoxCateg.repaint();
		}
	
	protected void mostrar(){
		pers=ctrl.buscaPersonaDni(txtDni.getText());
		txtNombre.setText(pers.getNombre());
		txtApe.setText(pers.getApellido());
		cBoxCateg.setSelectedItem(pers.getCat().getNombreCat());;
	
		
	}

	protected void altaUser() {
		
		pers=capturaDatosUsuario();
		ctrl.alta(pers);
	}
		
	public void listaCombo(){ 
		ArrayList<Categorias> listaCate=DataCategorias.getAll();
	for (int i=0;i<listaCate.size();i++){
		cBoxCateg.addItem(listaCate.get(i).getNombreCat());
		cBoxCateg.repaint();
		}
		
	}
		
		// TODO Auto-generated method stub
	private Personas capturaDatosUsuario() {
		Personas pers=new Personas();
		pers.setDni(txtDni.getText());
		pers.setNombre(txtNombre.getText());
		pers.setApellido(txtApe.getText());
		pers.setCat(cate());
		pers.setUser(txtUser.getText());
		char pass[]=this.txtPasswordField.getPassword();
		String Cont=new String(pass);
		pers.setContraseña(Cont);
		return pers;}
		// TODO Auto-generated method stub
		
	protected Categorias cate(){
		switch ((String)cBoxCateg.getSelectedItem()){
		case("Administrador"):
			cat.setIdCat(1);
		break;
		case("Encargado"):
			cat.setIdCat(2);
		break;
		case("Usuario"):
			cat.setIdCat(3);
		break;
		}
		return (ctrlCat.getCategoria(cat.getIdCat()));
	}
	
/*	protected void buscaPersona(){
	pers=new Personas();
	pers.setDni(txtDni.getText());
	pers=ctrl.Mostrar(pers);
	}*/
}