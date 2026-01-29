package principal;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import clases.*;
import excepciones.*;
import utilidades.MyObjectOutputStream;
import utilidades.Utilidades;

public class Main {

	public static int menu() {
		System.out.println("\n----- MENU ------"
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
	public static boolean login(File fichP, boolean loginCorrecto,String usuario) {
		String contra;
		boolean finArchivo=false;
		ObjectInputStream ois=null;	

		System.out.println("Contraseña:");
		contra=Utilidades.introducirCadena();

		try {
			ois = new ObjectInputStream(new FileInputStream(fichP));
			while (!finArchivo) {
				try {
					Personaje p = (Personaje) ois.readObject();

					if (contra.equalsIgnoreCase(p.getContrasena()) && usuario.equalsIgnoreCase(p.getUser())) {
						loginCorrecto = true;
					}
				} catch (EOFException e) {
					finArchivo = true;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se encontró el fichero");
		} catch (ClassNotFoundException e) {
			System.out.println("La clase Persona no es válida");
		} catch (IOException e) {
			System.out.println("Error leyendo el fichero");
		}
		return loginCorrecto;
	}

	public static void main(String[] args) {
		File fichP=new File("personajes.dat");
		File fichO=new File("objetos.dat");
		String usuario;
		int opcion;
		boolean loginCorrecto=false;

		do {
			System.out.println("Introduce tu usuario:");
			usuario = Utilidades.introducirCadena();

			loginCorrecto=login(fichP,loginCorrecto,usuario);
			if (loginCorrecto) {
				System.out.println("Acceso autorizado...");
			}else {
				System.out.println("Usuario o la contraseña son incorrectos");
			}
		}while(!loginCorrecto); //bucle hasta que exista 

		do{
			opcion = menu();
			System.out.println("");
			switch(opcion){

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
				buscarOro(fichP,usuario);
				break;
			case 7:

				break;
			case 8:
				anadirUsuario(fichP);
				break;
			case 9:
				System.out.println("Cerrando el programa...");
				System.out.println("Hasta la proxima aventura");
				break;
			}
		}while(opcion!=8);
	}
	/*OPCION 1 mostrar*/
	public static void mostrarTienda(File fichO, File fichP) {
		
	}
	
	/*OPCION 6 Buscar oro*/
	public static void buscarOro(File fichP, String usuario) {
		String respuesta;
		Random random = new Random();
		int oroP,oro=random.nextInt(101); //numero de 0 a 100

		File fichA = new File("departModify.dat");
		boolean finArchivo = false;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;


		do {
			System.out.println("Desea irse de aventuras a por ORO?(Si/No)");
			respuesta=Utilidades.introducirCadena();

			if(!respuesta.equalsIgnoreCase("si")&&!respuesta.equalsIgnoreCase("no")) {
				System.out.println("Respuesta incorrecta");
			}
		}while(!respuesta.equalsIgnoreCase("si")&&!respuesta.equalsIgnoreCase("no"));

		if(respuesta.equalsIgnoreCase("si")) {

			try {
				ois = new ObjectInputStream(new FileInputStream(fichP));
				oos = new ObjectOutputStream(new FileOutputStream(fichA));

				if (oro<=20) { //mensaje personalizado si el random es un numero menor que 20
					System.out.println("No ha tenido mucha suerte en la aventra a conseguido "+ oro+" de oro");
				}else {
					System.out.println("La aventura ha sido un exito a conseguido "+ oro+ " de oro" );
				}

				while (!finArchivo) {
					try {
						Personaje p = (Personaje) ois.readObject();

						if (p.getUser().equalsIgnoreCase(usuario)) { //cojo el usuario 
							oroP=p.getOro();
							oroP+=oro;
							p.setOro(oroP); //añado la nueva cantidad 
							System.out.println("Oro total: "+oroP);
						
						}
						oos.writeObject(p);

					} catch (EOFException ex) {
						finArchivo = true;
					}
				}
				ois.close();
				oos.close();

				fichP.delete();
				fichA.renameTo(fichP);

				System.out.println("Oro añadido correctamente");

			} catch (Exception e) {
				System.out.println("Error procesando el fichero");
			}
		}
		System.out.println("Hasta la proxima aventura");
	}
	
	/*OPCION 8 Añadir usuarios*/ 
	public static void anadirUsuario(File fichP) {
		String contra,user;
		MyObjectOutputStream moos;
		Personaje usuario=null;
		boolean existe=false,valido=false;

		System.out.println("Vamos a introducir los datos.");
		do {
			System.out.println("Usuario:");
			user=Utilidades.introducirCadena();
			existe=existe(fichP, user); //metodo que me busca si exite le mismo user 
			if(existe) {
				System.out.println("El usuario ya existe");
			}
		}while(existe=true);		//hasta que no ponga un usuario que no exista, no sale 

		do {
			System.out.println("Contraseña: ");
			contra = Utilidades.introducirCadena();
			try {
				validarContra(contra); //salta excepcion si no cumple con el patron
				valido = true; 
			} catch (ContraInvalidoException e) {
				System.out.println(e.getMessage());
			}
		}while (!valido); 		//hasta que no sea una contraseña segura no sale 

		try {
			moos = new MyObjectOutputStream(new FileOutputStream(fichP,true));
			//abro en moos porque pa entrar al programa ya tiene que existir el fichero y estar relleno

			usuario=introducirinfo(user,contra); //metodo pa guardar los demas datos, devuelvo personaje 

			moos.writeObject(usuario);
			moos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Trabajador insertado con exito");

	}
	public static boolean existe(File fichP, String user) {
		boolean finArchivo = false, existe=false;
		ObjectInputStream ois=null;	

		if (fichP.exists()) {
			try {
				ois=new ObjectInputStream(new FileInputStream(fichP));	
				while (!finArchivo) {
					try {
						Personaje p = (Personaje) ois.readObject();
						if (p.getUser().equalsIgnoreCase(user)) {
							existe=true;
						}
					} catch (EOFException e) {
						finArchivo = true; 
					}
				}
				ois.close();
			} catch (FileNotFoundException e) {
				System.out.println("No se encontró el fichero");
			} catch (ClassNotFoundException e) {
				System.out.println("La clase Persona no es válida");
			} catch (IOException e) {
				System.out.println("Error leyendo el fichero");
			}
		}
		return existe;
	}
	public static void validarContra(String contra) throws ContraInvalidoException {
		Pattern modelo = Pattern.compile("^(?=(?:.*\\d){2,}).{5,}$"); 		//(?=(?:.*\\d){2,}) Almenos 2 numeros en cualquier sitio
		Matcher m = modelo.matcher(contra);									//.{5,} que minimo tenga en total 5 digitos
																			//^ y $ marcan el inicio y fin de la cadena 
		if (!m.matches()) {
			throw new ContraInvalidoException("Contrasena no segura.\nIntenta que tenga 5 caracteres y 2 numeros");
		}
	}
	public static Personaje introducirinfo(String user ,String contra) {
		LocalDate fechaCreacion;
		int oro;

		System.out.println("Fecha de creacion:");
		fechaCreacion=Utilidades.leerFechaDMA();

		System.out.println("Oro:");
		oro=Utilidades.leerInt();

		System.out.println("Introduce la contraseña:");
		contra=Utilidades.introducirCadena();

		//contrustor de la clase 
		//arraylist de mochila vacia
		
		Personaje personaje=new Personaje(user,contra,fechaCreacion,oro);
		return personaje;
	}
}