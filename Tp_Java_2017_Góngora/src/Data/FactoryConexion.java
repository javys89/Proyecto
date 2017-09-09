package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConexion {

	private String host="localhost";
	private String port="3306";
	private String  user="javier";
	private String pass="34240467";
	private String db="tp_2017_java";
	
	private static FactoryConexion instancia;
	
	public FactoryConexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public static FactoryConexion getInstancia(){ //crea instancia de conexion
			if (FactoryConexion.instancia == null){		
				FactoryConexion.instancia=new FactoryConexion();
			}
			return FactoryConexion.instancia;
	}
		private Connection conn;
		private int cantConn=0;

		public Connection getConn(){ //devuelve conexion 
			try {
				if (conn==null || conn.isClosed()){
					conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+
							"?user="+user+"&password="+pass);
					/*conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/TP_2017_java?user=javier&password=34240467");*/
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			cantConn++;
			return conn;
		};
		public void releaseConn(){ //cierra conexion
			try {
				cantConn--;
				if (cantConn==0){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	

	}

