package clases;

public class Pocion extends Objeto{
	
	private int poderCurativo;

	public Pocion(String nombre, String desc, int precio, Rareza rareza, int poderCurativo) {
		super(nombre, desc, precio, rareza);
		this.poderCurativo = poderCurativo;
	}

	public int getPoderCurativo() {
		return poderCurativo;
	}

	public void setPoderCurativo(int poderCurativo) {
		this.poderCurativo = poderCurativo;
	}
	
	@Override
	public void visualizar() { 
		System.out.println("************************");
		System.out.println("NOMBRE: "+this.nombre);
		System.out.println("DESCRIPCION: "+this.desc);
		System.out.println("PRECIO: "+this.precio);
		System.out.println("RAREZA: "+this.rareza);
		System.out.println("PODER CURATIVO: "+this.poderCurativo);
	}
	
}
