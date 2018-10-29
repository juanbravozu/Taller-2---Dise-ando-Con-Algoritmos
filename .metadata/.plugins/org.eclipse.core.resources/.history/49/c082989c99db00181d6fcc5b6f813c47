package mquevedojbravo;

import java.util.LinkedList;

import processing.core.PApplet;
import processing.core.PImage;

public class Mundo {

	private PApplet app;
	private Jugador j;
	private PImage fondo;
	private PImage interfaz;
	private LinkedList<Ovni> ovnis;
	private LinkedList<Recogible> objetos;
	
	public Mundo(PApplet app) {
		this.app = app;
		j = new Jugador(app);
		j.start();
		fondo = app.loadImage("fondo1.png");
		interfaz = app.loadImage("Interfaz1.png");
	}
	
	public void pintar() {
		app.image(fondo, app.width/2, app.height/2);
		j.pintar();
		app.image(interfaz, app.width/2, app.height/2);
	}
	
	public LinkedList<Recogible> getObjetos() {
		return objetos;
	}
}