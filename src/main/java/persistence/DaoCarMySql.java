package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Car;

public class DaoCarMySql extends Dao {


	
		
		

	public boolean alta(Car c) {
		if (!abrirConexion()) {
			return false;
		}
		boolean alta = true;

		String query = "insert into Cars (MODEL,REGISTRATION,COLOR,CAPACITY) " + " values(?,?,?,?)";
		try {
			// preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getModel());
			ps.setString(2, c.getRegistration());
			ps.setString(3, c.getColor());
			ps.setInt(4, c.getCapacity());

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				alta = false;
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + c);
			alta = false;
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return alta;
	}

	public boolean baja(int id) {
		if (!abrirConexion()) {
			return false;
		}

		boolean borrado = true;
		String query = "delete from Cars where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			// sustituimos la primera interrgante por la id
			ps.setInt(1, id);

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			borrado = false;
			System.out.println("baja -> No se ha podido dar de baja" + " el id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado;
	}

	public boolean modificar(Car c) {
		if (!abrirConexion()) {
			return false;
		}
		boolean modificado = true;
		String query = "update Cars set MODEL=?, REGISTRATION=?, COLOR=?,CAPACITY=? " + " WHERE ID=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, c.getModel());
			ps.setString(2, c.getRegistration());
			ps.setString(3, c.getColor());
			ps.setInt(4, c.getCapacity());
			ps.setInt(5, c.getId());

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				modificado = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("modificar -> error al modificar la " + " Car " + c);
			modificado = false;
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return modificado;
	}

	public Car obtener(int id) {
		if (!abrirConexion()) {
			return null;
		}
		Car Car = null;

		String query = "select ID,MODEL,REGISTRATION,COLOR,CAPACITY from Cars " + "where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Car = new Car();
				Car.setId(rs.getInt(1));
				Car.setModel(rs.getString(2));
				Car.setRegistration(rs.getString(3));
				Car.setColor(rs.getString(4));
				Car.setCapacity(rs.getInt(5));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener la " + "Car con id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return Car;
	}

	
	public List<Car> listar() {
		if (!abrirConexion()) {
			return null;
		}
		List<Car> listaCars = new ArrayList<>();

		String query = "select Id,Model,Registration,Color,Capacity from Cars";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Car Car = new Car();
				Car.setId(rs.getInt(1));
				Car.setModel(rs.getString(2));
				Car.setRegistration(rs.getString(3));
				Car.setColor(rs.getString(4));
				Car.setCapacity(rs.getInt(5));
				listaCars.add(Car);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener las " + "Cars");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return listaCars;
	}

}
