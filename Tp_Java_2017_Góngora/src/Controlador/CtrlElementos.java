package Controlador;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Data.DataElementos;
import Entidades.Elementos;

public class CtrlElementos {
	DataElementos dataElements =new DataElementos();
	
	public ArrayList<Elementos> listado(){
		return dataElements.getAllElements();
	}

}
