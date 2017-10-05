package Data;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controlador.CtrlTipoElem;
import Entidades.Elementos;
import Entidades.TiposElementos;

public class DataElementos {
	
	CtrlTipoElem ctrl;
	private String sql;
	public ArrayList<Elementos> getAllElements(){
		String sql="select * from Elementos";
		
		ctrl =new CtrlTipoElem();
		java.sql.Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Elementos> lista=new ArrayList<Elementos>();
		TiposElementos tipo= new TiposElementos();
		tipo.getNombreTipoE();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from elementos");
			if (rs!=null){
				while (rs.next()){
					Elementos e=new Elementos();
					e.setIdElemento(rs.getInt("idElemento"));
					e.setNombreElementos(rs.getString("Nombre"));
					e.setTipo(ctrl.getTipos(rs.getInt("idtipoE")));
					lista.add(e);
				}
			}
		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		
 		try {
 			if(rs!=null) rs.close();
 			if(stmt!=null) stmt.close();
 			FactoryConexion.getInstancia().releaseConn();
 		} catch (SQLException e) {
 			
 			e.printStackTrace();
 		} 
 				return lista;
 		
 	}
}
