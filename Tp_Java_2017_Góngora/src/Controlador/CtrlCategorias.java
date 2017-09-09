package Controlador;

import java.util.ArrayList;

import Data.DataCategorias;
import Entidades.Categorias;
import Entidades.Personas;

public class CtrlCategorias {
	DataCategorias dataCat=new DataCategorias();
	
	public Categorias getCategoria(int id){
		return (dataCat.getByCat(id));
	}
	public void listaCategorias() {
		dataCat.getAll();
		
	}
	

}