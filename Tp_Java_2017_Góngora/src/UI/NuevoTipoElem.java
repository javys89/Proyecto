package UI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Date;
import java.sql.Time;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import com.mysql.jdbc.PreparedStatement.ParseInfo;

import Entidades.Personas;
import Entidades.TiposElementos;

public class NuevoTipoElem extends JInternalFrame {
	private JTextField textNombreTipo;
	private JTextField textCantReser;
	private JTextField textMaxHoras;
	private JTextField textDiasAnt;
	private JButton btnGuardar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoTipoElem frame = new NuevoTipoElem();
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
	public NuevoTipoElem() {
		setBounds(100, 100, 336, 412);
		
		JLabel lblNuevoTipoElemento = new JLabel("Nuevo Tipo Elemento");
		lblNuevoTipoElemento.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblNewLabel = new JLabel("Cant. Max. Reservas");
		
		JLabel lblNewLabel_1 = new JLabel("Maximo de horas");
		
		JLabel lblNewLabel_2 = new JLabel("Cant. dias anticipacion");
		
		textNombreTipo = new JTextField();
		textNombreTipo.setColumns(10);
		
		textCantReser = new JTextField();
		textCantReser.setColumns(10);
		
		textMaxHoras = new JTextField();
		textMaxHoras.setColumns(10);
		
		textDiasAnt = new JTextField();
		textDiasAnt.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		
		btnSalir = new JButton("Salir");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre)
						.addComponent(lblNuevoTipoElemento)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textCantReser, Alignment.TRAILING)
							.addComponent(textNombreTipo, Alignment.TRAILING)
							.addComponent(textMaxHoras, Alignment.TRAILING)
							.addComponent(textDiasAnt, Alignment.TRAILING)))
					.addGap(44))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNuevoTipoElemento)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textNombreTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textCantReser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(textMaxHoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textDiasAnt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuardar)
						.addComponent(btnSalir))
					.addContainerGap(138, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
	protected TiposElementos capturaDatos(){
		TiposElementos t=new TiposElementos();
		t.setNombreTipoE(textNombreTipo.getText());;
		t.setCantReservas(Integer.parseInt((textCantReser.getText())));
		//t.setMaxHs(Time.valueOf(textMaxHoras.getText()));//modificar tipo
		//t.setDiasAnt(Date.parse(textDiasAnt.getText()));//modificar tipo
		return t;
		 }
	}

