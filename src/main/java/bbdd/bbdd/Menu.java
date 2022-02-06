package bbdd.bbdd;

import java.util.Scanner;

import model.CarManager;
import model.PersonaManager;
import model.TripManager;

public class Menu {
	protected int value = 0;
	protected Scanner sc = new Scanner(System.in);
	protected TripManager managerTrip = new TripManager();
	protected CarManager managerCar= new CarManager();
	protected PersonaManager managerPersona = new PersonaManager();
	public String readString(String helpText) {
		String aux;
		System.out.println(helpText);
		aux = sc.next();
		return aux;
	}
	public int readInteger(String helpText) {
		int aux;
		System.out.println(helpText);
		aux = sc.nextInt();
		return aux;
	}
	public Double readDouble(String helpText) {
		double aux;
		System.out.println(helpText);
		aux=sc.nextDouble();
		return aux;
	}
}
