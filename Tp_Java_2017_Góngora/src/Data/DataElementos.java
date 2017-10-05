package Data;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.PreparedStatement.ParseInfo;

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
	public  ArrayList<Elementos> getByTypes(int IdTipoE, DefaultTableModel modelo){
			String sql="select * from Elementos where IdTipoE=?";
			
			ctrl =new CtrlTipoElem();
			java.sql.PreparedStatement stmt=null;
			ResultSet rs=null;
			ArrayList<Elementos> lista=new ArrayList<Elementos>();
			TiposElementos tipo= new TiposElementos();
			tipo.getNombreTipoE();
			try {
				stmt= FactoryConexion.getInstancia().getConn().prepareStatement(sql);
				stmt.setInt(1, IdTipoE);
				rs = stmt.executeQuery(sql);
				
				if (rs!=null){
					while (rs.next()){
						
						Elementos e=new Elementos();
						if(IdTipoE==(e.getTipo().getIdTipoElemento())){
							 Object[] fila = new Object[5];
							 fila [0]=(rs.getString("Nombre"));
							 TiposElementos a= (ctrl.getTipos(rs.getInt("idtipoE")));
							 fila [1]=rs.getString(a.getNombreTipoE());
							 fila [2]=rs.getTime((a.getMaxHs()));
							 fila [3]=rs.getDate(a.getDiasAnt());
							 fila [4]=rs.getInt(a.getCantReservas());
							 modelo.addRow(fila);
									 
										
						}
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
	 		
		
	};
}
