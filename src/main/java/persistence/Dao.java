package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Dao {
	String url = "jdbc:mysql://localhost:3306/bbdd?useSSL=false";
	String usuario = "root";
	String password = "Ferparras83";
	protected Connection conexion;

	public boolean abrirConexion() {

		try {
			conexion = DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
