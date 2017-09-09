package Data;
 
 import java.sql.*;
 import java.util.ArrayList;
 
 import Controlador.CtrlCategorias;
 import Data.FactoryConexion;
 import Entidades.Categorias;
 import Entidades.Personas;
 import Data.DataCategorias;
 public class DataPersonas { 
 	
 	String sql;
 	CtrlCategorias ctrCat;
 	
 	
 	public Personas getByUser(Personas per){
 		Personas p=null;
 		ResultSet rs=null;
 		ctrCat=new CtrlCategorias();
 		PreparedStatement stmt =null;
 		Categorias c=new Categorias();
 		c.getNombreCat();
 		try {
 			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(		
 					"select * from Personas where usuario=? or dni=?");
 			stmt.setString(1, per.getUser());
 			stmt.setString(2, per.getDni());
 			rs = stmt.executeQuery();
 			if(rs!=null && rs.next()){
 				p=new Personas();
 				p.setIdPersona(rs.getInt("idPersona"));
 				p.setNombre(rs.getString("nombre"));
 				p.setDni(rs.getString("dni"));
 				p.setApellido(rs.getString("apellido"));
 				p.setUser(rs.getString("usuario"));
 				p.setContraseña(rs.getString("contraseña"));
 				p.setCat(ctrCat.getCategoria(rs.getInt("idCat")));
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
 				return p;
 		
 	}
 
 
 
 
 	public void addPersona(Personas p) {
 		sql="insert  into personas(dni,nombre,Apellido,idcat,usuario,contraseña,habilitado) values(?,?,?,?,?,?,?)";
 		PreparedStatement stmt =null;
 		ResultSet keyResultSet=null;
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(sql
 					,PreparedStatement.RETURN_GENERATED_KEYS);
 			stmt.setString(1, p.getDni());
 			stmt.setString(2, p.getNombre());
 			stmt.setString(3, p.getApellido());
 			stmt.setInt(4, p.getCat().getIdCat());
 			stmt.setString(5, p.getUser());
 			stmt.setString(6, p.getContraseña());
 			stmt.setBoolean(7,p.isHabilitado());
 			stmt.executeUpdate();
 			keyResultSet=stmt.getGeneratedKeys();
 			if(keyResultSet!=null && keyResultSet.next()){
 			p.setIdPersona(keyResultSet.getInt(1));
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
 		
 
 
	public void deletePersona(Personas p) {
 		sql="delete from personas where dni=?";
 		PreparedStatement stmt =null;
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(sql);
 			stmt.setString(1, p.getDni());
 			stmt.execute();
 		}//Una fila modificada
 				catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		try {
 			if(stmt!=null) stmt.close();
 			FactoryConexion.getInstancia().releaseConn();
 		} catch (SQLException e) {
 			
 			e.printStackTrace();
 		}
 		// TODO Auto-generated method stub
 		
 	}
 
 	public ArrayList<Personas> getAll() {
 	
 		ctrCat=new CtrlCategorias();
 		Statement stmt=null;
 		ResultSet rs=null;
 		ArrayList<Personas> pers= new ArrayList<Personas>();
 		try {
 			stmt = FactoryConexion.getInstancia()
 					.getConn().createStatement();
 			rs = stmt.executeQuery("select * from personas");
 			if(rs!=null){
 				while(rs.next()){
 					Personas p=new Personas();
 					p.setNombre(rs.getString("nombre"));
 					p.setApellido(rs.getString("apellido"));
 					p.setDni(rs.getString("dni"));
 					p.setCat(ctrCat.getCategoria(rs.getInt("idCat")));
 					pers.add(p);
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
 		
 		return pers;
 	}
 	}
 
 	;/*
 	public void update(persona p){
 		
 		sql="update persona set nombre=?,apellido=?,habilitado=? where dni=?";
 		PreparedStatement stmt=null;
 		try {
 			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(sql);
 			stmt.setString(1, p.getNombre());
 			stmt.setString(2, p.getApellido());
 			stmt.setBoolean(3, p.isHabilitado());
 			stmt.setString(4, p.getDni());
 			stmt.executeUpdate();
 			
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
}*/ 