package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Categorias;
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
 		
	public static ArrayList<TiposElementos> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<TiposElementos> cats= new ArrayList<TiposElementos>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from tiposElementos");
			if(rs!=null){
				while(rs.next()){
					TiposElementos tipos= new TiposElementos();	//Verificar Nombres en la base de datos
					tipos.setIdTipoElemento(rs.getInt("idTipos"));
					tipos.setNombreTipoE(rs.getString("nombreTipoE"));
					tipos.setDiasAnt(rs.getString("diasAnt"));
					tipos.setMaxHs(rs.getString("maxHs"));
					tipos.setCantReservas(rs.getInt("cantmaxreservas"));
										
					cats.add(tipos);
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
		
		return cats;
	
	
	}
	
	 public TiposElementos getByName (String nombre){
			
		 		TiposElementos tipos =new TiposElementos();
		  		sql="select * from tipoElementos where nombreTipoE=?";
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
		 		
		 		return tipos;
	 }	
		public TiposElementos getBytipo(int id){
			ResultSet rs=null;
			PreparedStatement stmt =null;
			TiposElementos c=null;
			try {
				stmt= FactoryConexion.getInstancia().getConn().prepareStatement(		
						"select * from TipoElementos where idtipoE=?");
				stmt.setInt(1, id);
				rs = stmt.executeQuery();
				if(rs!=null && rs.next()){
					c=new TiposElementos();
					c.setIdTipoElemento(rs.getInt("idTipoE"));
					c.setNombreTipoE(rs.getString("nombreTipoE"));
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
					return c;
			
	}

}
