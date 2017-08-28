package UI;

import java.awt.EventQueue;

import javax.swing.CellRendererPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.prefs.BackingStoreException;

import javax.swing.JTable;

import Controlador.CtrlABMCPersona;
import Data.DataPersonas;
import Entidades.Personas;

import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.UIManager;

public class Listado extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private CtrlABMCPersona ctrl; 
	private String[] datoss = {"Nombre","Apellido","D.N.I.","Categoria"};
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listado frame = new Listado();
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
	public Listado() {
		setTitle("USUARIOS REGISTRADOS");
		setForeground(SystemColor.controlHighlight);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JTable();
		table.setBackground(SystemColor.controlHighlight);
		table.setFont(new Font("Bell MT", Font.BOLD, 11));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setCellSelectionEnabled(true);
		table.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
		table.setColumnSelectionAllowed(true);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		//mostrarTabla();
				
	}
	
	/*void mostrarTabla(){
		DefaultTableModel modelo=new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("D.N.I.");
		modelo.addColumn("Habilitado");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Habilitado", "D.N.I"
			}
		));
		table.setModel(modelo);
		modelo.addRow(datoss);
		
		ArrayList<Personas>list=DataPersonas.getAll();//Revisar**
		
		Object[] fila=new Object[modelo.getColumnCount()];
	
		for (int i=0;i < list.size(); i++) {
			fila[0]=list.get(i).getNombre();
			fila[1]=list.get(i).getApellido();
			fila[2]=list.get(i).getDni();
			fila[3]=list.get(i).getCat();
			modelo.addRow(fila);
		}
    }*/
}	
