package clases;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import utilidades.Utilidades;
public class Personaje implements Serializable , Comparable<Personaje>{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String contrasena; //crear patron para la contraseña
	private LocalDate fechaCreacion;
	private int codMochila;
	private int oro;
	private ArrayList<Objeto>mochila;
	
	
	public Personaje(String user, String contrasena, LocalDate fechaCreacion,  int oro,
			ArrayList<Objeto> mochila) {
		this.user = user;
		this.contrasena = contrasena;
		this.fechaCreacion = fechaCreacion;
		this.codMochila = codMochila;
		//user.substring(0,3).toUpperCase()+"-"+Utilidades.fechaToString(fechaCreacion).substring(8,10)
		//las 3 primeras letras del user y los dos ultimos nuemros del año ya que es DD-MM-AAAA 
		this.oro = oro;
		this.mochila = mochila;
	}
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public int getCodMochila() {
		return codMochila;
	}
	public void setCodMochila(int codMochila) {
		this.codMochila = codMochila;
	}
	public int getOro() {
		return oro;
	}
	public void setOro(int oro) {
		this.oro = oro;
	}
	public ArrayList<Objeto> getMochila() {
		return mochila;
	}
	public void setMochila(ArrayList<Objeto> mochila) {
		this.mochila = mochila;
	}

	public void visualizar() {
		System.out.println("***** PERSONAJE *****\nUser: "+user+"\nFecha de creación: "+fechaCreacion+"\nCódigo mochila: "+codMochila+"\nOro: "+oro+"\nObjetos de la mochila: "+mochila);
	}

	@Override
	public int compareTo(Personaje o) { //comprobar que funciona, ordenar de mayor a menor
		return Integer.compare(o.oro,this.oro);
	}

}

