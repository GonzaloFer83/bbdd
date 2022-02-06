package bbdd.bbdd;


import entity.Car;
import entity.Persona;
import entity.Trip;


public class MenuTrip extends Menu{
	

	public MenuTrip() {
		while (value != 6) {
			System.out.println("Que operación quieres hacer:\n" 
					+ "1. Añadir nuevo pasajero a un coche.\n" 
					+ "2. Borrar pasajero de un coche.\n"
					+ "3. modificar pasajero de un coche.\n"
					+ "4. Consulta de pasajeros de un coche.\n" 
					+ "5. Listado de pasajeros con sus coches.\n" 
					+ "6. Volver Atras.");
			value = sc.nextInt();
			switch (value) {
			case 1:
				addTrip();
				break;
			case 2:
				clearTrip();
				break;
			case 3:
				modifyTrip();
				break;
			case 4:
				seeTrip();
				break;
			case 5:
				Trips();
				break;
			case 6:
				System.out.println("<<");
				break;
			default:
				System.out.println("Debe seleccionar una de las opciones asignadas.");
			}
		}

	}

	public void addTrip() {
		Trip trip = new Trip();
		Car car = null;
		Boolean aux2=false;
		while(aux2==false) {
			car = managerCar.getCar(readInteger("Dame el id de un Coche"));
			if(car != null) {
				aux2=true;
			}
		}
		trip.setCar(car);
		aux2=false;
		Persona persona = null;
		while(aux2==false) {
			persona = managerPersona.getPersona(readInteger("Dame el id de la Persona"));
			if(persona != null) {
				aux2=true;
			}
		}
		aux2=false;
		trip.setPersona(persona);
		
		trip.setDate(readString("Dame la fecha del viaje."));
		if(managerTrip.isFreeSeatTrip(trip)) {
			managerTrip.createTrip(trip);
		}else {
			System.out.println("Lo sentimos, ya no queda espacio en este coche para estas fechas");
		}
		
	}
	
	public void clearTrip() {
		
		
		managerTrip.deleteTrip(readInteger("Dame el Id del Viaje."));
		
	}
	public void modifyTrip() {
		Trip trip = new Trip();
		Car car = null;
		boolean aux2=false;
		while(aux2==false) {
			
			car = managerCar.getCar(readInteger("Dame el id de un Coche"));
			if(car != null) {
				aux2=true;
			}
		}
		trip.setCar(car);
		aux2=false;
		Persona persona = null;
		while(aux2==false) {
			
			persona = managerPersona.getPersona(readInteger("Dame el id de la Persona"));
			if(persona != null) {
				aux2=true;
			}
		}
		aux2=false;
		trip.setPersona(persona);
		
		
		trip.setDate(readString("Dame la fecha del viaje."));
		managerTrip.modifyTrip(trip);
		
	}
	public void seeTrip() {
		int idCar;
		idCar = readInteger("Dame el id de un coche.");
		
		managerTrip.getTrip(idCar);
		
	}
	public void Trips() {
		managerTrip.trips();
		
	}

}
