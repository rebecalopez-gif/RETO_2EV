package clases;
import java.io.Serializable;

public abstract class Objeto implements Serializable{
	
	protected String nombre;
	protected String desc;
	protected int precio;
	protected Rareza rareza;
	
	
	public Objeto(String nombre, String desc, int precio, Rareza rareza) {
		this.nombre = nombre;
		this.desc = desc;
		this.precio = precio;
		this.rareza = rareza;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public Rareza getRareza() {
		return rareza;
	}


	public void setRareza(Rareza rareza) {
		this.rareza = rareza;
	}
	
	public abstract void visualizar();
	
	
}
