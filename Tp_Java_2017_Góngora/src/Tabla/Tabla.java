package Tabla;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import Controlador.*;
import Entidades.Elementos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.fabric.xmlrpc.base.Array;

public class Tabla extends JFrame {

	private DefaultTableModel modelo;
	private JPanel contentPane;
	private JTable table;
	int id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabla frame = new Tabla();
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
	public Tabla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);

		modelo = new DefaultTableModel() {
			   @Override
			   public boolean isCellEditable(int fila, int columna) {
			       return false; //Con esto conseguimos que la tabla no se pueda editar
			   }
			};

			table = new JTable(modelo); //Metemos el modelo dentro de la tabla

			modelo.addColumn("Nombre"); //Añadimos las columnas a la tabla (tantas como queramos)
			modelo.addColumn("Tipo");
			modelo.addColumn("maximo Horas");
			modelo.addColumn("Dias anterioridad");
			modelo.addColumn("Reservas Pendientes");

			rellenarTabla(id); //Llamamos al método que rellena la tabla con los datos de la base de datos

			scrollPane.setViewportView(table);//Esto añade la tabla al portView del scrollPane, si estaba puesto anteriormente
			                                  //hay que borrarlo del otro sitio, sino puede dar error de NullPointerException
	}
	protected void rellenarTabla(int id){
		
		try{
			CtrlElementos ctrl=new CtrlElementos();
			ArrayList<Elementos> listaElementos=ctrl.listado();
			for (int i=0;i<listaElementos.size();i++){
				if(id==(listaElementos.get(i).getTipo().getIdTipoElemento()))
				{
					Object[] fila =new Object[5];
					fila[0]= listaElementos.get(i).getNombreElementos();
					fila[1]= listaElementos.get(i).getTipo().getNombreTipoE();
					fila[2]= listaElementos.get(i).getTipo().getMaxHs();
					fila[3]= listaElementos.get(i).getTipo().getDiasAnt();
					fila[4]= listaElementos.get(i).getTipo().getCantReservas();
					modelo.addRow(fila);	
				}
			}
			
						
			
			
			table.updateUI();
		}
		catch (Exception e) {
            // TODO Auto-generated catch block
           JOptionPane.showMessageDialog(this,"se rompio aca");;
        }
 
    }
	
 
}
