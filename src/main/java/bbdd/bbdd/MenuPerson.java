package bbdd.bbdd;


import entity.Persona;

public class MenuPerson extends Menu{
	public MenuPerson() {
		while (value != 6) {
			System.out.println("Que operación quieres hacer:\n" 
					+ "1. Añadir nuevo pasajero.\n" 
					+ "2. Borrar pasajero.\n"
					+ "3. Modifipersona pasajero.\n"
					+ "4. Consulta de pasajero.\n" 
					+ "5. Listado de pasajeros.\n" 
					+ "6. Volver Atras.");
			value = sc.nextInt();
			switch (value) {
			case 1:
				addPersona();
				break;
			case 2:
				clearPersona();
				break;
			case 3:
				modifyPersona();
				break;
			case 4:
				seePersona();
				break;
			case 5:
				personas();
				break;
			case 6:
				System.out.println("<<");
				break;
			default:
				System.out.println("Debe seleccionar una de las opciones asignadas.");
			}
		}

	}

	public void addPersona() {
		Persona persona = new Persona();
		
		
		persona.setName(readString("Dame el nombre de la persona."));
		persona.setAge(readInteger("Dame la edad de la persona."));
		persona.setWeight(readDouble("Dame el peso de la persona."));
		managerPersona.createPersona(persona);
	}
	public void clearPersona() {
		
		
		managerPersona.deletePersona(readInteger("Dame el id de la persona"));
		
	}
	public void modifyPersona() {
		Persona  persona = new Persona();
		persona.setId(readInteger("Dame el id de la persona"));
		persona.setName(readString("Dame el nombre de la persona."));
		persona.setAge(readInteger("Dame la edad de la persona."));
		persona.setWeight(readDouble("Dame el peso de la persona."));
		managerPersona.modifyPersona(persona);
	}
	public void seePersona() {
	
		System.out.println(managerPersona.getPersona(readInteger("Dame el id de la persona")));
		
	}
	public void personas() {
		managerPersona.personas();
		
	}

}
