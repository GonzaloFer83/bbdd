package model;

import java.util.List;

import entity.Persona;
import persistence.DaoPersonaMySql;



public class PersonaManager {
	private DaoPersonaMySql persona = new DaoPersonaMySql();

	public void createPersona(Persona p) {
		boolean alta = persona.alta(p);
		if (alta) {
			System.out.println("La Persona se ha dado de alta");
		} else {
			System.out.println("La Persona NO se ha dado de alta");
		}
	}

	public void deletePersona(int i) {
		boolean baja = persona.baja(i);
		if (baja) {
			System.out.println("La Persona se ha dado de baja");
		} else {
			System.out.println("La Persona NO se ha dado de baja");
		}
	}

	public void modifyPersona(Persona p) {
		boolean modificar = persona.modificar(p);
		if (modificar) {
			System.out.println("El Coche se ha modificado");
		} else {
			System.out.println("El Coche NO se ha modificado");
		}
	}

	public void personas() {
		System.out.println("********* LISTANDO TODAS LAS PERSONAS **********");

		List<Persona> personas = persona.listar();
		for (Persona p : personas) {
			System.out.println(p);
		}
	}
	public Persona getPersona(int i) {
		return persona.obtener(i);
	}

}
