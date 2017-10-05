package Controlador;

import Data.DataTipoElem;
import Entidades.Categorias;
import Entidades.TiposElementos;

public class CtrlTipoElem {
	DataTipoElem dataType=new DataTipoElem();

	public TiposElementos buscarTipo(String name){
		return (dataType.getByName(name));
	}
	
	public TiposElementos getTipos(int id){
		return (dataType.getBytipo(id));
	}

}
