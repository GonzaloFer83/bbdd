package entity;



public class Car {
	private int id;
	private int capacity;
	private String model;
	private String registration;
	private String color;
	public Car(int id, int capacity, String model, String registration, String color) {
		this.id = id;
		this.capacity = capacity;
		this.model = model;
		this.registration = registration;
		this.color = color;
	}
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", capacity=" + capacity + ", model=" + model + ", registration=" + registration + ", color=" + color
				+ "]";
	}
}
