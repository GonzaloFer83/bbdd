package entity;

public class Persona {
	private int id;
	private String name;
	private int age;
	private double weight;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public Persona(int id, String name, double weight) {
		this.id = id;
		this.name = name;
		this.weight = weight;
	}
	public Persona() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
}
