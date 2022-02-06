package bbdd.bbdd;


import entity.Car;

public class MenuCar extends Menu{
	private int value ;
	int aux2;
	public MenuCar() {
		
		while (value != 6) {
			System.out.println("Que operación quieres hacer:\n"
					+ "1. Añadir nuevo coche.\n"
					+ "2. Borrar Coche.\n"
					+ "3. Modificar un Coche.\n"
					+ "4. Consulta de Coche.\n"
					+ "5. Listado de Coches.\n"
					+ "6. Volver Atras.");
			value = sc.nextInt();
			switch(value) {
			case 1:
				addCar();
				break;
			case 2:
				clearCar();
				break;
			case 3:
				modifyCar();
				break;
			case 4:
				seeCar();
				break;
			case 5:
				cars();
				break;
			case 6:
				System.out.println("<<");
				break;
			default:
					System.out.println("Debe seleccionar una de las opciones asignadas.");
			}	
		}
		
	}
	public void addCar() {

		Car  car = new Car();
		car.setModel(readString("Dame el modelo del coche."));
		car.setRegistration(readString("Dame la matricula del coche."));
		car.setColor(readString("Dame el color del coche."));
		car.setCapacity(readInteger("Dame la capacidad del coche."));
		managerCar.createCar(car);
	}
	public void clearCar() {
		
		managerCar.deleteCar(readInteger("Dame el Id del coche."));
		
	}
	public void modifyCar() {
		Car  car = new Car();
		car.setId(readInteger("Dame el id del coche."));
		car.setModel(readString("Dame el modelo del coche."));
		car.setRegistration(readString("Dame la matricula del coche."));
		car.setColor(readString("Dame el color del coche."));
		car.setCapacity(readInteger("Dame la capacidad del coche."));
		managerCar.createCar(car);
	}
	public void seeCar() {
		System.out.println(managerCar.getCar(readInteger("Dame el Id del coche.")));
		
	}
	public void cars() {
		managerCar.Cars();
		
	}
	
	
}
