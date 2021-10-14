package dad.gson;

import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

	public static void main(String[] args) {
		//Aunque edad deberia ser tipo int, lo declaramos como String para poder hacerle el .matches(), ya que esta funcion solo acepta Strings
		String nombre,apellidos,edad;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Introduzca su nombre: ");
		nombre = in.nextLine();
		
		if(nombre.matches("^[a-zA-Z]+$")==true) { //Verificamos que los datos introducidos son del tipo indicado
			
			System.out.println("Introduzca su  primer apellido: ");
			apellidos = in.nextLine();
			
			if(apellidos.matches("^[a-zA-Z]+$")==true) { //Verificamos que los datos introducidos son del tipo indicado
				
				System.out.println("Introduzca su edad: ");
				edad = in.nextLine();
				
				if(edad.matches("^[0-9]+$")==true) { //Verificamos que los datos introducidos son del tipo indicado
					in.close();
					Persona p = new Persona(nombre, apellidos, Integer.parseInt(edad)); //Parseamos a entero la edad
					toJson(p);
				}
			}
		}

	}
	
	public static void toJson (Persona p) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(p);
		System.out.println(json);
	}

}
