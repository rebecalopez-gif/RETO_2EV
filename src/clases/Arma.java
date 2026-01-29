package clases;

public class Arma extends Objeto{

	private int daño;
	private int alcance;

	public Arma(String nombre, String desc, int precio, Rareza rareza, int daño, int alcance) {
		super(nombre, desc, precio, rareza);
		this.daño = daño;
		this.alcance = alcance;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public int getAlcance() {
		return alcance;
	}

	public void setAlcance(int alcance) {
		this.alcance = alcance;
	}

	@Override
	public void visualizar() { 
		System.out.println("************************");
		System.out.println("NOMBRE: "+this.nombre);
		System.out.println("DESCRIPCION: "+this.desc);
		System.out.println("PRECIO: "+this.precio);
		System.out.println("RAREZA: "+this.rareza);
		System.out.println("DAÑO: "+this.daño);
		System.out.println("ALCANCE: "+this.alcance);
	}



}
