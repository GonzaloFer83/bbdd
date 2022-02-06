package model;

import java.util.List;

import entity.Car;
import persistence.DaoCarMySql;

public class CarManager {
	private DaoCarMySql car = new DaoCarMySql();

	public void createCar(Car c) {
		boolean alta = car.alta(c);
		if (alta) {
			System.out.println("El Coche se ha dado de alta");
		} else {
			System.out.println("El Coche NO se ha dado de alta");
		}
	}

	public void deleteCar(int i) {
		boolean baja = car.baja(i);
		if (baja) {
			System.out.println("El Coche se ha dado de baja");
		} else {
			System.out.println("El Coche NO se ha dado de baja");
		}
	}

	public void modifyCar(Car c) {
		boolean modificar = car.modificar(c);
		if (modificar) {
			System.out.println("El Coche se ha modificado");
		} else {
			System.out.println("El Coche NO se ha modificado");
		}
	}

	public void Cars() {
		System.out.println("********* LISTANDO TODAS LOS COCHES **********");

		List<Car> cars = car.listar();
		for (Car c : cars) {
			System.out.println(c);
		}
	}
	public Car getCar(int i) {
	return car.obtener(i);
	}

}
