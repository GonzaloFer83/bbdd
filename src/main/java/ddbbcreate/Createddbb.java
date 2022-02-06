package ddbbcreate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Createddbb {




//Esta clase la debemos ejecutar en caso de que queramos usar una bbdd
//derby embebida y no la tengamos


	private Connection conexion;

	public static void main(String[] args) {
		Createddbb cd = new Createddbb();
		cd.crearBBDD();
	}
	
	public boolean abrirConexion(){
		try {
			conexion = DriverManager.getConnection("jdbc:derby:bbdd;create=true");
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
	
	public boolean crearBBDD() {
		if(!abrirConexion()){
			return false;
		}
		boolean estaCreada = true;
		
		try {
			//Con esto creamos una bbdd enbebida dentro del proyecto 
			Statement state = conexion.createStatement();
			state.execute("CREATE SCHEMA BBDD;\n"
					+ "USE BBDD;\n"
					+ "CREATE TABLE Personas (\n"
					+ "Id	int NOT NULL AUTO_INCREMENT,\n"
					+ "Nombre	varchar(255),\n"
					+ "Edad	int,\n"
					+ "Peso	double,\n"
					+ "PRIMARY KEY (Id)\n"
					+ ");\n"
					+ "CREATE TABLE Cars(\n"
					+ "Id	int NOT NULL AUTO_INCREMENT,\n"
					+ "Model	varchar(255),\n"
					+ "Registration varchar(255),\n"
					+ "Color	varchar(255),\n"
					+ "Capacity	int,\n"
					+ "PRIMARY KEY (Id)\n"
					+ ");\n"
					+ "CREATE TABLE Trips(\n"
					+ "Id	int NOT NULL AUTO_INCREMENT,\n"
					+ "Car	int,\n"
					+ "Persona	int,\n"
					+ "Date	varchar(255),\n"
					+ "PRIMARY KEY (Id),\n"
					+ "FOREIGN KEY (Car) REFERENCES Cars(Id),\n"
					+ "FOREIGN KEY (Persona) REFERENCES Personas(Id)\n"
					+ ");\n"
					+ "\n"
					+ "INSERT INTO Personas VALUES(NULL,'Pepe',18,55);\n"
					+ "INSERT INTO Personas VALUES(NULL,'Manolo',20,60);\n"
					+ "INSERT INTO Personas VALUES(NULL,'Lucia',23,50);\n"
					+ "INSERT INTO Personas VALUES(NULL,'Paco',22,80);\n"
					+ "INSERT INTO Personas VALUES(NULL,'Luisa',18,53);\n"
					+ "INSERT INTO Personas VALUES(NULL,'Marta',44,70);\n"
					+ "INSERT INTO Personas VALUES(NULL,'Mario',34,65);\n"
					+ "INSERT INTO Personas VALUES(NULL,'Francisco',55,88);\n"
					+ "INSERT INTO Personas VALUES(NULL,'Jose',32,120);\n"
					+ "INSERT INTO Personas VALUES(NULL,'Patricia',23,76);\n"
					+ "\n"
					+ "\n"
					+ "INSERT INTO Cars VALUES(NULL,'Hyundai','7894FFF','Rojo',4);\n"
					+ "INSERT INTO Cars VALUES(NULL,'Opel','4556RTY','Amarillo',2);\n"
					+ "INSERT INTO Cars VALUES(NULL,'Hyundai','3344VBN','Blanco',4);\n"
					+ "\n"
					+ "INSERT INTO Trips VALUES(NULL,1,1,'4-4-2021');\n"
					+ "INSERT INTO Trips VALUES(NULL,2,2,'1-4-2021');\n"
					+ "INSERT INTO Trips VALUES(NULL,2,3,'1-4-2021');\n"
					+ "INSERT INTO Trips VALUES(NULL,1,4,'4-4-2021');\n"
					+ "INSERT INTO Trips VALUES(NULL,1,5,'4-4-2021');\n"
					+ "INSERT INTO Trips VALUES(NULL,3,6,'4-4-2021');\n"
					+ "INSERT INTO Trips VALUES(NULL,3,7,'4-4-2021');\n"
					+ "\n"
					+ "");
			
		} catch (SQLException e) {
			System.out.println("alta -> Error al crear: ");
			estaCreada = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return estaCreada;
	}
}
