package model;

import java.util.List;

import entity.Trip;
import persistence.DaoTripMySql;

public class TripManager {
	
	DaoTripMySql trip = new DaoTripMySql();
	
	
	public void createTrip(Trip t) {
		boolean alta = trip.alta(t);
		if (alta) {
			System.out.println("El Viaje se ha dado de alta");
		} else {
			System.out.println("El Viaje NO se ha dado de alta");
		}
	}

	public void deleteTrip(int i) {
		boolean baja = trip.baja(i);
		if (baja) {
			System.out.println("El Viaje se ha dado de baja");
		} else {
			System.out.println("El Viaje NO se ha dado de baja");
		}
	}

	public void modifyTrip(Trip t) {
		boolean modificar = trip.modificar(t);
		if (modificar) {
			System.out.println("El Viaje se ha modificado");
		} else {
			System.out.println("El Viaje NO se ha modificado");
		}
	}
	

	public void trips() {
		System.out.println("********* LISTANDO TODAS LOS VIAJES **********");

		List<Trip> trips = trip.listar();
		for (Trip t : trips) {
			System.out.println(t);
		}
	}
	
	public void getTrip(int i) {
		List<Trip> trips= trip.listTripsCar(i);
		for (Trip t:trips) {
			System.out.println(t);
		}
	}
	
	public boolean isFreeSeatTrip(Trip t) {
		return trip.freeSeat(t);
	}
	public int getNumberFreeSeatTrip(Trip t) {
		return trip.getnumberSeat(t);
	}
	
}
