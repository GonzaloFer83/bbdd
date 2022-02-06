package persistence;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Persona;

public class DaoPersonaMySql extends Dao{

	

	
	
	
	public boolean alta(Persona p) {
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "insert into personas (NOMBRE,EDAD,PESO) "
				+ " values(?,?,?)";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setDouble(3, p.getWeight());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				alta = false;
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + p);
			alta = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return alta;
	}

	public boolean baja(int id) {
		if(!abrirConexion()){
			return false;
		}
		
		boolean borrado = true;
		String query = "delete from personas where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			//sustituimos la primera interrgante por la id
			ps.setInt(1, id);
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				borrado = false;
		} catch (SQLException e) {
			borrado = false;
			System.out.println("baja -> No se ha podido dar de baja"
					+ " el id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return borrado; 
	}

	public boolean modificar(Persona p) {
		if(!abrirConexion()){
			return false;
		}
		boolean modificado = true;
		String query = "update personas set NOMBRE=?, EDAD=?, "
				+ "PESO=? WHERE ID=?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setDouble(3, p.getWeight());
			ps.setInt(4, p.getId());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				modificado = false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("modificar -> error al modificar la "
					+ " persona " + p);
			modificado = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return modificado;
	}

	public Persona obtener(int id) {
		if(!abrirConexion()){
			return null;
		}		
		Persona persona = null;
		
		String query = "select ID,NOMBRE,EDAD,PESO from personas "
				+ "where id = ?";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				persona = new Persona();
				persona.setId(rs.getInt(1));
				persona.setName(rs.getString(2));
				persona.setAge(rs.getInt(3));
				persona.setWeight(rs.getDouble(4));
			}
		} catch (SQLException e) {
			System.out.println("obtener -> error al obtener la "
					+ "persona con id " + id);
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return persona;
	}

	
	public List<Persona> listar() {
		if(!abrirConexion()){
			return null;
		}		
		List<Persona> listaPersonas = new ArrayList<>();
		
		String query = "select ID,NOMBRE,EDAD,PESO from personas";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Persona persona = new Persona();
				persona.setId(rs.getInt(1));
				persona.setName(rs.getString(2));
				persona.setAge(rs.getInt(3));
				persona.setWeight(rs.getDouble(4));
				listaPersonas.add(persona);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener las "
					+ "personas");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return listaPersonas;
	}

}