package UI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import Data.DataCategorias;
import Data.DataTipoElem;
import Entidades.Categorias;
import Entidades.TiposElementos;

public class NuevaReserva extends JInternalFrame {
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTextField textField;
	private JComboBox comboBoxElementos;
	private JButton btnBuscar;
	private JButton btnSalir;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevaReserva frame = new NuevaReserva();
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
	public NuevaReserva() {
		setBounds(100, 100, 349, 352);
		
		comboBoxElementos = new JComboBox();
		listaCombo();
		
		
		JLabel lblIdReserva = new JLabel("Id Reserva");
		
		JLabel lblNumeroId = new JLabel("Numero id");
		
		JLabel lblTipoElemento = new JLabel("Tipo Elemento");
		
		JLabel lblFecha = new JLabel("Fecha");
		
		JLabel lblHora = new JLabel("Hora");
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		
		btnSalir = new JButton("Salir");
		
		JLabel lblElemento = new JLabel("Elemento");
		
		btnBuscar = new JButton("...");
		
		JLabel lblElementoSeleccion = new JLabel("elemento seleccion");
		
		JLabel lblDetalle = new JLabel("Detalle");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblTipoElemento)
									.addComponent(lblFecha)
									.addComponent(lblHora)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblIdReserva)
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(122)
												.addComponent(lblElementoSeleccion))
											.addComponent(lblElemento))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addComponent(comboBoxElementos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNumeroId)
											.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(19, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addComponent(lblDetalle)
								.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
								.addGap(18)))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnSalir)
							.addGap(18)
							.addComponent(btnGuardar)
							.addGap(24))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdReserva)
						.addComponent(lblNumeroId))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoElemento)
						.addComponent(comboBoxElementos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFecha)
						.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHora)
						.addComponent(txtHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblElemento)
						.addComponent(lblElementoSeleccion)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSalir)
								.addComponent(btnGuardar)))
						.addComponent(lblDetalle))
					.addGap(220))
		);
		getContentPane().setLayout(groupLayout);

	}
	public void listaCombo(){ 
		ArrayList<TiposElementos> listaTipo=DataTipoElem.getAll();
	for (int i=0;i<listaTipo.size();i++){
		comboBoxElementos.addItem(listaTipo.get(i).getNombreTipoE());
		comboBoxElementos.repaint();
		}
		
	}
	
}
