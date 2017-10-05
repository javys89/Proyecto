package Tabla;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table {

	public void ver_tabla(JTable tabla){
		
		DefaultTableModel d= new DefaultTableModel
		(		new Object[][] {
				},
				new String[] {
					"Nombre", "Cantidad Reservas", "Maximo Horas", "dias Anterioridad"
				}
			);
				
		
	
	}

}
