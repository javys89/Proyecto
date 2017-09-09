package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.Personas;
import Entidades.TiposElementos;

public class DataTipoElem {
	String sql;
	public void addTipoElem(TiposElementos tipos) {
 		sql="insert  into tipoelementos(nombretipo,cant_max,maxTime,Diasant) values(?,?,?,?)";
 		PreparedStatement stmt =null;
 		ResultSet keyResultSet=null;
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(sql
 					,PreparedStatement.RETURN_GENERATED_KEYS);
 			stmt.setString(1,tipos.getNombreTipoE());
 			stmt.setInt(2, tipos.getCantReservas());
 			stmt.setTime(3, tipos.getMaxHs());
 			stmt.setDate(4, tipos.getDiasAnt());
 			stmt.executeUpdate();
 			keyResultSet=stmt.getGeneratedKeys();
 			if(keyResultSet!=null && keyResultSet.next()){
 			tipos.setIdTipoElemento(keyResultSet.getInt(1));
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		try {
 			if(stmt!=null) stmt.close();
 			FactoryConexion.getInstancia().releaseConn();
 		} catch (SQLException e) {
 			
 			e.printStackTrace();
 		}
 		
 	}	
 		

}
