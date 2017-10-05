package Controlador;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Data.DataElementos;

public class CtrlElementos {
	DataElementos dataElements =new DataElementos();
	
	public void getByTypes (int id,DefaultTableModel modelo){
		dataElements.getByTypes(id,modelo);
	}

}
