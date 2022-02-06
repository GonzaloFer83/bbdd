package bbdd.bbdd;

import java.util.Scanner;

public class Main {
private static int value=0;
static MenuCar menuCar ;
static MenuPerson menuPersona;
static MenuTrip menuTrip;

static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while(value!=4) {
			System.out.println("Que quieres hacer:\n"
					+ "1. Menu Coches.\n"
					+ "2. Menu Personas.\n"
					+ "3. Menu Viajes.\n"
					+ "4. Salir");
			value = sc.nextInt();
			switch(value) {
			case 1:
				createCarMenu();
				break;
			case 2:
				createPersonMenu();
				break;
			case 3:
				createTripMenu();
				break;
			case 4:
				System.out.println("Hasta luego.");
				break;
			default:
					System.out.println("Debe seleccionar una de las opciones asignadas.");
			}
		}
	}
	public static void createCarMenu() {
	    menuCar = new MenuCar();
	}
	public static void createPersonMenu() {
		menuPersona = new MenuPerson();
	}
	public static void createTripMenu() {
		menuTrip = new MenuTrip();
	}
	

}
