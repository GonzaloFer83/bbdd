package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Car;
import entity.Persona;
import entity.Trip;

public class DaoTripMySql extends Dao {

	public boolean alta(Trip t) {
		if (!abrirConexion()) {
			return false;
		}
		boolean alta = true;

		String query = "insert into Trips (CAR,PERSONA,DATE) " + " values(?,?,?)";
		try {
			// preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, t.getCar().getId());
			ps.setInt(2, t.getPersona().getId());
			ps.setString(3, t.getDate());

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				alta = false;
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + t);
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
		String query = "delete from Trips where id = ?";
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

	
	
	public boolean modificar(Trip t) {
		if (!abrirConexion()) {
			return false;
		}
		boolean modificado = true;
		String query = "update Trips set CAR=?, PERSONA=? " + "WHERE ID=? AND DATE=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, t.getCar().getId());
			ps.setInt(2, t.getPersona().getId());
			ps.setInt(3, t.getId());
			ps.setString(4, t.getDate());

			int numeroFilasAfectadas = ps.executeUpdate();
			if (numeroFilasAfectadas == 0)
				modificado = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("modificar -> error al modificar la " + " Trip " + t);
			modificado = false;
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return modificado;
	}
	

	public List<Trip> listar() {
		if (!abrirConexion()) {
			return null;
		}
		List<Trip> Trips = new ArrayList<>();

		String query = "select ID,CAR,PERSONA,DATE from Trips ORDER BY (CAR) ASC";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Trip trip = new Trip();
				trip.setId(rs.getInt(1));
				trip.setCar(findCar(rs.getInt(2)));
				trip.setPersona(findPersona(rs.getInt(3)));
				trip.setDate(rs.getString(4));
				Trips.add(trip);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener las " + "Trips");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return Trips;
	}
	

	public List<Trip> listarPersonaCar(Trip t) {
		if (!abrirConexion()) {
			return null;
		}
		List<Trip> Trips = new ArrayList<>();

		String query = "select ID,CAR,PERSONA,DATE from Trips Where CAR =" + t.getCar().getId() + " And DATE ="
				+ t.getDate();
		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Trip trip = new Trip();
				trip.setId(rs.getInt(1));
				trip.setCar(findCar(rs.getInt(2)));
				trip.setPersona(findPersona(rs.getInt(3)));
				trip.setDate(rs.getString(4));
				Trips.add(trip);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener las " + "Trips");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return Trips;
	}
	public List<Trip> listTripsCar(int id) {
		if (!abrirConexion()) {
			return null;
		}
		List<Trip> Trips = new ArrayList<>();

		String query = "select ID,CAR,PERSONA,DATE from Trips Where CAR =" + id ;
		try {
			PreparedStatement ps = conexion.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Trip trip = new Trip();
				trip.setId(rs.getInt(1));
				trip.setCar(findCar(rs.getInt(2)));
				trip.setPersona(findPersona(rs.getInt(3)));
				trip.setDate(rs.getString(4));
				Trips.add(trip);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener las " + "Trips");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return Trips;
	}

	public Car findCar(int ps) {
		DaoCarMySql car = new DaoCarMySql();
		return car.obtener(ps);

	}

	public Persona findPersona(int ps) {
		DaoPersonaMySql persona = new DaoPersonaMySql();
		return persona.obtener(ps);
	}

	public boolean freeSeat(Trip t) {
		boolean itsfree = false;
		if (listarPersonaCar(t).size() > t.getCar().getCapacity()) {
			itsfree = true;
		}
		return itsfree;

	}
	public int getnumberSeat (Trip t) {
		return t.getCar().getCapacity()-listarPersonaCar(t).size();
	} 
}
