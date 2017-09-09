package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Controlador.CtrlCategorias;
import Entidades.Categorias;
import Entidades.Personas;

public class DataCategorias {
	String sql;	
	public static ArrayList<Categorias> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Categorias> cats= new ArrayList<Categorias>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from categorias");
			if(rs!=null){
				while(rs.next()){
					Categorias c=new Categorias();
					c.setIdCat(rs.getInt("idCat"));
					c.setNombreCat(rs.getString("nombreCat"));
					cats.add(c);
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
	
	public Categorias getByCat(int id){
		ResultSet rs=null;
		PreparedStatement stmt =null;
		Categorias c=null;
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(		
					"select * from categorias where idCat=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()){
				c=new Categorias();
				c.setIdCat(rs.getInt("idCat"));
				c.setNombreCat(rs.getString("nombreCat"));
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