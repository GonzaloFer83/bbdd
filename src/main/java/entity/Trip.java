package entity;

public class Trip {
	private int id;
	private Car car;
	private Persona persona;
	private String Date;
	public Trip(int id, Car car, Persona persona, String date) {
		this.id = id;
		this.car = car;
		this.persona = persona;
		Date = date;
		
	}
	public Trip() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	
	
	@Override
	public String toString() {
		return "Trip [id=" + id + ", car=" + car.getId() + ", persona=" + persona.getId() + ", Date=" + Date + "]";
	}
}
