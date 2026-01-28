package principal;

import java.io.File;

import utilidades.Utilidades;

public class Main {
	
	public static int menu() {
		System.out.println("\n----- MENU ------  "
				+ "\n 1-Ir a la tienda "
				+ "\n 2-Visualizar inventario"
				+ "\n 3-Buscar objetos por rareza"
				+ "\n 4-Deshacerse de objetos de la mochila"
				+ "\n 5-Mostrar datos del personaje"
				+ "\n 6-Ir a buscar oro"
				+ "\n 7-Ranking de personajes por su oro"
				+ "\n 8-Salir");
		System.out.println("¿Que quieres hacer?");
		return Utilidades.leerInt(0, 4);
	}
	public static void main(String[] args) {
		File fichP=new File("personajes.dat");
		File fichO=new File("objetos.dat");
		int opcion;

		do{
			opcion = menu();
			System.out.println("");
			switch(opcion){
			case 0:
				System.out.println("Hasta pronto...");
				break;
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:

				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				System.out.println("Cerrando el programa...");
				System.out.println("Hasta la proxima aventura");
				break;
			}
		}while(opcion!=8);
	}
}
