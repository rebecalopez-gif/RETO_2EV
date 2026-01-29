package clases;

public class Armadura extends Objeto{
	
	private int defensa;

	public Armadura(String nombre, String desc, int precio, Rareza rareza, int defensa) {
		super(nombre, desc, precio, rareza);
		this.defensa = defensa;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	@Override
	public void visualizar() { 
		System.out.println("************************");
		System.out.println("NOMBRE: "+this.nombre);
		System.out.println("DESCRIPCION: "+this.desc);
		System.out.println("PRECIO: "+this.precio);
		System.out.println("RAREZA: "+this.rareza);
		System.out.println("DEFENSA: "+this.defensa);
	}
	
}
