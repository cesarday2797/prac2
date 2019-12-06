package uabc.edu.mx.libreria;

import java.util.Vector;

public class Lugar extends EspacioFisico {
	private String nombre = "";
	private Evento elEvento;
	private java.util.Vector<Objeto> losObjetos = new java.util.Vector<Objeto>();

	public Lugar(String nombre) {
		this.nombre = nombre;
	}

	public Vector<Objeto> getLosObjetos() {
		return losObjetos;
	}

	public void setLosObjetos(Vector<Objeto> losObjetos) {
		this.losObjetos = losObjetos;
	}

	@Override
	public String toString() {
		return "Lugar{" +
				"nombre='" + nombre + '\'' +
				", losObjetos=" + losObjetos +
				"} ";
	}
}