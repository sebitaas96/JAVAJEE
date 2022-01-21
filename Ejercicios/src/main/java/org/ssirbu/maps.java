package org.ssirbu;

import java.util.HashMap;
import java.util.Map;

public class maps {
	public static void main(String[] args) {
		/*Jerarquia de collectiones*/
		 //1- Tenmos el padre conllection que es la interfaz
		 //1.1-Tenemos los list , que es una interfaz  aqui podemos repetir elementos
		 //1.2 - Tenmos los set , no podemos repetir elementos  
		
		//Luefo tenemos aparte de la collection la clase map  , que es un valor asociado a un key
		
		//Declarar un mapa , aqui ya declaramos nuestro array asociativo creado
		Map<String , String> comida = new HashMap<String , String>();	
		
		//A�adir un valor dentro del array asociativo
		comida.put("pepe", "fabada"); // El primer paramtro es la clave y el segundo el valor
		comida.put("juan", "lenguado"); 
		
		//Consultar el valro de un array asociativo 
		System.out.println(comida.get("pepe"));
		
		//Recorrer un conjunto map y obtener sus valores , por eso ponemos el values()
		for(String gusta:comida.values()) {
			System.out.println(gusta);
		}
		
		//Recorrer un conjunto map y obtener sus claves , por eso ponemos el keySet()
				for(String persona:comida.keySet()) {
					System.out.println(persona+" : "+comida.get(persona));
				}
		
		
		
	}
}
